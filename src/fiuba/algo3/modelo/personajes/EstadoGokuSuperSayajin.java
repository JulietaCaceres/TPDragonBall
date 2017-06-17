package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGokuSuperSayajin implements EstadoGoku {
	
	private int ki = 0;
	
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 60*goku.aumentoDePoderPorAdrenalina() + 60*(goku.usarAumentoDeAtaque()), 4);
		this.ki += 5;
	}

	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 60){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void kamehameha(Goku goku, EnemigosDeLaTierra oponente) {
		if(this.ki<20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 90*goku.aumentoDePoderPorAdrenalina() + 90*(goku.usarAumentoDeAtaque()), 4);
		this.ki -= 20;
	}
	
	@Override
	public void mover(Goku goku, Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		int distanciaHorizontal = Math.abs(coordenadaInicial.obtenerColumna() - coordenadaFinal.obtenerColumna());
		int distanciaVertical = Math.abs(coordenadaInicial.obtenerFila() - coordenadaFinal.obtenerFila());
		
		if(distanciaHorizontal > 5 || distanciaVertical > 5){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		coordenadaInicial.vaciarCasillero();
		goku.asignarCoordenadas(coordenadaFinal);
		this.ki += 5;
	}
}
