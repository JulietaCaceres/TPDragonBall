package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoCellSemiPerfecto implements EstadoCell {
	
	private int cantidadDeAbsorciones = 0;
	private int ki;
    private EstadoCell estadoSiguiente  = null;
    private int velocidad = 3;
	private EstadoNubeVoladora nubeVoladora;
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),40 + 40*(cell.usarAumentoDeAtaque()), 4);
		this.ki += 5;
	}
	
	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		cell.disminuirPuntosDeVidaEn(danio);		
	}
	
	@Override
	public void absorberVida(Cell cell, GuerrerosZ oponente) {
		if(this.ki < 5)
			throw new ExceptionAtaqueEspecial();
		double aumentoPorEsferaDelDragon = 40*cell.usarAumentoDeAtaque();
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),40 + 40*(cell.usarAumentoDeAtaque()), 4);
		cell.aumentarVidaEn(40 + aumentoPorEsferaDelDragon);
		this.ki -= 5;
		this.cantidadDeAbsorciones++;
		this.transformar(cell);
	}
	
	private void transformar(Cell cell) {
		if(this.cantidadDeAbsorciones == 8){
			EstadoCell nuevaForma = new EstadoCellPerfecto();
			cell.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(cell, cell.obtenerCoordenadas());
			cell.asignarEstado(nuevaForma);
		}
	}

	@Override
	public void asignarCoordenadas(Cell cell, Coordenada coordenada) {
		//this.cell.obtenerCoordenadas() = coordenada;
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
	     if (estadoSiguiente == null) cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva);
	     else estadoSiguiente.cambiarCoordenadas(coordenadaActual,coordenadaNueva);
	}

    @Override
    public void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if (nubeVoladora != null) cambiarCoordenadasConNubeVoladora(coordenadaActual,coordenadaNueva);
		else cambiarCoordenadasSinNubeVoladora(coordenadaActual,coordenadaNueva);
	}

	private void cambiarCoordenadasSinNubeVoladora(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad ) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();

	}

	private void cambiarCoordenadasConNubeVoladora(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		if (estadoSiguiente != null)  estadoSiguiente.tomarNubeVoladora(unaNubeVoladora);
		else this.nubeVoladora = unaNubeVoladora;
    }

    private void aumentarKi() {
		ki = ki + 5;
	}
}
