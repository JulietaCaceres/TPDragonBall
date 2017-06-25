package juego;

public class EstadoMajinBooNormal extends Estado {

	public EstadoMajinBooNormal(MajinBoo majinboo) {
		this.posicion = new int[2];
		this.poderDePelea = 30;
		this.distanciaDeAtaque = 2;
		this.velocidad = 2;
		this.personaje = majinboo;
	}

	@Override
	public Estado transformar() {
		if (this.personaje.ki >= 20)
			return new EstadoBooMalo(this);
		return this;
	}

}
