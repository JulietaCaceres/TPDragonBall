package modelo.Juego;

import modelo.Personajes.Personaje;

public abstract class EnemigosDeLaTierra extends Personaje{
	public EnemigosDeLaTierra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract void atacar(GuerrerosZ oponente);
	public abstract void atacar(EnemigosDeLaTierra oponente);
} 
