package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public interface EstadoPiccolo {
	public abstract void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente);
	
	public abstract void mover(Piccolo piccolo, int filaDestino, int columnaDestino, Tablero tablero);

	public abstract void recibirDanio(Piccolo piccolo, double danio);
}
