package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoCell {
	
	public abstract void atacar(Cell cell, GuerrerosZ oponente);
	
	//public abstract void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero);

	public abstract void recibirDanio(Cell cell, double danio);

	public abstract void verificarDistancia(Cell cell, int distancia);
	
	public abstract void absorberVida(Cell cell, GuerrerosZ oponente);
}
