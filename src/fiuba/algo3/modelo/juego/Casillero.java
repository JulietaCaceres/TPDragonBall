package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;


public class Casillero {


	protected 	Personaje personaje;
	protected 	int fila;
	protected 	int columna;


	public Casillero(int numeroFila, int numeroColumna) {
			this.personaje = null;
			fila = numeroFila;
			columna = numeroColumna;

		}

	public Personaje obtenerPersonaje() {
			return this.personaje;
		}

		//public Consumible obtenerConsumible() {
		//	return this.consumible;
		//}

		public void asignarPersonaje(Personaje unPersonaje) {
			if (!ocupado()) {
				this.personaje = unPersonaje;
				personaje.asignarCoordenadas(fila, columna);
			}
			else throw new ExceptionCasilleroOcupado();
		}

		public void moverPersonaje(Coordenada[] coordenadas) {

		}

		//public void asignarConsumible(Consumible consumible) {
		//	this.consumible = consumible;

		//}

		public boolean ocupado() {
			return (this.personaje != null);
		}
}
