package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;

public interface EstadoGohan {
	
	public abstract void atacar(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Gohan gohan, double danio);

	void masenko(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void asignarCoordenadas(Gohan gohan, Coordenada coordenada);

	public abstract void recibirAtaque(Gohan gohan, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	void convertir(Gohan gohan);

    void cambiarCoordenadas(Coordenada coordenadaActual, Coordenada coordenadaFutura);

    void cambiarCoordenadasConEstadoActual(Coordenada coordenadaActual, Coordenada coordenadaNueva);

	void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

}
