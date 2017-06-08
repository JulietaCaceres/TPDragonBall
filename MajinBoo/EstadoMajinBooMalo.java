package MajinBoo;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoMajinBooMalo implements EstadoMajinBoo {

	@Override
	public void atacar(MajinBoo majinBoo, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(majinBoo, oponente, tablero, 50 + 50*(majinBoo.usarAumentoDeAtaque()), 2);
	}
	
	@Override
	public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(majinBoo, filaDestino, columnaDestino, 3*majinBoo.usarAumentoDeVelocidad());
	}

}
