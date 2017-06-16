package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public interface EstadoGoku {	
	
	public abstract void atacar(Goku goku, EnemigosDeLaTierra oponente);
	
	public abstract void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero);

	public abstract void recibirDanio(Goku goku, double danio);

	public abstract void kamehameha(Goku goku, EnemigosDeLaTierra oponente);

}
