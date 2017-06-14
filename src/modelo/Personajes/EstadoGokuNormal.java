package modelo.Personajes;

import modelo.Juego.Ataque;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Tablero;

public class EstadoGokuNormal implements EstadoGoku {
	
	@Override
	public void atacar(Goku goku, EnemigosDeLaTierra oponente, Tablero tablero) {
		oponente.recibirAtaqueDe(goku.obtenerCoordenadas(), 20 + 20*(goku.usarAumentoDeAtaque()), 2);
		Ataque ataque = new Ataque();
		ataque.atacar(goku, oponente, tablero, 20 + 20*(goku.usarAumentoDeAtaque()), 2);
	}

	@Override
	public void mover(Goku goku,int filaDestino,int columnaDestino, Tablero tablero) {
		tablero.moverA(goku, filaDestino, columnaDestino, 2*goku.usarAumentoDeVelocidad());		
	}

	@Override
	public void recibirDanio(Goku goku, double danio) {
		if(danio < 20){
			danio = danio*80/100;
		}
		goku.disminuirPuntosDeVidaEn(danio);
	}

}
