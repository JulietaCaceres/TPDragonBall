package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public abstract class Consumible implements IUbicable  {

    protected String direccionImagen;
    protected Coordenada coordenada;

	public abstract void aplicarEfecto(Personaje personaje);

    @Override
    public Coordenada obtenerCoordenadas() {
        return coordenada;
    }


    @Override
    public  String obtenerDireccionDeImagen(){ return direccionImagen;}

    @Override
    public boolean esUnConsumible() {
        return true;
    }

    @Override
    public boolean esUnPersonaje() {
        return false;
    }

    @Override
    public Consumible obtenerConsumible() {
        return this;
    }

    @Override
    public void asignarCoordenadas(Coordenada coordenadaNueva) {
        coordenada = coordenadaNueva;
    }

    @Override
    public boolean esVacio() {
        return false;
    }


}
