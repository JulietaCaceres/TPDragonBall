package fiuba.algo3.modelo.juego;


import fiuba.algo3.modelo.juego.excepciones.ExceptionElPersonajeNoLePertenece;

public class JugadorEnemigo extends Jugador {

    private JugadorGuerrero otroJugador;

    public JugadorEnemigo(String nombreJugadorEnemigo, JugadorGuerrero jugadorGuerrero){
        super(nombreJugadorEnemigo,jugadorGuerrero);
        otroJugador = jugadorGuerrero;
    }

    public void atacarConPersonajeA(Equipo atacante, Equipo atacado){
        buscarPersonaje(atacante).atacar(otroJugador.buscarPersonaje(atacado));
    }

    @Override
    public void realizarAtaqueEspercial(Equipo personajeAtacante, Equipo personajeAtacado) {
        buscarPersonaje(personajeAtacante).realizarAtaqueEspecial(otroJugador.buscarPersonaje(personajeAtacado));
    }

    public EnemigosDeLaTierra buscarPersonaje(Equipo personajeBuscado){
        if(!enemigos.contains(personajeBuscado))
            throw new ExceptionElPersonajeNoLePertenece();
        for (EnemigosDeLaTierra unPersonaje: enemigos){
            if(unPersonaje.equals(personajeBuscado))
                return unPersonaje;
        }
        return null;
    }

    public boolean noTienePersonajesVivos(){
        boolean tiene = true;
        for (EnemigosDeLaTierra unPersonaje:enemigos) {
            tiene = unPersonaje.estaVivo();
            if (tiene) return (!tiene);
        }
        return (!tiene);

    }

    @Override
    public boolean esGuerrero() {
        return false;
    }

    @Override
    public Jugador obtenerOtroJugador() {
        return otroJugador;
    }

    public void borrarPersonajesMuertos(){

        for (EnemigosDeLaTierra unEnemigo: enemigos
             ) { if (unEnemigo.obtenerPuntosDeVida() <= 0){
                 unEnemigo.obtenerCoordenadas().obtenerCasillero().liberarDePersonaje();
                 enemigos.remove(unEnemigo);
               }

        }

    }
}

