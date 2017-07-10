package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class SemillaDelErmitanio extends Consumible{

	public SemillaDelErmitanio(){

		direccionImagen = "file:src/fiuba/algo3/vista/images/semilla.jpg";

	}
	@Override
	public void aplicarEfecto(Personaje personaje) {
		personaje.comerSemillaDelErmitanio();
	}


}
