package juego;

public class Piccolo extends Personaje {

	public Piccolo() {

		this.puntosDeVida = 500;
		this.estado = new EstadoPiccoloNormal(this);
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
	public void realizarAtaqueEspecial(Personaje oponente) {
		if (this.ki > 10)
			this.atacar(oponente, this.estado.poderDePelea * 1.25);

	}

	@Override
	public void transformarEnChocolate() {
		this.estado = new EstadoChocolate(this.estado);
	}
/*
	public double obtenerPorcentajeDeVidaDeGohan() {
		return this.equipo.obtenerVidaDeGohan();
	}*/
}
