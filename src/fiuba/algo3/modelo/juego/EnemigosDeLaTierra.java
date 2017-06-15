package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public abstract class EnemigosDeLaTierra extends Personaje{
	public EnemigosDeLaTierra() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract void atacar(GuerrerosZ oponente);
	public abstract void realizarAtaqueEspecial(GuerrerosZ oponente);
	public abstract void atacar(EnemigosDeLaTierra oponente);
	public abstract void realizarAtaqueEspecial(EnemigosDeLaTierra oponente);
} 
