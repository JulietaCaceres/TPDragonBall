package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.Estado;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;

public abstract class EstadoGohan extends Estado {

	public abstract void atacar(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Gohan gohan, double danio);

	public abstract void masenko(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void asignarCoordenadas(Gohan gohan, Coordenada coordenada);

	public abstract void recibirAtaque(Gohan gohan, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	public abstract void convertir(Gohan gohan);

    public abstract void cambiarCoordenadas(Coordenada coordenadaActual, Coordenada coordenadaFutura);

    public abstract void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	public abstract void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

}
