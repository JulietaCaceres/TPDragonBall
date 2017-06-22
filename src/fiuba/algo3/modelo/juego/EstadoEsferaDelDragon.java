package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class EstadoEsferaDelDragon {
	private int cantidadDeAtaques = 2;
	
	public double obtenerAumentoDeAtaque(Personaje personaje){
		if(this.cantidadDeAtaques == 0){
			personaje.gastarEsferaDelDragon();
		}
		this.cantidadDeAtaques --;
		return 0.25;
	}
}
