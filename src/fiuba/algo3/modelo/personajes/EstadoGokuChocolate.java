package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;

public class
EstadoGokuChocolate implements EstadoGoku {
	
	private int turnos = 3;
	
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
			
		}
		this.convertir(goku);
	}
	
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
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		this.convertir(goku);		
	}

	@Override
	public void asignarCoordenadas(Goku goku, Coordenada coordenada) {
		}

	@Override
	public void recibirAtaque(Goku goku, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(goku.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(goku.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(goku, poderDePelea);
	}

	@Override
	public void convertir(Goku goku) {
		EstadoGoku formaNormal = new EstadoGokuNormal();
		goku.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaNormal.asignarCoordenadas(goku, goku.obtenerCoordenadas());
		goku.asignarEstado(formaNormal);
	}

    @Override
    public EstadoGoku cambiarCoordenadas(Goku goku, Coordenada nuevaCoordenada) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		return new EstadoGokuNormal();
    }
/*
    @Override
    public EstadoGoku cambiarCoordenadas(Coordenada coordenadaActual, Coordenada coordenada) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
       return new EstadoGokuNormal();
	}
*/

	@Override
	public void tomarNubeVoladora(EstadoNubeVoladora estadoNubeVoladora) {

	}
}
