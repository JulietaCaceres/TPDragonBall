package juego;

public class EstadoCellPerfecto extends Estado {

	public EstadoCellPerfecto(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 80;
		this.distanciaDeAtaque = 4;
		this.velocidad = 4;
		this.personaje = estado.personaje;
		((Cell)this.personaje).cantidadDeAbsorciones -= 80;
	}

	@Override
	public Estado transformar() {
		return this;
	}
}
