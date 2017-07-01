package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoPiccoloChocolate implements EstadoPiccolo {

	private int turnos = 3;

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
	public void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada) {

	}

	@Override
	public void convertir(Piccolo piccolo) {
		EstadoPiccolo formaNormal = new EstadoPiccoloNormal();
		piccolo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaNormal.asignarCoordenadas(piccolo, piccolo.obtenerCoordenadas());
		piccolo.asignarEstado(formaNormal);
	}

	@Override
	public void recibirAtaque(Piccolo piccolo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(piccolo.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(piccolo.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(piccolo, poderDePelea);
	}

	@Override
	public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {

	}

	@Override
	public void referenciarAGogan(GuerrerosZ gohan) {

	}

    @Override
    public EstadoPiccolo cambiarCoordenadas(Piccolo piccolo, Coordenada coordenadaNueva) {
		turnos--;
		if (turnos > 0) {
			throw new GuerreroZConvertidoEnChocolateException();

		}
		return new EstadoPiccoloNormal();
	}
/*
    @Override
    public EstadoPiccolo cambiarCoordenadas(Coordenada coordenadaActual, Coordenada nuevaCoordenada) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}

		return new EstadoPiccoloNormal();
    }
*/
	}


