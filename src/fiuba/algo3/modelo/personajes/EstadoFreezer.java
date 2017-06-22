package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoFreezer {

	void atacar(Freezer freezer, GuerrerosZ oponente);

	void recibirDanio(Freezer freezer, double danio);
	
	void rayoMortal(Freezer freezer, GuerrerosZ oponente);

	void asignarCoordenadas(Freezer freezer, Coordenada coordenada);

	void recibirAtaque(Freezer freezer, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

    void cambiarCoordenadas(Coordenada coordenada, Coordenada coordenadaNueva);

	void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

}