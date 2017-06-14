package modelo.Personajes;

import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public interface EstadoFreezer {

	void atacar(Freezer freezer, GuerrerosZ oponente);

	void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero);

	void recibirDanio(Freezer freezer, double danio);
	
}
