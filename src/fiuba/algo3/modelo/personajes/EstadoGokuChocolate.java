package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;

public class EstadoGokuChocolate implements EstadoGoku {
	
	private int turnos = 3;
	
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		goku.volverAEstadoNormal();
		goku.atacar(oponente);
	}

	/*@Override
	public void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		goku.volverAEstadoNormal();
		goku.mover(tablero, filaDestino, columnaDestino);
	}*/

	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}

	@Override
	public void kamehameha(Goku goku, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		goku.volverAEstadoNormal();
		goku.realizarAtaqueEspecial(oponente);		
	}
	
	@Override
	public void verificarDistancia(Goku goku, int distancia) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		goku.volverAEstadoNormal();
		goku.verificarDistancia(distancia);	
	}

}
