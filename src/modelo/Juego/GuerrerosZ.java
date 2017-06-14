package modelo.Juego;

import modelo.Personajes.Personaje;

public abstract class GuerrerosZ extends Personaje{
	public GuerrerosZ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public abstract void atacar(GuerrerosZ oponente);
	public abstract void atacar(EnemigosDeLaTierra oponente);
} 
