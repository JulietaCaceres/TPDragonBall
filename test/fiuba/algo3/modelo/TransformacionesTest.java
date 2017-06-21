package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.ExceptionVidaDeCompanierosPorEncimaDeLoPedido;
import fiuba.algo3.modelo.personajes.Freezer;
import fiuba.algo3.modelo.personajes.Gohan;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.personajes.GuerreroZConvertidoEnChocolateException;
import fiuba.algo3.modelo.personajes.MajinBoo;
import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.personajes.Piccolo;

public class TransformacionesTest {
    @Test
    public void test04SeUbicaUnPersonajeSeLoTransformaSeVerificaQueSePuedaTransformar()
    {
        Freezer unFreezer = new Freezer();
        Freezer otroFreezer = new Freezer();
        Goku goku = new Goku();
        Coordenada coordenada = new Coordenada(2,2);
        goku.asignarCoordenadas(coordenada);
        Coordenada otraCoordenada = new Coordenada(2,3);
        unFreezer.asignarCoordenadas(otraCoordenada);
        Coordenada otro = new Coordenada(2,1);
        otroFreezer.asignarCoordenadas(otro);

        goku.atacar(unFreezer);
        double vidaDeUnFreezerDespuesDePrimerAtaque = unFreezer.obtenerPuntosDeVida();
        goku.atacar(unFreezer);
        goku.atacar(unFreezer);
        goku.atacar(unFreezer);

        goku.atacar(otroFreezer);
        boolean menosDanio = (vidaDeUnFreezerDespuesDePrimerAtaque > otroFreezer.obtenerPuntosDeVida());
        assertTrue("Freezer recibe mas danio con goku transformado",menosDanio);

    }

   @Test
    public void test05VerificoSiPersonajeSeMueveAcuerdoASuTransformacion()
    {
        Tablero tablero = new Tablero();
        MajinBoo majinBoo = new MajinBoo();
        Goku goku = new Goku();

        tablero.ubicarPersonaje(majinBoo,2,2);
        tablero.ubicarPersonaje(goku,2,3);

        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        //Majin Boo se transforma en Majin Boo Malo, con velocidad 3
        majinBoo.cambiarCoordenadas(tablero.obtenerCoordenada(5, 5));

        assertEquals(5,majinBoo.obtenerCoordenadas().obtenerFila());
    }

   @Test(expected = GuerreroZConvertidoEnChocolateException.class)
   public void test09CrearAGokuMajinBooYConvertirAGokuEnChocolate(){
   	Goku goku = new Goku();
   	MajinBoo majinBoo = new MajinBoo();
   	Coordenada coordenadaGoku = new Coordenada(1, 1);
   	Coordenada coordenadaMajinBoo = new Coordenada(1, 2);
   	goku.asignarCoordenadas(coordenadaGoku);
   	majinBoo.asignarCoordenadas(coordenadaMajinBoo);

   	majinBoo.atacar(goku);

   	majinBoo.realizarAtaqueEspecial(goku);
   	goku.atacar(majinBoo);
   }

	@Test(expected = GuerreroZConvertidoEnChocolateException.class)
   public void test10ConvertirAGokuEnChocolateYVolverAEstadoNormal(){
   	Goku goku = new Goku();
   	MajinBoo majinBoo = new MajinBoo();
   	Coordenada coordenadaInicialGoku = new Coordenada(1, 2);
   	Coordenada coordenadaInicialMajinBoo = new Coordenada(1, 3);
   	goku.asignarCoordenadas(coordenadaInicialGoku);
   	majinBoo.asignarCoordenadas(coordenadaInicialMajinBoo);

   	majinBoo.atacar(goku);

   	majinBoo.realizarAtaqueEspecial(goku);
   	goku.atacar(majinBoo);
   	goku.atacar(majinBoo);
   	goku.atacar(majinBoo);
   	goku.atacar(majinBoo);
   	assertEquals(284,majinBoo.obtenerPuntosDeVida(),0);
   }

