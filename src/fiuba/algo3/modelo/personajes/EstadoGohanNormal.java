package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoGohanNormal implements EstadoGohan {

	private int ki = 0;
    private EstadoGohan estadoSiguiente = null;

	private int velocidad = 2;
	private EstadoNubeVoladora nubeVoladora;
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 15 + 15*(gohan.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
		this.transformar(gohan);
	}
	
	private void transformar(Gohan gohan) {
		if (this.ki >= 10){
			EstadoGohanSuperSayajinFase1 nuevaForma = new EstadoGohanSuperSayajinFase1();
			gohan.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(gohan, gohan.obtenerCoordenadas());
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
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 15*125/100 + 15*125/100*(gohan.usarAumentoDeAtaque()), 2);
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
	public void asignarCoordenadas(Gohan gohan, Coordenada coordenada) {
		//gohan.obtenerCoordenadas() = coordenada;
		coordenada.asignarPersonajeACasillero(gohan);
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
	     if (estadoSiguiente == null) cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva);
	     else estadoSiguiente.cambiarCoordenadas(coordenadaActual,coordenadaNueva);
	}

    @Override
    public void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if (nubeVoladora != null) cambiarCoordenadasConNubeVoladora(coordenadaActual,coordenadaNueva);
		else cambiarCoordenadasSinNubeVoladora(coordenadaActual,coordenadaNueva);
	}

	private void cambiarCoordenadasSinNubeVoladora(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad ) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();

	}

	private void cambiarCoordenadasConNubeVoladora(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		if (estadoSiguiente != null)  estadoSiguiente.tomarNubeVoladora(unaNubeVoladora);
		else this.nubeVoladora = unaNubeVoladora;
    }

    private void aumentarKi() {
		ki = ki + 5;
		if (ki == 20 ) estadoSiguiente = new EstadoGohanSuperSayajinFase1();
	}
}