package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public abstract class Personaje {
	
	protected String nombre;
	protected double puntosDeVida;
	protected EstadoEsferaDelDragon estadoEsferaDragon;
	protected EstadoNubeVoladora estadoNubeVoladora;
	protected Coordenada coordenada;
	protected int velocidad;
	private Consumible consumible;
	protected Personaje[] companieros;

	public void asignarCoordenadas(Coordenada unaCoordenada){
		if(unaCoordenada.obtenerCasillero().ocupado())
        throw new ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado();
		coordenada = unaCoordenada;
		coordenada.obtenerCasillero().asignarPersonaje(this);
	}

	public void asignarReferenciaAEquipo(Personaje[] companieros) {
		this.companieros = companieros;

	}

	public void tomarConsumibleDe(Casillero casillero) {
		this.consumible = casillero.liberarConsumible();
		this.consumir(this.consumible);
	}

	private void consumir(Consumible consumible) {
		if(this.consumible != null){
			this.consumible.aplicarEfecto(this);
		}
	}

	public String obtenerNombre(){
		return this.nombre;
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
	
	public void comerSemillaDelErmitanio(){
		this.puntosDeVida += 100;
	}
	
	public void tomarEsferaDelDragon(){
		this.estadoEsferaDragon = new EstadoEsferaDelDragon();
	}
	
	public double usarAumentoDeAtaque() {
		double aumento = 0;
		if(this.estadoEsferaDragon != null){
			aumento = this.estadoEsferaDragon.obtenerAumentoDeAtaque(this);
		}
		return aumento;
	}
	
	public void gastarEsferaDelDragon(){
			this.estadoEsferaDragon = null;	
	}

	public abstract void tomarNubeVoladora();

	public abstract void cambiarCoordenadas(Coordenada coordenadaNueva);

	public double[] obtenerPorcentajeVidaDeCompanieros(String[] nombreDeCompanieros){
		double vida[] = new double[nombreDeCompanieros.length];
		int j=0;
		for(int i = 0; i<this.companieros.length; i++){
			if(this.companieros[i].obtenerNombre() == nombreDeCompanieros[j]){
				vida[j] = this.companieros[i].porcentajeDeVida();
				j++;
			}
		}
		return vida;
	}

	protected double obtenerPorcentajeVidaDeCompaniero(String nombreDeCompaniero){
		double vida = 0;
		for(int i = 0; i<this.companieros.length; i++){
			if(this.companieros[i].obtenerNombre() == nombreDeCompaniero){
				vida = this.companieros[i].porcentajeDeVida();
			}
		}
		return vida;
	}

	public abstract double porcentajeDeVida();

	public  boolean estaVivo(){ return (puntosDeVida != 0);}
}
