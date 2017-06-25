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
		personaje.asignarCasillero(this);
		if (this.contenido != null)
			personaje.consumir(this.contenido);
		this.contenido = personaje;
	}

	public boolean ocupado() {
		if (this.contenido != null) {
			return this.contenido.ocupado();
		}
		return false;
	}

	public void asignarConsumible(Consumible consumible) {
		this.contenido = consumible;

	}

	public void desocupar() {
		this.contenido.desasignarCasillero();
		this.contenido = null;
	}
}
