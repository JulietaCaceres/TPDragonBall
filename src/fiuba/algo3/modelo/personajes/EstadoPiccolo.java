package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.Estado;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;

public abstract class EstadoPiccolo extends Estado {
	public abstract void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Piccolo piccolo, double danio);

	public abstract void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente);

	public abstract void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada);

	public abstract void recibirAtaque(Piccolo piccolo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	public abstract void convertir(Piccolo piccolo);

    public abstract void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva);

    public abstract void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	public abstract void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);
}
