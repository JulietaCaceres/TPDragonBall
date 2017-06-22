package fiuba.algo3.modelo.juego;

public class Turno {

     private Jugador jugadorUno;
     private Jugador jugadorDos;
     private Jugador jugadorActual;
     private MenuAcciones menuAcciones;
     public Turno(Jugador jugadorGuerrero, Jugador jugadorEnemigo){
         jugadorUno = jugadorGuerrero;
         jugadorDos = jugadorEnemigo;
         jugadorActual = jugadorUno;
     }

    public boolean ganoJugador() {
         return (jugadorActual.obtenerOtroJugador().noTienePersonajesVivos());
    }

    public void cambiarJugador() { jugadorActual = jugadorActual.obtenerOtroJugador();
    }

    public void jugadorActualJugar() {
        jugadorActual.elegirAccion(menuAcciones);
    }
}
