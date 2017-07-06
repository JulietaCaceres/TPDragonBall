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

    EstadoFreezer cambiarCoordenadas(Freezer freezer, Coordenada coordenadaNueva);

	void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

    String obtenerDireccionDeImagen();

    double obtenerAtaque(Freezer freezer);

	int obtenerDistanciaDeAtaque();

    int obtenerVelocidad();
}
