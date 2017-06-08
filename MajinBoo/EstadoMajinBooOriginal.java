package MajinBoo;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoMajinBooOriginal implements EstadoMajinBoo {

	@Override
	public void atacar(MajinBoo majinBoo, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(majinBoo, oponente, tablero, 60 + 60*(majinBoo.usarAumentoDeAtaque()), 3);
	}

	@Override
	public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(majinBoo, filaDestino, columnaDestino, 4*majinBoo.usarAumentoDeVelocidad());
	}

}
