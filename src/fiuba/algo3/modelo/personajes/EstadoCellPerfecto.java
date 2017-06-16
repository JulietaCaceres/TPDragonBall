package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoCellPerfecto implements EstadoCell {
	
	private int ki;
	
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),80 + 80*(cell.usarAumentoDeAtaque()), 4);
		this.ki +=5;
	}

	/*@Override
	public void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(cell, filaDestino, columnaDestino, 4*cell.usarAumentoDeVelocidad());
	}*/
	
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
	public void verificarDistancia(Cell cell, int distancia) {
		
		if (4*cell.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
				
	}

}
