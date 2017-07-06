package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import org.junit.Test;

import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Freezer;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.personajes.Piccolo;

public class ConsumiblesTest {
	
	@Test
	public void muevoPersonajeAUnCasilleroConEsferaDeDragonYAtacoAOtroComprobandoDaños() {
		GuerrerosZ goku = new Goku();
		EnemigosDeLaTierra freezer = new Freezer();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku,2,2);
		tablero.ubicarPersonaje(freezer,2,4);
        EsferaDelDragon esfera = new EsferaDelDragon();
		tablero.obtenerCasillero(2,3).asignarConsumible(esfera);
        tablero.moverPersonaje(goku,2,3);
		goku.atacar(freezer);
		assertEquals(freezer.obtenerPuntosDeVida(), 375, 0);
	}


	@Test
	public void gokuSeMueveAUnCasilleroConNubeVoladoraYAumentaSuVelocidad() {
		Goku goku = new Goku();
		NubeVoladora nube = new NubeVoladora();
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.obtenerCasillero(2,2).asignarConsumible(nube);
		tablero.moverPersonaje(goku, 2, 2);
		tablero.moverPersonaje(goku,4,2);
		assertTrue(tablero.obtenerCasillero(4, 2).ocupado());
	}

	@Test (expected = ExceptionLaDistanciaEntreLasCoordenadasNoEsValida.class)
	public void seIntentaMoverMasCasillerosDeLosQuePuedeConNubeYFalla() {

		Goku goku = new Goku();
		Coordenada coordenadaGoku = new Coordenada(1, 1);
		NubeVoladora nube = new NubeVoladora();
		coordenadaGoku.obtenerCasillero().asignarConsumible(nube);

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
		coordenadaGoku.obtenerCasillero().asignarConsumible(nube);
		goku.asignarCoordenadas(coordenadaGoku);
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(goku,1,1);
		tablero.moverPersonaje(goku,1,5);
		tablero.moverPersonaje(goku,1,9);
		tablero.moverPersonaje(goku,1,13);

	}
	@Test
	public void test26PiccoloUsaSemillaDelErmitanio(){
		GuerrerosZ majunia = new Piccolo();
		EnemigosDeLaTierra cell = new Cell();
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(majunia,1,1);
		tablero.ubicarPersonaje(cell,1,2);
		Coordenada unaCoordenada = tablero.obtenerCoordenada(2,2);
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
