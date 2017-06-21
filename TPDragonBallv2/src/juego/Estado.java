package juego;

import excepciones.*;

public class Estado {

	protected Tablero tablero;
	protected double poderDePelea;
	protected double distanciaDeAtaque;
	protected int velocidad;
	protected int[] posicion;

	public Estado() {
		this.posicion = new int[2];
	}

	public Estado(double poderDePelea, double distanciaDeAtaque, int velocidad) {
		this.posicion = new int[2];
		this.poderDePelea = poderDePelea;
		this.distanciaDeAtaque = distanciaDeAtaque;
		this.velocidad = velocidad;
	}

	public int[] obtenerPosicion() {
		return this.posicion;
	}

	public void mover(int x, int y) {
		if (!this.velocidadEsValida(new int[] { x, y }))
			throw new VelocidadInsuficienteException();
		this.asignarCasillero(x, y);
	}

	public void asignarCasillero(int x, int y) {
		this.posicion[0] = x;
		this.posicion[1] = y;
	}

	public void atacar(Personaje personaje) {
		if (!this.distanciaEsValida(personaje.obtenerPosicion()))
			throw new DistanciaDeAtaqueInsuficienteException();
		personaje.recibirAtaque(this.poderDePelea);
	}

	protected boolean distanciaEsValida(int[] posicion) {
		return ((Math.abs(posicion[0] - this.posicion[0]) <= this.distanciaDeAtaque) &&
				(Math.abs(posicion[1] - this.posicion[1]) <= this.distanciaDeAtaque));
	}

	protected boolean velocidadEsValida(int[] posicion) {
		return ((Math.abs(posicion[0] - this.posicion[0]) <= this.velocidad) &&
			    (Math.abs(posicion[1] - this.posicion[1]) <= this.velocidad));
	}

}
