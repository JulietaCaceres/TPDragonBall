package juego;

public class MajinBoo extends Personaje {

	public MajinBoo() {

		this.puntosDeVida = 300;
		this.estado = new Estado(30, 2, 2);
	}
}
