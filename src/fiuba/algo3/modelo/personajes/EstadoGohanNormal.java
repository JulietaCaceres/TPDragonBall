package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGohanNormal implements EstadoGohan {

	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 15 + 15*(gohan.usarAumentoDeAtaque()), 2);
	}
	
	/*@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(gohan, filaDestino, columnaDestino, 2*gohan.usarAumentoDeVelocidad());
	}
*/
	public  void verificarDistancia(Gohan gohan, int distancia)
	{
		if (2*gohan.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 15){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		if(gohan.obtenerKi() < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 15*125/100 + 15*125/100*(gohan.usarAumentoDeAtaque()), 2);
		gohan.disminuirKiEn(10);
	}

}
