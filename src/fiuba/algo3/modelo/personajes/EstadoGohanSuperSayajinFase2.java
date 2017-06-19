package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;

public class EstadoGohanSuperSayajinFase2 implements EstadoGohan {

	private int ki = 0;
	private Coordenada coordenada;
	
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(this.coordenada, 100 + 100*(gohan.usarAumentoDeAtaque()), 4);
		this.ki += 5;
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
		oponente.recibirAtaqueDe(this.coordenada, 125 + 125*(gohan.usarAumentoDeAtaque()), 4);
		this.ki -= 10;
	}

	@Override
	public void mover(Gohan gohan, Coordenada coordenadaDestino) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 2 || distanciaVertical > 2){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		this.coordenada.vaciarCasillero();
		this.coordenada = coordenadaDestino;
		this.ki += 5;
	}

	@Override
	public void asignarCoordenadas(Gohan gohan, Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
	@Override
	public void recibirAtaque(Gohan gohan, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(gohan, poderDePelea);
	}

	@Override
	public void convertir(Gohan gohan) {
		EstadoGohan formaChocolate = new EstadoGohanChocolate();
		this.coordenada.obtenerCasillero().liberarDePersonaje();
		formaChocolate.asignarCoordenadas(gohan, this.coordenada);
		gohan.asignarEstado(formaChocolate);
	}
}
