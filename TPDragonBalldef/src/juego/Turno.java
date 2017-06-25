package juego;

public class Turno {

	private Equipo equipoActual;
	private Equipo adversario;

	public Turno(Equipo equipoActual, Equipo equipoAdversario) {
		this.equipoActual = equipoActual;
		this.adversario = equipoAdversario;
	}

	public boolean jugadorGano() {
		return (!this.adversario.tienePersonajesVivos());
	}

	public void jugar() {
		equipoActual.jugar();
	}

}
