package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;

public class EstadoGokuChocolate implements EstadoGoku {
	
	private int turnos = 3;
	private Coordenada coordenada;
	
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
			
		}
		this.convertir(goku);
	}

	@Override
	public void mover(Goku goku, Coordenada coordenadaFinal) {
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
		this.coordenada = coordenada;
	}

	@Override
	public void recibirAtaque(Goku goku, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(goku, poderDePelea);
	}

	@Override
	public void convertir(Goku goku) {
		EstadoGoku formaNormal = new EstadoGokuNormal();
		this.coordenada.obtenerCasillero().liberarDePersonaje();
		formaNormal.asignarCoordenadas(goku, this.coordenada);
		goku.asignarEstado(formaNormal);
	}
}
