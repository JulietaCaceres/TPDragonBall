package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

import java.util.ArrayList;
import java.util.Scanner;


public class Jugador {

    private String nombreEquipo;
    private String nombre;
    private ArrayList<GuerrerosZ> guerrerosZ;
    private ArrayList<EnemigosDeLaTierra> enemigos;
    private Jugador otroJugador;

    public Jugador(String unNombre){ nombre = unNombre;
    nombreEquipo = "enemigo"; }

    public  Jugador(String unNombre, String nombreOtroJugador){
        nombre = unNombre;
        otroJugador = new Jugador(nombreOtroJugador);
        nombreEquipo = "guerrero";
    }

    public void asignarEquipo(ArrayList<EnemigosDeLaTierra> equipoEnemigo){
        enemigos = equipoEnemigo;
    }

    public void asignarEquipo(ArrayList<GuerrerosZ> equipoZ, ArrayList<EnemigosDeLaTierra> equipoEnemigo) {

        guerrerosZ = equipoZ;
        otroJugador.asignarEquipo(equipoEnemigo);
    }

    public void asignarEquipoEnemigo(ArrayList<EnemigosDeLaTierra> enemigos) {
        otroJugador.asignarEquipo(enemigos);
    }

    public ArrayList<GuerrerosZ> obtenerEquipoGuerreros() {
    	return guerrerosZ;
    }

    public ArrayList<EnemigosDeLaTierra> obtenerEquipoEnemigo(){
        return enemigos;
    }

    public Jugador obtenerOtroJugador(){
    	return otroJugador;
    }



 public GuerrerosZ buscarPersonajeGuerrero(Personaje personajeBuscado) {
     if (!guerrerosZ.contains(personajeBuscado))
         throw new ExceptionElPersonajeNoLePertenece();

     for (GuerrerosZ unPersonaje : guerrerosZ) {

         if (unPersonaje.equals(personajeBuscado)) ;
         return unPersonaje;
     }
     return null;
 }

    public EnemigosDeLaTierra buscarPersonajeEnemigo(Personaje personajeBuscado){
        if(enemigos.contains(personajeBuscado))
            throw new ExceptionElPersonajeNoLePertenece();
        for (EnemigosDeLaTierra unPersonaje: enemigos){
            if(unPersonaje.equals(personajeBuscado))
                return unPersonaje;
        }
     return null;
    }


    public boolean noTienePersonajesVivos() {
       if (this.esGuerrero()) return noTieneGuerrerosVivos();
       return noTieneEnemigosVivos();

    }

    private boolean noTieneEnemigosVivos() {
        boolean tiene = true;
        for (EnemigosDeLaTierra unPersonaje:enemigos) {
            tiene = unPersonaje.estaVivo();
            if (tiene) return (!tiene);
        }
        return (!tiene);


    }

    private boolean noTieneGuerrerosVivos() {
        boolean tiene = true;
        for (GuerrerosZ unPersonaje: guerrerosZ) {
            tiene = unPersonaje.estaVivo();
            if (tiene) return (!tiene);
        }
        return (!tiene);

    }


    public boolean esGuerrero() {
        return  nombreEquipo == "guerrero";
    }
}