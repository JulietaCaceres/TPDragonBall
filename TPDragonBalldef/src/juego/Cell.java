package juego;

import excepciones.AtaqueAMismoEquipoException;

public class Cell extends Personaje {

	protected int cantidadDeAbsorciones;

	public Cell() {

		this.puntosDeVida = 500;
		this.estado = new EstadoCellNormal(this);
		this.cantidadDeAbsorciones = 0;
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
		if (this.ki >= 5) {
			try {
				this.atacar(oponente);
				this.cantidadDeAbsorciones++;
				this.transformar();
				this.puntosDeVida += this.estado.poderDePelea;
			} catch (AtaqueAMismoEquipoException exception) {
				throw exception;
			}
		}
	}


	@Override
	public void transformarEnChocolate() {
		throw new AtaqueAMismoEquipoException();

	}
}
