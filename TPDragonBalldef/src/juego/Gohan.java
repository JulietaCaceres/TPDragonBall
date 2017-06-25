package juego;

public class Gohan extends Personaje {

	public Gohan() {
		this.puntosDeVida = 300;
		this.estado = new EstadoGohanNormal(this);
	}

	protected boolean companerosTienen30DeVida() {
		return ((this.equipo.obtenerCompaneros(this).get(0).
							obtenerPorcentajeDeVida() < 30) &&
				(this.equipo.obtenerCompaneros(this).get(1).
							obtenerPorcentajeDeVida() < 30));
	}

	@Override
	public void transformar() {
		this.estado = this.estado.transformar().transformar();
	}

	@Override
	public int obtenerPorcentajeDeVida() {
		return this.puntosDeVida / 3;
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


}
