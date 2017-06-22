package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;

public interface EstadoPiccolo {
	public abstract void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Piccolo piccolo, double danio);

	public abstract void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente);

	void asignarCoordenadas(Piccolo piccolo, Coordenada coordenada);

	void recibirAtaque(Piccolo piccolo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	void convertir(Piccolo piccolo);

    void cambiarCoordenadas(Coordenada coordenadaActual,Coordenada coordenadaNueva);

    void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);
}
