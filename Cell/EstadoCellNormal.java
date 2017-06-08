package Cell;
import Juego.Ataque;
import Juego.Personaje;
import Juego.Tablero;

public class EstadoCellNormal implements EstadoCell {

	@Override
	public void atacar(Cell cell, Personaje oponente, Tablero tablero) {
		Ataque ataque = new Ataque();
		ataque.atacar(cell, oponente, tablero, 20 + 20*(cell.usarAumentoDeAtaque()), 3);
	}

	@Override
	public void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(cell, filaDestino, columnaDestino, 2*cell.usarAumentoDeVelocidad());
	}

}
