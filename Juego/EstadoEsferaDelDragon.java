package Juego;

public class EstadoEsferaDelDragon {
	private int cantidadDeAtaques = 2;
	
	public double obtenerAumentoDeAtaque(){
		this.cantidadDeAtaques --;
		return 0.25;
	}

	public int obtenerTurnosDisponibles() {
		return cantidadDeAtaques;
	}
}