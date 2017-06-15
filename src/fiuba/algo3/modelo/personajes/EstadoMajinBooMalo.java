package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;
import fiuba.algo3.modelo.juego.Tablero;

public class
EstadoMajinBooMalo implements EstadoMajinBoo {
	
	@Override
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(majinBoo.obtenerCoordenadas(),50 + 50*(majinBoo.usarAumentoDeAtaque()), 2);
	}
	
	/*@Override
	public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(majinBoo, filaDestino, columnaDestino, 3*majinBoo.usarAumentoDeVelocidad());
	}
	*/
	public  void verificarDistancia(MajinBoo majinBoo, int distancia)
	{
		if (3*majinBoo.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}
	@Override
	public void recibirDanio(MajinBoo majinBoo, double danio) {
		if(danio < 50){
			danio = danio*80/100;
		}
		majinBoo.disminuirPuntosDeVidaEn(danio);
	}

}
