package modelo.Personajes;

import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public class EstadoGohanSuperSayajinFase1 implements EstadoGohan {

	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 30 + 30*(gohan.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(gohan, filaDestino, columnaDestino, 2*gohan.usarAumentoDeVelocidad());
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 30){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}

}
