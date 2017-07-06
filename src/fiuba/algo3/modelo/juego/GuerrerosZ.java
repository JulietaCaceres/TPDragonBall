package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.personajes.Piccolo;

public interface GuerrerosZ extends Equipo{

	public abstract void atacar(GuerrerosZ oponente);
	public abstract void realizarAtaqueEspecial(GuerrerosZ oponente);
	public abstract void atacar(EnemigosDeLaTierra oponente);
	public abstract void realizarAtaqueEspecial(EnemigosDeLaTierra oponente);
	public abstract void convertirseEnChocolate();
	public abstract void recibirDanio(double poderDePelea);
	public abstract void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque);
	void referenciarAGoku(GuerrerosZ goku);
	void referenciarAPiccolo(GuerrerosZ piccolo);
	boolean porcentajeDeVidaMenor30();
	boolean porcentajeDeVidaMenosde20();
	void asignarCoordenadas(Coordenada unaCoordenada);
	double obtenerPuntosDeVida();

    @Override
    public double obtenerAtaque();
} 
