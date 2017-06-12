package modelo.Personajes;

import modelo.Juego.Tablero;

public interface EstadoMajinBoo {
	
	public void atacar(MajinBoo majinBoo, Personaje oponente, Tablero tablero);

	public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero);
}
