package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoFreezerFormaOriginal implements EstadoFreezer {
	
	private int ki = 0;
    private EstadoFreezer estadoSiguiente = null;
	private int velocidad = 6;
	@Override
	public void atacar(Freezer freezer, GuerrerosZ oponente){
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 50 + 50*(freezer.usarAumentoDeAtaque()), 3);
		this.ki += 5;
	}

	@Override
	public void recibirDanio(Freezer freezer, double danio) {
		if(danio < 50){
			danio = danio*80/100;
		}
		freezer.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void rayoMortal(Freezer freezer, GuerrerosZ oponente) {
		if(this.ki < 20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 75 + 75*(freezer.usarAumentoDeAtaque()), 3);
		this.ki -= 20;
	}

	@Override
	public void mover(Freezer freezer, Coordenada coordenadaDestino) {
		int distanciaHorizontal = Math.abs(freezer.obtenerCoordenadas().obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(freezer.obtenerCoordenadas().obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 6 || distanciaVertical > 6){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		freezer.obtenerCoordenadas().vaciarCasillero();
		//freezer.obtenerCoordenadas() = coordenadaDestino;
		this.ki += 5;
	}
	
	@Override
	public void asignarCoordenadas(Freezer freezer, Coordenada coordenada) {
		//freezer.obtenerCoordenadas() = coordenada;
		coordenada.asignarPersonajeACasillero(freezer);
	}
	
	@Override
	public void recibirAtaque(Freezer freezer, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(freezer.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(freezer.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(freezer, poderDePelea);
	}

    @Override
	public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
          cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva);}


	@Override
	public void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();

	}

	private void aumentarKi() { ki = ki + 5;

	}
}
