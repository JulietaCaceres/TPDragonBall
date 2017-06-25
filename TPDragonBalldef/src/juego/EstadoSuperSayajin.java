package juego;

public class EstadoSuperSayajin extends Estado {

	public EstadoSuperSayajin(Estado estadoAnterior) {

		this.posicion = estadoAnterior.posicion;
		this.poderDePelea = 60;
		this.distanciaDeAtaque = 4;
		this.velocidad = 5;
		this.personaje = estadoAnterior.personaje;
		this.personaje.ki -= 50;
	}

	@Override
	public Estado transformar()  {
		return this;
	}
}
