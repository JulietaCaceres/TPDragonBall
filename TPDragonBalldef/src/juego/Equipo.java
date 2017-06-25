package juego;

import java.util.LinkedList;

public class Equipo {

	protected LinkedList<Personaje> personajes = new LinkedList<Personaje>();

	public LinkedList<Personaje> obtenerCompaneros(Personaje personaje) {
		LinkedList<Personaje> companeros = new LinkedList<Personaje>();
		for (int i = 0; i < 3; i++) {
			if (this.personajes.get(i) != personaje)
				companeros.add(this.personajes.get(i));
		}
		return companeros;
	}

}
