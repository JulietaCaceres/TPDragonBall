public class Partida {
	
	int campo [] = {48,27};
	
    public void crearEquipos(){
    	string guerreros [] = {"Goku", "Gohan", "Piccolo"};
    	string enemigos [] = {"Cell", "Freezer", "MajinBoo"};
    	Equipo guerrerosZ = new GuerrerosZ (guerreros);
    	Equipo enemigosDeLaTierra = new EnemigosDeLaTierra (enemigos);
    }
    
    public void crearTablero(){
    	Tablero tablero = new Tablero (campo);
    }
}
