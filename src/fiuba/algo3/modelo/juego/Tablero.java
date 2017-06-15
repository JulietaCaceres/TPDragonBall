package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

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

	public static Tablero obtenerTablero(){
		if (Tablero.instance == null){
			Tablero.instance = new Tablero();
		}
		return Tablero.instance;
	}

	public void reiniciarTablero(){
		Tablero.instance = null;
	}

	public Fila obtenerFila(int posicion){
		return filas[posicion-1];
	}

	public void ubicarPersonaje(Personaje unPersonaje, int unaFila, int unaColumna){

		obtenerFila(unaFila).agregarPersonaje(unaColumna,unPersonaje);
		unPersonaje.asignarCoordenadas(unaFila, unaColumna);
	}
}
