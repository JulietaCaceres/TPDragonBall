package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class SemillaDelErmitanio implements Consumible{

	public void aplicarEfecto(Personaje personaje) {
		personaje.comerSemillaDelErmitanio();
	}

}
