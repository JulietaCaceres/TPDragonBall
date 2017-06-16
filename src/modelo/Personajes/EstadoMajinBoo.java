package modelo.Personajes;

import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public interface EstadoMajinBoo {
	
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente);

	public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero);

	public void recibirDanio(MajinBoo majinBoo, double danio);
}
