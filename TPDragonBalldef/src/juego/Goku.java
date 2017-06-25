package juego;

public class Goku extends Personaje {

	public Goku() {

		this.puntosDeVida = 500;
		this.estado = new EstadoGokuNormal(this);
	}

	@Override
	public void transformar() {
		this.estado = this.estado.transformar().transformar();
	}

	@Override
	public int obtenerPorcentajeDeVida() {
		return this.puntosDeVida / 5;
	}

	@Override
	public void atacar(Personaje oponente) {
		if (this.obtenerPorcentajeDeVida() <= 30)
			this.estado.atacar(oponente, 1.2 * this.estado.poderDePelea);
		else
			this.estado.atacar(oponente);
	}


	@Override
	public void realizarAtaqueEspecial(Personaje oponente) {
		if (this.ki >= 20)
			this.atacar(oponente, this.estado.poderDePelea * 1.5);
	}

	@Override
	public void transformarEnChocolate() {
		this.estado = new EstadoChocolate(this.estado);
	}
}
