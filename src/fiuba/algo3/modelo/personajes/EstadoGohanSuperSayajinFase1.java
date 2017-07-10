package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.juego.excepciones.ExceptionNoAlcanzaAlOponente;

public class EstadoGohanSuperSayajinFase1 implements EstadoGohan {

	private int ki = 0;
    private int velocidad = 2;
    private String direccionDeImagen;
   	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();
	private GuerrerosZ referenciaAGoku;
	private GuerrerosZ referenciaAPiccolo;

    public EstadoGohanSuperSayajinFase1(){
    	direccionDeImagen =  "file:src/fiuba/algo3/vista/images/GohaSuperFase1.jpg";
	}
	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 30 + 30*(gohan.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		this.transformarEnSuperSayajin2(gohan);
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 30){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}

	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 30*25/100 + 30*25/100*(gohan.usarAumentoDeAtaque()), 2);
		this.ki -= 10;
	}
	

	
	private void transformarEnSuperSayajin2(Gohan gohan) {
		if (this.ki >= 30 && this.vidaDeCompanierosMenorA30PorCiento()){
			EstadoGohanSuperSayajinFase2 nuevaForma = new EstadoGohanSuperSayajinFase2();
			gohan.asignarEstado(nuevaForma);
		}
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

	@Override
    public void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora) {
		nubeVoladora = unaNubeVoladora.iniciarNube();
    }

	@Override
	public void referenciarAGoku(GuerrerosZ goku) {
		referenciaAGoku = goku;
	}

	@Override
	public void referenciarAPiccolo(GuerrerosZ piccolo) {
		referenciaAPiccolo = piccolo;
	}

    @Override
    public String obtenerDireccionDeImagen() {
        return direccionDeImagen;
    }

    @Override
    public double obtenerAtaque(Gohan gohan) {
        return 30 + 30*(gohan.usarAumentoDeAtaque());
    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return 2;
    }

    @Override
    public int obtenerVelocidad() {
        return 2;
    }

    private EstadoGohan aumentarKi() {
		ki = ki + 5;
	  if ((ki >= 10) && (vidaDeCompanierosMenorA30PorCiento()))return new EstadoGohanSuperSayajinFase2();
      return this;
	}

	private boolean vidaDeCompanierosMenorA30PorCiento(){
	   return ((referenciaAGoku.porcentajeDeVidaMenor30()) && (referenciaAPiccolo.porcentajeDeVidaMenor30()));
	}
}
