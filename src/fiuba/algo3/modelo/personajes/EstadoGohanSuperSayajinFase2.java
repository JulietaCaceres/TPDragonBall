package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGohanSuperSayajinFase2 implements EstadoGohan {

	private int ki = 0;
	
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 100 + 100*(gohan.usarAumentoDeAtaque()), 4);
		this.ki += 5;
	}

	/*@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(gohan, filaDestino, columnaDestino, 3*gohan.usarAumentoDeVelocidad());
	}
	*/
	public  void verificarDistancia(Gohan gohan, int distancia)
	{
		if (3*gohan.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 100){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 125 + 125*(gohan.usarAumentoDeAtaque()), 4);
		this.ki -= 10;
	}
}