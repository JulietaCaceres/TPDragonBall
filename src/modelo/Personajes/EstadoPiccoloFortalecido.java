package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public class EstadoPiccoloFortalecido implements EstadoPiccolo {
	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {		
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 40 + 40*(piccolo.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Piccolo piccolo,int filaDestino,int columnaDestino, Tablero tablero) {
		tablero.moverA(piccolo, filaDestino, columnaDestino, 3*piccolo.usarAumentoDeVelocidad());		
	}

	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
}
