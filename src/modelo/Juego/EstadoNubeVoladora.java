package modelo.Juego;

public class EstadoNubeVoladora {
	private int turnos = 2;
	
	public int obtenerAumentoDeVelocidad(){
		this.turnos --;
		return 2;
	}

	public int obtenerTurnosDisponibles() {
		return turnos;
	}
}
