package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.juego.excepciones.ExceptionElPersonajeNoLePertenece;
import fiuba.algo3.modelo.personajes.Personaje;

import java.util.Random;

public class Turno {


     private Jugador jugadorActual;
     private MenuAcciones menuAcciones;
     private Tablero tablero;
     
     public Turno(JugadorGuerrero jugadorGuerrero){

         jugadorActual = jugadorGuerrero;
     }
     public void iniciarTablero(Tablero unTablero){
         tablero = unTablero;
         tablero.iniciarTablero(jugadorActual.obtenerEquipoGuerreros(),jugadorActual.obtenerOtroJugador().obtenerEquipoEnemigo());

     }
     public void colocarConsumibles() {
         Random numeroRandom = new Random();
         int cantidadDeConsumibles = numeroRandom.nextInt(3) + 1;
         Random numeroFilaRandom = new Random();
         int fila = numeroFilaRandom.nextInt(8);
         Random numeroColumnaRandom = new Random();
         int columna = numeroColumnaRandom.nextInt(8);
         for (int k = 0; k < cantidadDeConsumibles; k++) {
             Random numeroProba = new Random(System.currentTimeMillis());
             if (numeroProba.nextInt(100) / 2 < 2) {
                 Consumible unConsumible = new NubeVoladora();
                 tablero.ubicarConsumible(unConsumible, fila, columna);
             } else {
                 if (numeroProba.nextInt(100) / 3 < 3) {
                     Consumible unConsumible = new EsferaDelDragon();
                     tablero.ubicarConsumible(unConsumible, fila, columna);
                 } else {
                     if (numeroProba.nextInt(100) / 5 < 5) {
                         Consumible unConsumible = new SemillaDelErmitanio();
                         tablero.ubicarConsumible(unConsumible, fila, columna);
                     }
                 }
             }
         }
     }
    public boolean ganoJugador() {
         return (jugadorActual.obtenerOtroJugador().noTienePersonajesVivos());
    }

    public void cambiarJugador() { 
    	jugadorActual = jugadorActual.obtenerOtroJugador();
    }


    public void moverPersonaje(Equipo unPersonaje, int fila, int columna) {
         if (!jugadorActual.tienePersonaje(unPersonaje))
             throw new ExceptionElPersonajeNoLePertenece();
         tablero.moverPersonaje(unPersonaje,fila, columna);
        cambiarJugador();
        colocarConsumibles();
     };

    public void atacarConPersonajeA(Equipo personajeAtacante, Equipo personajeAtacado) {
        jugadorActual.atacarConPersonajeA(personajeAtacante,personajeAtacado);
        cambiarJugador();
        colocarConsumibles();
        borrarPersonajesMuertos();
    }

    public  void realzarAtaqueEspecialA(Equipo personajeAtacante, Equipo personajeAtacado){
        jugadorActual.realizarAtaqueEspercial(personajeAtacante,personajeAtacado);
        cambiarJugador();
        colocarConsumibles();
        borrarPersonajesMuertos();
    }

    public Jugador obtenerJugadorActual() { return jugadorActual;
    }

    public void borrarPersonajesMuertos() {
        jugadorActual.borrarPersonajesMuertos();

    }

    public Tablero obtenerTablero() { return tablero;
    }

    public Jugador obtenerJugadorGuerrero() {
        if (jugadorActual.esGuerrero()) return jugadorActual;
        return jugadorActual.obtenerOtroJugador();
    }

    public Jugador obtenerJugadorEnemigo() {
        if (jugadorActual.esGuerrero())return jugadorActual.obtenerOtroJugador();
        return jugadorActual;
    }
}
