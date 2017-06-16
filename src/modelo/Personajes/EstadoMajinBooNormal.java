package modelo.Personajes;

import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class EstadoMajinBooNormal implements EstadoMajinBoo {
	
	@Override
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(majinBoo.obtenerCoordenadas(),30 + 30*(majinBoo.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(MajinBoo majinBoo, int filaDestino, int columnaDestino, Tablero tablero) {
		tablero.moverA(majinBoo, filaDestino, columnaDestino, 2*majinBoo.usarAumentoDeVelocidad());
	}

	@Override
	public void recibirDanio(MajinBoo majinBoo, double danio) {
		if(danio < 30){
			danio = danio*80/100;
		}
		majinBoo.disminuirPuntosDeVidaEn(danio);
	}
}
