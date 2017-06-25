package juego;

public class EstadoPiccoloProtector extends Estado {

	public EstadoPiccoloProtector(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 60;
		this.distanciaDeAtaque = 6;
		this.velocidad = 4;
		this.personaje = estado.personaje;
	}

	@Override
	public Estado transformar() {
		return this;
	}

}
