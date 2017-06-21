package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoGokuKaioKen implements EstadoGoku {
	
	private int ki = 0;
	private EstadoGoku estadoSiguiente = null;
	private int velocidad = 3;

	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 40*goku.aumentoDePoderPorAdrenalina() + 40*(goku.usarAumentoDeAtaque()), 4);
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
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 60*goku.aumentoDePoderPorAdrenalina() + 60*(goku.usarAumentoDeAtaque()), 4);
		this.ki -= 20;
	}

	public void transformar(Goku goku){
		if(this.ki == 50){
			EstadoGoku nuevaForma = new EstadoGokuSuperSayajin();
			goku.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(goku,goku.obtenerCoordenadas());
			goku.asignarEstado(nuevaForma);
		}
	}

	@Override
	public void asignarCoordenadas(Goku goku, Coordenada coordenada) {
		
	}


	@Override
	public void recibirAtaque(Goku goku, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(goku.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(goku.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(goku, poderDePelea);
	}
	
	@Override
	public void convertir(Goku goku) {
		EstadoGoku formaChocolate = new EstadoGokuChocolate();
		goku.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaChocolate.asignarCoordenadas(goku, goku.obtenerCoordenadas());
		goku.asignarEstado(formaChocolate);		
	}

    @Override
    public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva, int aumentoDeVelocidad) {
	     if (estadoSiguiente == null) 
	    	 cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva, aumentoDeVelocidad);
	     else
	    	 estadoSiguiente.cambiarCoordenadas(coordenadaActual,coordenadaNueva, aumentoDeVelocidad);
	}

    @Override
    public void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva, int aumentoDeVelocidad){
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad*aumentoDeVelocidad) 
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad*aumentoDeVelocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

    private void aumentarKi() {
		ki = ki +5;
		if (ki == 50) estadoSiguiente = new EstadoGokuSuperSayajin();
	}
}
