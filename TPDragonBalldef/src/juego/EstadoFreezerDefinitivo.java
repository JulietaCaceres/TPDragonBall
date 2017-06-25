package juego;

public class EstadoFreezerDefinitivo extends Estado {

	public EstadoFreezerDefinitivo(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 40;
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
