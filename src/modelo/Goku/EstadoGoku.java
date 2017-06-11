package modelo.Goku;
import Juego.Personaje;
import Juego.Tablero;

public interface EstadoGoku {	
	
	public abstract void atacar(Goku goku, Personaje oponente, Tablero tablero);
	
	public abstract void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero);

}
