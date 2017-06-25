package juego;

public class Jugador {

	String nombre;
	Jugador oponente;

	public Jugador(Jugador jugador1, String jugador2) {
		this.oponente = new Jugador(jugador2);
	}

	public Jugador(String jugador2) {
		// TODO Auto-generated constructor stub
	}

}
