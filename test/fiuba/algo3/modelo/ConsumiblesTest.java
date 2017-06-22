package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.modelo.juego.*;
import org.junit.Test;

import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Freezer;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.personajes.Piccolo;

public class ConsumiblesTest {
	@Test
	public void test24AtacarConConsumibleEsferaDelDragon() {
		Goku goku = new Goku();
		Freezer freezer = new Freezer();

		EsferaDelDragon esfera = new EsferaDelDragon();

		Coordenada coordenadaGoku = new Coordenada(1, 1);
		Coordenada coordenadaFreezer = new Coordenada(1, 2);
		coordenadaGoku.obtenerCasillero().asignarConsumible(esfera);

		goku.asignarCoordenadas(coordenadaGoku);
		freezer.asignarCoordenadas(coordenadaFreezer);

		goku.atacar(freezer);
		assertEquals(freezer.obtenerPuntosDeVida(), 375, 0);
	}


	@Test
	public void test25GokuMueveConNubeVoladora() {
		Goku goku = new Goku();
		Coordenada coordenadaGoku = new Coordenada(1, 1);
		NubeVoladora nube = new NubeVoladora();
		coordenadaGoku.obtenerCasillero().asignarConsumible(nube);

		goku.asignarCoordenadas(coordenadaGoku);
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.moverPersonaje(goku, 1, 5);
		assertTrue(tablero.obtenerCasillero(1, 5).ocupado());
	}

	@Test (expected = ExceptionLaDistanciaEntreLasCoordenadasNoEsValida.class)
	public void seIntentaMoverMasCasillerosDeLosQuePuedeConNubeYFalla() {

		Goku goku = new Goku();
		Coordenada coordenadaGoku = new Coordenada(1, 1);
		NubeVoladora nube = new NubeVoladora();
		coordenadaGoku.obtenerCasillero().

				asignarConsumible(nube);

		goku.asignarCoordenadas(coordenadaGoku);
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(goku,1,1);
		tablero.moverPersonaje(goku,1,6);
	}

	@Test  (expected = ExceptionLaDistanciaEntreLasCoordenadasNoEsValida.class)
	public void seGastanLosTurnosConNubeVoladoraYSeIntentaMoverAlPersonajeComoSiLaTuvieseYFalla(){
		Goku goku = new Goku();
		Coordenada coordenadaGoku = new Coordenada(1, 1);
		NubeVoladora nube = new NubeVoladora();
		coordenadaGoku.obtenerCasillero().
				asignarConsumible(nube);
		goku.asignarCoordenadas(coordenadaGoku);
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(goku,1,1);
		tablero.moverPersonaje(goku,1,5);
		tablero.moverPersonaje(goku,1,9);
		tablero.moverPersonaje(goku,1,13);

	}
	@Test
	public void test26PiccoloUsaSemillaDelErmitanio(){
		Piccolo majunia = new Piccolo();
		Cell cell = new Cell();
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(majunia,1,1);
		tablero.ubicarPersonaje(cell,1,2);
		SemillaDelErmitanio semilla = new SemillaDelErmitanio();
		tablero.obtenerCasillero(2,2).asignarConsumible(semilla);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);

		assertEquals(400,majunia.obtenerPuntosDeVida(),0);
		tablero.moverPersonaje(majunia,2,2);
		//assertTrue(coordenadaSemilla.obtenerCasillero().liberarConsumible() == null);

		assertEquals(500,majunia.obtenerPuntosDeVida(),0);
	}
}
