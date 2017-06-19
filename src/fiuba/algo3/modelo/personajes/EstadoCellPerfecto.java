package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.ExceptionCantidadDeCasillerosSuperaVelocidad;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class EstadoCellPerfecto implements EstadoCell {
	
	private int ki;
	private Coordenada coordenada;
	
	@Override
	public void atacar(Cell cell, GuerrerosZ oponente) {
		oponente.recibirAtaqueDe(this.coordenada,80 + 80*(cell.usarAumentoDeAtaque()), 4);
		this.ki +=5;
	}
	
	@Override
	public void recibirDanio(Cell cell, double danio) {
		if(danio < 80){
			danio = danio*80/100;
		}
		cell.disminuirPuntosDeVidaEn(danio);		
	}
	
	@Override
	public void absorberVida(Cell cell, GuerrerosZ oponente) {
		if(this.ki < 5)
			throw new ExceptionAtaqueEspecial();
		double aumentoPorEsferaDelDragon = 80*cell.usarAumentoDeAtaque();
		oponente.recibirAtaqueDe(this.coordenada,80 + 80*(cell.usarAumentoDeAtaque()), 4);
		cell.aumentarVidaEn(80 + aumentoPorEsferaDelDragon);
		this.ki -= 5;
	}

	@Override
	public void mover(Cell cell, Coordenada coordenadaDestino) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadaDestino.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadaDestino.obtenerFila());
		
		if(distanciaHorizontal > 4 || distanciaVertical > 4){
			throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
		}
		this.coordenada.vaciarCasillero();
		coordenadaDestino.asignarPersonajeACasillero(cell);
		this.ki += 5;
	}

	@Override
	public void asignarCoordenadas(Cell cell, Coordenada coordenada) {
		this.coordenada = coordenada;
		coordenada.asignarPersonajeACasillero(cell);
	}
	
	@Override
	public void recibirAtaque(Cell cell, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea) {
		int distanciaHorizontal = Math.abs(this.coordenada.obtenerColumna() - coordenadasDeAtacante.obtenerColumna());
		int distanciaVertical = Math.abs(this.coordenada.obtenerFila() - coordenadasDeAtacante.obtenerFila());
		if(distanciaHorizontal > alcanceDeAtaque || distanciaVertical > alcanceDeAtaque){
			throw new ExceptionNoAlcanzaAlOponente();
		}
		this.recibirDanio(cell, poderDePelea);
	}
}
