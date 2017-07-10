
package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.juego.excepciones.ExceptionNoAlcanzaAlOponente;
import fiuba.algo3.modelo.juego.excepciones.ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado;
import fiuba.algo3.modelo.personajes.Personaje;

public class Coordenada {

    protected int fila;
    protected int columna;
    protected Casillero casillero;

    public Coordenada(int numeroFila, int numeroColumna){
    	this.fila = numeroFila;
        this.columna = numeroColumna;
        this.casillero = new Casillero(this);
    }

    public int obtenerFila()
    {
        return fila;
    }

    public int obtenerColumna()
    {
        return columna;
    }
    
    public void asignarPersonajeACasillero(Equipo personaje){
    	this.casillero.asignarPersonaje(personaje);
    }

    public void asignarConsumibleACasillero(Consumible unConsumible){casillero.asignarConsumible(unConsumible);}
    
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

    public void cambiarCoordenadas(Coordenada nuevaCoordenada) {
        if(nuevaCoordenada.obtenerCasillero().ocupado())
           throw new ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado();
          vaciarCasillero();
           asignarCoordenadas(nuevaCoordenada.obtenerFila(),nuevaCoordenada.obtenerColumna(),nuevaCoordenada.obtenerCasillero());



    }

    public void asignarCoordenadas(int unaFila,int unaColumna,Casillero unCasillero) {
        fila = unaFila;
        columna = unaColumna;
        casillero = unCasillero;
    }


    public void intercambiarCoordenada(Coordenada nuevaCoordenada) {

    }

}
