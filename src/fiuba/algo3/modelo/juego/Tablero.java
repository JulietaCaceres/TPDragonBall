package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

import java.util.ArrayList;

public class Tablero {

	private static final int CANTIDAD_COLUMNAS = 32;
	private static final int CANTIDAD_FILAS = 32;
	public Coordenada coordenadas[][] = new Coordenada[CANTIDAD_FILAS][CANTIDAD_COLUMNAS] ;

	public Tablero() {
		for (int i = 0; i < CANTIDAD_FILAS; i++) {
			for (int j = 0; j < CANTIDAD_COLUMNAS; j++){
				this.coordenadas[i][j] = new Coordenada(i,j);
			}
		}
	}

	public void ubicarPersonaje(Equipo unPersonaje, int unaFila, int unaColumna){
		unPersonaje.asignarCoordenadas(this.coordenadas[unaFila][unaColumna]);
	    obtenerCasillero(unaFila,unaColumna).asignarPersonaje(unPersonaje);
	}

	public void iniciarTablero(ArrayList<GuerrerosZ> guerreros,ArrayList<EnemigosDeLaTierra> enemigos)
	{
		ubicarPersonaje(guerreros.get(0),2,0);
		ubicarPersonaje(guerreros.get(1),1,1);
		ubicarPersonaje(guerreros.get(2), 0,2);
		ubicarPersonaje(enemigos.get(0),31,29);
		ubicarPersonaje(enemigos.get(1),30,30);
		ubicarPersonaje(enemigos.get(2),29,31);

	}

	public Coordenada obtenerCoordenada(int fila,int columna)
	{
      return this.coordenadas[fila][columna];
	}

	public Casillero obtenerCasillero(int i, int j) {
		return this.obtenerCoordenada(i, j).obtenerCasillero();
	}

	public void moverPersonaje(Equipo unPersonaje, int fila, int columna) {

		Casillero casilleroActual = obtenerCasillero(unPersonaje.obtenerCoordenadas().obtenerFila(),unPersonaje.obtenerCoordenadas().obtenerColumna());
		unPersonaje.cambiarCoordenadas(obtenerCoordenada(fila,columna));
		casilleroActual.liberarDePersonaje();
		obtenerCasillero(fila,columna).asignarPersonaje(unPersonaje);
	}
}
