package modelo.Piccolo;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoPiccoloFortalecido implements EstadoPiccolo {
	@Override
	public void atacar(Piccolo piccolo, Personaje oponente, Tablero tablero) {		
		Ataque ataque = new Ataque();
		ataque.atacar(piccolo, oponente, tablero, 40 + 40*(piccolo.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Piccolo piccolo,int filaDestino,int columnaDestino, Tablero tablero) {
		tablero.moverA(piccolo, filaDestino, columnaDestino, 3*piccolo.usarAumentoDeVelocidad());		
	}
}
