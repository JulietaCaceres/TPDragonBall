package modelo.Personajes;

import modelo.Juego.Tablero;

public interface EstadoFreezer {

	void atacar(Freezer freezer, Personaje oponente, Tablero tablero);

	void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero);
	
}
