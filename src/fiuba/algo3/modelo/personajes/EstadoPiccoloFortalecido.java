package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoPiccoloFortalecido implements EstadoPiccolo {
	
	private int ki = 0;

	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 40 + 40*(piccolo.usarAumentoDeAtaque()), 4);
		this.ki += 5;
	}

	private void transformarEnPiccoloProtector(Piccolo piccolo) {
		EstadoPiccoloProtector nuevoEstado = new EstadoPiccoloProtector(); 
		piccolo.asignarEstado(nuevoEstado);
	}

	/*@Override
	public void mover(Piccolo piccolo,int filaDestino,int columnaDestino, Tablero tablero) {
		tablero.moverA(piccolo, filaDestino, columnaDestino, 3*piccolo.usarAumentoDeVelocidad());		
	}
*/
	public  void verificarDistancia(Piccolo piccolo, int distancia)
	{
		if (3*piccolo.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}
	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 50, 4);
		this.ki -= 10;
	}
}