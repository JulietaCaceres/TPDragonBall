package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoPiccoloNormal implements EstadoPiccolo {
	
	private int ki = 0;
	private int velocidad = 2;
	private EstadoPiccolo estado = null;
	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 20 + 20*(piccolo.usarAumentoDeAtaque()), 2);
		this.ki +=5;
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
		this.transformar(piccolo);
	}

	private void transformar(Piccolo piccolo) {
		if(this.ki == 20){
			EstadoPiccoloFortalecido nuevoEstado = new EstadoPiccoloFortalecido();
			piccolo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevoEstado.asignarCoordenadas(piccolo, piccolo.obtenerCoordenadas());
			piccolo.asignarEstado(nuevoEstado);
		}
	}

	private void transformarEnPiccoloProtector(Piccolo piccolo) {
		EstadoPiccoloProtector nuevoEstado = new EstadoPiccoloProtector();
		piccolo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		nuevoEstado.asignarCoordenadas(piccolo, piccolo.obtenerCoordenadas());
		piccolo.asignarEstado(nuevoEstado);
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
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 25, 2);
		this.ki -= 10;
	}

	@Override
	public void mover(Piccolo piccolo, Coordenada coordenadaDestino){
		/*int distanciaHorizontal = Math.abs(this.piccolo.obtenerCoordenadas().obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(this.piccolo.obtenerCoordenadas().obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 2 || distanciaVertical > 2){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		this.piccolo.obtenerCoordenadas().vaciarCasillero();
		this.piccolo.obtenerCoordenadas() = coordenadaDestino;
		coordenadaDestino.asignarPersonajeACasillero(piccolo);
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
		this.ki += 5;
		this.transformar(piccolo);
	*/}
	
	@Override
	public void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada) {
	    //	this.piccolo.obtenerCoordenadas() = coordenada;
		coordenada.asignarPersonajeACasillero(piccolo);
	}
	
	@Override
	public void recibirAtaque(Piccolo piccolo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea){
		int distanciaHorizontal = Math.abs(piccolo.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(piccolo.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(piccolo, poderDePelea);
	}

	@Override
	public void convertir(Piccolo piccolo) {
		EstadoPiccolo formaChocolate = new EstadoPiccoloChocolate();
		piccolo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaChocolate.asignarCoordenadas(piccolo, piccolo.obtenerCoordenadas());
		piccolo.asignarEstado(formaChocolate);		
	}

    @Override

	public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if (estado == null)cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva);
		if(estado !=null)estado.cambiarCoordenadas(coordenadaActual,coordenadaNueva);
	}

	@Override
	public void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

	private void aumentarKi() { ki = ki + 5;
	if (ki == 20) estado = new EstadoPiccoloFortalecido();
	}

}
