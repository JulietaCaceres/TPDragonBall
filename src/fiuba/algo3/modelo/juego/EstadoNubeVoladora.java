package fiuba.algo3.modelo.juego;


public class EstadoNubeVoladora {
	private int turnos;

	public EstadoNubeVoladora() {
		turnos = 0;
	}

	
	public int obtenerAumentoDeVelocidad(){

		if(this.turnos == 0){
			return 1;
		}
		this.turnos --;

		return 2;
	}

	public EstadoNubeVoladora iniciarNube() {
		turnos = 2;
		return this;
	}
}
