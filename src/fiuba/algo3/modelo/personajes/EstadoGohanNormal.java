package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGohanNormal implements EstadoGohan {
	
	private int ki = 0;

	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 15 + 15*(gohan.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
		this.transformar(gohan);
	}
	
	private void transformar(Gohan gohan) {
		if (this.ki >= 10){
			EstadoGohanSuperSayajinFase1 nuevaForma = new EstadoGohanSuperSayajinFase1();
			gohan.asignarEstado(nuevaForma);
			this.ki -= 10;
		}
	}

	@Override
	public void recibirDanio(Gohan gohan, double danio) {
		if(danio < 15){
			danio = danio*80/100;
		}
		gohan.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void masenko(Gohan gohan, EnemigosDeLaTierra oponente) {
		if(this.ki < 10)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 15*125/100 + 15*125/100*(gohan.usarAumentoDeAtaque()), 2);
		this.ki -= 10;
	}

	public void transformarEnSuperSayajin2(Gohan gohan) {
		if (this.ki >= 30){
			EstadoGohanSuperSayajinFase2 nuevaForma = new EstadoGohanSuperSayajinFase2();
			gohan.asignarEstado(nuevaForma);
			this.ki -= 30;
		}
	}
	
	@Override
	public void mover(Gohan gohan, Coordenada coordenadaInicial, Coordenada coordenadaFinal) {
		int distanciaHorizontal = Math.abs(coordenadaInicial.obtenerColumna() - coordenadaFinal.obtenerColumna());
		int distanciaVertical = Math.abs(coordenadaInicial.obtenerFila() - coordenadaFinal.obtenerFila());
		
		if(distanciaHorizontal > 2 || distanciaVertical > 2){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		coordenadaInicial.vaciarCasillero();
		gohan.asignarCoordenadas(coordenadaFinal);
		this.ki += 5;
		this.transformar(gohan);
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
	}
}