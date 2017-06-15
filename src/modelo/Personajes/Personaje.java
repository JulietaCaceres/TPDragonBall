package modelo.Personajes;

import modelo.Juego.EstadoEsferaDelDragon;
import modelo.Juego.EstadoNubeVoladora;
import modelo.Juego.Tablero;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.LaDistanciaNoEsValidaException;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.Equipo;

public abstract class Personaje {
	
	protected String nombre;
	protected double puntosDeVida;
	protected int Ki;
	protected EstadoEsferaDelDragon estadoEsferaDragon;
	protected EstadoNubeVoladora estadoNubeVoladora;
	protected int[] coordenadas;

	public void asignarCoordenadas(int x, int y) {
		this.coordenadas[0] = x;
		this.coordenadas[1] = y;
	}
	
	public int[] obtenerCoordenadas(){
		return this.coordenadas;
	}

	public double obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	public String obtenerNombre() { 
		return this.nombre; 
	}
	
	public void disminuirPuntosDeVidaEn(double danio){
		this.puntosDeVida -= danio;
	}
	
	public int obtenerKi() {
		return this.Ki;
	}
	
	public void aumentarKiEn(int kiParaAgregar){
		this.Ki += kiParaAgregar;
	}
	
	protected void comerSemillaDelErmitaño(){
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
	
	public void recibirAtaqueDe(int[] coordenadasDeAtacante,double poderDePelea, int alcanceDeAtaque){
		
		if ((alcanceDeAtaque <= Math.abs(this.coordenadas[0] - coordenadasDeAtacante[0])) &&
		           (alcanceDeAtaque <= Math.abs(this.coordenadas[1] - coordenadasDeAtacante[1]))){
			throw new LaDistanciaNoEsValidaException();
		}	
		this.recibirDanio(poderDePelea);
	}
	
	public abstract void recibirDanio(double poderDePelea);	
}