    @Test
    public void test14CombatirEntreGokuGohanPiccoloYCellYVerEvolucionDeGohanHastaSegundaTransformacion(){
    	Piccolo piccolo = new Piccolo();
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	Gohan gohan = new Gohan();
    	Personaje guerreros [] = {goku,gohan,piccolo};
    	
    	gohan.asignarReferenciaAEquipo(guerreros);

    	Coordenada coordenadaInicialCell = new Coordenada(5, 5);
    	Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
    	Coordenada coordenadaInicialGoku = new Coordenada(4, 4);
    	Coordenada coordenadaInicialGohan = new Coordenada(4, 5);
    	cell.asignarCoordenadas(coordenadaInicialCell);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	gohan.asignarCoordenadas(coordenadaInicialGohan);
    	goku.asignarCoordenadas(coordenadaInicialGoku);

    	for(int i = 1; i<=19;i++){
    		cell.atacar(goku);
    		cell.atacar(piccolo);
    	}

    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	//Ahora Gohan es Super Sayajin Fase 1
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	//Ahora Gohan es Super Sayajin Fase 2
  		gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),196, 0);
    }
    
    @Test
    public void ubicarAGohanPiccoloYFreezerYHacerQuePiccoloLlegueALaSegundaTransformacion(){
    	Piccolo piccolo = new Piccolo();
    	Freezer freezer = new Freezer();
    	Gohan gohan = new Gohan();
    	Personaje guerreros [] = {gohan,piccolo};
    	
    	piccolo.asignarReferenciaAEquipo(guerreros);

    	Coordenada coordenadaInicialFreezer = new Coordenada(5, 5);
    	Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
    	Coordenada coordenadaInicialGoku = new Coordenada(4, 4);
    	Coordenada coordenadaInicialGohan = new Coordenada(4, 5);
    	freezer.asignarCoordenadas(coordenadaInicialFreezer);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	gohan.asignarCoordenadas(coordenadaInicialGohan);
    	
    	for(int i = 1; i<=19;i++){
    		freezer.atacar(gohan);
    	}

    	piccolo.atacar(freezer);
    	piccolo.atacar(freezer);
    	piccolo.atacar(freezer);
    	piccolo.atacar(freezer);
    	//Ahora Piccolo esta en estado Fortalecido
    	piccolo.atacar(freezer);
    	//Ahora Piccolo esta en estado Protector
    	piccolo.atacar(freezer);
    	assertEquals(freezer.obtenerPuntosDeVida(),220, 0);
    }
    
    @Test (expected = ExceptionVidaDeCompanierosPorEncimaDeLoPedido.class)
    public void test15ubicarALosGuerrerosZACellYVerQueGohanNoLlegaALaSegundaTransformacion(){
    	Piccolo piccolo = new Piccolo();
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	Gohan gohan = new Gohan();
    	Personaje guerreros [] = {goku,gohan,piccolo};
    	
    	gohan.asignarReferenciaAEquipo(guerreros);

    	Coordenada coordenadaInicialCell = new Coordenada(5, 5);
    	Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
    	Coordenada coordenadaInicialGoku = new Coordenada(4, 4);
    	Coordenada coordenadaInicialGohan = new Coordenada(4, 5);
    	cell.asignarCoordenadas(coordenadaInicialCell);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	gohan.asignarCoordenadas(coordenadaInicialGohan);
    	goku.asignarCoordenadas(coordenadaInicialGoku);

    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	//Ahora Gohan es Super Sayajin Fase 1
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	gohan.atacar(cell);
    	//Ahora Gohan trata de convertirse en Super Sayajin 2
  		gohan.atacar(cell);
    }
    
    @Test (expected = ExceptionVidaDeCompanierosPorEncimaDeLoPedido.class)
    public void ubicarAGohanPiccoloYFreezerYVerQuePiccoloNoLlegaALaSegundaTransformacion(){
    	Piccolo piccolo = new Piccolo();
    	Freezer freezer = new Freezer();
    	Gohan gohan = new Gohan();
    	Personaje guerreros [] = {gohan,piccolo};
    	
    	piccolo.asignarReferenciaAEquipo(guerreros);

    	Coordenada coordenadaInicialFreezer = new Coordenada(5, 5);
    	Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
    	Coordenada coordenadaInicialGohan = new Coordenada(4, 5);
    	freezer.asignarCoordenadas(coordenadaInicialFreezer);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	gohan.asignarCoordenadas(coordenadaInicialGohan);

    	piccolo.atacar(freezer);
    	piccolo.atacar(freezer);
    	piccolo.atacar(freezer);
    	piccolo.atacar(freezer);
    	//Ahora Piccolo esta en estado Fortalecido
    	piccolo.atacar(freezer);
    }

    @Test
    public void test20GokuLlegaASuSegundaTransformacion(){
    	Goku goku = new Goku();
    	Cell cell = new Cell();

    	Coordenada coordenadaInicialGoku = new Coordenada(2, 3);
    	Coordenada coordenadaInicialCell = new Coordenada(3, 2);
    	goku.asignarCoordenadas(coordenadaInicialGoku);
    	cell.asignarCoordenadas(coordenadaInicialCell);

    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);

    	assertEquals(cell.obtenerPuntosDeVida(),420, 0);

    	goku.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),380, 0);
    	cell.comerSemillaDelErmitanio();
    	assertEquals(cell.obtenerPuntosDeVida(),480, 0);

    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);

    	assertEquals(cell.obtenerPuntosDeVida(),160, 0);

    	goku.atacar(cell);

    	assertEquals(cell.obtenerPuntosDeVida(),120, 0);

    	goku.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),60, 0);
    }
}
