package fiuba.algo3.modelo.juego;
import fiuba.algo3.modelo.personajes.Personaje;

public class Fila {

    public Columna columnas[];

    public Fila(int fila, int cantidadDeColumnas){
        columnas = new Columna[cantidadDeColumnas];
        for (int i = 0; i<cantidadDeColumnas;i++){
            columnas[i] = new Columna(fila, cantidadDeColumnas);
        }
    }

    public void agregarPersonaje(int unaColumna, Personaje unPersonaje)
    {
        obtenerColumna(unaColumna).agregarPersonaje(unaColumna, unPersonaje);
    }

    public Columna obtenerColumna(int posicion){
        return columnas[posicion-1];
        }
}
