package Cell;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoCellSemiPerfecto implements EstadoCell {

	@Override
	public void atacar(Cell cell, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(cell, oponente, tablero, 40 + 40*(cell.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(cell, filaDestino, columnaDestino, 3*cell.usarAumentoDeVelocidad());
	}

}
