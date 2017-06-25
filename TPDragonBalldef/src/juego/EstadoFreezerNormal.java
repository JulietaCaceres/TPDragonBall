package juego;

public class EstadoFreezerNormal extends Estado {

	public EstadoFreezerNormal(Freezer freezer) {
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidad = 4;
		this.personaje = freezer;
	}

	@Override
	public Estado transformar() {
		if (this.personaje.ki >= 20)
			return new EstadoFreezerSegundaForma(this);
		return this;
	}

}
