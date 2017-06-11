package modelo.Cell;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoCellPerfecto implements EstadoCell {

	@Override
	public void atacar(Cell cell, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(cell, oponente, tablero, 80 + 80*(cell.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(cell, filaDestino, columnaDestino, 4*cell.usarAumentoDeVelocidad());
	}

}
