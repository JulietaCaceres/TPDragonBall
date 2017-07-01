package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoGokuNormal implements EstadoGoku {

	private int ki = 0;
    private EstadoGoku estadoSiguiente = null;
    private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	private int velocidad = 2;
		
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 20*(goku.aumentoDePoderPorAdrenalina() + goku.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		this.transformar(goku);
	}

	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void kamehameha(Goku goku, EnemigosDeLaTierra oponente) {
		if(this.ki<20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 30*goku.aumentoDePoderPorAdrenalina() + 30*(goku.usarAumentoDeAtaque()), 2);
		this.ki -= 20;
	}

	public void transformar(Goku goku){
		if(this.ki == 20){
			EstadoGoku nuevaForma = new EstadoGokuKaioKen();
			goku.asignarEstado(nuevaForma);
		}
	}
	
	@Override
	public void asignarCoordenadas(Goku goku, Coordenada coordenada) {
	    goku.asignarCoordenadas(coordenada);
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
		formaChocolate.asignarCoordenadas(goku,goku.obtenerCoordenadas());
		goku.asignarEstado(formaChocolate);		
	}

    @Override
    public EstadoGoku cambiarCoordenadas(Goku goku, Coordenada coordenadaNueva) {
		if ((Math.abs(goku.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(goku.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(goku,coordenadaNueva);
		return 	aumentarKi();

    }
/*
    @Override
    public EstadoGoku cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
	    return 	aumentarKi();

	}
*/
	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		 nubeVoladora = unaNubeVoladora.iniciarNube();
    }

    private EstadoGoku aumentarKi() {
		ki = ki + 5;
		if (ki == 20 ) return new EstadoGokuKaioKen();
		return this;
	}
}