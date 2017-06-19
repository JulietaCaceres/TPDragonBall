package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.*;

import java.util.ArrayList;

public class Juego {
	
    private Tablero tablero;
	private Jugador jugadorGuerrero;
	private Jugador jugadorEnemigo;
	private ArrayList<Personaje> guerreros;
	private ArrayList<Personaje> enemigos;
	public Juego(Jugador guerrerosZ, Jugador enemigosTierra)
	{
        tablero = new Tablero();
		jugadorGuerrero = guerrerosZ;
		jugadorEnemigo = enemigosTierra;
		guerreros = new ArrayList<Personaje>();
		enemigos = new ArrayList<Personaje>();
		guerreros.add(new Goku());
		guerreros.add(new Gohan());
		guerreros.add(new Piccolo());
		enemigos.add(new Freezer());
		enemigos.add(new MajinBoo());
		enemigos.add(new Cell());
	}

	public void iniciarTablero()
	{
		tablero.iniciarTablero(guerreros,enemigos);
	}

	public Tablero obtenerTablero()
	{
		return tablero;
	}
}
