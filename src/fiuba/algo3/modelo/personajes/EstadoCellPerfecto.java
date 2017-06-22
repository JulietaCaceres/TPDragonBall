package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoCellPerfecto extends EstadoCell {
	
	EstadoCellPerfecto(){
		this.poder = 80;
		this.alcance = 4;
		this.velocidad = 4;
		this.ki = 0;
		this.estadoSiguiente = null;
		this.nubeVoladora = null;
		this.cantidadDeAbsorciones = 0;
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
}
