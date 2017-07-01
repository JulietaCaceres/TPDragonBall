package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.GuerrerosZ;
import org.junit.Test;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.personajes.Cell;
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
        EnemigosDeLaTierra unFreezer = new Freezer();
        EnemigosDeLaTierra otroFreezer = new Freezer();
        GuerrerosZ goku = new Goku();
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
        EnemigosDeLaTierra majinBoo = new MajinBoo();
        GuerrerosZ goku = new Goku();

        tablero.ubicarPersonaje(majinBoo,2,2);
        tablero.ubicarPersonaje(goku,2,3);

        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        //Majin Boo se transforma en Majin Boo Malo, con velocidad 3
        majinBoo.cambiarCoordenadas(tablero.obtenerCoordenada(5, 5));

        assertEquals(majinBoo.obtenerCoordenadas().obtenerColumna(),5);
    }

   @Test(expected = GuerreroZConvertidoEnChocolateException.class)
   public void test09CrearAGokuMajinBooYConvertirAGokuEnChocolate(){
    GuerrerosZ goku = new Goku();
   	EnemigosDeLaTierra majinBoo = new MajinBoo();
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
   	GuerrerosZ goku = new Goku();
   	EnemigosDeLaTierra majinBoo = new MajinBoo();
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

    /*@Test
    public void test14CombatirEntreGokuGohanPiccoloYCellYVerEvolucionDeGohanHastaSegundaTransformacion(){
    	GuerrerosZ piccolo = new Piccolo();
    	GuerrerosZ goku = new Goku();
    	EnemigosDeLaTierra cell = new Cell();
    	Gohan gohan = new Gohan();
    	
    	Equipo[] companierosDeGohan = {goku, piccolo};
    	
    	gohan.asignarReferenciaAEquipo(companierosDeGohan);
    	
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
    	assertEquals(cell.obtenerPuntosDeVida(),488, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),476, 0);
    	//Ahora Gohan es Super Sayajin Fase 1
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),446, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),416, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),386, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),356, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),326, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),296, 0);
    	//Ahora Gohan es Super Sayajin Fase 2
  		gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),196, 0);
    }
*/
    @Test
    public void test20GokuLlegaASuSegundaTransformacion(){
    	GuerrerosZ goku = new Goku();
    	EnemigosDeLaTierra cell = new Cell();

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
