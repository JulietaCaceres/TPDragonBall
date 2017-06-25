package juego;

public abstract class Personaje implements IUbicable {

	protected Estado estado;
	protected Equipo equipo;
	protected int puntosDeVida;
	protected int ki = 0;
	protected Casillero casillero;

	public void asignarEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public void mover(int x, int y) {
		this.estado.mover(x, y);
		this.casillero.desocupar();
	}

	public int[] obtenerPosicion() {
		return this.estado.obtenerPosicion();
	}

	public void asignarCasillero(int x, int y) {
		this.estado.asignarCasillero(x, y);
	}

	public void aumentarKi(int cantidad) {
		this.ki += cantidad;
		this.transformar();
	}

	public abstract void transformar();

	public int obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}

	public void atacar(Personaje personaje) {
		this.estado.atacar(personaje);
	}

	public void atacar(Personaje oponente, double poderDePelea) {
		this.estado.atacar(oponente, poderDePelea);

	}
	public void recibirAtaque(double poderDePelea) {
		this.puntosDeVida -= poderDePelea;
	}

	public abstract int obtenerPorcentajeDeVida();

	public Estado estado() {
		return this.estado;
	}

	public abstract void realizarAtaqueEspecial(Personaje oponente);

	public abstract void transformarEnChocolate();

	public void consumir(IUbicable contenido) {
		this.estado.consumir((Consumible)contenido);

	}

	public boolean ocupado() {
		return true;
	}

	public void asignarCasillero(Casillero casillero) {
		this.casillero = casillero;
	}

	public void desasignarCasillero() {
		this.casillero = null;
	}

}
