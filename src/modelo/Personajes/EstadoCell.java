package modelo.Personajes;

import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public interface EstadoCell {
	
	public abstract void atacar(Cell cell, GuerrerosZ oponente);
	
	public abstract void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero);

	public abstract void recibirDanio(Cell cell, double danio);

	public abstract void absorberVida(Cell cell, GuerrerosZ oponente);
}
