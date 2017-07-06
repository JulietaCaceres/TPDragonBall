package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.juego.excepciones.ExceptionNoAlcanzaAlOponente;

public class EstadoCellSemiPerfecto implements EstadoCell {

	private  String direccionDeImagen;
	private int cantidadDeAbsorciones = 0;
	private int ki;

    private int velocidad = 3;
	private EstadoNubeVoladora nubeVoladora = new EstadoNubeVoladora();

	public EstadoCellSemiPerfecto(){
		direccionDeImagen = "file:src/fiuba/algo3/vista/images/Cell_semi_perfecto.jpg";
	}

	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
        oponente.recibirAtaqueDe(cell.obtenerCoordenadas(), 40 + 40 * (cell.usarAumentoDeAtaque()), 4);
		this.ki += 5;
	}
	
	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		cell.disminuirPuntosDeVidaEn(danio);		
	}
	
	@Override
	public void absorberVida(Cell cell, GuerrerosZ oponente) {
		if(this.ki < 5)
			throw new ExceptionAtaqueEspecial();
		double aumentoPorEsferaDelDragon = 40*cell.usarAumentoDeAtaque();
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),40 + 40*(cell.usarAumentoDeAtaque()), 4);
		cell.aumentarVidaEn(40 + aumentoPorEsferaDelDragon);
		this.ki -= 5;
		this.cantidadDeAbsorciones++;
		this.transformar(cell);
	}
	
	private void transformar(Cell cell) {
		if(this.cantidadDeAbsorciones == 8){
			EstadoCell nuevaForma = new EstadoCellPerfecto();
			cell.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
			nuevaForma.asignarCoordenadas(cell, cell.obtenerCoordenadas());
			cell.asignarEstado(nuevaForma);
		}
	}

	@Override
	public void asignarCoordenadas(Cell cell, Coordenada coordenada) {
	cell.asignarCoordenadas(coordenada);
	}
	
	@Override
	public void recibirAtaque(Cell cell, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(cell.obtenerCoordenadas().obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(cell.obtenerCoordenadas().obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(cell, poderDePelea);
	}

	@Override
	public EstadoCell cambiarCoordenadas(Cell cell, Coordenada coordenadaNueva) {
		if ((Math.abs(cell.obtenerCoordenadas().obtenerColumna() - coordenadaNueva.obtenerColumna()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad()))
				|| (Math.abs(cell.obtenerCoordenadas().obtenerFila() - coordenadaNueva.obtenerFila()) > (velocidad * nubeVoladora.obtenerAumentoDeVelocidad())))
			throw new ExceptionLaDistanciaEntreLasCoordenadasNoEsValida();
		asignarCoordenadas(cell,coordenadaNueva);
		aumentarKi();
		if (cantidadDeAbsorciones == 8) return new EstadoCellPerfecto();
		return this;
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
    public double obtenerAtaque(Cell cell) {
        return 40 + 40 * (cell.usarAumentoDeAtaque());
    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return 4;
    }

    @Override
    public int obtenerVelocidad() {
        return 3;
    }

    private void aumentarKi() {
		ki = ki + 5;
	}
}
