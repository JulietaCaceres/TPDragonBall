package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

public class Movimiento {
     protected Tablero tablero;

     public Movimiento(Tablero unTablero)
	 {
	tablero = unTablero;
	//this.cantidadDeMovimientos = 0;
     }

	public void moverPersonaje(Coordenada[] coordenadas, Personaje unPersonaje)
	{
		unPersonaje.verificarCoordenadasDeMovimiento(coordenadas);
		for (Coordenada unaCoordenada: coordenadas
			 )
		{
			tablero.ubicarPersonaje(unPersonaje,unaCoordenada.obtenerFila(),unaCoordenada.obtenerColumna());
		}
	}/*public boolean esValida(int velocidadDelPersonaje, int[] coordenadasDelPersonaje, int[] coordenadasDestino) {

		int distanciaDelRecorrido = 0;
		boolean laTraslacionEsValida = false;

		distanciaDelRecorrido += Math.abs(coordenadasDelPersonaje[0] - coordenadasDestino[0]);
		distanciaDelRecorrido += Math.abs(coordenadasDelPersonaje[1] - coordenadasDestino[1]);

		if(distanciaDelRecorrido <= velocidadDelPersonaje){
			laTraslacionEsValida = true;
		}
		return laTraslacionEsValida;
	}

	public void moverAlPersonaje(Personaje personaje, int[] coordenadasOrigen, int[] coordenadasDestino, Tablero tablero){
		Casillero casilleroOrigen = tablero.obtenerCasillero(coordenadasOrigen[0], coordenadasOrigen[1]);
		Casillero casilleroDestino = tablero.obtenerCasillero(coordenadasDestino[0], coordenadasDestino[1]);

		if(casilleroDestino.obtenerPersonaje() != null){
			casilleroDestino.asignarPersonaje(casilleroOrigen.obtenerPersonaje());
			casilleroOrigen.asignarPersonaje(null);
		}
	}

	public int obtenerCantidadDeMovimientos(){
		return this.cantidadDeMovimientos;
	}
*/
}