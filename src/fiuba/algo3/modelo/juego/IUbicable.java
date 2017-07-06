package fiuba.algo3.modelo.juego;

public interface IUbicable {


	Coordenada obtenerCoordenadas();

	String obtenerDireccionDeImagen();

	boolean esUnConsumible();

	boolean esUnPersonaje();

	Consumible obtenerConsumible();

	void asignarCoordenadas(Coordenada coordenadaNueva);

	boolean esVacio();
}
