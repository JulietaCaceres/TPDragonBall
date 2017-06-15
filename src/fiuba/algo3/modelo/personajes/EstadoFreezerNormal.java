package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoFreezerNormal implements EstadoFreezer {

	@Override
	public void atacar(Freezer freezer, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 20 + 20*(freezer.usarAumentoDeAtaque()), 2);
	}

	/*@Override
	public void mover(Freezer freezer, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(freezer, filaDestino, columnaDestino, 4*freezer.usarAumentoDeVelocidad());
	}
*/
	public  void verificarDistancia(Freezer freezer, int distancia)
	{
		if (4*freezer.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}
	@Override
	public void recibirDanio(Freezer freezer, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		freezer.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void rayoMortal(Freezer freezer, GuerrerosZ oponente) {
		if(freezer.obtenerKi() < 20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 30 + 30*(freezer.usarAumentoDeAtaque()), 2);
		freezer.disminuirKiEn(20);
	}

}
