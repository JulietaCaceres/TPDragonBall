import Juego.Tablero;
public class Partida {


    public void crearEquipos(){
        String guerreros [] = {"Goku", "Gohan", "Piccolo"};
        String enemigos [] = {"Cell", "Freezer", "MajinBoo"};
        Equipo guerrerosZ = new GuerrerosZ (guerreros);
        Equipo enemigosDeLaTierra = new EnemigosDeLaTierra (enemigos);
    }

    public void crearTablero(){
        Tablero tablero = new Tablero ();
    }
}