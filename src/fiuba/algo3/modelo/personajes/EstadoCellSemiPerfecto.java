package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoCellSemiPerfecto implements EstadoCell {
	
	private int cantidadDeAbsorciones = 0;
	private int ki;

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
			cell.asignarEstado(nuevaForma);
		}
	}

	@Override
	public void mover(Cell cell, Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		int distanciaHorizontal = Math.abs(coordenadaInicial.obtenerColumna() - coordenadaFinal.obtenerColumna());
		int distanciaVertical = Math.abs(coordenadaInicial.obtenerFila() - coordenadaFinal.obtenerFila());
		
		if(distanciaHorizontal > 3 || distanciaVertical > 3){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		coordenadaInicial.vaciarCasillero();
		cell.asignarCoordenadas(coordenadaFinal);
		this.ki += 5;
	}

}
