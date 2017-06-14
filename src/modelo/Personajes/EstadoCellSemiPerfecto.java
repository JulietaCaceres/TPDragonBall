package modelo.Personajes;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class EstadoCellSemiPerfecto implements EstadoCell {
	
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),40 + 40*(cell.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(cell, filaDestino, columnaDestino, 3*cell.usarAumentoDeVelocidad());
	}
	
	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		cell.disminuirPuntosDeVidaEn(danio);		
	}

}
