package juego;

public class EstadoKaioKen extends Estado {

	public EstadoKaioKen(Estado estadoAnterior) {

		this.posicion = estadoAnterior.posicion;
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidad = 3;
		this.personaje = estadoAnterior.personaje;
		this.personaje.ki -= 20;
	}

	@Override
	public Estado transformar() {
		if (this.personaje.ki >= 50)
			return new EstadoSuperSayajin(this);
		return this;
	}
}
