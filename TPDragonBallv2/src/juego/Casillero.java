package juego;

public class Casillero {

	private int x;
	private int y;
	private IUbicable contenido;

	public Casillero(int x, int y) {
		this.x = x;
		this.y = y;
		this.contenido = null;
	}

	public void ubicarPersonaje(Personaje personaje) {
		this.contenido = personaje;
	}

	public boolean ocupado() {

		return (this.contenido != null);
	}
}
