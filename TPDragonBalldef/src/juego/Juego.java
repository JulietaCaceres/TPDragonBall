package juego;

import java.util.*;

public class Juego {


	private Partida partidaActual;

	public void iniciarPartida() {
		this.partidaActual = new Partida();
		this.partidaActual.iniciarPartida();
	}

}
