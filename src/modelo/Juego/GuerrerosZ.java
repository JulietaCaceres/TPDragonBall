package modelo.Juego;

import modelo.Personajes.Personaje;

public abstract class GuerrerosZ extends Personaje{
	public GuerrerosZ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public abstract void atacar(GuerrerosZ oponente);
	public abstract void realizarAtaqueEspecial(GuerrerosZ oponente);
	public abstract void atacar(EnemigosDeLaTierra oponente);
	public abstract void realizarAtaqueEspecial(EnemigosDeLaTierra oponente);
	public abstract void convertirseEnChocolate();
	public abstract void volverAEstadoNormal();
} 
