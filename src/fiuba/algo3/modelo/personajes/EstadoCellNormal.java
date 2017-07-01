package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoCellNormal implements EstadoCell {

	private int ki = 0;
	private int cantidadDeAbsorciones = 0;
	private int velocidad = 2;
	private EstadoCell estadoSiguiente = null;
	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),20 + 20*(cell.usarAumentoDeAtaque()), 3);
		this.ki += 5;
	}
	
	@Override
	public void recibirDanio(Cell cell, double danio) {
		//if(danio < 20){
		//	danio = danio*80/100;
		//}
		cell.disminuirPuntosDeVidaEn(danio);		
	}

	@Override
	public void absorberVida(Cell cell, GuerrerosZ oponente) {
		if(this.ki < 5)
			throw new ExceptionAtaqueEspecial();
		double aumentoPorEsferaDelDragon = 20*cell.usarAumentoDeAtaque();
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),20 + aumentoPorEsferaDelDragon, 3);
		cell.aumentarVidaEn(20 + aumentoPorEsferaDelDragon);
		this.ki -= 5;
		this.cantidadDeAbsorciones ++;
		this.transformar(cell);
	}

	private void transformar(Cell cell) {
		if(this.cantidadDeAbsorciones == 4){
			EstadoCell nuevaForma = new EstadoCellSemiPerfecto();
			cell.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(cell, cell.obtenerCoordenadas());
			cell.asignarEstado(nuevaForma);
			estadoSiguiente = new EstadoCellSemiPerfecto();
		}
	}

	@Override
	public void asignarCoordenadas(Cell cell, Coordenada coordenada) {

		cell.asignarCoordenadas(coordenada);
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
	public EstadoCell cambiarCoordenadas(Cell cell, Coordenada coordenadaNueva) {
		if ((Math.abs(cell.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(cell.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(cell,coordenadaNueva);
		aumentarKi();
		if (cantidadDeAbsorciones == 4 ) return new EstadoCellSemiPerfecto();
		return this;

	}

	/*@Override
    public EstadoCell cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
        aumentarKi();
        if (cantidadDeAbsorciones == 4 ) return new EstadoCellSemiPerfecto();
        return this;

	}
*/

	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		nubeVoladora = unaNubeVoladora.iniciarNube();
    }

    private void  aumentarKi() {
		ki = ki + 5;
	}
}
