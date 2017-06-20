package fiuba.algo3.modelo;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.personajes.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
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

    @Test(expected = ExceptionCasilleroOcupado.class)
    public void tet02seVerificaQueNoPuedenHaberDosPersonajesEnElMismoCasillero()
    {
        Goku goku = new Goku();
        Casillero unCasillero = new Casillero();
        unCasillero.asignarPersonaje(goku);
        Cell cell = new Cell();
        unCasillero.asignarPersonaje(cell);
    }
    
    @Test(expected = ExceptionCasilleroOcupado.class)
    public void test03unPersonajeIntentaMoversePeroNoPuedePasarPorEncimaDeOtro()
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
        
        assertTrue(tablero.obtenerCoordenada(5, 5).obtenerCasillero().ocupado());
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
       assertTrue(posicionCorrecta);
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
    public void test11HacerQueGokuRealiceElKamehamehaACell(){
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
    
    @Test(expected = ExceptionAtaqueAMismoEquipo.class)
    public void test12HacerQueGohanAtaqueAPiccolo(){
    	Gohan gohan = new Gohan();
    	Piccolo piccolo = new Piccolo();
    	
    	Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
    	Coordenada coordenadaInicialGohan = new Coordenada(4, 4);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	gohan.asignarCoordenadas(coordenadaInicialGohan);
    	
    	gohan.atacar(piccolo);
    }
    
    @Test
    public void test13CombatirEntreGokuPiccoloYCellYLlevarACellASegundaTransformacion(){
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
    public void test14CombatirEntreGokuGohanPiccoloYCellYVerEvolucionDeGohanHastaSegundaTransformacion(){
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
    
    @Test(expected = ExceptionNoAlcanzaAlOponente.class)
    public void test15CellNoAlcanzaAAtacarAPiccoloConSuAtaqueEspecial(){
    	Cell cell = new Cell();
    	Piccolo piccolo = new Piccolo();
    	
    	Coordenada coordenadaInicialCell = new Coordenada(3, 3);
    	Coordenada coordenadaInicialPiccolo = new Coordenada(10, 10);
    	cell.asignarCoordenadas(coordenadaInicialCell);
    	piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
    	
    	cell.atacar(piccolo);
    	cell.realizarAtaqueEspecial(piccolo);
    }
    
    @Test(expected = ExceptionAtaqueAMismoEquipo.class)
    public void test16MajinBooNoPuedeConvertirEnChocolateAFreezer(){
    	MajinBoo boo = new MajinBoo();
    	Freezer freezer = new Freezer();
    	
    	Coordenada coordenadaInicialBoo = new Coordenada(2, 3);
    	Coordenada coordenadaInicialFreezer = new Coordenada(3, 2);
    	boo.asignarCoordenadas(coordenadaInicialBoo);
    	freezer.asignarCoordenadas(coordenadaInicialFreezer);
    	
    	boo.realizarAtaqueEspecial(freezer);
    }
    
    @Test
    public void test17GokuAumentaDePoderConPocaVida(){
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
    	
    	assertEquals(cell.obtenerPuntosDeVida(),476, 0);
    	assertEquals(goku.obtenerPuntosDeVida(),100, 0);    	
    }
    
    @Test
    public void test18GokuAtacaAumentaKiYHaceElKamehameha(){
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
    	assertEquals(cell.obtenerPuntosDeVida(),420, 0);
    	
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),260, 0);
    	
    	goku.realizarAtaqueEspecial(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),200, 0);
    }
    
    @Test
    public void test19GokuAtacaYHacePrimeraTransformacion(){
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
    
    @Test
    public void test21MoverAGokuDosCoordenadasMasAdelante(){
    	Goku goku = new Goku();
    	Coordenada coordenadaInicial = new Coordenada (1,1);
    	Coordenada coordenadaFinal = new Coordenada (1,3);
    	
    	goku.asignarCoordenadas(coordenadaInicial);
    	
    	goku.mover(coordenadaFinal);
    	
    	assertTrue(!coordenadaInicial.obtenerCasillero().ocupado());
    	assertTrue(coordenadaFinal.obtenerCasillero().ocupado());
    }
    
    @Test
    public void test22AsignarAGokuEnCasilleroMoverloYVerQueElPrimerCasilleroEstaVacio(){
    	Goku goku = new Goku();
    	Coordenada coordenadaInicial = new Coordenada (1,1);
    	Coordenada coordenadaFinal = new Coordenada (1,3);
    	
    	goku.asignarCoordenadas(coordenadaInicial);
    	
    	goku.mover(coordenadaFinal);
    	
    	assertTrue(coordenadaFinal.obtenerCasillero().ocupado());
    	assertTrue(!coordenadaInicial.obtenerCasillero().ocupado());
    	
    	Freezer freezer = new Freezer();
    	freezer.asignarCoordenadas(coordenadaInicial);
    	
    	assertTrue(coordenadaInicial.obtenerCasillero().ocupado());
    }
    
    @Test
    public void test23HacerTransformarAPiccoloMoviendoloEntreCoordenadas(){
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
    	
    	assertTrue(coordenada6.obtenerCasillero().ocupado());
    }
    
    @Test
    public void test24AtacarConConsumibleEsferaDelDragon(){
    	Goku goku = new Goku();
    	Freezer freezer = new Freezer();
    	
    	EsferaDelDragon esfera = new EsferaDelDragon();
    	
    	Coordenada coordenadaGoku = new Coordenada(1,1);
    	Coordenada coordenadaFreezer = new Coordenada(1,2);
    	coordenadaGoku.obtenerCasillero().asignarConsumible(esfera);
    	
    	goku.asignarCoordenadas(coordenadaGoku);
    	freezer.asignarCoordenadas(coordenadaFreezer);
    	
    	goku.atacar(freezer);
    	assertEquals(freezer.obtenerPuntosDeVida(),375, 0);
    }
    
    @Test
    public void test25GokuMueveConNubeVoladora(){
    	Goku goku = new Goku();
    	Coordenada coordenadaGoku = new Coordenada(1,1);
    	NubeVoladora nube = new NubeVoladora();
    	coordenadaGoku.obtenerCasillero().asignarConsumible(nube);
    	
    	goku.asignarCoordenadas(coordenadaGoku);
    	
    	Coordenada coordenadaGokuConNube = new Coordenada(1,5);
    	
    	goku.mover(coordenadaGokuConNube);
    }
    
    @Test
    public void test26PiccoloUsaSemillaDelErmitanio(){
    	Piccolo majunia = new Piccolo();
    	Cell cell = new Cell();
    	
    	Coordenada coordenadaPiccolo = new Coordenada(1,1);
    	Coordenada coordenadaCell = new Coordenada(1,2);
    	Coordenada coordenadaSemilla = new Coordenada(2,2);
    	SemillaDelErmitanio semilla = new SemillaDelErmitanio();
    	coordenadaSemilla.obtenerCasillero().asignarConsumible(semilla);
    	
    	majunia.asignarCoordenadas(coordenadaPiccolo);
    	cell.asignarCoordenadas(coordenadaCell);
    	cell.atacar(majunia);
    	cell.atacar(majunia);
    	cell.atacar(majunia);
    	cell.atacar(majunia);
    	cell.atacar(majunia);
    	
    	assertEquals(400,majunia.obtenerPuntosDeVida(),0);
    	majunia.mover(coordenadaSemilla);
    	//assertTrue(coordenadaSemilla.obtenerCasillero().liberarConsumible() == null);
    	
    	assertEquals(500,majunia.obtenerPuntosDeVida(),0);
    }
}