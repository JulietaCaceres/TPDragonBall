
package fiuba.algo3.modelo.juego;


public class Fila {
    
    
    public Columna columnas[];
    
    public Fila(int fila, int cantidadDeColumnas){
        columnas = new Columna[cantidadDeColumnas];
        for (int i = 0; i<cantidadDeColumnas;i++){
            columnas[i] = new Columna(fila, cantidadDeColumnas);
    }
    }
    


    public Coordenada obtenerCoordenada(int columna) {
        return columnas[columna].obtenerCoordenada(columna);

    }
}
