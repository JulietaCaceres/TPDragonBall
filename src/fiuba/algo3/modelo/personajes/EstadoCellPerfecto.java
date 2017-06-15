package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoCellPerfecto implements EstadoCell {
	
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(cell.obtenerCoordenadas(),80 + 80*(cell.usarAumentoDeAtaque()), 4);
	}
     /*
	@Override
	public void mover(Cell cell, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(cell, filaDestino, columnaDestino, 4*cell.usarAumentoDeVelocidad());
	}
*/
	public  void verificarDistancia(Cell cell, int distancia)
	{
		if (4*cell.usarAumentoDeVelocidad() < distancia)
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
	}

	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 80){
			danio = danio*80/100;
		}
		cell.disminuirPuntosDeVidaEn(danio);		
	}

}
