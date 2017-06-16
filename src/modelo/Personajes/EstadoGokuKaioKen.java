package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public class EstadoGokuKaioKen implements EstadoGoku {

	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 40*goku.aumentoDePoderPorAdrenalina() + 40*(goku.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 3*goku.usarAumentoDeVelocidad());
	}

	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}

	@Override
	public void kamehameha(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 60*goku.aumentoDePoderPorAdrenalina() + 60*(goku.usarAumentoDeAtaque()), 2);
		goku.disminuirKiEn(20);
	}
}
