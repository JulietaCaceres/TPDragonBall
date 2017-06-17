package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import fiuba.algo3.modelo.juego.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import fiuba.algo3.modelo.personajes.*;

public class DragonBallTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    
    @Test
    public void test00ubicoUnPersonajeEnUnCasilleroVerificoCasilleroOcupado() {
        Goku unPersonaje = new Goku();
        Casillero unCasillero = new Casillero();
        unCasillero.asignarPersonaje(unPersonaje);
        assertTrue(unCasillero.ocupado());
    }
    
    @Test
    public void test01seMueveAGokuAUnCasilleroEncontradoAUnaVelocidadAcordeASuModoYSeVerificaQueElCasilleroQuedeOcupado(){
        Goku goku = new Goku();
        Casillero casilleroInicial = new Casillero();
        casilleroInicial.asignarPersonaje(goku);
        Casillero casilleroFinal = new Casillero();
        casilleroFinal.asignarPersonaje(goku);
        assertTrue(casilleroFinal.ocupado());
    }

    @Test (expected = ExceptionCasilleroOcupado.class)
    public void tet02seVerificaQueNoPuedenHaberDosPersonajesEnElMismoCasillero()
    {
        Goku goku = new Goku();
        Casillero unCasillero = new Casillero();
        unCasillero.asignarPersonaje(goku);
        Cell cell = new Cell();
        unCasillero.asignarPersonaje(cell);
    }
    
    @Test(expected = ExceptionCasilleroOcupado.class)
    public void Test03unPersonajeIntentaMoversePeroNoPuedePasarPorEncimaDeOtro()
    {
        Goku goku = new Goku();
        Cell cell =new Cell();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku, 2,2);
        tablero.ubicarPersonaje(cell,2,3);
        cell.mover(tablero.obtenerCoordenada(2, 2));
    }

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
        majinBoo.mover(tablero.obtenerCoordenada(5, 5));
        
        assertTrue(majinBoo.obtenerCoordenadas().obtenerColumna() == 5);
    }
    
    @Test
    public void test06seIniciaUnJuegoYSeVerificanLasCondicionesIniciales()
    {   Jugador jugador1 = new Jugador("juli");
        Jugador jugador2 = new Jugador("jime");
        Juego juego = new Juego(jugador1,jugador2);
        juego.iniciarTablero();
        Tablero tablero = juego.obtenerTablero();
        Casillero casillero1 = tablero.obtenerCasillero(2,0);
        Casillero casillero2 = tablero.obtenerCasillero(1,1);
        Casillero casillero3 = tablero.obtenerCasillero(0,2);
        Casillero casillero4 = tablero.obtenerCasillero(31,29);
        Casillero casillero5 = tablero.obtenerCasillero(30,30);
        Casillero casillero6 = tablero.obtenerCasillero(29,31);
        boolean posicionCorrecta = (casillero1.ocupado() && casillero2.ocupado() && casillero3.ocupado()
                                     && casillero4.ocupado() && casillero5.ocupado() && casillero6.ocupado());
       assertTrue("se colocaron mal los personajes", posicionCorrecta);
    }
        
    @Test
    public void test07CrearAGoku(){
    	Goku goku = new Goku();
    	assertTrue(500 == goku.obtenerPuntosDeVida());
    }
    
    @Test
    public void test08CrearAGokuACellYAtacarACell(){
    	Goku goku = new Goku();
    	
    	Coordenada coordenadaGoku = new Coordenada(1, 1);
    	Coordenada coordenadaMajinBoo = new Coordenada(1, 2);
    	goku.asignarCoordenadas(coordenadaGoku);
    	
    	Cell cell = new Cell();
    	cell.asignarCoordenadas(coordenadaMajinBoo);    	
    	
    	goku.atacar(cell);
    	
    	assertTrue(cell.obtenerPuntosDeVida() == 480);
    }        
       
    @Test(expected = GuerreroZConvertidoEnChocolateException.class)
    public void test11CrearAGokuMajinBooYConvertirAGokuEnChocolate(){
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
    
	@Test
    public void test12ConvertirAGokuEnChocolateYVolverAEstadoNormal(){
    	Goku goku = new Goku();
    	MajinBoo majinBoo = new MajinBoo();
    	Coordenada coordenadaInicialGoku = new Coordenada(1, 2);
    	Coordenada coordenadaInicialMajinBoo = new Coordenada(1, 3);
    	goku.asignarCoordenadas(coordenadaInicialGoku);
    	majinBoo.asignarCoordenadas(coordenadaInicialMajinBoo);
    	
    	majinBoo.atacar(goku);
    	
    	majinBoo.realizarAtaqueEspecial(goku);
    	goku.volverAEstadoNormal();
    	goku.atacar(majinBoo);
    	assertTrue(majinBoo.obtenerPuntosDeVida() == 284);
    }
    
    @Test
    public void test13HacerQueGokuRealiceElKamehamehaACell(){
    	Goku goku = new Goku();
    	Coordenada coordenadaInicialGoku = new Coordenada(5, 4);
    	goku.asignarCoordenadas(coordenadaInicialGoku);
    	
    	Cell cell = new Cell();
    	Coordenada coordenadaInicialCell = new Coordenada(5, 4);
    	cell.asignarCoordenadas(coordenadaInicialCell);
    	
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	//Goku pasa a KaioKen
    	
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	
    	assertTrue(cell.obtenerPuntosDeVida() == 260);
    	
    	goku.realizarAtaqueEspecial(cell);
    	
    	assertTrue(cell.obtenerPuntosDeVida() == 200);
    }
    
    @Test (expected = ExceptionAtaqueAMismoEquipo.class)
    public void test14HacerQueGohanAtaqueAPiccolo(){
    	Gohan gohan = new Gohan();
    	Piccolo piccolo = new Piccolo();
    	
    	Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
    	Coordenada coordenadaInicialGohan = new Coordenada(4, 4);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	gohan.asignarCoordenadas(coordenadaInicialGohan);
    	
    	gohan.atacar(piccolo);
    }
    
    @Test
    public void test15CombatirEntreGokuPiccoloYCellYLlevarACellASegundaTransformacion(){
    	Piccolo piccolo = new Piccolo();
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	
    	Coordenada coordenadaInicialCell = new Coordenada(5, 5);
    	Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
    	Coordenada coordenadaInicialGoku = new Coordenada(4, 4);
    	
    	cell.asignarCoordenadas(coordenadaInicialCell);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	goku.asignarCoordenadas(coordenadaInicialGoku);
    	
    	for(int i = 1; i<=4;i++){
    		cell.atacar(goku);
    		cell.realizarAtaqueEspecial(piccolo);
    	}
    	
    	assertTrue(420 == goku.obtenerPuntosDeVida());
    	//Ahora Cell esta en fase SemiPerfecto
    	
    	for(int i = 1; i<=8;i++){
    		cell.atacar(goku);
    		cell.realizarAtaqueEspecial(piccolo);
    	}
    	
    	assertTrue(100 == goku.obtenerPuntosDeVida());
    	//Ahora Cell esta en fase Perfecto
    	cell.atacar(goku);
    	assertTrue(20 == goku.obtenerPuntosDeVida());
    }
    
    @Test
    public void test16CombatirEntreGokuGohanPiccoloYCellYVerEvolucionDeGohanHastaSegundaTransformacion(){
    	Piccolo piccolo = new Piccolo();
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	Gohan gohan = new Gohan();
    	
    	gohan.referenciarAGoku(goku);
    	gohan.referenciarAPiccolo(piccolo);
    	
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
    	assertTrue(488 == cell.obtenerPuntosDeVida());
    	gohan.atacar(cell);
    	assertTrue(476 == cell.obtenerPuntosDeVida());
    	//Ahora Gohan es Super Sayajin Fase 1
    	gohan.atacar(cell);
    	assertTrue(446 == cell.obtenerPuntosDeVida());
    	gohan.atacar(cell);
    	assertTrue(416 == cell.obtenerPuntosDeVida());
    	gohan.atacar(cell);
    	assertTrue(386 == cell.obtenerPuntosDeVida());
    	gohan.atacar(cell);    	
    	assertTrue(356 == cell.obtenerPuntosDeVida());
    	gohan.atacar(cell);
    	assertTrue(326 == cell.obtenerPuntosDeVida());
    	gohan.atacar(cell);
    	assertTrue(296 == cell.obtenerPuntosDeVida());
    	//Ahora Gohan es Super Sayajin Fase 2
  		gohan.atacar(cell);
    	assertTrue(196 == cell.obtenerPuntosDeVida());
    }
    
    @Test (expected = ExceptionNoAlcanzaAlOponente.class)
    public void test17CellNoAlcanzaAAtacarAPiccoloConSuAtaqueEspecial(){
    	Cell cell = new Cell();
    	Piccolo piccolo = new Piccolo();
    	
    	Coordenada coordenadaInicialCell = new Coordenada(3, 3);
    	Coordenada coordenadaInicialPiccolo = new Coordenada(10, 10);
    	cell.asignarCoordenadas(coordenadaInicialCell);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	
    	cell.atacar(piccolo);
    	cell.realizarAtaqueEspecial(piccolo);
    }
    
    @Test (expected = ExceptionAtaqueAMismoEquipo.class)
    public void test18MajinBooNoPuedeConvertirEnChocolateAFreezer(){
    	MajinBoo boo = new MajinBoo();
    	Freezer freezer = new Freezer();
    	
    	Coordenada coordenadaInicialBoo = new Coordenada(2, 3);
    	Coordenada coordenadaInicialFreezer = new Coordenada(3, 2);
    	boo.asignarCoordenadas(coordenadaInicialBoo);
    	freezer.asignarCoordenadas(coordenadaInicialFreezer);
    	
    	boo.realizarAtaqueEspecial(freezer);
    }
    
    @Test
    public void test19GokuAumentaDePoderConPocaVida(){
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	
    	Coordenada coordenadaInicialGoku = new Coordenada(2, 3);
    	Coordenada coordenadaInicialCell = new Coordenada(3, 2);
    	goku.asignarCoordenadas(coordenadaInicialGoku);
    	cell.asignarCoordenadas(coordenadaInicialCell);
    	
    	for (int i = 0; i<20; i++){
    		cell.atacar(goku);
    	}
    	
    	goku.atacar(cell);
    	
    	assertTrue(100 == goku.obtenerPuntosDeVida());
    	assertTrue(476 == cell.obtenerPuntosDeVida());
    	
    }
    
    @Test
    public void test20GokuAtacaAumentaKiYHaceElKamehameha(){
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
    	//Goku llega a Kaioken, Cell tiene 420 de vida
    	assertTrue(420 == cell.obtenerPuntosDeVida());
    	
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	assertTrue(260 == cell.obtenerPuntosDeVida());
    	
    	goku.realizarAtaqueEspecial(cell);
    	assertTrue(200 == cell.obtenerPuntosDeVida());
    }
    
    @Test
    public void test20GokuAtacaYHacePrimeraTransformacion(){
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
    	    	
    	assertTrue(cell.obtenerPuntosDeVida() == 420);
    	
    	goku.atacar(cell);
    	assertTrue(cell.obtenerPuntosDeVida() == 380);
    }
    
    @Test
    public void test21GokuLlegaASuSegundaTransformacion(){
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
    	    	
    	assertTrue(cell.obtenerPuntosDeVida() == 420);
    	
    	goku.atacar(cell);
    	assertTrue(cell.obtenerPuntosDeVida() == 380);
    	cell.comerSemillaDelErmitanio();
    	assertTrue(cell.obtenerPuntosDeVida() == 480);
    	
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	
    	assertTrue(cell.obtenerPuntosDeVida() == 160);
    	
    	goku.atacar(cell);
    	
    	assertTrue(cell.obtenerPuntosDeVida() == 120);
    	
    	goku.atacar(cell);
    	assertTrue(cell.obtenerPuntosDeVida() == 60);
    }
    
    @Test
    public void test22MoverAGokuDosCoordenadasMasAdelante(){
    	Goku goku = new Goku();
    	Coordenada coordenadaInicial = new Coordenada (1,1);
    	Coordenada coordenadaFinal = new Coordenada (1,3);
    	
    	goku.asignarCoordenadas(coordenadaInicial);
    	
    	goku.mover(coordenadaFinal);
    	
    	assertTrue(goku.obtenerCoordenadas().obtenerColumna() == 3);
    }
    
    @Test
    public void test23AsignarAGokuEnCasilleroMoverloYVerQueElPrimerCasilleroEstaVacio(){
    	Goku goku = new Goku();
    	Coordenada coordenadaInicial = new Coordenada (1,1);
    	Coordenada coordenadaFinal = new Coordenada (1,3);
    	
    	goku.asignarCoordenadas(coordenadaInicial);
    	
    	goku.mover(coordenadaFinal);
    	
    	assertTrue(goku.obtenerCoordenadas().obtenerColumna() == 3);
    	
    	Freezer freezer = new Freezer();
    	freezer.asignarCoordenadas(coordenadaInicial);
    	
    	assertTrue(freezer.obtenerCoordenadas().obtenerColumna() == 1);
    }
    
    @Test
    public void test24HacerTransformarAPiccoloMoviendoloEntreCoordenadas(){
    	Piccolo piccolo = new Piccolo();
    	Coordenada coordenada1 = new Coordenada(1,1);
    	Coordenada coordenada2 = new Coordenada(1,3);
    	Coordenada coordenada3 = new Coordenada(1,5);
    	Coordenada coordenada4 = new Coordenada(1,7);
    	Coordenada coordenada5 = new Coordenada(1,9);
    	Coordenada coordenada6 = new Coordenada(1,12);
    	
    	piccolo.asignarCoordenadas(coordenada1);
    	
    	piccolo.mover(coordenada2);
    	piccolo.mover(coordenada3);
    	piccolo.mover(coordenada4);
    	piccolo.mover(coordenada5);
    	//Piccolo esta en estado fortalecido
    	piccolo.mover(coordenada6);
    	
    	assertTrue(piccolo.obtenerCoordenadas().obtenerColumna() == 12);
    }
}