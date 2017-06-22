package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.GuerrerosZ;

public abstract class EstadoCell extends Estado{
	
	protected int cantidadDeAbsorciones;
	
	protected abstract void absorberVida(Cell cell, GuerrerosZ oponente);
}
