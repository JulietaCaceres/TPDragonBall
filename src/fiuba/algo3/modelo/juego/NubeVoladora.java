package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class NubeVoladora implements Consumible{

	@Override
	public void aplicarEfecto(Personaje personaje) {
		personaje.tomarNubeVoladora();
	}

}