package fiuba.algo3.modelo;

import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.juego.Equipo;
public class Partida {

     protected Equipo guerrerosZ;
    public void crearEquipos(){
        String guerreros [] = {"Goku", "Gohan", "Piccolo"};
        String enemigos [] = {"Cell", "Freezer", "MajinBoo"};
        // guerrerosZ= new GuerrerosZ(guerreros);
        //fiuba.algo3.modelo.Equipo enemigosDeLaTierra = new EnemigosDeLaTierra(enemigos);
    }

    public void crearTablero(){
        Tablero tablero = new Tablero ();
    }
}