package juego;

import excepciones.GuerreroZConvertidoEnChocolateException;

public class EstadoChocolate extends Estado {

	private Estado estadoAnterior;
	private int turnosRestantes = 3;

	public EstadoChocolate(Estado estadoAnterior) {
		this.estadoAnterior = estadoAnterior;
	}

	@Override
	public Estado transformar() {
		if (this.turnosRestantes > 0) {
			this.turnosRestantes--;
			return this;
		}
		return estadoAnterior;
	}

	@Override
	public void atacar(Personaje personaje) {
		throw new GuerreroZConvertidoEnChocolateException();
	}

	@Override
	public void atacar(Personaje personaje, double poderDePelea) {
		throw new GuerreroZConvertidoEnChocolateException();
	}

}
