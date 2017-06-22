package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.Estado;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;

public abstract class EstadoGoku extends Estado {

	public abstract void atacar(Goku goku, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Goku goku, double danio);

	public abstract void kamehameha(Goku goku, EnemigosDeLaTierra oponente);

	public abstract void asignarCoordenadas(Goku goku, Coordenada coordenada);

	public abstract void recibirAtaque(Goku goku, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	public abstract void convertir(Goku goku);

    public abstract void cambiarCoordenadas(Coordenada coordenadaActual, Coordenada nuevaCoordenada);

	public abstract void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	public abstract void tomarNubeVoladora(EstadoNubeVoladora estadoNubeVoladora);

}
