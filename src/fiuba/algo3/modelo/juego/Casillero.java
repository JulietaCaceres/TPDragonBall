package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;


public class Casillero {

	protected Equipo personaje;
	public Consumible consumible;
	protected IUbicable contenido;


	public Casillero(Coordenada suCoordenada) {
		this.personaje = null;
		this.consumible = null;
		contenido = new Vacio(suCoordenada);
	}

	public void asignarConsumible(Consumible consumible) {
		this.consumible = consumible;
	}

	public Consumible liberarConsumible() {
		Consumible objetoADevolver = this.consumible;
		this.consumible = null;
		return objetoADevolver;
	}

	public Equipo
	obtenerPersonaje() {
		if (personaje == null)
			throw new ExceptionNoHayPersonajeEnElCasilleroSeleccionado();
		return this.personaje;
	}

	public void asignarPersonaje(Equipo unPersonaje) {

		this.personaje = unPersonaje;
		if (consumible != null) personaje.tomarConsumibleDe(this);

	}

	public boolean ocupado() {
		return (this.personaje != null);
	}

	public void liberarDePersonaje() {
		this.personaje = null;
	}

	public IUbicable obtenerContenido() {
		if (consumible == null) {
			if (personaje == null) {
				return contenido;
			} else return personaje;
		}
		return consumible;
	}
}
