package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EsferaDelDragon;
import fiuba.algo3.modelo.juego.NubeVoladora;
import fiuba.algo3.modelo.juego.SemillaDelErmitanio;
import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Freezer;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.personajes.Piccolo;

public class ConsumiblesTest {


    @Test
    public void test24AtacarConConsumibleEsferaDelDragon(){
		Goku goku = new Goku();
		Freezer freezer = new Freezer();

		EsferaDelDragon esfera = new EsferaDelDragon();

		Coordenada coordenadaGoku = new Coordenada(1,1);
		Coordenada coordenadaFreezer = new Coordenada(1,2);
		coordenadaGoku.obtenerCasillero().asignarConsumible(esfera);

		goku.asignarCoordenadas(coordenadaGoku);
		freezer.asignarCoordenadas(coordenadaFreezer);

		goku.atacar(freezer);
		assertEquals(freezer.obtenerPuntosDeVida(),375, 0);
	}


	@Test
    public void test25GokuMueveConNubeVoladora(){
		Goku goku = new Goku();
		Coordenada coordenadaGoku = new Coordenada(1,1);
		NubeVoladora nube = new NubeVoladora();
		coordenadaGoku.obtenerCasillero().asignarConsumible(nube);

		goku.asignarCoordenadas(coordenadaGoku);

		Coordenada coordenadaGokuConNube = new Coordenada(1,5);

		goku.mover(coordenadaGokuConNube);
		assertTrue(coordenadaGokuConNube.obtenerCasillero().ocupado());
	}

	@Test
    public void test26PiccoloUsaSemillaDelErmitanio(){
		Piccolo majunia = new Piccolo();
		Cell cell = new Cell();

		Coordenada coordenadaPiccolo = new Coordenada(1,1);
		Coordenada coordenadaCell = new Coordenada(1,2);
		Coordenada coordenadaSemilla = new Coordenada(2,2);
		SemillaDelErmitanio semilla = new SemillaDelErmitanio();
		coordenadaSemilla.obtenerCasillero().asignarConsumible(semilla);

		majunia.asignarCoordenadas(coordenadaPiccolo);
		cell.asignarCoordenadas(coordenadaCell);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);

		assertEquals(400,majunia.obtenerPuntosDeVida(),0);
		majunia.mover(coordenadaSemilla);
		//assertTrue(coordenadaSemilla.obtenerCasillero().liberarConsumible() == null);

		assertEquals(500,majunia.obtenerPuntosDeVida(),0);
	}
}
