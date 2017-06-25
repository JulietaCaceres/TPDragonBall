package juego;

public class EstadoBooMalo extends Estado {


	public EstadoBooMalo(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 50;
		this.distanciaDeAtaque = 2;
		this.velocidad = 3;
		this.personaje = estado.personaje;
		this.personaje.ki -= 20;
	}

	@Override
	public Estado transformar() {
		if (this.personaje.ki >= 50)
			return new EstadoBooOriginal(this);
		return this;
	}

}
