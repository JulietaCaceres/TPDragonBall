package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.juego.excepciones.ExceptionNoAlcanzaAlOponente;

public class EstadoPiccoloFortalecido implements EstadoPiccolo {
	
	private int ki = 0;
    private int velocidad = 3;
	private EstadoPiccolo estadoSiguiente;
	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	private GuerrerosZ referenciaAGohan;
	private String direccionDeImagen;

	public EstadoPiccoloFortalecido(){
		direccionDeImagen = "file:src/fiuba/algo3/vista/images/PiccoloFortalecido.jpg";
	}

	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 40 + 40*(piccolo.usarAumentoDeAtaque()), 4);
		this.ki += 5;
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
	}

	private void transformarEnPiccoloProtector(Piccolo piccolo) {
		EstadoPiccoloProtector nuevoEstado = new EstadoPiccoloProtector(); 
		piccolo.asignarEstado(nuevoEstado);
	}

	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 50, 4);
		this.ki -= 10;
	}
	
	@Override
	public void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada) {
		piccolo.asignarCoordenadas(coordenada);
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
    public EstadoPiccolo cambiarCoordenadas(Piccolo piccolo, Coordenada coordenadaNueva) {
		if ((Math.abs(piccolo.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * this.nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(piccolo.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(piccolo,coordenadaNueva);
		aumentarKi();
		if (referenciaAGohan.porcentajeDeVidaMenosde20()) return new EstadoPiccoloProtector();
		return this;

	}
/*
    @Override
    public EstadoPiccolo cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva) {
		if ((Math.abs(coordenadaActual.obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * this.nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(coordenadaActual.obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		coordenadaActual.cambiarCoordenadas(coordenadaNueva);
	    aumentarKi();
	    if (referenciaAGohan.porcentajeDeVidaMenosde20()) return new EstadoPiccoloProtector();
	    return this;
	}
*/
	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
        nubeVoladora = unaNubeVoladora.iniciarNube();
    }

	@Override
	public void referenciarAGogan(GuerrerosZ gohan) {
		referenciaAGohan  = gohan;
	}

    @Override
    public String obtenerDireccionDeImagen() {
        return direccionDeImagen;
    }


	@Override
    public double obtenerAtaque(Piccolo piccolo) {
        return 40 + 40*(piccolo.usarAumentoDeAtaque()) ;
    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return 4;
    }

    @Override
    public int obtenerVelocidad() {
        return velocidad;
    }

    private void aumentarKi() {
		ki = ki + 5;
	}
}
