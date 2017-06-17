package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;


public class Casillero {

	protected Personaje personaje;
	protected int fila;
	protected int columna;

	public Casillero() {
		this.personaje = null;
	}

	public Personaje obtenerPersonaje() {
		return this.personaje;
	}

		//public Consumible obtenerConsumible() {
		//	return this.consumible;
		//}

	public void asignarPersonaje(Personaje unPersonaje) {
		if (!ocupado()) {
			this.personaje = unPersonaje;
		}
		else throw new ExceptionCasilleroOcupado();
	}

	//public void asignarConsumible(Consumible consumible) {
	//	this.consumible = consumible;

	//}

	public boolean ocupado() {
		return (this.personaje != null);
	}

	public void liberarDePersonaje() {
		this.personaje = null;
	}
}
