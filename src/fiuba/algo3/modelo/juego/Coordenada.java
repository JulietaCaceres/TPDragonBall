
package fiuba.algo3.modelo.juego;

public class Coordenada {

    protected int fila;
    protected int columna;

    public Coordenada(int numeroFila, int numeroColumna){
        fila = numeroFila;
        columna = numeroColumna;
    }

    public int obtenerFila()
    {
        return fila;
    }

    public int obtenerColumna()
    {
        return columna;
    }

    public void verificarCoordenadasFuturas(Coordenada[] coordenadas)
    {   Coordenada coordenadaActual = new Coordenada(fila , columna);
        for (Coordenada unaCoordenadaFutura: coordenadas
             ) {verificarQueSeanContiguas(coordenadaActual,unaCoordenadaFutura);
                coordenadaActual = unaCoordenadaFutura;
        }
    }

    public void verificarCantidadDePasos(Coordenada[] coordenadas,int  velocidad)
    {
        if (coordenadas.length > velocidad)
            throw new ExceptionCantidadDeCasillerosSuperaVelocidad();
    }

    public void verificarQueSeanContiguas(Coordenada coordenadaActual,Coordenada coordenadaFutura)
    {
        int filaActual = coordenadaActual.obtenerFila();
        int columnaActual = coordenadaActual.obtenerColumna();
        int filaFutura = coordenadaFutura.obtenerFila();
        int columnaFutura = coordenadaFutura.obtenerColumna();
        if ((Math.abs(filaActual-filaFutura) > 1) || (Math.abs(columnaActual-columnaFutura) > 1))
            throw new ExceptionLosCasillerosNoSonContiguos();
    }

   public void    verificarDistanciaAtaque(Coordenada coordenadasDeAtacante, int alcanceDeAtaque)
   {
       int filaAtacante = coordenadasDeAtacante.obtenerFila();
       int columnaAtacante = coordenadasDeAtacante.obtenerColumna();
       if((Math.abs(filaAtacante-fila) > alcanceDeAtaque) || (Math.abs(columnaAtacante-columna) > alcanceDeAtaque))
             throw new ExceptionNoAlcanzaAlOponente();
   }


}
