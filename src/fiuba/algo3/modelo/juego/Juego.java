package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.*;

import java.util.ArrayList;

public class Juego {

	private Turno turno;
	private Partida partida;
    private Tablero tablero;
	private Jugador jugadorGuerrero;
	private Jugador jugadorEnemigo;
	private Personaje[] guerreros;
	private Personaje[] enemigos;
	public Juego(String guerrerosZ, String enemigosTierra)
	{
		jugadorGuerrero = new Jugador(guerrerosZ);
		jugadorEnemigo = new Jugador(enemigosTierra);
		jugadorGuerrero.asignarOtroJugador(jugadorEnemigo);
		jugadorEnemigo.asignarOtroJugador(jugadorGuerrero);
        tablero = new Tablero();
		guerreros = new Personaje[3];
		enemigos = new Personaje[3];
		guerreros[0] = new Goku();
		guerreros[1] = new Gohan();
		guerreros[2] = new Piccolo();
		enemigos[0] = new Freezer();
		enemigos[1] = new MajinBoo();
		enemigos[2] = new Cell();
		jugadorGuerrero.asignarEquipo(guerreros);
		jugadorEnemigo.asignarEquipo(enemigos);
		turno = new Turno(jugadorGuerrero,jugadorEnemigo);
	}

    public void iniciarPartida(){ partida = new Partida(jugadorEnemigo,jugadorGuerrero,tablero);}

    public void iniciarTablero() { partida.iniciarTablero();}


    public void iniciarJuego(){
    	iniciarPartida();
    	iniciarTablero();
    	while (!turno.ganoJugador()){
    		turno.cambiarJugador();
    		turno.jugadorActualJugar();
		}
	}

	public Tablero obtenerTablero()
	{
		return tablero;
	}
}
