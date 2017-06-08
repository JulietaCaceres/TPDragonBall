package Goku;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoGokuNormal implements EstadoGoku {
	
	@Override
	public void atacar(Goku goku, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(goku, oponente, tablero, 20 + 20*(goku.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(Goku goku,int filaDestino,int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 2*goku.usarAumentoDeVelocidad());		
	}

}
