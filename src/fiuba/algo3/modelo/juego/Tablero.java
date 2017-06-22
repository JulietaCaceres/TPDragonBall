package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

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

	public void ubicarPersonaje(Personaje unPersonaje, int unaFila, int unaColumna){
		unPersonaje.asignarCoordenadas(this.coordenadas[unaFila][unaColumna]);
	    obtenerCasillero(unaFila,unaColumna).asignarPersonaje(unPersonaje);
	}

	public void iniciarTablero(Personaje[] guerreros, Personaje[] enemigos)
	{
		ubicarPersonaje(guerreros[0],2,0);
		ubicarPersonaje(guerreros[1],1,1);
		ubicarPersonaje(guerreros[2], 0,2);
		ubicarPersonaje(enemigos[0],31,29);
		ubicarPersonaje(enemigos[1],30,30);
		ubicarPersonaje(enemigos[2],29,31);

	}

	public Coordenada obtenerCoordenada(int fila,int columna)
	{
      return this.coordenadas[fila][columna];
	}

	public Casillero obtenerCasillero(int i, int j) {
		return this.obtenerCoordenada(i, j).obtenerCasillero();
	}

	public void moverPersonaje(Personaje unPersonaje, int fila, int columna) {
		unPersonaje.cambiarCoordenadas(obtenerCoordenada(fila,columna));
		obtenerCasillero(fila,columna).asignarPersonaje(unPersonaje);
	}
}
