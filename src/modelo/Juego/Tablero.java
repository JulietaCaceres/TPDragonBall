package modelo.Juego;

import modelo.Personajes.Personaje;

public class Tablero {
	
	private Casillero[][] matrizDeCasillero;

	public Tablero(){
		this.matrizDeCasillero = new Casillero[32][32];
	}

	public void moverA(Personaje personaje, int filaDestino, int columnaDestino, int velocidadDelPersonaje) {
		Movimiento traslacion = new Movimiento();
		
		int[] coordenadasDelPersonaje = this.obtenerCoordenadasDe(personaje);
		int[] coordenadasDestino = new int[2];
		coordenadasDestino[0] = filaDestino;
		coordenadasDestino[1] = columnaDestino;
		
		if(traslacion.esValida(velocidadDelPersonaje, coordenadasDelPersonaje, coordenadasDestino)){
			traslacion.moverAlPersonaje(personaje, coordenadasDelPersonaje, coordenadasDestino, this);
		}
	}

	int[] obtenerCoordenadasDe(Personaje personaje) {
		boolean personajeNoEncontrado = true;
		int[] coordenadas = new int[2];
		coordenadas[0] = -1;
		coordenadas[1] = -1;
		for(int i = 0; i < 31 && personajeNoEncontrado; i++){
			for(int j = 0; j < 31 && personajeNoEncontrado; j++){
				Casillero casilleroSeleccionado = this.matrizDeCasillero[i][j];
				Personaje personajeSeleccionado = casilleroSeleccionado.obtenerPersonaje();		
				if(personajeSeleccionado.obtenerNombre() == personaje.obtenerNombre()){
					personajeNoEncontrado = false;
					coordenadas[0] = i;
					coordenadas[1] = j;
				}
			}
		}
		
		return coordenadas;
	}

	public Casillero obtenerCasillero(int fila, int columna) {
		return this.matrizDeCasillero[fila][columna];
	}
	
	
	
}
