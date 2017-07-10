package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoMajinBoo {
	
	public void atacar(MajinBoo majinBoo, GuerrerosZ oponente);

	public void recibirDanio(MajinBoo majinBoo, double danio);

	public void convertirEnChocolate(GuerrerosZ oponente);


	public void asignarCoordenadas(MajinBoo majinBoo, Coordenada coordenada);

	public void recibirAtaque(MajinBoo majinBoo, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

    EstadoMajinBoo cambiarCoordenadas(MajinBoo majinBoo, Coordenada coordenadaNueva);


	void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

    String obtenerDireccionDePersonaje();

    double obtenerAtaque(MajinBoo majinBoo);

	int obtenerDistanciaDeAtaque();

	int obtenerVelocidad();
}
