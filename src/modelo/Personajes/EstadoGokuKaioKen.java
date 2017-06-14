package modelo.Personajes;

import modelo.Juego.Ataque;
import modelo.Juego.Tablero;

public class EstadoGokuKaioKen implements EstadoGoku {

	@Override
	public void atacar(Goku goku, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(goku, oponente, tablero, 40 + 40*(goku.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 3*goku.usarAumentoDeVelocidad());
	}

	@Override
	public int obtenerVelocidad() {
		// TODO Auto-generated method stub
		return 0;
	}

}
