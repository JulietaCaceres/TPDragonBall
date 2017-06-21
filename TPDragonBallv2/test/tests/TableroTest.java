package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import juego.*;
import excepciones.*;

public class TableroTest {

	@Test
	public void UbicaPersonajeLoMueveYVerificaNuevaPosicion() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.mover(goku, 3, 3);
		assertEquals(3, goku.obtenerPosicion()[0]);
		assertEquals(3, goku.obtenerPosicion()[1]);
		Assert.assertTrue(tablero.obtenerCasillero(3,3).ocupado());
	}

	@Test (expected = PersonajesEnElMismoCasilleroException.class)
	public void VerificaQueNoPuedeHaberDosPersonajesEnUnCasillero() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.ubicarPersonaje(cell, 1, 1);

	}

	/*@Test
	public void VerificaQueUnPersonajeNoPuedePasarEncimaDeOtro() {

	}*/

	@Test
	public void UbicaUnPersonajeYVerificaQueSePuedeTransformar() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.ubicarPersonaje(cell, 3, 3);

		int vidaInicialCell = cell.obtenerPuntosDeVida();
		goku.atacar(cell);
		int vidaFinalCell = cell.obtenerPuntosDeVida();
		int danioCausadoSinTransformar = vidaInicialCell - vidaFinalCell;
		goku.aumentarKi(20);
		vidaInicialCell = vidaFinalCell;
		goku.atacar(cell);
		vidaFinalCell = cell.obtenerPuntosDeVida();
		int danioCausadoConTransformacion = vidaInicialCell - vidaFinalCell;

		assertEquals(danioCausadoConTransformacion, danioCausadoSinTransformar + 20);
	}

	@Test
	public void TransformaUnPersonajeLoMueveYVerificaPosicionAcorde() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		tablero.ubicarPersonaje(goku, 1, 1);
		goku.aumentarKi(20);
		tablero.mover(goku, 5, 5);
		Assert.assertTrue(tablero.obtenerCasillero(5, 5).ocupado());
	}

	// Integracion
	@Test
	public void InicializaTableroYUbicaPersonajes() {

		Tablero tablero = new Tablero();
		tablero.inicializarTablero();
		assertTrue(tablero.obtenerCasillero(1, 3).ocupado());
		assertTrue(tablero.obtenerCasillero(2, 2).ocupado());
		assertTrue(tablero.obtenerCasillero(3, 1).ocupado());
		assertTrue(tablero.obtenerCasillero(8, 10).ocupado());
		assertTrue(tablero.obtenerCasillero(9, 9).ocupado());
		assertTrue(tablero.obtenerCasillero(10, 8).ocupado());
	}

	@Test
	public void UbicaEnemigosHaceQueSeAtaquenYVerificaDanioConDistanciasValidas() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		tablero.ubicarPersonaje(goku, 2, 2);
		tablero.ubicarPersonaje(cell, 4, 4);

		int vidaInicialCell = cell.obtenerPuntosDeVida();
		goku.atacar(cell);
		int vidaFinalCell = cell.obtenerPuntosDeVida();
		assertEquals(20, vidaInicialCell - vidaFinalCell);
	}

	@Test (expected = DistanciaDeAtaqueInsuficienteException.class)
	public void UbicaEnemigosHaceQueSeAtaquenYVerificaQueNoSePuedeConDistanciasInvalidas() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje cell = new Cell();

		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.ubicarPersonaje(cell, 5, 5);

		goku.atacar(cell);
	}


}