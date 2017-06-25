package juego;

public class EstadoPiccoloNormal extends Estado {

	public EstadoPiccoloNormal(Personaje personaje) {
		this.posicion = new int[2];
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidad = 2;
		this.personaje = personaje;
	}

	@Override
	public Estado transformar() {
		if (this.personaje.ki >= 20) {
			return new EstadoPiccoloFortalecido(this);
		}
		return this;
	}

}
