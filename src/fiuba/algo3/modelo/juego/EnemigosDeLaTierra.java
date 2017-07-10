package fiuba.algo3.modelo.juego;

public interface EnemigosDeLaTierra extends Equipo{

	public abstract void asignarCoordenadas(Coordenada unaCoordenada);
	public abstract double obtenerPuntosDeVida();

    @Override
    public double obtenerAtaque();

    @Override
     int obtenerDistanciaDeAtaque();

	public abstract void atacar(GuerrerosZ oponente);
	public abstract void realizarAtaqueEspecial(GuerrerosZ oponente);
	public abstract void atacar(EnemigosDeLaTierra oponente);
	public abstract void realizarAtaqueEspecial(EnemigosDeLaTierra oponente);
	public abstract void recibirDanio(double poderDePelea);
	public abstract void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque);

}
