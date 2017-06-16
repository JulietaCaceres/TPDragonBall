package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public class EstadoGohanSuperSayajinFase2 implements EstadoGohan {

	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 100 + 100*(gohan.usarAumentoDeAtaque()), 4);
	}

	@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(gohan, filaDestino, columnaDestino, 3*gohan.usarAumentoDeVelocidad());
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 100){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}

	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 125 + 125*(gohan.usarAumentoDeAtaque()), 4);
		gohan.disminuirKiEn(10);
	}
}
