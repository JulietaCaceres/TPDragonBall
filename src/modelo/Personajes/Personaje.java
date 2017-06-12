package modelo.Personajes;

import modelo.Juego.EstadoEsferaDelDragon;
import modelo.Juego.EstadoNubeVoladora;
import modelo.Juego.Tablero;

public abstract class Personaje {
	
	protected String nombre;
	protected double puntosDeVida;
	protected int poderDePelea;
	protected int Ki;
	protected EstadoEsferaDelDragon estadoEsferaDragon;
	protected EstadoNubeVoladora estadoNubeVoladora;
	
	public void recibirDanio(double poderDelAtacante) {
		
		double danioRecibido = poderDelAtacante;
		
		if(poderDelAtacante < this.poderDePelea){
			danioRecibido = danioRecibido*20/100;
		}
		
		this.puntosDeVida = this.puntosDeVida - danioRecibido;
		
	}

	public Object obtenerNombre() {
		return this.nombre;
	}

	public double obtenerPuntosDeVida() {
		return this.puntosDeVida;
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

	public abstract void recibirDanioDe(Goku goku, double poderDePelea);
	public abstract void recibirDanioDe(Gohan gohan, double poderDePelea);
	public abstract void recibirDanioDe(Piccolo piccolo, double poderDePelea);
	public abstract void recibirDanioDe(Freezer freezer, double poderDePelea);
	public abstract void recibirDanioDe(Cell cell, double poderDePelea);
	public abstract void recibirDanioDe(MajinBoo majinBoo, double poderDePelea);

	public abstract void recibirDanioDe(Personaje atacante, double poderDeAtaque);
	
}
