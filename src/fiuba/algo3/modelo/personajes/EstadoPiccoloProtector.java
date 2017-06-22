package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.*;

public class EstadoPiccoloProtector implements EstadoPiccolo {

	private int ki = 0;
    private int velocidad = 4;
	private EstadoPiccolo estado = new EstadoPiccoloProtector();
    @Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 60 + 60*(piccolo.usarAumentoDeAtaque()), 6);
		this.ki += 5;
	}
	
	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 60){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 75, 6);
		this.ki -= 10;
	}
	
	@Override
	public void mover(Piccolo piccolo, Coordenada coordenadaDestino){
		int distanciaHorizontal = Math.abs(piccolo.obtenerCoordenadas().obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(piccolo.obtenerCoordenadas().obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 4 || distanciaVertical > 4){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		//this.piccolo.obtenerCoordenadas().vaciarCasillero();
		//this.piccolo.obtenerCoordenadas() = coordenadaDestino;
		coordenadaDestino.asignarPersonajeACasillero(piccolo);
		this.ki += 5;
	}

	@Override
	public void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada) {
		//thispiccolo.obtenerCoordenadas() = coordenada;
		coordenada.asignarPersonajeACasillero(piccolo);
	}
	
	@Override
	public void recibirAtaque(Piccolo piccolo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea){
		int distanciaHorizontal = Math.abs(piccolo.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(piccolo.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(piccolo, poderDePelea);
	}

	@Override
	public void convertir(Piccolo piccolo) {
		EstadoPiccolo formaChocolate = new EstadoPiccoloChocolate();
		piccolo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaChocolate.asignarCoordenadas(piccolo, piccolo.obtenerCoordenadas());
		piccolo.asignarEstado(formaChocolate);
	}

    @Override
	public void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if (estado == null)cambiarCoordenadasConEstadoActual(coordenadaActual,coordenadaNueva);
		if(estado !=null)estado.cambiarCoordenadas(coordenadaActual,coordenadaNueva);

	}

	@Override
	public void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > velocidad) || (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > velocidad))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
		aumentarKi();
	}
	private void aumentarKi() { ki = ki + 5;
	}


}
