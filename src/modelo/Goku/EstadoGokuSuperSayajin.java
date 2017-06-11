package modelo.Goku;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoGokuSuperSayajin implements EstadoGoku {

	@Override
	public void atacar(Goku goku, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(goku, oponente, tablero, 60 + 60*(goku.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 5*goku.usarAumentoDeVelocidad());
	}

}
