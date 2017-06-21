package juego;

public class Personaje implements IUbicable {

	protected Estado estado;
	protected int puntosDeVida;
	protected int ki = 0;

	public void mover(int x, int y) {
		this.estado.mover(x, y);
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

	private void transformar() {
		if (this.ki >= 40)
			this.estado = new EstadoSuperSayajin(this.estado);
		else if (this.ki >= 20)
			this.estado = new EstadoKaioKen(this.estado);
	}

	public int obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}

	public void atacar(Personaje personaje) {

		this.estado.atacar(personaje);
	}

	public void recibirAtaque(double poderDePelea) {
		this.puntosDeVida -= poderDePelea;
	}

}
