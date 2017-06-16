package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;

public class EstadoPiccoloChocolate implements EstadoPiccolo {
	
	private int turnos = 3;
	
	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		piccolo.volverAEstadoNormal();
		piccolo.atacar(oponente);
	}

	/*@Override
	public void mover(Piccolo piccolo, int filaDestino, int columnaDestino, Tablero tablero) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		piccolo.volverAEstadoNormal();
		piccolo.mover(tablero, filaDestino, columnaDestino);
	}*/

	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}

	@Override
	public void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		piccolo.volverAEstadoNormal();
		piccolo.realizarAtaqueEspecial(oponente);
	}

	@Override
	public void verificarDistancia(Piccolo piccolo, int distancia) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		piccolo.volverAEstadoNormal();
		piccolo.verificarDistancia(distancia);		
	}

}
