package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.juego.excepciones.ExceptionElPersonajeNoLePertenece;
import fiuba.algo3.modelo.personajes.Personaje;

import java.util.ArrayList;


public abstract class Jugador {

    private String nombreEquipo;
    private String nombre;
    protected ArrayList<GuerrerosZ> guerrerosZ;
    protected ArrayList<EnemigosDeLaTierra> enemigos;

    public Jugador(String unNombre, Jugador otroJugador){
        nombre = unNombre;

    }

    public  Jugador(String unNombre, String nombreOtroJugador){
        nombre = unNombre;
         }

    public void asignarEquipo(ArrayList<EnemigosDeLaTierra> equipoEnemigo){
        enemigos = equipoEnemigo;
    }

    public void asignarEquipo(ArrayList<GuerrerosZ> equipoZ, ArrayList<EnemigosDeLaTierra> equipoEnemigo) {

        guerrerosZ = equipoZ;
        obtenerOtroJugador().asignarEquipoEnemigo(equipoEnemigo);
    }

    public void asignarEquipoEnemigo(ArrayList<EnemigosDeLaTierra> enemigos) {
        obtenerOtroJugador().asignarEquipo(enemigos);
    }

    public ArrayList<GuerrerosZ> obtenerEquipoGuerreros() {
    	return guerrerosZ;
    }

    public ArrayList<EnemigosDeLaTierra> obtenerEquipoEnemigo(){
        return enemigos;
    }

    public abstract Jugador obtenerOtroJugador();


    public abstract boolean noTienePersonajesVivos();



    public abstract boolean esGuerrero();

    public String obtenerNombre() { return nombre;
    }

    public abstract void borrarPersonajesMuertos();
  

    public boolean tienePersonaje(Equipo unPersonaje) {
        if (esGuerrero()){
            return guerrerosZ.contains(unPersonaje);
        }
        return enemigos.contains(unPersonaje);
    }

    public abstract void atacarConPersonajeA(Equipo personajeAtacante, Equipo personajeAtacado);

    public abstract void realizarAtaqueEspercial(Equipo personajeAtacante, Equipo personajeAtacado);
}