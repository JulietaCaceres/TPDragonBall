package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class NubeVoladora extends Consumible{

	public NubeVoladora(){
		direccionImagen = "file:src/fiuba/algo3/vista/images/nube.jpg";
	}
	@Override
	public void aplicarEfecto(Personaje personaje) {
		personaje.tomarNubeVoladora();
	}

	/*@Override
	public boolean ocupado() {
		return false;
	}

	@Override
	public void desasignarCasillero() {

	}*/
}
