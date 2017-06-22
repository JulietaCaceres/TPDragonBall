package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

import java.util.ArrayList;


public class Jugador {

    private String nombre;
    private Personaje[] equipo;
    private Jugador otroJugador;

    public Jugador(String unNombre){
        nombre = unNombre;

    }

    public void asignarOtroJugador(Jugador unJugador){ otroJugador = unJugador;}


    public void asignarEquipo(Personaje[] guerreros) { equipo = guerreros; }

    public Personaje[] obtenerEquipo() { return equipo;
    }

    public Jugador obtenerOtroJugador(){ return otroJugador;}

    public boolean noTienePersonajesVivos() {
        boolean tiene = true;
        for (Personaje unPersonaje: equipo
             ) {
            tiene = unPersonaje.estaVivo();
            if (tiene) return (!tiene);
        }
        return (!tiene);
        }

    public void elegirAccion(MenuAcciones menuAcciones) {


    }
}

