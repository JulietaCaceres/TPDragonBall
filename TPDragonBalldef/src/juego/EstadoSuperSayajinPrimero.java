package juego;

public class EstadoSuperSayajinPrimero extends Estado {

	public EstadoSuperSayajinPrimero(Estado estadoAnterior) {
		this.posicion = estadoAnterior.posicion;
		this.poderDePelea = 30;
		this.distanciaDeAtaque = 2;
		this.velocidad = 2;
		this.personaje = estadoAnterior.personaje;
		this.personaje.ki -= 10;
	}

	@Override
	public Estado transformar()  {
		if ((this.personaje.ki >= 30) && ((Gohan)this.personaje).companerosTienen30DeVida()) {
			return new EstadoSuperSayajinSegundo(this);
		}
		return this;
	}

}

