package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public interface EstadoGohan {
	
	public abstract void atacar(Gohan gohan, EnemigosDeLaTierra oponente);
	
	public abstract void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero);

	public abstract void recibirDanio(Gohan gohan, double danio);

	public abstract void masenko(Gohan gohan, EnemigosDeLaTierra oponente);
}
