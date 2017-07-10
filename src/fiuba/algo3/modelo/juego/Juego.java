package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.*;

import java.util.ArrayList;


public class Juego {

	private Turno turno;
	private Partida partida;
	private JugadorGuerrero jugadorGuerrero;
	private ArrayList<GuerrerosZ> guerreros;
	private ArrayList<EnemigosDeLaTierra> enemigos;
	protected Tablero tablero;
	private static Juego instance = null;


	public Juego(String guerrerosZ, String enemigosTierra) {
		jugadorGuerrero = new JugadorGuerrero(guerrerosZ, enemigosTierra);
		tablero = Tablero.getTablero();
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


    public void iniciarTablero() {

    	turno.iniciarTablero(tablero);
    }

	public void moverPersonaje(Equipo unPersonaje, int fila, int columna) {turno.moverPersonaje(unPersonaje,fila,columna);}

	public void atacarConPersonajeA(Equipo personajeAtacante, Equipo personajeAtacado) { turno.atacarConPersonajeA(personajeAtacante, personajeAtacado);}

		public Tablero obtenerTablero()
	{
		return obtenerTurno().obtenerTablero();
	}

	public static Juego obtenerJuego(){
		if (Juego.instance == null){
			Juego.instance = new Juego("jugador1","jugador2");
		}
		return Juego.instance;
	}

	public Turno obtenerTurno(){
		return turno;
	}

	public Jugador obtenerJugadorGuerrero(){return turno.obtenerJugadorGuerrero();}

	public Jugador obtenerJugadorEnemigo(){return  turno.obtenerJugadorEnemigo();}
}


