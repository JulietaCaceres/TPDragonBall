package juego;

public class EstadoSuperSayajinSegundo extends Estado {

	public EstadoSuperSayajinSegundo(Estado estadoAnterior) {
		this.posicion = estadoAnterior.posicion;
		this.poderDePelea = 100;
		this.distanciaDeAtaque = 4;
		this.velocidad = 3;
		this.personaje = estadoAnterior.personaje;
		this.personaje.ki -= 30;
	}

	@Override
	public Estado transformar()  {
		return this;
	}


}
