package juego;

import excepciones.AtaqueAMismoEquipoException;

public class Freezer extends Personaje {

	public Freezer() {

		this.puntosDeVida = 400;
		this.estado = new EstadoFreezerNormal(this);
	}

	@Override
	public void transformar() {
		this.estado = this.estado.transformar().transformar();
	}

	@Override
	public int obtenerPorcentajeDeVida() {
		return this.puntosDeVida / 4;
	}

	@Override
	public void realizarAtaqueEspecial(Personaje oponente) {
		if (this.ki > 20) {
			this.atacar(oponente, this.estado.poderDePelea * 1.5);
		}
	}


	@Override
	public void transformarEnChocolate() {
		throw new AtaqueAMismoEquipoException();
	}
}
