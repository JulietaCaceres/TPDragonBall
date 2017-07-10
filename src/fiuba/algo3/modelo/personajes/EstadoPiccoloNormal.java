package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.juego.excepciones.ExceptionNoAlcanzaAlOponente;

public class EstadoPiccoloNormal implements EstadoPiccolo {
	
	private int ki = 0;
	private int velocidad = 2;
	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	private String direccionDeImagen;

	public EstadoPiccoloNormal(){
		direccionDeImagen = "file:src/fiuba/algo3/vista/images/Picolo.jpg";
	}
	@Override
	public void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 20 + 20*(piccolo.usarAumentoDeAtaque()), 2);
		this.ki +=5;
		if(piccolo.verVidaDeGohan() < 90){
			this.transformarEnPiccoloProtector(piccolo);
		}
		this.transformar(piccolo);
	}

	private void transformar(Piccolo piccolo) {
		if(this.ki == 20){
			EstadoPiccoloFortalecido nuevoEstado = new EstadoPiccoloFortalecido();
			piccolo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevoEstado.asignarCoordenadas(piccolo, piccolo.obtenerCoordenadas());
			piccolo.asignarEstado(nuevoEstado);
		}
	}

	private void transformarEnPiccoloProtector(Piccolo piccolo) {
		EstadoPiccoloProtector nuevoEstado = new EstadoPiccoloProtector();
		piccolo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		nuevoEstado.asignarCoordenadas(piccolo, piccolo.obtenerCoordenadas());
		piccolo.asignarEstado(nuevoEstado);
	}

	@Override
	public void recibirDanio(Piccolo piccolo, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		piccolo.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(piccolo.obtenerCoordenadas(), 25, 2);
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
    public EstadoPiccolo cambiarCoordenadas(Piccolo piccolo, Coordenada coordenadaNueva){
		if ((Math.abs(piccolo.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(piccolo.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(piccolo,coordenadaNueva);
		return aumentarKi();
	}


	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		nubeVoladora = unaNubeVoladora.iniciarNube();
    }

	@Override
	public void referenciarAGogan(GuerrerosZ gohan) {

	}

    @Override
    public String obtenerDireccionDeImagen() {
        return direccionDeImagen;
    }

    @Override
    public double obtenerAtaque(Piccolo piccolo) {
        return 20 + 20*(piccolo.usarAumentoDeAtaque());
    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return 2;
    }

    @Override
    public int obtenerVelocidad() {
        return velocidad;
    }

    private EstadoPiccolo aumentarKi() {
		ki = ki + 5;
		if (ki == 20 ) return  new EstadoPiccoloFortalecido();
		return this;
	}
}
