package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoFreezerNormal implements EstadoFreezer {
	
	private int ki = 0;
	private int velocidad = 4;
	@Override
	public void atacar(Freezer freezer, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 20 + 20*(freezer.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		this.transformar(freezer);
	}

	private void transformar(Freezer freezer) {
		if(this.ki == 20){
			EstadoFreezerSegundaForma nuevaForma = new EstadoFreezerSegundaForma();
			freezer.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(freezer, freezer.obtenerCoordenadas());
			freezer.asignarEstado(nuevaForma);
		}
	}

	@Override
	public void recibirDanio(Freezer freezer, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		freezer.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void rayoMortal(Freezer freezer, GuerrerosZ oponente) {
		if(this.ki < 20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 30 + 30*(freezer.usarAumentoDeAtaque()), 2);
		this.ki -= 20;
	}
	
	@Override
	public void mover(Freezer freezer, Coordenada coordenadaDestino) {
		int distanciaHorizontal = Math.abs(freezer.obtenerCoordenadas().obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(freezer.obtenerCoordenadas().obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 4 || distanciaVertical > 4){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		//this.freezer.obtenerCoordenadas().vaciarCasillero();
		//this.freezer.obtenerCoordenadas() = coordenadaDestino;
		this.ki += 5;
		this.transformar(freezer);
	}

	@Override
	public void asignarCoordenadas(Freezer freezer, Coordenada coordenada) {
		//this.freezer.obtenerCoordenadas() = coordenada;
		coordenada.asignarPersonajeACasillero(freezer);
	}
	
	@Override
	public void recibirAtaque(Freezer freezer, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea){
		int distanciaHorizontal = Math.abs(freezer.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(freezer.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(freezer, poderDePelea);
	}

    @Override
	public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

	private void aumentarKi() { ki = ki + 5;
	}


}
