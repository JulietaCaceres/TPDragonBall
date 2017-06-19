package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;

public class EstadoGokuKaioKen implements EstadoGoku {
	
	private int ki = 0;
	private Coordenada coordenada;
	
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(this.coordenada, 40*goku.aumentoDePoderPorAdrenalina() + 40*(goku.usarAumentoDeAtaque()), 4);
		this.ki += 5;
		this.transformar(goku);
	}
	
	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void kamehameha(Goku goku, EnemigosDeLaTierra oponente) {
		if(this.ki<20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(this.coordenada, 60*goku.aumentoDePoderPorAdrenalina() + 60*(goku.usarAumentoDeAtaque()), 4);
		this.ki -= 20;
	}

	public void transformar(Goku goku){
		if(this.ki == 50){
			EstadoGoku nuevaForma = new EstadoGokuSuperSayajin();
			this.coordenada.obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(goku, this.coordenada);
			goku.asignarEstado(nuevaForma);
		}
	}
	
	@Override
	public void mover(Goku goku, Coordenada coordenadaDestino){
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 3 || distanciaVertical > 3){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		this.coordenada.vaciarCasillero();
		this.coordenada = coordenadaDestino;
		coordenadaDestino.asignarPersonajeACasillero(goku);
		//goku.asignarCoordenadas(coordenadaFinal);
		this.ki += 5;
		this.transformar(goku);
	}
	
	@Override
	public void asignarCoordenadas(Goku goku, Coordenada coordenada) {
		this.coordenada = coordenada;
		coordenada.asignarPersonajeACasillero(goku);
	}
	
	@Override
	public void recibirAtaque(Goku goku, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(goku, poderDePelea);
	}
	
	@Override
	public void convertir(Goku goku) {
		EstadoGoku formaChocolate = new EstadoGokuChocolate();
		this.coordenada.obtenerCasillero().liberarDePersonaje();
		formaChocolate.asignarCoordenadas(goku, this.coordenada);
		goku.asignarEstado(formaChocolate);		
	}
}
