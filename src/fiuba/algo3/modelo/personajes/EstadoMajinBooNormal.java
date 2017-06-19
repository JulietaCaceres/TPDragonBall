package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoMajinBooNormal implements EstadoMajinBoo {
	
	private int ki;
	private Coordenada coordenada;

	@Override
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(this.coordenada,30 + 30*(majinBoo.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		this.transformar(majinBoo);
	}

	@Override
	public void recibirDanio(MajinBoo majinBoo, double danio) {
		if(danio < 30){
			danio = danio*80/100;
		}
		majinBoo.disminuirPuntosDeVidaEn(danio);
	}

	public void transformar(MajinBoo majinBoo) {
		if(this.ki == 20){
			EstadoMajinBooMalo nuevaForma = new EstadoMajinBooMalo();
			this.coordenada.obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(majinBoo, this.coordenada);
			majinBoo.asignarEstado(nuevaForma);
		}
	}
	
	@Override
	public void convertirEnChocolate(GuerrerosZ oponente) {
		if (this.ki < 5){
			throw new ExceptionAtaqueEspecial();
		}
		oponente.convertirseEnChocolate();
	}
	
	@Override
	public void mover(MajinBoo majinBoo, Coordenada coordenadaDestino) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 2 || distanciaVertical > 2){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		this.coordenada.vaciarCasillero();
		this.coordenada = coordenadaDestino;
		coordenadaDestino.asignarPersonajeACasillero(majinBoo);
		this.ki += 5;
		this.transformar(majinBoo);
	}

	@Override
	public void asignarCoordenadas(MajinBoo majinBoo, Coordenada coordenada) {
		this.coordenada = coordenada;
		coordenada.asignarPersonajeACasillero(majinBoo);
	}
	
	@Override
	public void recibirAtaque(MajinBoo majinBoo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(majinBoo, poderDePelea);
	}
}
