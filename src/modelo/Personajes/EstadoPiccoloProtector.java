package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public class EstadoPiccoloProtector implements EstadoPiccolo {
	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 60 + 60*(piccolo.usarAumentoDeAtaque()), 6);
	}
	
	@Override
	public void mover(Piccolo piccolo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(piccolo, filaDestino, columnaDestino, 4*piccolo.usarAumentoDeVelocidad());
	}

	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 60){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
}
