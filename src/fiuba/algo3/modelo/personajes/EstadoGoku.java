package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;

public interface
EstadoGoku {
	
	public abstract void atacar(Goku goku, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Goku goku, double danio);

	void kamehameha(Goku goku, EnemigosDeLaTierra oponente);

	void asignarCoordenadas(Goku goku, Coordenada coordenada);

	 void recibirAtaque(Goku goku, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	public abstract void convertir(Goku goku);

    EstadoGoku cambiarCoordenadas(Goku goku, Coordenada nuevaCoordenada);

	void tomarNubeVoladora(EstadoNubeVoladora estadoNubeVoladora);

}
