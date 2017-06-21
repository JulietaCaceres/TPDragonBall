package juego;

public class Piccolo extends Personaje {

	public Piccolo() {

		this.puntosDeVida = 500;
		this.estado = new Estado(20, 2, 2);
	}
}
