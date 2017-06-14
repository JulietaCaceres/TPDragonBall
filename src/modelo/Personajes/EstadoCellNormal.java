package modelo.Personajes;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class EstadoCellNormal implements EstadoCell {

	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),20 + 20*(cell.usarAumentoDeAtaque()), 3);
	}

	@Override
	public void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(cell, filaDestino, columnaDestino, 2*cell.usarAumentoDeVelocidad());
	}

	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		cell.disminuirPuntosDeVidaEn(danio);		
	}

}
