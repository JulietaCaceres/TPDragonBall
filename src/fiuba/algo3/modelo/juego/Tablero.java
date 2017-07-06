package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.juego.excepciones.ExceptionCasilleroOcupado;
import fiuba.algo3.modelo.personajes.Personaje;

import java.util.ArrayList;

public class Tablero {

	private static final int CANTIDAD_COLUMNAS = 8;
	private static final int CANTIDAD_FILAS = 8;
	public Coordenada coordenadas[][] = new Coordenada[CANTIDAD_FILAS][CANTIDAD_COLUMNAS] ;
	private static Tablero instance = null;
	public Fila filas[];


	public Tablero() {
		filas = new Fila[CANTIDAD_FILAS];
		for (int i = 0; i<CANTIDAD_FILAS;i++){
			filas[i] = new Fila(i, CANTIDAD_COLUMNAS);
		}



					/*for (int i = 0; i < CANTIDAD_FILAS; i++) {
			for (int j = 0; j < CANTIDAD_COLUMNAS; j++){
				this.coordenadas[i][j] = new Coordenada(i,j);
			}
		}
	*/}

	public void ubicarPersonaje(Equipo unPersonaje, int unaFila, int unaColumna){
		unPersonaje.asignarCoordenadas(this.obtenerFila(unaFila).obtenerCoordenada(unaColumna));
	    obtenerCasillero(unaFila,unaColumna).asignarPersonaje(unPersonaje);
	}

	public void ubicarConsumible(Consumible unConsumible, int unaFila, int unaColumna){
        if (!obtenerCoordenada(unaFila,unaColumna).obtenerCasillero().ocupado()){
		unConsumible.asignarCoordenadas(obtenerFila(unaFila).obtenerCoordenada(unaColumna));
		obtenerCasillero(unaFila,unaColumna).asignarConsumible(unConsumible);}
	}

	public void iniciarTablero(ArrayList<GuerrerosZ> guerreros,ArrayList<EnemigosDeLaTierra> enemigos)
	{
		ubicarPersonaje(guerreros.get(0),2,0);
		ubicarPersonaje(guerreros.get(1),1,1);
		ubicarPersonaje(guerreros.get(2), 0,2);
		ubicarPersonaje(enemigos.get(0),7,5);
		ubicarPersonaje(enemigos.get(1),6,6);
		ubicarPersonaje(enemigos.get(2),5,7);

	}

	public Fila obtenerFila(int posicion){
		return filas[posicion];
	}

	public Coordenada obtenerCoordenada(int fila,int columna)
	{    return obtenerFila(fila).obtenerCoordenada(columna);

	}

	public Casillero obtenerCasillero(int i, int j) {

		return this.obtenerCoordenada(i, j).obtenerCasillero();
	}

	public void moverPersonaje(Equipo unPersonaje, int fila, int columna) {
        if ((fila>CANTIDAD_FILAS) || (columna > CANTIDAD_COLUMNAS)) throw new ExceptionFueraDeRango();
		Casillero casilleroActual = obtenerCasillero(unPersonaje.obtenerCoordenadas().obtenerFila(),unPersonaje.obtenerCoordenadas().obtenerColumna());
		unPersonaje.cambiarCoordenadas(obtenerCoordenada(fila,columna));
		casilleroActual.liberarDePersonaje();
		obtenerCasillero(fila,columna).asignarPersonaje(unPersonaje);
	}

	public static Tablero getTablero(){
		if (Tablero.instance == null){
			Tablero.instance = new Tablero();
		}
		return Tablero.instance;
	}

	public int obtenerCantidadDeFilas(){return CANTIDAD_FILAS;}

	public int obtenerCantidadDeColumnas(){return  CANTIDAD_COLUMNAS;}

}
