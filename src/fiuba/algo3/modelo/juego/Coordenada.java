
package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class Coordenada {

    protected int fila;
    protected int columna;
    protected Casillero casillero;

    public Coordenada(int numeroFila, int numeroColumna){
    	this.fila = numeroFila;
        this.columna = numeroColumna;
        this.casillero = new Casillero();
    }

    public int obtenerFila()
    {
        return fila;
    }

    public int obtenerColumna()
    {
        return columna;
    }
    
    public void asignarPersonajeACasillero(Personaje personaje){
    	this.casillero.asignarPersonaje(personaje);
    }
    
    public void vaciarCasillero(){
    	this.casillero.liberarDePersonaje();
    }

   public void verificarDistanciaAtaque(Coordenada coordenadasDeAtacante, int alcanceDeAtaque)
   {
       int filaAtacante = coordenadasDeAtacante.obtenerFila();
       int columnaAtacante = coordenadasDeAtacante.obtenerColumna();
       if((Math.abs(filaAtacante-fila) > alcanceDeAtaque) || (Math.abs(columnaAtacante-columna) > alcanceDeAtaque))
             throw new ExceptionNoAlcanzaAlOponente();
   }

	public Casillero obtenerCasillero() {
		return this.casillero;
	}
}
