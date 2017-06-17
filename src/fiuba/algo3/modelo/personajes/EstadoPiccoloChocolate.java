package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
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
	public void mover(Piccolo piccolo, Coordenada coordenadaInicial, Coordenada coordenadaFinal){
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		piccolo.volverAEstadoNormal();
		piccolo.mover(coordenadaFinal);
	}

}
