package fiuba.algo3.modelo.juego;

public interface Equipo {

    void cambiarCoordenadas(Coordenada unaCoordenada);
    void asignarCoordenadas(Coordenada unaCoordenada);
    Coordenada obtenerCoordenadas();
    void tomarConsumibleDe(Casillero unCasillero);
    void comerSemillaDelErmitanio();
    void atacar(GuerrerosZ unGuerreroZ);
    void atacar(EnemigosDeLaTierra unEnemigo);
    boolean estaVivo();
}
