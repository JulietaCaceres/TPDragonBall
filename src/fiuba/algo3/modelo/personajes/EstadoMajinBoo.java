package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoMajinBoo {
	
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente);

	//public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero);

	void verificarDistancia(MajinBoo majinBoo, int distancia);

	public void recibirDanio(MajinBoo majinBoo, double danio);
}
