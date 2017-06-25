package juego;

import excepciones.*;

public abstract class Estado {

	protected double poderDePelea;
	protected double distanciaDeAtaque;
	protected int velocidad;
	protected int[] posicion;
	protected Personaje personaje;
	protected Consumible consumible;

	public Estado() {
		this.posicion = new int[2];
	}

	public int[] obtenerPosicion() {
		return this.posicion;
	}

	public void mover(int x, int y) {
		if (!this.velocidadEsValida(new int[] { x , y }))
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
		if (this.personaje.equipo.personajes.contains(personaje))
			throw new AtaqueAMismoEquipoException();
		if (this.consumible != null) {
			personaje.recibirAtaque(this.poderDePelea * this.consumible.usarAumentoDanio());
			this.consumible = consumible.obtenerConsumible();
		} else {
			personaje.recibirAtaque(this.poderDePelea);
		}
		this.personaje.aumentarKi(5);
	}

	public void atacar(Personaje personaje, double poderDePelea) {
		if (!this.distanciaEsValida(personaje.obtenerPosicion()))
			throw new DistanciaDeAtaqueInsuficienteException();
		if (this.personaje.equipo.personajes.contains(personaje))
			throw new AtaqueAMismoEquipoException();
		if (this.consumible != null) {
			personaje.recibirAtaque(poderDePelea * this.consumible.usarAumentoDanio());
			this.consumible = consumible.obtenerConsumible();
		} else {
			personaje.recibirAtaque(poderDePelea);
		}
		this.personaje.aumentarKi(5);
	}

	protected boolean distanciaEsValida(int[] posicion) {
		return ((Math.abs(posicion[0] - this.posicion[0]) <= this.distanciaDeAtaque) &&
				(Math.abs(posicion[1] - this.posicion[1]) <= this.distanciaDeAtaque));
	}

	protected boolean velocidadEsValida(int[] posicion) {
		double velocidad = this.velocidad;
		if (this.consumible != null) {
			velocidad *= this.consumible.usarAumentoVelocidad();
			this.consumible = this.consumible.obtenerConsumible();
		}
		return !((Math.abs(posicion[0] - this.posicion[0]) >= velocidad) ||
			     (Math.abs(posicion[1] - this.posicion[1]) >= velocidad));
	}

	public abstract Estado transformar();

	public void consumir(Consumible consumible) {
		this.personaje.puntosDeVida += consumible.usarAumentoDeVida();
		this.consumible = consumible.obtenerConsumible();
	}


}
