package juego;

public class EstadoBooOriginal extends Estado {

	public EstadoBooOriginal(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 60;
		this.distanciaDeAtaque = 3;
		this.velocidad = 4;
		this.personaje = estado.personaje;
		this.personaje.ki -= 50;
	}

	@Override
	public Estado transformar() {
		return this;
	}

}
