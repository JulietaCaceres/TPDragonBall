package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public abstract class Personaje {
	
	protected String nombre;
	protected double puntosDeVida;
	protected int Ki;
	protected EstadoEsferaDelDragon estadoEsferaDragon;
	protected EstadoNubeVoladora estadoNubeVoladora;
	protected Coordenada coordenada;
	protected int velocidad;

	public void asignarCoordenadas(int fila,int columna)
	{
		Coordenada coordenadas = new Coordenada(fila,columna);
		coordenada = coordenadas;
	}

	public abstract void verificarDistancia(int distancia);

	public void verificarCoordenadasDeMovimiento(Coordenada[] coordenadas)
	{   verificarDistancia(coordenadas.length);
		coordenada.verificarCoordenadasFuturas(coordenadas);
	}
	public Coordenada obtenerCoordenadas(){
		return this.coordenada;
	}

	public double obtenerPuntosDeVida() {
		return this.puntosDeVida;
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
	
	public void disminuirKiEn(int kiParaAgregar){
		this.Ki += kiParaAgregar;
	}
	
	protected void comerSemillaDelErmitanio(){
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
	
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante,double poderDePelea, int alcanceDeAtaque){

		coordenada.verificarDistanciaAtaque(coordenadasDeAtacante, alcanceDeAtaque);
		this.recibirDanio(poderDePelea);
	}
	
	public abstract void recibirDanio(double poderDePelea);	
}
