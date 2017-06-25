package juego;

public abstract class Consumible implements IUbicable {

	protected int usos;
	protected double aumentoVelocidad;
	protected double aumentoDanio;
	protected double aumentoVida;

	public boolean ocupado() {
		return false;
	}

	public double usarAumentoDeVida() {
		if (this.usos > 0)  {
			this.usos--;
			return this.aumentoVida;
		}
		return 0;
	}

	public double usarAumentoDanio() {
		if (this.usos > 0)  {
			this.usos--;
			return this.aumentoDanio;
		}
		return 0;
	}

	public double usarAumentoVelocidad() {
		if (this.usos > 0)  {
			this.usos--;
			return this.aumentoVelocidad;
		}
		return 0;
	}

	public Consumible obtenerConsumible() {
		if (this.usos > 0)
			return this;
		return null;
	}

	public void desasignarCasillero() {

	}

}
