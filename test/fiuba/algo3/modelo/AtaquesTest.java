package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.ExceptionNoAlcanzaAlOponente;
import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Freezer;
import fiuba.algo3.modelo.personajes.Gohan;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.personajes.MajinBoo;
import fiuba.algo3.modelo.personajes.Piccolo;

public class AtaquesTest {

    @Test
    public void test08CrearAGokuACellYAtacarACell(){
		Goku goku = new Goku();

		Coordenada coordenadaGoku = new Coordenada(1, 1);
		Coordenada coordenadaMajinBoo = new Coordenada(1, 2);
		goku.asignarCoordenadas(coordenadaGoku);

		Cell cell = new Cell();
		cell.asignarCoordenadas(coordenadaMajinBoo);

		goku.atacar(cell);

		assertTrue(cell.obtenerPuntosDeVida() == 480);
	}

	@Test
    public void test11HacerQueGokuRealiceElKamehamehaACell(){
		Goku goku = new Goku();
		Coordenada coordenadaInicialGoku = new Coordenada(5, 4);
		goku.asignarCoordenadas(coordenadaInicialGoku);

		Cell cell = new Cell();
		Coordenada coordenadaInicialCell = new Coordenada(5, 4);
		cell.asignarCoordenadas(coordenadaInicialCell);

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		//Goku pasa a KaioKen

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);

		assertTrue(cell.obtenerPuntosDeVida() == 260);

		goku.realizarAtaqueEspecial(cell);

		assertTrue(cell.obtenerPuntosDeVida() == 200);
	}

    @Test (expected = ExceptionAtaqueAMismoEquipo.class)
    public void test12HacerQueGohanAtaqueAPiccolo(){
		Gohan gohan = new Gohan();
		Piccolo piccolo = new Piccolo();

		Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
		Coordenada coordenadaInicialGohan = new Coordenada(4, 4);
		piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
		gohan.asignarCoordenadas(coordenadaInicialGohan);

		gohan.atacar(piccolo);
	}

    @Test
    public void test13CombatirEntreGokuPiccoloYCellYLlevarACellASegundaTransformacion(){
		Piccolo piccolo = new Piccolo();
		Goku goku = new Goku();
		Cell cell = new Cell();

		Coordenada coordenadaInicialCell = new Coordenada(5, 5);
		Coordenada coordenadaInicialPiccolo = new Coordenada(5, 4);
		Coordenada coordenadaInicialGoku = new Coordenada(4, 4);

		cell.asignarCoordenadas(coordenadaInicialCell);
		piccolo.asignarCoordenadas(coordenadaInicialPiccolo);
		goku.asignarCoordenadas(coordenadaInicialGoku);

		for(int i = 1; i<=4;i++){
			cell.atacar(goku);
			cell.realizarAtaqueEspecial(piccolo);
		}

		assertTrue(420 == goku.obtenerPuntosDeVida());
		//Ahora Cell esta en fase SemiPerfecto

		for(int i = 1; i<=8;i++){
			cell.atacar(goku);
			cell.realizarAtaqueEspecial(piccolo);
		}

		assertTrue(100 == goku.obtenerPuntosDeVida());
		//Ahora Cell esta en fase Perfecto
		cell.atacar(goku);
		assertTrue(20 == goku.obtenerPuntosDeVida());
	}
    @Test (expected = ExceptionNoAlcanzaAlOponente.class)
    public void test15CellNoAlcanzaAAtacarAPiccoloConSuAtaqueEspecial(){
		Cell cell = new Cell();
		Piccolo piccolo = new Piccolo();

		Coordenada coordenadaInicialCell = new Coordenada(3, 3);
		Coordenada coordenadaInicialPiccolo = new Coordenada(10, 10);
		cell.asignarCoordenadas(coordenadaInicialCell);
		piccolo.asignarCoordenadas(coordenadaInicialPiccolo);

		cell.atacar(piccolo);
		cell.realizarAtaqueEspecial(piccolo);
	}

    @Test (expected = ExceptionAtaqueAMismoEquipo.class)
    public void test16MajinBooNoPuedeConvertirEnChocolateAFreezer(){
		MajinBoo boo = new MajinBoo();
		Freezer freezer = new Freezer();

		Coordenada coordenadaInicialBoo = new Coordenada(2, 3);
		Coordenada coordenadaInicialFreezer = new Coordenada(3, 2);
		boo.asignarCoordenadas(coordenadaInicialBoo);
		freezer.asignarCoordenadas(coordenadaInicialFreezer);

		boo.realizarAtaqueEspecial(freezer);
	}


    @Test
    public void test17GokuAumentaDePoderConPocaVida(){
		Goku goku = new Goku();
		Cell cell = new Cell();

		Coordenada coordenadaInicialGoku = new Coordenada(2, 3);
		Coordenada coordenadaInicialCell = new Coordenada(3, 2);
		goku.asignarCoordenadas(coordenadaInicialGoku);
		cell.asignarCoordenadas(coordenadaInicialCell);

		for (int i = 0; i<20; i++){
			cell.atacar(goku);
		}

		goku.atacar(cell);

		assertEquals(cell.obtenerPuntosDeVida(),476, 0);
		assertEquals(goku.obtenerPuntosDeVida(),100, 0);
	}

    @Test
    public void test18GokuAtacaAumentaKiYHaceElKamehameha(){
		Goku goku = new Goku();
		Cell cell = new Cell();

		Coordenada coordenadaInicialGoku = new Coordenada(2, 3);
		Coordenada coordenadaInicialCell = new Coordenada(3, 2);
		goku.asignarCoordenadas(coordenadaInicialGoku);
		cell.asignarCoordenadas(coordenadaInicialCell);

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		//Goku llega a Kaioken, Cell tiene 420 de vida
		assertEquals(cell.obtenerPuntosDeVida(),420, 0);

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		assertEquals(cell.obtenerPuntosDeVida(),260, 0);

		goku.realizarAtaqueEspecial(cell);
		assertEquals(cell.obtenerPuntosDeVida(),200, 0);
	}


	@Test
    public void test19GokuAtacaYHacePrimeraTransformacion(){
		Goku goku = new Goku();
		Cell cell = new Cell();

		Coordenada coordenadaInicialGoku = new Coordenada(2, 3);
		Coordenada coordenadaInicialCell = new Coordenada(3, 2);
		goku.asignarCoordenadas(coordenadaInicialGoku);
		cell.asignarCoordenadas(coordenadaInicialCell);

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);

		assertEquals(cell.obtenerPuntosDeVida(),420, 0);

		goku.atacar(cell);
		assertEquals(cell.obtenerPuntosDeVida(),380, 0);
	}
}
