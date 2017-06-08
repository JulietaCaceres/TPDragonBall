package Gohan;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoGohanSuperSayajinFase1 implements EstadoGohan {

	@Override
	public void atacar(Gohan gohan, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(gohan, oponente, tablero, 30 + 30*(gohan.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(gohan, filaDestino, columnaDestino, 2*gohan.usarAumentoDeVelocidad());
	}

}
