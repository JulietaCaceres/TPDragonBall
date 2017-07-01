package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoMajinBooOriginal implements EstadoMajinBoo {
	
	private int ki = 0;
	private int velocidad = 4;
	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	@Override
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(majinBoo.obtenerCoordenadas(),60 + 60*(majinBoo.usarAumentoDeAtaque()), 3);
		this.ki += 5;
	}

	@Override
	public void recibirDanio(MajinBoo majinBoo, double danio) {
		if(danio < 60){
			danio = danio*80/100;
		}
		majinBoo.disminuirPuntosDeVidaEn(danio);
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
    public EstadoMajinBoo cambiarCoordenadas(MajinBoo  majinBoo,Coordenada coordenadaNueva) {
		if ((Math.abs(majinBoo.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(majinBoo.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(majinBoo,coordenadaNueva);
		return aumentarKi();
	}


	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		this.nubeVoladora = unaNubeVoladora.iniciarNube();
    }

    private EstadoMajinBoo aumentarKi() {
		ki = ki + 5;
		return this;
	}
}
