package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoMajinBoo {
	
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente);

	public void recibirDanio(MajinBoo majinBoo, double danio);

	public void convertirEnChocolate(GuerrerosZ oponente);

	public void mover(MajinBoo majinBoo, Coordenada coordenadaDestino);

	public void asignarCoordenadas(MajinBoo majinBoo, Coordenada coordenada);

	public void recibirAtaque(MajinBoo majinBoo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

    void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva);

	void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);
}
