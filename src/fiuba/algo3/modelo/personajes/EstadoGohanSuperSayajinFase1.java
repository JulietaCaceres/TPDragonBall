package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoGohanSuperSayajinFase1 implements EstadoGohan {

	private int ki = 0;
    private int velocidad = 2;
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 30 + 30*(gohan.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 30){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}

	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 30*25/100 + 30*25/100*(gohan.usarAumentoDeAtaque()), 2);
		this.ki -= 10;
	}
	
	public void transformarEnSuperSayajin2(Gohan gohan) {
		if (this.ki >= 30){
			EstadoGohanSuperSayajinFase2 nuevaForma = new EstadoGohanSuperSayajinFase2();
			gohan.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(gohan, gohan.obtenerCoordenadas());
			gohan.asignarEstado(nuevaForma);
			this.ki -= 30;
		}
	}
	
	@Override
	public void mover(Gohan gohan, Coordenada coordenadaDestino) {
		int distanciaHorizontal = Math.abs(gohan.obtenerCoordenadas().obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(gohan.obtenerCoordenadas().obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 2 || distanciaVertical > 2){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		//this.gohan.obtenerCoordenadas().vaciarCasillero();
		//this.gohan.obtenerCoordenadas() = coordenadaDestino;
		this.ki += 5;
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
	}

	@Override
	public void asignarCoordenadas(Gohan gohan, Coordenada coordenada) {
		//gohan.obtenerCoordenadas() = coordenada;
	}
	
	@Override
	public void recibirAtaque(Gohan gohan, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(gohan.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(gohan.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(gohan, poderDePelea);
	}

	@Override
	public void convertir(Gohan gohan) {
		EstadoGohan formaChocolate = new EstadoGohanChocolate();
		gohan.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaChocolate.asignarCoordenadas(gohan, gohan.obtenerCoordenadas());
		gohan.asignarEstado(formaChocolate);
	}

    @Override
	public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

	private void aumentarKi() { ki = ki + 5;
	}
}
