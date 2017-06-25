package juego;

public class EstadoFreezerSegundaForma extends Estado {

	public EstadoFreezerSegundaForma(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 50;
		this.distanciaDeAtaque = 3;
		this.velocidad = 6;
		this.personaje = estado.personaje;
		this.personaje.ki -= 20;
	}

	@Override
	public Estado transformar() {
		if (this.personaje.ki >= 50)
			return new EstadoFreezerDefinitivo(this);
		return this;
	}
}
