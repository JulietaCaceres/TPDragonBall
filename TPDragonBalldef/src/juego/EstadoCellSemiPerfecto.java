package juego;

public class EstadoCellSemiPerfecto extends Estado {

	public EstadoCellSemiPerfecto(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidad = 3;
		this.personaje = estado.personaje;
		((Cell)this.personaje).cantidadDeAbsorciones -= 4;
	}

	@Override
	public Estado transformar() {
		if (((Cell)this.personaje).cantidadDeAbsorciones >= 8)
			return new EstadoCellPerfecto(this);
		return this;
	}

}
