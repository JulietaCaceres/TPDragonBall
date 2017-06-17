package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public abstract class Personaje {
	
	protected String nombre;
	protected double puntosDeVida;
	protected EstadoEsferaDelDragon estadoEsferaDragon;
	protected EstadoNubeVoladora estadoNubeVoladora;
	protected Coordenada coordenada;
	protected int velocidad;

	public void asignarCoordenadas(Coordenada coordenada){
		this.coordenada = coordenada;
		this.coordenada.asignarPersonajeACasillero(this);
	}
	
	public abstract void mover(Coordenada coordenada);

	public Coordenada obtenerCoordenadas(){
		return this.coordenada;
	}

	public double obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	public void disminuirPuntosDeVidaEn(double danio){
		this.puntosDeVida -= danio;
	}
	
	public void comerSemillaDelErmitanio(){
		this.puntosDeVida += 100;
	}
	
	protected void tomarEsferaDelDragon(){
		this.estadoEsferaDragon = new EstadoEsferaDelDragon();
	}
	
	public double usarAumentoDeAtaque() {
		double aumento = 0;
		if (this.estadoEsferaDragon != null){
			aumento = this.estadoEsferaDragon.obtenerAumentoDeAtaque();
			this.gastarEsferaDelDragon();
		}
		return aumento;
	}
	
	public void gastarEsferaDelDragon(){
				
		if (this.estadoEsferaDragon.obtenerTurnosDisponibles() == 0){
			this.estadoEsferaDragon = null;
		}
	}
	
	public int usarAumentoDeVelocidad() {
		int aumento = 1;
		if (this.estadoNubeVoladora != null){
			aumento = 2;
			this.gastarEsferaDelDragon();
		}
		return aumento;
	}
	
	public void gastaNubeVoladora(){
				
		if (this.estadoNubeVoladora.obtenerTurnosDisponibles() == 0){
			this.estadoNubeVoladora = null;
		}
	}
}
