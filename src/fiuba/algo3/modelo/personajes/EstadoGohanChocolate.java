package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGohanChocolate implements EstadoGohan {
	private int turnos = 3;
	
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		gohan.volverAEstadoNormal();
		gohan.atacar(oponente);
	}

	/*@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		gohan.volverAEstadoNormal();
		gohan.mover(tablero, filaDestino, columnaDestino);
	}*/

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 10){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		gohan.volverAEstadoNormal();
		gohan.realizarAtaqueEspecial(oponente);		
	}

	@Override
	public void verificarDistancia(Gohan gohan, int distancia) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		gohan.volverAEstadoNormal();
		gohan.verificarDistancia(distancia);
	}
}
