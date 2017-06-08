package Gohan;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoGohanSuperSayajinFase2 implements EstadoGohan {

	@Override
	public void atacar(Gohan gohan, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(gohan, oponente, tablero, 100 + 100*(gohan.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(gohan, filaDestino, columnaDestino, 3*gohan.usarAumentoDeVelocidad());
	}

}
