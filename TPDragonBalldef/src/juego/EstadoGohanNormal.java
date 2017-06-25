package juego;

public class EstadoGohanNormal extends Estado {

	public EstadoGohanNormal(Gohan gohan) {
		this.poderDePelea = 15;
		this.distanciaDeAtaque = 2;
		this.velocidad = 2;
		this.personaje = gohan;
	}

	@Override
	public Estado transformar()  {
		if (personaje.ki >= 10) {
			return new EstadoSuperSayajinPrimero(this);
		}
		return this;
	}

	public String nombre() {
		return "normal";
	}

}
