package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;

public interface EstadoGoku {	
	
	public abstract void atacar(Goku goku, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Goku goku, double danio);

	void kamehameha(Goku goku, EnemigosDeLaTierra oponente);
	
	public abstract void mover(Goku goku, Coordenada coordenadaInicial, Coordenada coordenadaFinal);
}
