package fiuba.algo3.modelo.personajes;


import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGokuNormal implements EstadoGoku {

	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 20 + 20*(goku.usarAumentoDeAtaque()), 2);
	}

	/*@Override
	public void mover(Goku goku,int filaDestino,int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 2*goku.usarAumentoDeVelocidad());
	}
	*/
	public  void verificarDistancia(Goku goku, int distancia)
	{
		if (2*goku.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}

	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void kamehameha(Goku goku, EnemigosDeLaTierra oponente) {
		if(goku.obtenerKi()<20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 30*goku.aumentoDePoderPorAdrenalina() + 30*(goku.usarAumentoDeAtaque()), 2);
		goku.disminuirKiEn(20);
	}

}