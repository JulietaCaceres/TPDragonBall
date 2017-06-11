package modelo.Piccolo;
import Juego.Personaje;
import Juego.Tablero;

public interface EstadoPiccolo {
	public abstract void atacar(Piccolo piccolo, Personaje oponente, Tablero tablero);
	
	public abstract void mover(Piccolo piccolo, int filaDestino, int columnaDestino, Tablero tablero);
}
