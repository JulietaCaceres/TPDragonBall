package modelo.Cell;
import Juego.Personaje;
import Juego.Tablero;

public interface EstadoCell {
	
	public abstract void atacar(Cell cell, Personaje oponente, Tablero tablero);
	
	public abstract void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero);
}
