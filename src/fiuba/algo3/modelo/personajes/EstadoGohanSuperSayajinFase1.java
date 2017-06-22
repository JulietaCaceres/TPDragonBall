package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoGohanSuperSayajinFase1 implements EstadoGohan {

	private int ki = 0;
    private int velocidad = 2;
    private EstadoGohan estadoSiguiente = null;
    
	private EstadoNubeVoladora nubeVoladora;

	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 30 + 30*(gohan.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		this.transformarEnSuperSayajin2(gohan);
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
	
	private boolean vidaDeCompanierosMenorA30PorCiento(Gohan gohan){
		boolean todosMenorATreinta = true;
		String nombresCompanieros[] = {"Goku", "Piccolo"};
		double vidaDeCompanieros[] = gohan.obtenerPorcentajeVidaDeCompanieros(nombresCompanieros);
		for (int i = 0; i< vidaDeCompanieros.length; i++){
			if(vidaDeCompanieros[i] > 30){
				todosMenorATreinta = false;
			}
		}
		return todosMenorATreinta;
	}
	
	private void transformarEnSuperSayajin2(Gohan gohan) {
		if (this.ki >= 30 && this.vidaDeCompanierosMenorA30PorCiento(gohan)){
			EstadoGohanSuperSayajinFase2 nuevaForma = new EstadoGohanSuperSayajinFase2();
			gohan.asignarEstado(nuevaForma);
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
	}
}
