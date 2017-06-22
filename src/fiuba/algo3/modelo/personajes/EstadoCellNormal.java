package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoCellNormal extends EstadoCell {
	
	EstadoCellNormal(){
		this.velocidad = 2;
		this.ki = 0;
		this.estadoSiguiente = null;
		this.nubeVoladora = null;
		this.cantidadDeAbsorciones = 0;
		this.alcance = 3;
		this.poder = 20;
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
			EstadoCell nuevoEstado = new EstadoCellSemiPerfecto();
			cell.asignarEstado(nuevoEstado);
		}
	}
}
