import fiuba.algo3.modelo.juego.excepciones.ExceptionElPersonajeNoLePertenece;
import fiuba.algo3.modelo.personajes.Personaje;

import java.util.ArrayList;


public class Jugador {

    private String nombreEquipo;
    private String nombre;
    private ArrayList<GuerrerosZ> guerrerosZ;
    private ArrayList<EnemigosDeLaTierra> enemigos;
    private Jugador otroJugador;

    public Jugador(String unNombre, Jugador otroJugador){
        nombre = unNombre;
        nombreEquipo = "enemigo";
        this.otroJugador = otroJugador;
    }

    public  Jugador(String unNombre, String nombreOtroJugador){
        nombre = unNombre;
        otroJugador = new Jugador(nombreOtroJugador, this);
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



 public GuerrerosZ buscarPersonajeGuerrero(Equipo personajeBuscado) {
     if (!guerrerosZ.contains(personajeBuscado))
         throw new ExceptionElPersonajeNoLePertenece();

     for (GuerrerosZ unPersonaje : guerrerosZ) {

         if (unPersonaje.equals(personajeBuscado)) return unPersonaje;
     }
     return null;
 }

    public EnemigosDeLaTierra buscarPersonajeEnemigo(Equipo personajeBuscado){
        if(!enemigos.contains(personajeBuscado))
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

    public String obtenerNombre() { return nombre;
    }

    public void borrarPersonajesMuertos() {
        borrarGuerrerosMuertos();
        borrasEnemigosMuertos();
        }

    public void borrasEnemigosMuertos() {

        int i=0;
        while (i < enemigos.size()) {
            if (enemigos.get(i).obtenerPuntosDeVida() <= 0) {
                EnemigosDeLaTierra enemigoMuerto = enemigos.get(i);
                Coordenada coordenada = enemigoMuerto.obtenerCoordenadas();
                Tablero.getTablero().obtenerCasillero(coordenada.obtenerFila(), coordenada.obtenerColumna()).liberarDePersonaje();
                enemigos.remove(i);
            } else {
                i++;
            }
        }
    }

    public void borrarGuerrerosMuertos() {
        int i=0;
        while (i < guerrerosZ.size()) {
            if (guerrerosZ.get(i).obtenerPuntosDeVida() <= 0){
                GuerrerosZ guerreroMuerto = guerrerosZ.get(i);
                Coordenada coordenada = guerreroMuerto.obtenerCoordenadas();
                Tablero.getTablero().obtenerCasillero(coordenada.obtenerFila(),coordenada.obtenerColumna()).liberarDePersonaje();
                guerrerosZ.remove(i);
            } else {
                i++;
            }
    }
}

    public boolean tienePersonaje(Equipo unPersonaje) {
        if (esGuerrero()){
            return guerrerosZ.contains(unPersonaje);
        }
        return enemigos.contains(unPersonaje);
    }
}
