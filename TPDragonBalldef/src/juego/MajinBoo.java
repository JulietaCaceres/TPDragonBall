package juego;

import excepciones.AtaqueAMismoEquipoException;

public class MajinBoo extends Personaje {

	public MajinBoo() {

		this.puntosDeVida = 300;
		this.estado = new EstadoMajinBooNormal(this);
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
		if (this.ki >= 30) {
			oponente.transformarEnChocolate();
			this.aumentarKi(5);
		}

	}

	@Override
	public void transformarEnChocolate() {
		throw new AtaqueAMismoEquipoException();

	}
}
