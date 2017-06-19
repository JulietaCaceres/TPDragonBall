package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;

public class EstadoPiccoloChocolate implements EstadoPiccolo {
	
	private int turnos = 3;
	private Coordenada coordenada;
	
	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		this.convertir(piccolo);
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
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		this.convertir(piccolo);
	}

	@Override
	public void mover(Piccolo piccolo , Coordenada coordenadaFinal){
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		this.convertir(piccolo);
	}
	
	@Override
	public void convertir(Piccolo piccolo) {
		EstadoPiccolo formaNormal = new EstadoPiccoloNormal();
		this.coordenada.obtenerCasillero().liberarDePersonaje();
		formaNormal.asignarCoordenadas(piccolo, this.coordenada);
		piccolo.asignarEstado(formaNormal);
	}

	@Override
	public void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada) {
		this.coordenada = coordenada;
	}

	@Override
	public void recibirAtaque(Piccolo piccolo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(piccolo, poderDePelea);
	}
}
