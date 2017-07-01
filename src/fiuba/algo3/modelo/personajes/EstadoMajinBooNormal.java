package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoMajinBooNormal implements EstadoMajinBoo {

	private int ki;

    private int velocidad = 2;
	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	@Override
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(majinBoo.obtenerCoordenadas(),30 + 30*(majinBoo.usarAumentoDeAtaque()), 2);
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
			majinBoo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(majinBoo, majinBoo.obtenerCoordenadas());
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
	public void asignarCoordenadas(MajinBoo majinBoo, Coordenada coordenada) {
		majinBoo.asignarCoordenadas(coordenada);
	}
	
	@Override
	public void recibirAtaque(MajinBoo majinBoo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(majinBoo.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(majinBoo.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(majinBoo, poderDePelea);
	}

	@Override
	public EstadoMajinBoo cambiarCoordenadas(MajinBoo majinBoo, Coordenada coordenadaNueva) {
		if ((Math.abs(majinBoo.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(majinBoo.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(majinBoo,coordenadaNueva);
		return aumentarKi();
	}
/*
	@Override
    public EstadoMajinBoo cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		return aumentarKi();
	}
*/
	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		nubeVoladora = unaNubeVoladora.iniciarNube();
    }

    private EstadoMajinBoo aumentarKi() {
		ki = ki + 5;
		if (ki == 20 ) return new EstadoMajinBooMalo();
		return this;
	}
}
