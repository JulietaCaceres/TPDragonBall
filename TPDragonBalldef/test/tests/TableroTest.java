package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import juego.*;
import excepciones.*;

public class TableroTest {


	// primera entrega

	@Test
	public void UbicaPersonajeLoMueveYVerificaNuevaPosicion() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.mover(goku, 3, 3);
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


	@Test
	public void UbicaUnPersonajeYVerificaQueSePuedeTransformar() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.ubicarPersonaje(cell, 3, 3);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

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
		tablero.mover(goku, 4, 4);
		Assert.assertTrue(tablero.obtenerCasillero(4, 4).ocupado());
	}

	// Integracion
	@Test
	public void InicializaTableroYUbicaPersonajes() {

		Partida partida = new Partida();
		partida.iniciarPartida();
		Tablero tablero = partida.obtenerTablero();
		assertTrue(tablero.obtenerCasillero(1, 3).ocupado());
		assertTrue(tablero.obtenerCasillero(2, 2).ocupado());
		assertTrue(tablero.obtenerCasillero(3, 1).ocupado());
		assertTrue(tablero.obtenerCasillero(13, 15).ocupado());
		assertTrue(tablero.obtenerCasillero(14, 14).ocupado());
		assertTrue(tablero.obtenerCasillero(15, 13).ocupado());
	}

	@Test
	public void UbicaEnemigosHaceQueSeAtaquenYVerificaDanioConDistanciasValidas() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		tablero.ubicarPersonaje(goku, 2, 2);
		tablero.ubicarPersonaje(cell, 4, 4);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(goku, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

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


	// segunda entrega

	@Test (expected = VelocidadInsuficienteException.class)
	public void VerificaQueGohanNoPuedeLlegarASegundaTransformacion() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		Personaje piccolo = new Piccolo();
		Equipo GuerrerosZ = new GuerrerosZ(goku, piccolo, gohan);
		goku.asignarEquipo(GuerrerosZ);
		gohan.asignarEquipo(GuerrerosZ);
		piccolo.asignarEquipo(GuerrerosZ);
		tablero.obtenerCasillero(1, 3).ubicarPersonaje(goku);
		tablero.obtenerCasillero(2, 2).ubicarPersonaje(gohan);
		tablero.obtenerCasillero(3, 1).ubicarPersonaje(piccolo);

		gohan.aumentarKi(30);

		tablero.mover(gohan, 5, 5);
	}

	@Test
	public void DejaAGokuYPiccoloConLaVidaNecesariaYCompruebaTransformacionDeGohan() {

		Tablero tablero = new Tablero();
		Personaje goku = new Goku();
		Personaje gohan = new Gohan();
		Personaje piccolo = new Piccolo();
		Equipo GuerrerosZ = new GuerrerosZ(goku, piccolo, gohan);
		goku.asignarEquipo(GuerrerosZ);
		gohan.asignarEquipo(GuerrerosZ);
		piccolo.asignarEquipo(GuerrerosZ);
		tablero.ubicarPersonaje(goku, 1, 3);
		tablero.ubicarPersonaje(gohan, 2, 2);
		tablero.ubicarPersonaje(piccolo, 3, 1);
		goku.recibirAtaque(400);
		piccolo.recibirAtaque(400);

		gohan.aumentarKi(40);
		tablero.mover(gohan, 5, 5);
		Assert.assertTrue(tablero.obtenerCasillero(5, 5).ocupado());
		Assert.assertTrue(gohan.obtenerPosicion()[0] == 5 && gohan.obtenerPosicion()[1] == 5);
	}


	@Test
    public void CrearAGokuACellYAtacarACell(){

    	Tablero tablero = new Tablero();
    	Personaje goku = new Goku();
		tablero.ubicarPersonaje(goku, 1, 1);
		Personaje cell = new Cell();
		tablero.ubicarPersonaje(cell, 1,2);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);
		goku.atacar(cell);

		assertTrue(cell.obtenerPuntosDeVida() == 480);
	}

	@Test
    public void HacerQueGokuRealiceElKamehamehaACell(){
		Personaje goku = new Goku();
		goku.asignarCasillero(5,4);
		Personaje cell = new Cell();
		cell.asignarCasillero(5, 4);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		//Goku pasa a KaioKen

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);

		assertEquals(260, cell.obtenerPuntosDeVida());

		goku.realizarAtaqueEspecial(cell);

		assertEquals(200, cell.obtenerPuntosDeVida());
	}

    @Test (expected = AtaqueAMismoEquipoException.class)
    public void HacerQueGohanAtaqueAPiccolo(){
		Personaje gohan = new Gohan();
		Personaje piccolo = new Piccolo();
		Equipo GuerrerosZ = new GuerrerosZ(gohan, piccolo, gohan);
		gohan.asignarEquipo(GuerrerosZ);
		piccolo.asignarEquipo(GuerrerosZ);

		piccolo.asignarCasillero(5, 4);
		gohan.asignarCasillero(4, 4);

		gohan.atacar(piccolo);
	}

    @Test
    public void CombatirEntreGokuPiccoloYCellYLlevarACellASegundaTransformacion(){
		Personaje piccolo = new Piccolo();
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		Equipo GuerrerosZ = new GuerrerosZ(goku, piccolo, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		piccolo.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);


		cell.asignarCasillero(5, 5);
		piccolo.asignarCasillero(5, 4);
		goku.asignarCasillero(4, 4);

		for(int i = 1; i<=4;i++){
			cell.atacar(goku);
			cell.realizarAtaqueEspecial(piccolo);
		}

		assertEquals(420, goku.obtenerPuntosDeVida());
		//Ahora Cell esta en fase SemiPerfecto

		for(int i = 1; i<=8;i++){
			cell.atacar(goku);
			cell.realizarAtaqueEspecial(piccolo);
		}

		assertEquals(100, goku.obtenerPuntosDeVida());
		//Ahora Cell esta en fase Perfecto
		cell.atacar(goku);
		assertEquals(20, goku.obtenerPuntosDeVida());
	}

    @Test (expected = DistanciaDeAtaqueInsuficienteException.class)
    public void CellNoAlcanzaAAtacarAPiccoloConSuAtaqueEspecial(){
		Personaje cell = new Cell();
		Personaje piccolo = new Piccolo();

		cell.asignarCasillero(3, 3);
		piccolo.asignarCasillero(10, 10);

		cell.atacar(piccolo);
		cell.realizarAtaqueEspecial(piccolo);
	}

    @Test (expected = AtaqueAMismoEquipoException.class)
    public void MajinBooNoPuedeConvertirEnChocolateAFreezer(){
		Personaje boo = new MajinBoo();
		Personaje freezer = new Freezer();
		Equipo EnemigosDeLaTierra = new GuerrerosZ(boo, freezer, boo);
		boo.asignarEquipo(EnemigosDeLaTierra);
		freezer.asignarEquipo(EnemigosDeLaTierra);


		boo.asignarCasillero(2, 3);
		freezer.asignarCasillero(3, 2);
		boo.aumentarKi(100);

		boo.realizarAtaqueEspecial(freezer);
	}

    @Test
    public void GokuAumentaDePoderConPocaVida(){
		Personaje goku = new Goku();
		Personaje cell = new Cell();

		goku.asignarCasillero(2, 3);
		cell.asignarCasillero(3, 2);

		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

		for (int i = 0; i<20; i++){
			cell.atacar(goku);
		}

		goku.atacar(cell);

		assertEquals(476, cell.obtenerPuntosDeVida(),0);
		assertEquals(100, goku.obtenerPuntosDeVida(),0);
	}

    @Test
    public void GokuAtacaAumentaKiYHaceElKamehameha(){
		Personaje goku = new Goku();
		Personaje cell = new Cell();

		goku.asignarCasillero(2, 3);
		cell.asignarCasillero(3, 2);

		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

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
		assertEquals(200, cell.obtenerPuntosDeVida(), 0);
	}

	@Test
    public void GokuAtacaYHacePrimeraTransformacion(){
		Personaje goku = new Goku();
		Personaje cell = new Cell();
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

		goku.asignarCasillero(2, 3);
		cell.asignarCasillero(3, 2);

		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);
		goku.atacar(cell);

		assertEquals(cell.obtenerPuntosDeVida(),420, 0);

		goku.atacar(cell);
		assertEquals(cell.obtenerPuntosDeVida(),380, 0);
	}




	//



	@Test
	public void AtacarConConsumibleEsferaDelDragon() {
		Goku goku = new Goku();
		Freezer freezer = new Freezer();
		Tablero tablero = new Tablero();

		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(freezer, freezer, freezer);
		goku.asignarEquipo(GuerrerosZ);
		freezer.asignarEquipo(EnemigosDeLaTierra);
		Consumible esfera = new EsferaDelDragon();

		tablero.obtenerCasillero(1, 1).asignarConsumible(esfera);
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.ubicarPersonaje(freezer, 1, 2);
		goku.atacar(freezer);
		assertEquals(375, freezer.obtenerPuntosDeVida(), 0);
	}


	@Test
	public void GokuMueveConNubeVoladora() {
		Tablero tablero = new Tablero();
		Goku goku = new Goku();

		Consumible nube = new NubeVoladora();
		tablero.obtenerCasillero(1, 1).asignarConsumible(nube);
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.mover(goku, 1, 5);
		assertTrue(tablero.obtenerCasillero(1, 5).ocupado());
	}

	@Test (expected = VelocidadInsuficienteException.class)
	public void SeIntentaMoverMasCasillerosDeLosQuePuedeConNubeYFalla() {

		Tablero tablero = new Tablero();
		Goku goku = new Goku();
		Consumible nube = new NubeVoladora();
		tablero.obtenerCasillero(1, 1).asignarConsumible(nube);
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.mover(goku,1,6);
	}

	@Test  (expected = VelocidadInsuficienteException.class)
	public void SeGastanLosTurnosConNubeVoladoraYSeIntentaMoverAlPersonajeComoSiLaTuvieseYFalla(){
		Goku goku = new Goku();
		Tablero tablero = new Tablero();
		Consumible nube = new NubeVoladora();
		tablero.obtenerCasillero(1, 1).asignarConsumible(nube);
		tablero.ubicarPersonaje(goku, 1, 1);

		tablero.mover(goku,1,5);
		tablero.mover(goku,1,9);
		tablero.mover(goku,1,13);
	}

	@Test
	public void PiccoloUsaSemillaDelErmitanio(){
		Piccolo majunia = new Piccolo();
		Cell cell = new Cell();
		Tablero tablero = new Tablero();
		tablero.ubicarPersonaje(majunia,1,1);
		tablero.ubicarPersonaje(cell,1,2);
		Consumible semilla = new SemillaDelErmitanio();
		tablero.obtenerCasillero(2,2).asignarConsumible(semilla);
		Equipo GuerrerosZ = new GuerrerosZ(majunia, majunia, majunia);
		Equipo EnemigosDeLaTierra = new GuerrerosZ(cell, cell, cell);
		majunia.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);
		cell.atacar(majunia);

		assertEquals(400,majunia.obtenerPuntosDeVida(),0);
		tablero.mover(majunia,2,2);

		assertEquals(500,majunia.obtenerPuntosDeVida(),0);
	}


   @Test
   public void UbicoPersonajeEnTableroYPidoQueSeMuevaAUnaDistanciaValidaYVerificoQueElCasilleroInicialSeHayaVaciado()
   {
       Tablero tablero = new Tablero();
       Piccolo piccolo = new Piccolo();
       tablero.ubicarPersonaje(piccolo,2,2);
       tablero.mover(piccolo,3,2);
       assertTrue(!tablero.obtenerCasillero(2,2).ocupado());
   }

    @Test
    public void UbicoPersonajeEnTableroYPidoQueSeMuevaAUnaDistanciaValidaYVerificoQueElCasilleroDestinoSeHayaOcupado()
    {
        Tablero tablero = new Tablero();
        Cell cell = new Cell();
        tablero.ubicarPersonaje(cell,2,2);
        tablero.mover(cell,3,2);
        assertTrue(tablero.obtenerCasillero(3,2).ocupado());
    }



    //



    @Test
    public void test04SeUbicaUnPersonajeSeLoTransformaSeVerificaQueSePuedaTransformar()
    {
        Freezer unFreezer = new Freezer();
        Freezer otroFreezer = new Freezer();
        Goku goku = new Goku();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku, 2,2);
        tablero.ubicarPersonaje(unFreezer, 2, 3);
        tablero.ubicarPersonaje(otroFreezer, 2, 1);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new EnemigosDeLaTierra(unFreezer, otroFreezer, otroFreezer);
		goku.asignarEquipo(GuerrerosZ);
		unFreezer.asignarEquipo(EnemigosDeLaTierra);
		otroFreezer.asignarEquipo(EnemigosDeLaTierra);

        goku.atacar(unFreezer);
        double vidaDeUnFreezerDespuesDePrimerAtaque = unFreezer.obtenerPuntosDeVida();
        goku.atacar(unFreezer);
        goku.atacar(unFreezer);
        goku.atacar(unFreezer);

        goku.atacar(otroFreezer);
        boolean menosDanio = (vidaDeUnFreezerDespuesDePrimerAtaque > otroFreezer.obtenerPuntosDeVida());
        assertTrue(menosDanio);
    }

   @Test
    public void test05VerificoSiPersonajeSeMueveAcuerdoASuTransformacion()
    {
        Tablero tablero = new Tablero();
        MajinBoo majinBoo = new MajinBoo();
        Goku goku = new Goku();
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new EnemigosDeLaTierra(majinBoo, majinBoo, majinBoo);
		goku.asignarEquipo(GuerrerosZ);
		majinBoo.asignarEquipo(EnemigosDeLaTierra);

        tablero.ubicarPersonaje(majinBoo,2,2);
        tablero.ubicarPersonaje(goku,2,3);

        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        majinBoo.atacar(goku);
        //Majin Boo se transforma en Majin Boo Malo, con velocidad 3
        tablero.mover(majinBoo, 5, 5);
        assertEquals(majinBoo.obtenerPosicion()[1],5);
    }

	@Test(expected = GuerreroZConvertidoEnChocolateException.class)
	public void test09CrearAGokuMajinBooYConvertirAGokuEnChocolate(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku();
		MajinBoo majinBoo = new MajinBoo();
		tablero.ubicarPersonaje(goku, 1, 1);
		tablero.ubicarPersonaje(majinBoo, 1, 2);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new EnemigosDeLaTierra(majinBoo, majinBoo, majinBoo);
		goku.asignarEquipo(GuerrerosZ);
		majinBoo.asignarEquipo(EnemigosDeLaTierra);
		majinBoo.aumentarKi(60);
		majinBoo.realizarAtaqueEspecial(goku);
		goku.atacar(majinBoo);
	}

	@Test(expected = GuerreroZConvertidoEnChocolateException.class)
	public void test10ConvertirAGokuEnChocolateYVolverAEstadoNormal(){
		Tablero tablero = new Tablero();
		Goku goku = new Goku();
		MajinBoo majinBoo = new MajinBoo();
		tablero.ubicarPersonaje(goku, 1, 2);
		tablero.ubicarPersonaje(majinBoo, 1, 3);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new EnemigosDeLaTierra(majinBoo, majinBoo, majinBoo);
		goku.asignarEquipo(GuerrerosZ);
		majinBoo.asignarEquipo(EnemigosDeLaTierra);

		majinBoo.atacar(goku);
		majinBoo.aumentarKi(60);
		majinBoo.realizarAtaqueEspecial(goku);
		goku.atacar(majinBoo);
		goku.atacar(majinBoo);
		goku.atacar(majinBoo);
		goku.atacar(majinBoo);
		assertEquals(284,majinBoo.obtenerPuntosDeVida(),0);
	}
