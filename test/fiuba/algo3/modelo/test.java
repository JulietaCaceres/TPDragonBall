package modelo;

import fiuba.algo3.modelo.juego.*;

import fiuba.algo3.modelo.personajes.*;
import org.junit.Test;

import static org.junit.Assert.*;

import fiuba.algo3.modelo.juego.ExceptionCasilleroOcupado;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class test {

  /*  @Rule
    public ExpectedException thrown = ExpectedException.none();

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
       assertTrue("se colocaron mal los fiuba.algo3.modelo.personajes", posicionCorrecta);
    }

    @Test (expected = ExceptionNoAlcanzaAlOponente.class)
    public void test07unGuerreroIntenaAtacarAUnEnemigoYFallaPorqueEstaMasLEjosDeSuDistanciaDeAtaque()
    {
        Goku goku = new Goku();
        Freezer freezer = new Freezer();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku, 2,2);
        tablero.ubicarPersonaje(freezer, 6,2);
        goku.atacar(freezer);

    }

    @Test
    public  void test08seAtacaAUnOponenteYSeVerificaQueRecibioDaño()
    {
        Goku goku = new Goku();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku,4,4);
        Cell cell = new Cell();
        double vidaInicial = cell.obtenerPuntosDeVida();
        tablero.ubicarPersonaje(cell,4,5);
        goku.atacar(cell);
        double vidaFinal = cell.obtenerPuntosDeVida();
        boolean seRedujoVida = (vidaInicial > vidaFinal);
        assertTrue("el personaje no recibio daño", seRedujoVida);
    }

    @Test (expected = ExceptionAtaqueAMismoEquipo.class)
    public void test09SeIntentaAtacarAPersonajesDelMismoEquipoYFalla()
    {
        Goku goku = new Goku();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku,4,4);
        Gohan gohan = new Gohan();
        tablero.ubicarPersonaje(gohan,4,5);
        goku.atacar(gohan);
    }

*/
}


