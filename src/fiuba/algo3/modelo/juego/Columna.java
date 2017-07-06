package fiuba.algo3.modelo.juego;

public class Columna {
    
    public Coordenada coordenadas[];
    
    public Columna(int fila, int largoDeLaColumna){
        coordenadas = new Coordenada[largoDeLaColumna];
        for (int i = 0; i<largoDeLaColumna;i++){
            coordenadas[i] = new Coordenada(fila, i);
        }
    }
    
    public Coordenada obtenerCoordenada(int posicion){
        return coordenadas[posicion];
    }
            
 }
