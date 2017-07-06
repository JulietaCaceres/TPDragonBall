package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public interface EstadoGohan {
	
	public abstract void atacar(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Gohan gohan, double danio);

	void masenko(Gohan gohan, EnemigosDeLaTierra oponente);

	public abstract void asignarCoordenadas(Gohan gohan, Coordenada coordenada);

	public abstract void recibirAtaque(Gohan gohan, Coordenada coordenadasDeAtacante, int alcanceDeAtaque, double poderDePelea);

	void convertir(Gohan gohan);

    EstadoGohan cambiarCoordenadas(Gohan gohan, Coordenada coordenadaFutura);

	void tomarNubeVoladora(EstadoNubeVoladora unaNubeVoladora);

	void  referenciarAGoku(GuerrerosZ goku);

	void referenciarAPiccolo(GuerrerosZ piccolo);

    String obtenerDireccionDeImagen();

    double obtenerAtaque(Gohan gohan);

	int obtenerDistanciaDeAtaque();

	int obtenerVelocidad();
}
