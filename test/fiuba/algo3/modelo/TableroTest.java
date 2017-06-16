package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import fiuba.algo3.modelo.juego.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import fiuba.algo3.modelo.personajes.*;

public class TableroTest {

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
        goku.aumentarKiEn(50);
        goku.atacar(unFreezer);
        goku.usarKaioKen();
        goku.atacar(otroFreezer);
        boolean menosDanio = (unFreezer.obtenerPuntosDeVida() > otroFreezer.obtenerPuntosDeVida());
        assertTrue("Freezer recibe mas daño con goku transformado",menosDanio);

    }

   @Test
    public void test05VerificoSiPersonajeSeMueveAcuerdoASuTransformacion()
    {
        Tablero tablero = new Tablero();
        MajinBoo majinBoo = new MajinBoo();
        majinBoo.aumentarKiEn(50);
        majinBoo.convertirseEnBooMalo();
        tablero.ubicarPersonaje(majinBoo,2,2);
        Coordenada cordenadaInicial = majinBoo.obtenerCoordenadas();
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
        assertTrue("tuvo problemas al moverse", posicionEsperada);
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
    
    @Test
    public void test09TransformarAGoku(){
    	Goku goku = new Goku();
    	goku.aumentarKiEn(100);
    	goku.usarKaioKen();
    	assertEquals(goku.obtenerKi(), 80);
    	//assertTrue(goku.obtenerEstado() == EstadoGokuKaioKen.class);
    }
    
    @Test (expected = ExceptionPrimeraTransformacion.class)
    public void test10CrearGokuYFallarEnUsarKaioKen(){
    	Goku goku = new Goku();
    	goku.usarKaioKen();
    }
    
    @Test(expected = GuerreroZConvertidoEnChocolateException.class)
    public void test11CrearAGokuMajinBooYConvertirAGokuEnChocolate(){
    	Goku goku = new Goku();
    	MajinBoo majinBoo = new MajinBoo();
    	majinBoo.aumentarKiEn(50);
    	majinBoo.realizarAtaqueEspecial(goku);
    	goku.atacar(majinBoo);
    }
    
    @Test
    public void test12ConvertirAGokuEnChocolateYVolverAEstadoNormal(){
    	Goku goku = new Goku();
    	MajinBoo majinBoo = new MajinBoo();
    	goku.asignarCoordenadas(1, 2);
    	majinBoo.asignarCoordenadas(1, 3);
    	majinBoo.aumentarKiEn(50);
    	majinBoo.realizarAtaqueEspecial(goku);
    	goku.volverAEstadoNormal();
    	goku.atacar(majinBoo);
    	//assertEquals(majinBoo.obtenerPuntosDeVida(), 280);
    }
    
    @Test
    public void test13HacerQueGokuRealiceElKamehamehaACell(){
    	Goku goku = new Goku();
    	goku.asignarCoordenadas(1, 1);
    	
    	Cell cell = new Cell();
    	cell.asignarCoordenadas(1, 2);
    	
    	goku.aumentarKiEn(30);
    	goku.realizarAtaqueEspecial(cell);
    	
    	assertTrue(cell.obtenerPuntosDeVida() == 470);
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
    	
    	cell.aumentarKiEn(500);
    	
    	for(int i = 1; i<=6;i++){
    		cell.realizarAtaqueEspecial(goku);
    		cell.realizarAtaqueEspecial(piccolo);
    	}
    	
    	cell.absorberA17();
    	cell.absorberA18();
    	
    	cell.atacar(goku);
    	
    	assertTrue(300 == goku.obtenerPuntosDeVida());
    }
    
    @Test
    public void test16CombatirEntreGokuGohanPiccoloYCellYLlevarAGohanASegundaTransformacion(){
    	Gohan gohan = new Gohan();
    	Piccolo piccolo = new Piccolo();
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	
    	goku.asignarCoordenadas(4, 4);
    	gohan.asignarCoordenadas(4, 5);
    	piccolo.asignarCoordenadas(5, 4);
    	cell.asignarCoordenadas(5, 5);
    	
    	cell.aumentarKiEn(500);
    	gohan.aumentarKiEn(100);
    	
    	for(int i = 1; i<=19;i++){
    		cell.atacar(goku);
    		cell.atacar(piccolo);
    	}
    	
    	gohan.convertirseEnSuperSayajin1();
    	gohan.convertirseEnSuperSayajin2(goku.obtenerPuntosDeVida(), piccolo.obtenerPuntosDeVida());
    	
    	gohan.atacar(cell);
    	
    	assertTrue(400 == cell.obtenerPuntosDeVida());
    }
}


