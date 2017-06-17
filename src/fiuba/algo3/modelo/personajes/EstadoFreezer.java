package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoFreezer {

	void atacar(Freezer freezer, GuerrerosZ oponente);

	void recibirDanio(Freezer freezer, double danio);
	
	void rayoMortal(Freezer freezer, GuerrerosZ oponente);

	void mover(Freezer freezer, Coordenada coordenadaInicial, Coordenada coordenadaFinal);
	
}
