package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoFreezer {

	void atacar(Freezer freezer, GuerrerosZ oponente);

	//void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero);

	void verificarDistancia(Freezer freezer, int distancia);

	void recibirDanio(Freezer freezer, double danio);
	
}
