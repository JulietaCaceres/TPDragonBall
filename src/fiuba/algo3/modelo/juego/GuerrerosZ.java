package fiuba.algo3.modelo.juego;

public interface GuerrerosZ{
	
	public abstract void atacar(GuerrerosZ oponente);
	public abstract void realizarAtaqueEspecial(GuerrerosZ oponente);
	public abstract void atacar(EnemigosDeLaTierra oponente);
	public abstract void realizarAtaqueEspecial(EnemigosDeLaTierra oponente);
	public abstract void convertirseEnChocolate();
	public abstract void recibirDanio(double poderDePelea);
	public abstract void recibirAtaqueDe(Coordenada coordenadasDeAtacante,double poderDePelea, int alcanceDeAtaque);
	
} 
