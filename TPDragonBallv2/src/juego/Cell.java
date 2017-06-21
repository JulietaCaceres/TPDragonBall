package juego;

public class Cell extends Personaje {

	public Cell() {

		this.puntosDeVida = 500;
		this.estado = new Estado(20, 3, 2);
	}
}
