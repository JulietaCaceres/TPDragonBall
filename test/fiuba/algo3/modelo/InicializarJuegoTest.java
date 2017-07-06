package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.juego.Casillero;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.personajes.Goku;

public class InicializarJuegoTest {



    @Test
    public void test07CrearAGoku(){
    	Goku goku = new Goku();
    	assertTrue(500 == goku.obtenerPuntosDeVida());
    }

    @Test
    public void test06seIniciaUnJuegoYSeVerificanLasCondicionesIniciales()
    {
        Juego juego = new Juego("juli","jime");
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


}
