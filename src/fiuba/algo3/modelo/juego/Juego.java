package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.*;

import java.util.ArrayList;


public class Juego {

	private Turno turno;
	private Partida partida;
    private Tablero tablero;
	private Jugador jugadorGuerrero;
	private ArrayList<GuerrerosZ> guerreros;
	private ArrayList<EnemigosDeLaTierra> enemigos;
	public Juego(String guerrerosZ, String enemigosTierra) {
		jugadorGuerrero = new Jugador(guerrerosZ, enemigosTierra);
		tablero = new Tablero();
		guerreros = new ArrayList<GuerrerosZ>();
		enemigos = new ArrayList<EnemigosDeLaTierra>();
		Goku goku = new Goku();
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();
		gohan.referenciarAGoku(goku);
		gohan.referenciarAPiccolo(piccolo);
		piccolo.referenciarAGohan(gohan);
		guerreros.add(goku);
		guerreros.add(gohan);
		guerreros.add(piccolo);
		enemigos.add(new Freezer());
		enemigos.add(new MajinBoo());
		enemigos.add(new Cell());
		jugadorGuerrero.asignarEquipo(guerreros,enemigos);
		jugadorGuerrero.asignarEquipoEnemigo(enemigos);
		turno = new Turno(jugadorGuerrero);
	}

    public void iniciarPartida(){ 
    	partida = new Partida(jugadorGuerrero,tablero);
    }

    public void iniciarTablero() { 
    	partida.iniciarTablero();
    	turno.iniciarTablero(tablero);
    }

    public void iniciarJuego(){
    	/*iniciarPartida();
    	iniciarTablero();
    	while (!turno.ganoJugador()){
    		turno.cambiarJugador();
    		turno.jugadorActualJugar(tablero);
		}*/
	}

	public Tablero obtenerTablero()
	{
		return partida.obtnerTablero();
	}


}


