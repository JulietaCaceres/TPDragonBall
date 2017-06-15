package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

import java.util.ArrayList;

public class Tablero {

	public Fila filas[];
	private static final int CANTIDAD_COLUMNAS = 32;
	private static final int CANTIDAD_FILAS = 32;
	private static Tablero instance = null;

	public Tablero() {
		filas = new Fila[CANTIDAD_FILAS];
		for (int i = 0; i < CANTIDAD_FILAS; i++) {
			filas[i] = new Fila(i, CANTIDAD_COLUMNAS);
		}
	}

	public Fila obtenerFila(int posicion){
		return filas[posicion];
	}

	public void ubicarPersonaje(Personaje unPersonaje, int unaFila, int unaColumna){

		obtenerFila(unaFila).agregarPersonaje(unaColumna,unPersonaje);
		unPersonaje.asignarCoordenadas(unaFila, unaColumna);
	}

	public void iniciarTablero(ArrayList<Personaje>guerreros, ArrayList<Personaje> enemigos)
	{
		ubicarPersonaje(guerreros.get(0),2,0);
		ubicarPersonaje(guerreros.get(1),1,1);
		ubicarPersonaje(guerreros.get(2), 0,2);
		ubicarPersonaje(enemigos.get(0),31,29);
		ubicarPersonaje(enemigos.get(1),30,30);
		ubicarPersonaje(enemigos.get(2),29,31);

	}

	public Casillero obtenerCasillero(int fila,int columna)
	{
      return obtenerFila(fila).obtenerCasillero(fila,columna);
	}
}
