package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.Estado;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public abstract class EstadoFreezer extends Estado {

	public abstract void atacar(Freezer freezer, GuerrerosZ oponente);

	public abstract void recibirDanio(Freezer freezer, double danio);

	public abstract void rayoMortal(Freezer freezer, GuerrerosZ oponente);

	public abstract void asignarCoordenadas(Freezer freezer, Coordenada coordenada);

	public abstract void recibirAtaque(Freezer freezer, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

    public abstract void cambiarCoordenadas(Coordenada coordenada, Coordenada coordenadaNueva);

	public abstract void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	public abstract void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

}
