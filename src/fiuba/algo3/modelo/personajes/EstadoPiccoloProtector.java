package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoPiccoloProtector implements EstadoPiccolo {
	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 60 + 60*(piccolo.usarAumentoDeAtaque()), 6);
	}
	/*
	@Override
	public void mover(Piccolo piccolo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(piccolo, filaDestino, columnaDestino, 4*piccolo.usarAumentoDeVelocidad());
	}
*/
	public  void verificarDistancia(Piccolo piccolo, int distancia)
	{
		if (4*piccolo.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}
	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 60){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(piccolo.obtenerKi() < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 75, 6);
		piccolo.disminuirKiEn(10);
	}
}
