package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionNoAlcanzaAlOponente;

public class EstadoGohanChocolate implements EstadoGohan {
	private int turnos = 3;
    private String direccionDeImagen;

    public EstadoGohanChocolate(){
    	direccionDeImagen =  "file:src/fiuba/algo3/vista/images/chocolate.jpg";
	}
	
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		this.convertir(gohan);
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 10){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		turnos--;
		if(turnos > -1){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		this.convertir(gohan);		
	}

	@Override
	public void convertir(Gohan gohan) {
		EstadoGohan formaNormal = new EstadoGohanNormal();
		gohan.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
		formaNormal.asignarCoordenadas(gohan, gohan.obtenerCoordenadas());
		gohan.asignarEstado(formaNormal);
	}

	@Override
	public EstadoGohan cambiarCoordenadas(Gohan gohan, Coordenada coordenadaFutura) {

		turnos--;
		if(turnos > 0){
			throw new GuerreroZConvertidoEnChocolateException();
		}
		return this;
	}


    @Override
	public void asignarCoordenadas(Gohan gohan, Coordenada coordenada) {

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
	public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		
	}

    @Override
    public void referenciarAGoku(GuerrerosZ goku) {

    }

	@Override
	public void referenciarAPiccolo(GuerrerosZ piccolo) {

	}

    @Override
    public String obtenerDireccionDeImagen() {
        return direccionDeImagen;
    }

    @Override
    public double obtenerAtaque(Gohan gohan) {
        return 0;
    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return 0;
    }

    @Override
    public int obtenerVelocidad() {
        return 0;
    }
}
