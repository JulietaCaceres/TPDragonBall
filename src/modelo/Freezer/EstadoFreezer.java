package modelo.Freezer;

import Juego.Personaje;
import Juego.Tablero;

public interface EstadoFreezer {

	void atacar(Freezer freezer, Personaje oponente, Tablero tablero);

	void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero);
	
}
