package juego;

public class Freezer extends Personaje {

	public Freezer() {

		this.puntosDeVida = 400;
		this.estado = new Estado(20, 2, 4);
	}
}
