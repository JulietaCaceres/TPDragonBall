package modelo.Juego;

import modelo.Personajes.Personaje;

public class Casillero {
	Personaje personaje;
	Consumible consumible;
	
	Casillero(){
		this.personaje = null;
		this.consumible= null;
	}

	public Personaje obtenerPersonaje() {
		return this.personaje;
	}
	
	public Consumible obtenerConsumible() {
		return this.consumible;
	}

	public void asignarPersonaje(Personaje personaje) {
		this.personaje = personaje;
		
	}
	
	public void asignarConsumible(Consumible consumible) {
		this.consumible = consumible;
		
	}
	
	public boolean ocupado(){
		return (this.personaje != null);
	}
}
