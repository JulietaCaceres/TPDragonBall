package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.GuerrerosZ;
import fiuba.algo3.modelo.juego.Tablero;

public interface EstadoPiccolo {
	public abstract void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente);
	
	//public abstract void mover(Piccolo piccolo, int filaDestino, int columnaDestino, Tablero tablero);

	void verificarDistancia(Piccolo piccolo, int distancia);

	public abstract void recibirDanio(Piccolo piccolo, double danio);
}
