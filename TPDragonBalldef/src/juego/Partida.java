package juego;

import java.util.LinkedList;
import java.util.Random;

public class Partida {

	private LinkedList<Turno> turnos;
	private Tablero tablero;

	public Partida() {
		this.tablero = new Tablero();
		this.turnos = new LinkedList<Turno>();
	}

	public void iniciarPartida() {
		Personaje goku = new Goku();
		Personaje piccolo = new Piccolo();
		Personaje gohan = new Gohan();
		Equipo GuerrerosZ = new GuerrerosZ(goku, piccolo, gohan);
		Personaje freezer = new Freezer();
		Personaje majinboo = new MajinBoo();
		Personaje cell = new Cell();
		Equipo EnemigosDeLaTierra = new EnemigosDeLaTierra(freezer, majinboo, cell);
		goku.asignarEquipo(GuerrerosZ);
		piccolo.asignarEquipo(GuerrerosZ);
		gohan.asignarEquipo(GuerrerosZ);
		freezer.asignarEquipo(EnemigosDeLaTierra);
		majinboo.asignarEquipo(EnemigosDeLaTierra);
		cell.asignarEquipo(EnemigosDeLaTierra);
		this.tablero.inicializarTablero(goku, gohan, piccolo, cell, majinboo, freezer);
		Random random = new Random();
		if (random.nextBoolean())
			this.turnos.add(new Turno(GuerrerosZ));
		else
			this.turnos.add(new Turno(EnemigosDeLaTierra));
	}

	public Tablero obtenerTablero() {
		return this.tablero;
	}
}
