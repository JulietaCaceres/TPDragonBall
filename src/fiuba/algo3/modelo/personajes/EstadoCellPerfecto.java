package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoCellPerfecto implements EstadoCell {
	
	private int ki;

    private int velocidad = 4;
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),80 + 80*(cell.usarAumentoDeAtaque()), 4);
		this.ki +=5;
	}
	
	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 80){
			danio = danio*80/100;
		}
		cell.disminuirPuntosDeVidaEn(danio);		
	}
	
	@Override
	public void absorberVida(Cell cell, GuerrerosZ oponente) {
		if(this.ki < 5)
			throw new ExceptionAtaqueEspecial();
		double aumentoPorEsferaDelDragon = 80*cell.usarAumentoDeAtaque();
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),80 + 80*(cell.usarAumentoDeAtaque()), 4);
		cell.aumentarVidaEn(80 + aumentoPorEsferaDelDragon);
		this.ki -= 5;
	}

	@Override
	public void mover(Cell cell, Coordenada coordenadaDestino) {
		int distanciaHorizontal = Math.abs(cell.obtenerCoordenadas().obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(cell.obtenerCoordenadas().obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 4 || distanciaVertical > 4){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		cell.obtenerCoordenadas().vaciarCasillero();
		coordenadaDestino.asignarPersonajeACasillero(cell);
		this.ki += 5;
	}

	@Override
	public void asignarCoordenadas(Cell cell, Coordenada coordenada) {
		//cell.obtenerCoordenadas() = coordenada;
		coordenada.asignarPersonajeACasillero(cell);
	}
	
	@Override
	public void recibirAtaque(Cell cell, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(cell.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(cell.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(cell, poderDePelea);
	}

    @Override
	public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva);
	}

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
