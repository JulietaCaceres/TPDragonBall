package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class Turno {


     private Jugador jugadorActual;
     private MenuAcciones menuAcciones;
     private Tablero tablero;
     
     public Turno(Jugador jugadorGuerrero){

         jugadorActual = jugadorGuerrero;
     }
     public void iniciarTablero(Tablero unTablero){
         tablero = unTablero;

     }

    public boolean ganoJugador() {
         return (jugadorActual.obtenerOtroJugador().noTienePersonajesVivos());
    }

    public void cambiarJugador() { 
    	jugadorActual = jugadorActual.obtenerOtroJugador();
    }


    public void moverPersonaje(Equipo unPersonaje, int fila, int columna) {tablero.moverPersonaje(unPersonaje,fila, columna); };

    public void atacarConPersonajeA(Personaje personajeAtacante, Personaje personajeAtacado) {
        if (jugadorActual.esGuerrero()) {
            jugadorActual.buscarPersonajeGuerrero(personajeAtacante).atacar(jugadorActual.obtenerOtroJugador().buscarPersonajeEnemigo(personajeAtacado));
        }else jugadorActual.buscarPersonajeEnemigo(personajeAtacante).atacar(jugadorActual.obtenerOtroJugador().buscarPersonajeGuerrero(personajeAtacado));
    }



}
