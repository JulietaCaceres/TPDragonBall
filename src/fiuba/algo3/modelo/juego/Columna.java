package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class Columna {
    public Casillero casilleros[];

    public Columna(int fila, int largoDeLaColumna){
        casilleros = new Casillero[largoDeLaColumna];
        for (int i = 0; i<largoDeLaColumna;i++){
            casilleros[i] = new Casillero(fila+1, i+1);
        }
    }
    public void agregarPersonaje(int unaColumna,Personaje unPersonaje)
    {
        obtenerCasillero(unaColumna).asignarPersonaje(unPersonaje);
    }

    public Casillero obtenerCasillero(int posicion){
        return casilleros[posicion-1];
    }
}
