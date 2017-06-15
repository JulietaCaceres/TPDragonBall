package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.Tablero;

public class EstadoGokuSuperSayajin implements EstadoGoku {

	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 60 + 60*(goku.usarAumentoDeAtaque()), 4);
	}
/*
	@Override
	public void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 5*goku.usarAumentoDeVelocidad());
	}
*/	public  void verificarDistancia(Goku goku, int distancia)
	{
		if (5*goku.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}
	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 60){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}

}
