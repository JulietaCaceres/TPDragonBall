package fiuba.algo3.modelo.juego;

public interface Equipo extends IUbicable {

 public abstract void cambiarCoordenadas(Coordenada unaCoordenada);
 public abstract void asignarCoordenadas(Coordenada unaCoordenada);
 abstract Coordenada obtenerCoordenadas();
 abstract void tomarConsumibleDe(Casillero unCasillero);
 abstract void comerSemillaDelErmitanio();
 abstract void atacar(GuerrerosZ unGuerreroZ);
 abstract void atacar(EnemigosDeLaTierra unEnemigo);
 public  abstract boolean estaVivo();
String obtenerDireccionDeImagen();

    @Override
    default boolean esUnPersonaje() {
        return true;
    }

    String obtenerNombre();

 double obtenerPuntosDeVida();

    double obtenerAtaque();


    int obtenerDistanciaDeAtaque();

    int obtnerVelocidad();
}
