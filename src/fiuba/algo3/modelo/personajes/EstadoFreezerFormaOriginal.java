package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoFreezerFormaOriginal implements EstadoFreezer {
	
	private int ki = 0;
	
	@Override
	public void atacar(Freezer freezer, GuerrerosZ oponente){
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 50 + 50*(freezer.usarAumentoDeAtaque()), 3);
		this.ki += 5;
	}

	/*@Override
	public void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(freezer, filaDestino, columnaDestino, 6*freezer.usarAumentoDeVelocidad());
	}
*/
	public  void verificarDistancia(Freezer freezer, int distancia)
	{
		if (6*freezer.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
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

}
