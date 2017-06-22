package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.*;
public class Partida {
    
	private Tablero tablero;
    private Jugador jugadorZ;
    private Jugador jugadorE;
    Personaje[] guerreros = new Personaje[3];
    
    public  Partida (Jugador jugadorEnemigo,Jugador jugadorGuerrero,Tablero unTablero)
    {   tablero = unTablero;
        jugadorZ = jugadorGuerrero;
        jugadorE = jugadorEnemigo;
        guerreros = jugadorZ.obtenerEquipo();
        //Gohan puede obtener el porcentaje de vida de todos sus companieros
        guerreros[1].asignarReferenciaAEquipo(guerreros);
        //Piccolo puede obtener el porcentaje de vida de todos sus companieros
        guerreros[2].asignarReferenciaAEquipo(guerreros);
    }



    public void iniciarTablero() { tablero.iniciarTablero(guerreros,jugadorE.obtenerEquipo()); }
}