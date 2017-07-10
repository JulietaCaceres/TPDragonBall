package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.juego.excepciones.ExceptionElPersonajeNoLePertenece;

import java.util.ArrayList;

public class JugadorGuerrero extends Jugador {

    private JugadorEnemigo otroJugador;

    public JugadorGuerrero(String nombreJugadorGuerrero, String nombreJugadorEnemigo){
        super(nombreJugadorGuerrero,nombreJugadorEnemigo);
        otroJugador = new JugadorEnemigo(nombreJugadorEnemigo,this);
    }

    @Override
    public Jugador obtenerOtroJugador() {
        return otroJugador;
    }

    public void atacarConPersonajeA(Equipo atacante, Equipo atacado){

            buscarPersonaje(atacante).atacar(otroJugador.buscarPersonaje(atacado));
    }

    @Override
    public void realizarAtaqueEspercial(Equipo personajeAtacante, Equipo personajeAtacado) {
        buscarPersonaje(personajeAtacante).realizarAtaqueEspecial(otroJugador.buscarPersonaje(personajeAtacado));
    }


    public GuerrerosZ buscarPersonaje(Equipo personajeBuscado){
        if (!guerrerosZ.contains(personajeBuscado))
            throw new ExceptionElPersonajeNoLePertenece();

        for (GuerrerosZ unPersonaje : guerrerosZ) {

            if (unPersonaje.equals(personajeBuscado)) return unPersonaje;
        }
        return null;
    }


    public boolean noTienePersonajesVivos(){
        boolean tiene = true;
        for (GuerrerosZ unPersonaje: guerrerosZ) {
            tiene = unPersonaje.estaVivo();
            if (tiene) return (!tiene);
        }
        return (!tiene);

    }

    @Override
    public boolean esGuerrero() {
        return true;
    }

    public void borrarPersonajesMuertos(){
        int i = 0;
        while (i < guerrerosZ.size()){

            GuerrerosZ unGuerrero = guerrerosZ.get(i);
            if (unGuerrero.obtenerPuntosDeVida() <= 0){
                unGuerrero.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
                guerrerosZ.remove(i);
            }

            i++;
        }
    }




}


