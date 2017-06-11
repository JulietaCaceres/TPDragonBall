package modelo.Gohan;
import Juego.Personaje;
import Juego.Tablero;

public interface EstadoGohan {
	public abstract void atacar(Gohan gohan, Personaje oponente, Tablero tablero);
	
	public abstract void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero);
}
