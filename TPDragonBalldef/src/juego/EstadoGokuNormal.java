package juego;

public class EstadoGokuNormal extends Estado {

	public EstadoGokuNormal(Goku goku) {
		this.poderDePelea = 20;
		this.distanciaDeAtaque = 2;
		this.velocidad = 2;
		this.personaje = goku;
	}

	@Override
	public Estado transformar() {
		if (this.personaje.ki >= 20)
			return new EstadoKaioKen(this);
		return this;
	}

}
