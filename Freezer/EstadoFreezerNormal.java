package Freezer;

import Juego.Personaje;
import Juego.Ataque;
import Juego.Tablero;

public class EstadoFreezerNormal implements EstadoFreezer {

	@Override
	public void atacar(Freezer freezer, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(freezer, oponente, tablero, 20 + 20*(freezer.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(freezer, filaDestino, columnaDestino, 4*freezer.usarAumentoDeVelocidad());
	}

}
