package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;

public class EstadoGokuKaioKen implements EstadoGoku {
	
	private int ki = 0;
	
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 40*goku.aumentoDePoderPorAdrenalina() + 40*(goku.usarAumentoDeAtaque()), 4);
		this.ki += 5;
		this.transformar(goku);
	}

	/*@Override
	public void mover(Goku goku, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 3*goku.usarAumentoDeVelocidad());
	}
*/
	public  void verificarDistancia(Goku goku, int distancia)
	{
		if (3*goku.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}

	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 40){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}
	
	@Override
	public void kamehameha(Goku goku, EnemigosDeLaTierra oponente) {
		if(this.ki<20)
			throw new ExceptionAtaqueEspecial();
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 60*goku.aumentoDePoderPorAdrenalina() + 60*(goku.usarAumentoDeAtaque()), 4);
		this.ki -= 20;
	}

	public void transformar(Goku goku){
		if(this.ki == 50){
			EstadoGoku nuevaForma = new EstadoGokuSuperSayajin();
			goku.asignarEstado(nuevaForma);
		}
	}
}
