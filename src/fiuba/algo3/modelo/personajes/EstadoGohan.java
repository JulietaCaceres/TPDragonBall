package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;

public interface EstadoGohan {
	
	public abstract void atacar(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Gohan gohan, double danio);

	void masenko(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void mover(Gohan gohan, Coordenada coordenadaDestino);

	public abstract void asignarCoordenadas(Gohan gohan, Coordenada coordenada);

	public abstract void recibirAtaque(Gohan gohan, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	void convertir(Gohan gohan);
}
