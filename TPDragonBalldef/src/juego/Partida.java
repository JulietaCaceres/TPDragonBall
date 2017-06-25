package juego;

import java.util.Random;

public class Partida {

	private Turno turnoActual;
	private Tablero tablero;

	public Partida() {
		this.tablero = new Tablero();
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
			this.turnoActual = new Turno(GuerrerosZ, EnemigosDeLaTierra);
		else
			this.turnoActual = new Turno(EnemigosDeLaTierra, GuerrerosZ);
		while (!this.turnoActual.jugadorGano())
			this.turnoActual.jugar();
	}

	public Tablero obtenerTablero() {
		return this.tablero;
	}

	public Turno obtenerTurno() {
		return this.turnoActual;
	}
}
