package modelo.Juego;
 
public class Personaje {
	
	protected String nombre;
	protected String equipo;
	protected double puntosDeVida;
	protected int poderDePelea;
	protected int Ki;
	protected EstadoEsferaDelDragon estadoEsferaDragon;
	protected EstadoNubeVoladora estadoNubeVoladora;
	
	public void recibirDa�o(double poderDelAtacante) {
		
		double da�oRecibido = poderDelAtacante;
		
		if(poderDelAtacante < this.poderDePelea){
			da�oRecibido = da�oRecibido*20/100;
		}
		
		this.puntosDeVida = this.puntosDeVida - da�oRecibido;
		
	}

	public Object obtenerNombre() {
		return this.nombre;
	}

	public double obtenerPuntosDeVida() {
		return this.puntosDeVida;
	}
	
	public String obtenerEquipo(){
		return this.equipo;
	}
	
	public int obtenerKi() {
		return this.Ki;
	}
	
	public void aumentarKiEn(int kiParaAgregar){
		this.Ki += kiParaAgregar;
	}
	
	protected void comerSemillaDelErmita�o(){
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
