package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class EstadoNubeVoladora {
	private int turnos = 2;
	
	public int obtenerAumentoDeVelocidad(Personaje personaje){
		int aumento = 1;
		if(this.turnos == 0){
			personaje.gastaNubeVoladora();
		}
		this.turnos --;
		aumento = 2;
		return aumento;
	}
}
