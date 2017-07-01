package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class EstadoGohanSuperSayajinFase2 implements EstadoGohan {

	private int ki = 0;

	private int velocidad = 2;

	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 100 + 100*(gohan.usarAumentoDeAtaque()), 4);
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
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 125 + 125*(gohan.usarAumentoDeAtaque()), 4);
		this.ki -= 10;
	}

	@Override
	public void asignarCoordenadas(Gohan gohan, Coordenada coordenada) {
		gohan.asignarCoordenadas(coordenada);
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
    public EstadoGohan cambiarCoordenadas(Gohan gohan, Coordenada coordenadaNueva) {

		if ((Math.abs(gohan.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
					|| (Math.abs(gohan.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
				throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(gohan,coordenadaNueva);
		return aumentarKi();
		}
/*
    @Override
    public EstadoGohan cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
      return aumentarKi();	}
*/
	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		this.nubeVoladora = unaNubeVoladora.iniciarNube();
    }

    @Override
    public void referenciarAGoku(GuerrerosZ goku) {

    }

	@Override
	public void referenciarAPiccolo(GuerrerosZ piccolo) {

	}

	private EstadoGohan aumentarKi() {
		ki = ki + 5;
		return this;

	}
}
