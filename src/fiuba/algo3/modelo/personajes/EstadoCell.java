package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public abstract class EstadoCell extends Estado {

	public abstract void atacar(Cell cell, GuerrerosZ oponente);

	public abstract void recibirDanio(Cell cell, double danio);

	public abstract void absorberVida(Cell cell, GuerrerosZ oponente);

	public abstract void asignarCoordenadas(Cell cell, Coordenada coordenada);

	public abstract void recibirAtaque(Cell cell, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

    public abstract void cambiarCoordenadas(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	public abstract void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	public abstract void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

}
