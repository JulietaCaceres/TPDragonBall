package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class EstadoNubeVoladora {
	private int turnos = 2;
	
	public int obtenerAumentoDeVelocidad(){

		if(this.turnos == 0){
			return 1;
		}
		this.turnos --;

		return 2;
	}
}
