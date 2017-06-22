package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;

public class EstadoGohanChocolate implements EstadoGohan {
	private int turnos = 3;

	
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		this.convertir(gohan);
	}

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
		this.convertir(gohan);		
	}

	@Override
	public void convertir(Gohan gohan) {
		EstadoGohan formaNormal = new EstadoGohanNormal();
		gohan.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaNormal.asignarCoordenadas(gohan, gohan.obtenerCoordenadas());
		gohan.asignarEstado(formaNormal);
	}

    @Override
    public void cambiarCoordenadas(Coordenada coordenadaActual, Coordenada coordenadaFutura) {
        cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaFutura);
    }

    @Override
    public void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva) {

		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}

    }

    @Override
	public void asignarCoordenadas(Gohan gohan, Coordenada coordenada) {
		//this.gohan.obtenerCoordenadas() = coordenada;
	}

	@Override
	public void recibirAtaque(Gohan gohan, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(gohan.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(gohan.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(gohan, poderDePelea);
	}

	@Override
	public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		
	}
}
