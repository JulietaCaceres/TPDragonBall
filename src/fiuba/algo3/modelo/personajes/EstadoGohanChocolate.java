package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;

public class EstadoGohanChocolate implements EstadoGohan {
	private int turnos = 3;
	
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		gohan.volverAEstadoNormal();
		gohan.atacar(oponente);
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 10){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		gohan.volverAEstadoNormal();
		gohan.realizarAtaqueEspecial(oponente);		
	}

	@Override
	public void mover(Gohan gohan, Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		gohan.volverAEstadoNormal();
		gohan.mover(coordenadaFinal);
	}
}
