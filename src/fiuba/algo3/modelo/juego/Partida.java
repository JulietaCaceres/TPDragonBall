package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.*;

public class Partida {


    public void crearEquipos(){
        Personaje guerreros [] = {new Goku(), new Gohan(), new Piccolo()};
        //Gohan puede obtener el porcentaje de vida de todos sus companieros
        guerreros[1].asignarReferenciaAEquipo(guerreros);
        //Piccolo puede obtener el porcentaje de vida de todos sus companieros
        guerreros[2].asignarReferenciaAEquipo(guerreros);
        Personaje enemigos [] = {new Cell(), new Freezer(), new MajinBoo()};
        //fiuba.algo3.modelo.Equipo guerrerosZ = new GuerrerosZ (guerreros);
        //fiuba.algo3.modelo.Equipo enemigosDeLaTierra = new EnemigosDeLaTierra (enemigos);
    }

    public void crearTablero(){
        Tablero tablero = new Tablero ();
    }
}