package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
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
        Casillero unCasillero = new Casillero(2,2);
        unCasillero.asignarPersonaje(unPersonaje);
        assertTrue(unCasillero.ocupado());
    }
    
    @Test
    public void test01seMueveAGokuAUnCasilleroEncontradoAUnaVelocidadAcordeASuModoYSeVerificaQueElCasilleroQuedeOcupado(){
        Goku goku = new Goku();
        Casillero casilleroInicial = new Casillero(2,2);
        casilleroInicial.asignarPersonaje(goku);
        Casillero casilleroFinal = new Casillero(2,4);
        casilleroFinal.asignarPersonaje(goku);
        assertTrue(casilleroFinal.ocupado());
    }

    @Test (expected = ExceptionCasilleroOcupado.class)
    public void tet02seVerificaQueNoPuedenHaberDosPersonajesEnElMismoCasillero()
    {
        Goku goku = new Goku();
        Casillero unCasillero = new Casillero(2,2);
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
        Coordenada unaCoornada = new Coordenada(2,2);
        Coordenada otraCordenada = new Coordenada(2,1);
        Coordenada[] recorrido = new Coordenada[2];
        recorrido[0] = unaCoornada;
        recorrido[1] = otraCordenada;
        Movimiento despazar = new Movimiento(tablero);
        despazar.moverPersonaje(recorrido, cell);
    }

 @Test
    public void test04SeUbicaUnPersonajeSeLoTransformaSeVerificaQueSePuedaTransformar()
    {
        Freezer unFreezer = new Freezer();
        Freezer otroFreezer = new Freezer();
        Goku goku = new Goku();
        Casillero unCasillero = new Casillero(2,2);
        unCasillero.asignarPersonaje(goku);
        Casillero otroCasillero = new Casillero(2,3);
        otroCasillero.asignarPersonaje(unFreezer);
        Casillero otro = new Casillero(2,1);
        otro.asignarPersonaje(otroFreezer);
        
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
        
        Movimiento desplazamiento = new Movimiento(tablero);
        Coordenada coordenada1 = new Coordenada(3,2);
        Coordenada coordenada2 = new Coordenada(4,2);
        Coordenada coordenada3 = new Coordenada(5,2);
        Coordenada[] coordenadas = new Coordenada[3];
        coordenadas[0] = coordenada1;
        coordenadas[1] = coordenada2;
        coordenadas[2] = coordenada3;
        desplazamiento.moverPersonaje(coordenadas,majinBoo);
        Coordenada coordenadaFinal = majinBoo.obtenerCoordenadas();
        boolean posicionEsperada = ((coordenadaFinal.obtenerFila() == coordenada3.obtenerFila()) &&(coordenadaFinal.obtenerColumna() == coordenada3.obtenerColumna()));
        assertTrue(posicionEsperada);
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
    	goku.asignarCoordenadas(1, 1);
    	
    	Cell cell = new Cell();
    	cell.asignarCoordenadas(1, 2);
    	
    	goku.atacar(cell);
    	
    	assertTrue(cell.obtenerPuntosDeVida() == 480);
    }        
       
    @Test(expected = GuerreroZConvertidoEnChocolateException.class)
    public void test11CrearAGokuMajinBooYConvertirAGokuEnChocolate(){
    	Goku goku = new Goku();
    	MajinBoo majinBoo = new MajinBoo();
    	goku.asignarCoordenadas(1, 1);
    	majinBoo.asignarCoordenadas(1, 2);
    	
    	majinBoo.atacar(goku);
    	
    	majinBoo.realizarAtaqueEspecial(goku);
    	goku.atacar(majinBoo);
    }
    
	@Test
    public void test12ConvertirAGokuEnChocolateYVolverAEstadoNormal(){
    	Goku goku = new Goku();
    	MajinBoo majinBoo = new MajinBoo();
    	goku.asignarCoordenadas(1, 2);
    	majinBoo.asignarCoordenadas(1, 3);
    	majinBoo.atacar(goku);
    	
    	majinBoo.realizarAtaqueEspecial(goku);
    	goku.volverAEstadoNormal();
    	goku.atacar(majinBoo);
    	assertTrue(majinBoo.obtenerPuntosDeVida() == 284);
    }
    
    @Test
    public void test13HacerQueGokuRealiceElKamehamehaACell(){
    	Goku goku = new Goku();
    	goku.asignarCoordenadas(1, 1);
    	
    	Cell cell = new Cell();
    	cell.asignarCoordenadas(1, 2);
    	
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
    	
    	gohan.asignarCoordenadas(4, 5);
    	piccolo.asignarCoordenadas(5, 4);
    	
    	gohan.atacar(piccolo);
    }
    
    @Test
    public void test15CombatirEntreGokuPiccoloYCellYLlevarACellASegundaTransformacion(){
    	Piccolo piccolo = new Piccolo();
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	
    	goku.asignarCoordenadas(4, 4);
    	piccolo.asignarCoordenadas(5, 4);
    	cell.asignarCoordenadas(5, 5);
    	
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
    	
    	goku.asignarCoordenadas(4, 4);
    	gohan.asignarCoordenadas(4, 5);
    	piccolo.asignarCoordenadas(5, 4);
    	cell.asignarCoordenadas(5, 5);
    	
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
  		gohan.atacar(cell);
    	assertTrue(266 == cell.obtenerPuntosDeVida());
    	//Ahora Gohan es Super Sayajin Fase 2
    	gohan.atacar(cell);
    	assertTrue(166 == cell.obtenerPuntosDeVida());
    }
    
    @Test (expected = ExceptionNoAlcanzaAlOponente.class)
    public void test17CellNoAlcanzaAAtacarAPiccoloConSuAtaqueEspecial(){
    	Cell cell = new Cell();
    	Piccolo piccolo = new Piccolo();
    	
    	cell.asignarCoordenadas(3, 3);
    	piccolo.asignarCoordenadas(10, 10);
    	
    	cell.atacar(piccolo);
    	cell.realizarAtaqueEspecial(piccolo);
    }
    
    @Test (expected = ExceptionAtaqueAMismoEquipo.class)
    public void test18MajinBooNoPuedeConvertirEnChocolateAFreezer(){
    	MajinBoo boo = new MajinBoo();
    	Freezer freezer = new Freezer();
    	
    	boo.asignarCoordenadas(2, 3);
    	freezer.asignarCoordenadas(3, 2);
    	
    	boo.realizarAtaqueEspecial(freezer);
    }
    
    @Test
    public void test19GokuAumentaDePoderConPocaVida(){
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	
    	goku.asignarCoordenadas(2, 3);
    	cell.asignarCoordenadas(3, 2);
    	
    	for (int i = 0; i<20; i++){
    		cell.atacar(goku);
    	}
    	
    	goku.atacar(cell);
    	
    	assertTrue(100 == goku.obtenerPuntosDeVida());
    	assertTrue(476 == cell.obtenerPuntosDeVida());
    	
    }
    
    @Test
    public void test20GokuAtacaYAumentaKi(){
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	
    	goku.asignarCoordenadas(2, 3);
    	cell.asignarCoordenadas(3, 2);
    	
    	goku.atacar(cell);
    }
    
    @Test
    public void test20GokuAtacaYHacePrimeraTransformacion(){
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	
    	goku.asignarCoordenadas(2, 3);
    	cell.asignarCoordenadas(3, 2);
    	
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
    	
    	goku.asignarCoordenadas(2, 3);
    	cell.asignarCoordenadas(3, 2);
    	
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
}