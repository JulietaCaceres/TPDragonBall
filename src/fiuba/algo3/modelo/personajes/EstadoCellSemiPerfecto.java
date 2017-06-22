package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoCellSemiPerfecto extends EstadoCell {
	
	EstadoCellSemiPerfecto(){
		this.poder = 40;
		this.alcance = 4;
		this.velocidad = 3;
		this.ki = 0;
		this.estadoSiguiente = null;
		this.nubeVoladora = null;
		this.cantidadDeAbsorciones = 0;
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
			EstadoCell nuevoEstado = new EstadoCellPerfecto();
			cell.asignarEstado(nuevoEstado);
		}
	}
}
