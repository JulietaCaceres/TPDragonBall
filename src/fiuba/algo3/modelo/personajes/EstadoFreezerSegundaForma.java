package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.juego.excepciones.ExceptionNoAlcanzaAlOponente;

public class EstadoFreezerSegundaForma implements EstadoFreezer {

	private int ki = 0;
	private EstadoFreezer estadoSiguiente = null;
	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
    private int velocidad = 6;
    private String direccionDeImagen;

    public EstadoFreezerSegundaForma(){
    	direccionDeImagen =  "file:src/fiuba/algo3/vista/images/freezerSegundaForma.jpg";
	}
	@Override
	public void atacar(Freezer freezer, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 40 + 40*(freezer.usarAumentoDeAtaque()), 3);
		this.aumentarKi();
	}
	
	private void transformar() {
		if(this.ki == 20){
			estadoSiguiente = new EstadoFreezerSegundaForma();
		}
	}

	@Override
	public void recibirDanio(Freezer freezer, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		freezer.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void rayoMortal(Freezer freezer, GuerrerosZ oponente) {
		if(this.ki < 20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(freezer.obtenerCoordenadas(), 60 + 60*(freezer.usarAumentoDeAtaque()), 3);
		this.ki  -= 20;
	}

	@Override
	public void asignarCoordenadas(Freezer freezer, Coordenada coordenada) {
	  freezer.asignarCoordenadas(coordenada);
	}
	
	@Override
	public void recibirAtaque(Freezer freezer, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(freezer.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(freezer.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(freezer, poderDePelea);
	}

    @Override
    public EstadoFreezer cambiarCoordenadas(Freezer freezer, Coordenada coordenadaNueva) {
		if ((Math.abs(freezer.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(freezer.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad*nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(freezer,coordenadaNueva);
		return aumentarKi();


    }


    @Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
    	nubeVoladora = unaNubeVoladora.iniciarNube();
    }

    @Override
    public String obtenerDireccionDeImagen() {
        return direccionDeImagen;
    }

    @Override
    public double obtenerAtaque(Freezer freezer) {
        return 40 + 40*(freezer.usarAumentoDeAtaque());
    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return 3;
    }

    @Override
    public int obtenerVelocidad() {
        return 4;
    }

    private EstadoFreezer aumentarKi() {
		ki = ki + 5;
		if (ki == 50) return new EstadoFreezerFormaOriginal();
		return this;
	}
}
