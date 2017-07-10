package fiuba.algo3.modelo.juego;


public  class Vacio implements IUbicable {


    protected Coordenada coordenada;
    private String direccionDeImagen;

    public Vacio(Coordenada suCoordenada) {

        coordenada = suCoordenada;
        direccionDeImagen = "file:src/fiuba/algo3/vista/images/transparente.png";
    }

    @Override
    public Coordenada obtenerCoordenadas() {
        return coordenada;
    }



    @Override
    public String obtenerDireccionDeImagen() {
        return direccionDeImagen;
    }

    @Override
    public boolean esUnConsumible() {
        return false;
    }

    @Override
    public boolean esUnPersonaje() {
        return false;
    }

    @Override
    public Consumible obtenerConsumible() {
        return null;
    }

    @Override
    public void asignarCoordenadas(Coordenada coordenadaNueva) {

    }

    @Override
    public boolean esVacio() {
        return true;
    }
}
