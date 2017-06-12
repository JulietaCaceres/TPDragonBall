package modelo.Personajes;

import modelo.Juego.Ataque;
import modelo.Juego.Tablero;

public class EstadoMajinBooNormal implements EstadoMajinBoo {

	@Override
	public void atacar(MajinBoo majinBoo, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(majinBoo, oponente, tablero, 30 + 30*(majinBoo.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(majinBoo, filaDestino, columnaDestino, 2*majinBoo.usarAumentoDeVelocidad());
	}

}
