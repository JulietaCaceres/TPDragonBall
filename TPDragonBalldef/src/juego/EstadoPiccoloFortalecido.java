package juego;

public class EstadoPiccoloFortalecido extends Estado {

	public EstadoPiccoloFortalecido(Estado estado) {
		this.posicion = estado.posicion;
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidad = 3;
		this.personaje = estado.personaje;
		this.personaje.ki -= 20;
	}

	@Override
	public Estado transformar() {
		//((Piccolo)this.personaje).obtenerPorcentajeDeVidaDeGohan() < 20)
			return new EstadoPiccoloProtector(this);
		//return this;
	}
}
