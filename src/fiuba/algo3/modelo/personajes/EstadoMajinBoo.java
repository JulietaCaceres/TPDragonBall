package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.Estado;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public abstract class EstadoMajinBoo extends Estado {

	public abstract void atacar(MajinBoo majinBoo, GuerrerosZ oponente);

	public abstract void recibirDanio(MajinBoo majinBoo, double danio);

	public abstract void convertirEnChocolate(GuerrerosZ oponente);

	public abstract void mover(MajinBoo majinBoo, Coordenada coordenadaDestino);

	public abstract void asignarCoordenadas(MajinBoo majinBoo, Coordenada coordenada);

	public abstract void recibirAtaque(MajinBoo majinBoo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

    public abstract void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva);

	public abstract void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	public abstract void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);
}
