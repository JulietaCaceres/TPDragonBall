package Freezer;

import Juego.Personaje;
import Juego.Ataque;
import Juego.Tablero;

public class EstadoFreezerFormaOriginal implements EstadoFreezer {

	@Override
	public void atacar(Freezer freezer, Personaje oponente, Tablero tablero){
		Ataque ataque = new Ataque();
		ataque.atacar(freezer, oponente, tablero, 50 + 50*(freezer.usarAumentoDeAtaque()), 3);
	}

	@Override
	public void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(freezer, filaDestino, columnaDestino, 6*freezer.usarAumentoDeVelocidad());
	}

}
