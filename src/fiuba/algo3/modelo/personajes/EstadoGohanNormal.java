package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoGohanNormal implements EstadoGohan {
	
	private int ki = 0;
	private Coordenada coordenada;
    private int velocidad = 2;
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(this.coordenada, 15 + 15*(gohan.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
		this.transformar(gohan);
	}
	
	private void transformar(Gohan gohan) {
		if (this.ki >= 10){
			EstadoGohanSuperSayajinFase1 nuevaForma = new EstadoGohanSuperSayajinFase1();
			this.coordenada.obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(gohan, this.coordenada);
			gohan.asignarEstado(nuevaForma);
			this.ki -= 10;
		}
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 15){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(this.coordenada, 15*125/100 + 15*125/100*(gohan.usarAumentoDeAtaque()), 2);
		this.ki -= 10;
	}

	public void transformarEnSuperSayajin2(Gohan gohan) {
		if (this.ki >= 30){
			EstadoGohanSuperSayajinFase2 nuevaForma = new EstadoGohanSuperSayajinFase2();
			this.coordenada.obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(gohan, this.coordenada);
			gohan.asignarEstado(nuevaForma);
			this.ki -= 30;
		}
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
		this.transformar(gohan);
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
	}

	@Override
	public void asignarCoordenadas(Gohan gohan, Coordenada coordenada) {
		this.coordenada = coordenada;
		coordenada.asignarPersonajeACasillero(gohan);
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

    @Override
	public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

	private void aumentarKi() {
		ki = ki + 5;
	}


}