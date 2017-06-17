package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoCellNormal implements EstadoCell {

	private int ki = 0;
	private int cantidadDeAbsorciones = 0;
	
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),20 + 20*(cell.usarAumentoDeAtaque()), 3);
		this.ki += 5;
	}
	
	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
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
			cell.asignarEstado(nuevaForma);
		}
	}

	@Override
	public void mover(Cell cell, Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		int distanciaHorizontal = Math.abs(coordenadaInicial.obtenerColumna() - coordenadaFinal.obtenerColumna());
		int distanciaVertical = Math.abs(coordenadaInicial.obtenerFila() - coordenadaFinal.obtenerFila());
		
		if(distanciaHorizontal > 2 || distanciaVertical > 2){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		coordenadaInicial.vaciarCasillero();
		cell.asignarCoordenadas(coordenadaFinal);
		this.ki += 5;
	}
}
