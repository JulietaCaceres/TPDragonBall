package Freezer;

import Juego.Personaje;
import Juego.Tablero;
import Juego.Ataque;

public class EstadoFreezerSegundaForma implements EstadoFreezer {

	@Override
	public void atacar(Freezer freezer, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(freezer, oponente, tablero, 40 + 40*(freezer.usarAumentoDeAtaque()), 3);
	}
	
	@Override
	public void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(freezer, filaDestino, columnaDestino, 4*freezer.usarAumentoDeVelocidad());
	}

}
