package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.*;
public class Partida {
    
	private Tablero tablero;
    private Jugador jugadorZ;


    public  Partida (Jugador jugadorGuerrero,Tablero unTablero)
    {   tablero = unTablero;
        jugadorZ = jugadorGuerrero;


    }

    public void iniciarTablero() { tablero.iniciarTablero(jugadorZ.obtenerEquipoGuerreros(),jugadorZ.obtenerOtroJugador().obtenerEquipoEnemigo()); }

    public Tablero obtnerTablero() { return tablero;
    }
}