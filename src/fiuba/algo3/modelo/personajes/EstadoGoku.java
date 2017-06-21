package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;

public interface EstadoGoku {	
	
	public abstract void atacar(Goku goku, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Goku goku, double danio);

	void kamehameha(Goku goku, EnemigosDeLaTierra oponente);
	
	public abstract void asignarCoordenadas(Goku goku, Coordenada coordenada);

	public abstract void recibirAtaque(Goku goku, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	public abstract void convertir(Goku goku);

    void cambiarCoordenadas(Coordenada coordenadaActual, Coordenada nuevaCoordenada, int aumentoDeVelocidad);

	void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva, int aumentoDeVelocidad);

}
