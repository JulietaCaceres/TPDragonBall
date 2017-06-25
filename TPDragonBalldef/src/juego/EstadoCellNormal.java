package juego;

public class EstadoCellNormal extends Estado {

	public EstadoCellNormal(Cell cell) {
		this.posicion = new int[2];
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 3;
		this.velocidad = 2;
		this.personaje = cell;
	}

	@Override
	public Estado transformar() {
		if (((Cell)this.personaje).cantidadDeAbsorciones >= 4)
			return new EstadoCellSemiPerfecto(this);
		return this;
	}

}
