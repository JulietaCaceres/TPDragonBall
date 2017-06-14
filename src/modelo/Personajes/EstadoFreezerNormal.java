package modelo.Personajes;

import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class EstadoFreezerNormal implements EstadoFreezer {

	@Override
	public void atacar(Freezer freezer, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 20 + 20*(freezer.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(freezer, filaDestino, columnaDestino, 4*freezer.usarAumentoDeVelocidad());
	}

	@Override
	public void recibirDanio(Freezer freezer, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		freezer.disminuirPuntosDeVidaEn(danio);
	}

}
