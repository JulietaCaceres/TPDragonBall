package modelo.Personajes;

import modelo.Juego.Ataque;
import modelo.Juego.Tablero;

public class EstadoPiccoloProtector implements EstadoPiccolo {
	@Override
	public void atacar(Piccolo piccolo, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(piccolo, oponente, tablero, 60 + 60*(piccolo.usarAumentoDeAtaque()), 6);
	}
	
	@Override
	public void mover(Piccolo piccolo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(piccolo, filaDestino, columnaDestino, 4*piccolo.usarAumentoDeVelocidad());
	}
}
