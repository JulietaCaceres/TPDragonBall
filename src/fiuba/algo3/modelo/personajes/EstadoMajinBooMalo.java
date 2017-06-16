package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoMajinBooMalo implements EstadoMajinBoo {
	
	private int ki = 0;

	@Override
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(majinBoo.obtenerCoordenadas(),50 + 50*(majinBoo.usarAumentoDeAtaque()), 2);
		this.ki += 5;
		this.transformar(majinBoo);
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
	
	public void transformar(MajinBoo majinBoo) {
		if(this.ki == 50){
			EstadoMajinBooMalo nuevaForma = new EstadoMajinBooMalo(); 
			majinBoo.asignarEstado(nuevaForma);
		}
	}
	
	@Override
	public void convertirEnChocolate(GuerrerosZ oponente) {
		if (this.ki < 5){
			throw new ExceptionAtaqueEspecial();
		}
		oponente.convertirseEnChocolate();
	}

}
