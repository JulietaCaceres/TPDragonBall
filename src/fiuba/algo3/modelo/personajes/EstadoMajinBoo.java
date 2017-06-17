package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoMajinBoo {
	
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente);

	public void recibirDanio(MajinBoo majinBoo, double danio);

	public void convertirEnChocolate(GuerrerosZ oponente);

	public void mover(MajinBoo majinBoo, Coordenada coordenadaInicial, Coordenada coordenadaFinal);
}
