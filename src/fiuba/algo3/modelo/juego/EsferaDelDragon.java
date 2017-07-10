package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class EsferaDelDragon extends Consumible{

	public EsferaDelDragon(){ direccionImagen ="file:src/fiuba/algo3/vista/images/EsferaDelDragon.jpg";}

	@Override
	public void aplicarEfecto(Personaje personaje) {
		personaje.tomarEsferaDelDragon();
	}



    @Override
    public boolean esVacio() {
        return false;
    }



   /* @Override
	public boolean ocupado() {
		return false;
	}

	@Override
	public void desasignarCasillero() {

	}
*/
}