/*
	@Test
	public void CombatirEntreGokuGohanPiccoloYCellYVerEvolucionDeGohanHastaSegundaTransformacion(){
		Tablero tablero = new Tablero();
		Piccolo piccolo = new Piccolo();
		Goku goku = new Goku();
		Cell cell = new Cell();
		Gohan gohan = new Gohan();
		Equipo GuerrerosZ = new GuerrerosZ(goku, gohan, piccolo);
		Equipo EnemigosDeLaTierra = new EnemigosDeLaTierra(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		gohan.asignarEquipo(GuerrerosZ);
		piccolo.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

		tablero.ubicarPersonaje(cell, 5, 5);
		tablero.ubicarPersonaje(piccolo, 5, 4);
		tablero.ubicarPersonaje(goku, 4, 4);
		tablero.ubicarPersonaje(gohan, 4, 5);

		for(int i = 1; i<=19;i++){
			cell.atacar(goku);
			cell.atacar(piccolo);
		}

		gohan.atacar(cell);
		assertEquals(cell.obtenerPuntosDeVida(),488, 0);
		gohan.atacar(cell);
		assertEquals(cell.obtenerPuntosDeVida(),476, 0);
		//Ahora Gohan es Super Sayajin Fase 1
		gohan.atacar(cell);
		assertEquals(cell.obtenerPuntosDeVida(),446, 0);
		gohan.atacar(cell);
		assertEquals(cell.obtenerPuntosDeVida(),416, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),386, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),356, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),326, 0);
    	gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),296, 0);
    	//Ahora Gohan es Super Sayajin Fase 2
  		gohan.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),196, 0);
    }
*/

    @Test
    public void test20GokuLlegaASuSegundaTransformacion(){
    	Tablero tablero = new Tablero();
    	Goku goku = new Goku();
    	Cell cell = new Cell();
    	tablero.ubicarPersonaje(goku, 2, 3);
    	tablero.ubicarPersonaje(cell, 3, 2);
		Equipo GuerrerosZ = new GuerrerosZ(goku, goku, goku);
		Equipo EnemigosDeLaTierra = new EnemigosDeLaTierra(cell, cell, cell);
		goku.asignarEquipo(GuerrerosZ);
		cell.asignarEquipo(EnemigosDeLaTierra);

    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);

    	assertEquals(cell.obtenerPuntosDeVida(),420, 0);

    	goku.atacar(cell);
    	Consumible semilla = new SemillaDelErmitanio();
    	assertEquals(cell.obtenerPuntosDeVida(),380, 0);
		cell.consumir(semilla);
    	assertEquals(cell.obtenerPuntosDeVida(),480, 0);

    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);
    	goku.atacar(cell);

    	assertEquals(cell.obtenerPuntosDeVida(),160, 0);

    	goku.atacar(cell);

    	assertEquals(cell.obtenerPuntosDeVida(),120, 0);

    	goku.atacar(cell);
    	assertEquals(cell.obtenerPuntosDeVida(),60, 0);
    }



}