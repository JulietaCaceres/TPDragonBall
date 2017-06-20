package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class EsferaDelDragon implements Consumible{

	@Override
	public void aplicarEfecto(Personaje personaje) {
		personaje.tomarEsferaDelDragon();
	}

}
