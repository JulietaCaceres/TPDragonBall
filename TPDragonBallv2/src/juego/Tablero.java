package juego;

import static org.junit.Assert.assertTrue;

import excepciones.*;

public class Tablero {

	static final int TAM = 10;

	private Casillero[][] casilleros;

	public Tablero() {

		this.casilleros = new Casillero[TAM][TAM];
		for (int i = 1; i <= TAM; i++) {
			for (int j = 1; j <= TAM; j++) {
				this.casilleros[i-1][j-1] = new Casillero(i, j);
			}
		}
	}

	public void mover(Personaje personaje, int x, int y) {
		if (!this.casilleros[x-1][y-1].ocupado()) {
			try {
				personaje.mover(x-1, y-1);
				this.ubicarPersonaje(personaje, x, y);
			} catch (VelocidadInsuficienteException e) { }
		}
	}

	public void ubicarPersonaje(Personaje personaje, int x, int y) {
		if (this.casilleros[x-1][y-1].ocupado())
			throw new PersonajesEnElMismoCasilleroException();
		personaje.asignarCasillero(x, y);
		this.casilleros[x-1][y-1].ubicarPersonaje(personaje);
	}

	public Casillero obtenerCasillero(int i, int j) {

		return this.casilleros[i-1][j-1];
	}

	public void inicializarTablero() {

		this.casilleros[0][2].ubicarPersonaje(new Goku());
		this.casilleros[1][1].ubicarPersonaje(new Piccolo());
		this.casilleros[2][0].ubicarPersonaje(new Gohan());
		this.casilleros[TAM-3][TAM-1].ubicarPersonaje(new Freezer());
		this.casilleros[TAM-2][TAM-2].ubicarPersonaje(new MajinBoo());
		this.casilleros[TAM-1][TAM-3].ubicarPersonaje(new Cell());
	}


}
