package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;

public class EstadoPiccoloFortalecido implements EstadoPiccolo {
	
	private int ki = 0;
	private Coordenada coordenadas;

	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 40 + 40*(piccolo.usarAumentoDeAtaque()), 4);
		this.ki += 5;
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
	}

	private void transformarEnPiccoloProtector(Piccolo piccolo) {
		EstadoPiccoloProtector nuevoEstado = new EstadoPiccoloProtector(); 
		piccolo.asignarEstado(nuevoEstado);
	}

	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(this.coordenadas, 50, 4);
		this.ki -= 10;
	}
	
	@Override
	public void mover(Piccolo piccolo, Coordenada coordenadaDestino){
		int distanciaHorizontal = Math.abs(this.coordenadas.obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenadas.obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 3 || distanciaVertical > 3){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		this.coordenadas.vaciarCasillero();
		coordenadaDestino.asignarPersonajeACasillero(piccolo);
		this.ki += 5;
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
	}
	
	@Override
	public void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada) {
		this.coordenadas = coordenada;
		coordenada.asignarPersonajeACasillero(piccolo);
	}
	
	@Override
	public void recibirAtaque(Piccolo piccolo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea){
		int distanciaHorizontal = Math.abs(this.coordenadas.obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenadas.obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(piccolo, poderDePelea);
	}

	@Override
	public void convertir(Piccolo piccolo) {
		EstadoPiccolo formaChocolate = new EstadoPiccoloChocolate();
		this.coordenadas.obtenerCasillero().liberarDePersonaje();
		formaChocolate.asignarCoordenadas(piccolo, this.coordenadas);
		piccolo.asignarEstado(formaChocolate);		
	}
}
