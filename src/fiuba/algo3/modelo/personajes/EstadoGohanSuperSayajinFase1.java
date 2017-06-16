package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGohanSuperSayajinFase1 implements EstadoGohan {

	private int ki = 0;

	@Override
	public void atacar(Gohan gohan, EnemigosDeLaTierra oponente) {
		if((gohan.obtenerVidaDeGoku() < 150) && (gohan.obtenerVidaDePiccolo() < 150)){
			this.transformarEnSuperSayajin2(gohan);
		}
		oponente.recibirAtaqueDe(gohan.obtenerCoordenadas(), 30 + 30*(gohan.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		
	}

	/*@Override
	public void mover(Gohan gohan, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(gohan, filaDestino, columnaDestino, 2*gohan.usarAumentoDeVelocidad());
	}
	*/
	public  void verificarDistancia(Gohan gohan, int distancia)
	{
		if (2*gohan.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
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
	
	public void transformarEnSuperSayajin2(Gohan gohan) {
		if (this.ki >= 30){
			EstadoGohanSuperSayajinFase2 nuevaForma = new EstadoGohanSuperSayajinFase2();
			gohan.asignarEstado(nuevaForma);
			this.ki -= 30;
		}
	}
}