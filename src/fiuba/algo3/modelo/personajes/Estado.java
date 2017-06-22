package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public abstract class Estado {
	
	protected int ki;
	protected int velocidad;
	protected int poder;
	protected int alcance;
	protected Estado estadoSiguiente;
	protected EstadoNubeVoladora nubeVoladora;
	
	protected void atacar(Personaje personaje, GuerrerosZ oponente){
		oponente.recibirAtaqueDe(personaje.obtenerCoordenadas(),this.poder*(1 + personaje.usarAumentoDeAtaque()), this.alcance);
		this.aumentarKi();
	}
	
	protected void atacar(Personaje personaje, EnemigosDeLaTierra oponente){
		oponente.recibirAtaqueDe(personaje.obtenerCoordenadas(),this.poder*(1 + personaje.usarAumentoDeAtaque()), this.alcance);
		this.aumentarKi();
	}
	
	public void recibirAtaque(Personaje personaje, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(coordenadasDeAtacante.obtenerColumna() - personaje.obtenerCoordenadas().obtenerColumna());
		int distanciaVertical = Math.abs(coordenadasDeAtacante.obtenerFila() - personaje.obtenerCoordenadas().obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(personaje, poderDePelea);
	}

	protected void recibirDanio(Personaje personaje, double danio){
		if(danio < this.poder){
			danio = danio*80/100;
		}
		personaje.disminuirPuntosDeVidaEn(danio);
	}

	
    protected void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
	    cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva);
	}
    
    protected void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if (this.nubeVoladora != null) cambiarCoordenadasConNubeVoladora(coordenadaActual,coordenadaNueva);
		else cambiarCoordenadasSinNubeVoladora(coordenadaActual,coordenadaNueva);
	}

	protected void cambiarCoordenadasSinNubeVoladora(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > this.velocidad ) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();

	}

	protected void cambiarCoordenadasConNubeVoladora(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (this.velocidad*nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (this.velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}

	
    protected void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		this.nubeVoladora = unaNubeVoladora;
    }

    protected void aumentarKi() {
		this.ki += 5;
	}
}
