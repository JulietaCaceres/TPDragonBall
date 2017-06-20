package fiuba.algo3.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.juego.ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado;
import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Freezer;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.personajes.Piccolo;

public class MovimientoTest {


    @Test
    public void test21MoverAGokuDosCoordenadasMasAdelante(){
    	Goku goku = new Goku();
    	Coordenada coordenadaInicial = new Coordenada (1,1);
    	Coordenada coordenadaFinal = new Coordenada (1,3);

    	goku.asignarCoordenadas(coordenadaInicial);

    	goku.mover(coordenadaFinal);

    	assertTrue(!coordenadaInicial.obtenerCasillero().ocupado());
    	assertTrue(coordenadaFinal.obtenerCasillero().ocupado());
    }

    @Test
    public void test22AsignarAGokuEnCasilleroMoverloYVerQueElPrimerCasilleroEstaVacio(){
    	Goku goku = new Goku();
    	Coordenada coordenadaInicial = new Coordenada (1,1);
    	Coordenada coordenadaFinal = new Coordenada (1,3);

    	goku.asignarCoordenadas(coordenadaInicial);

    	goku.mover(coordenadaFinal);

    	assertTrue(coordenadaFinal.obtenerCasillero().ocupado());
    	assertTrue(!coordenadaInicial.obtenerCasillero().ocupado());

    	Freezer freezer = new Freezer();
    	freezer.asignarCoordenadas(coordenadaInicial);

    	assertTrue(coordenadaInicial.obtenerCasillero().ocupado());
    }

    @Test
    public void test23HacerTransformarAPiccoloMoviendoloEntreCoordenadas(){
    	Piccolo piccolo = new Piccolo();
    	Coordenada coordenada1 = new Coordenada(1,1);
    	Coordenada coordenada2 = new Coordenada(1,3);
    	Coordenada coordenada3 = new Coordenada(1,5);
    	Coordenada coordenada4 = new Coordenada(1,7);
    	Coordenada coordenada5 = new Coordenada(1,9);
    	Coordenada coordenada6 = new Coordenada(1,12);

    	piccolo.asignarCoordenadas(coordenada1);

    	piccolo.mover(coordenada2);
    	piccolo.mover(coordenada3);
    	piccolo.mover(coordenada4);
    	piccolo.mover(coordenada5);
    	//Piccolo esta en estado fortalecido
    	piccolo.mover(coordenada6);

    	assertTrue(coordenada6.obtenerCasillero().ocupado());
    }


@Test
    public void suponiendoQueLaDistanciaPermtidaDeMovimientoEsDosSeIntentaCambiarDeCoordenadasValidas()

   {   Coordenada unaCoordenada = new Coordenada(4,4);
       Coordenada otraCoordenada = new Coordenada(6,4);
       unaCoordenada.cambiarCoordenadas(otraCoordenada);
       assertEquals(6,unaCoordenada.obtenerFila());
   }


   @Test
    public void unPersonajeCambiaSuCoordenadaAOtraUbicadaAUnaDistanciaAcordeASuVelocidadYSeVerficaSuNuevaCoordenada()
   {
       Goku goku = new Goku();
       Coordenada unaCoordenada = new Coordenada(2,2);
       goku.asignarCoordenadas(unaCoordenada);
       Coordenada otraCoordenada = new Coordenada(3,2);
       goku.cambiarCoordenadas(otraCoordenada);
       assertEquals(3,goku.obtenerCoordenadas().obtenerFila());
   }

   @Test (expected = ExceptionLaDistanciaEntreLasCoordenadasNoEsValida.class)
    public void unPersonajeIntentaCambiaSuCoordenadaAOtraUbicadaAUnaDistanciaNoAcordeASuVelocidadYFalla(){

       Goku goku = new Goku();
       Coordenada unaCoordenada = new Coordenada(2,2);
       goku.asignarCoordenadas(unaCoordenada);
       Coordenada otraCoordenada = new Coordenada(8,2);
       goku.cambiarCoordenadas(otraCoordenada);


   }

   @Test
   public void leAsignoUnaNuevaCoordenadaACellYElCasilleroDeLaMismaCoordenadaQuedaOcupadoPorqueEstabaVacio()
   {
       Cell unCell = new Cell();
       Coordenada unaCoordenada = new Coordenada(2,2);
       unCell.asignarCoordenadas(unaCoordenada);
       assertTrue(unaCoordenada.obtenerCasillero().ocupado());
   }

   @Test (expected = ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado.class)
   public void  intentoAsiganarleUnaCoordenadaInicialAFreezerPeroNoPuedePorqueElCasilleroConLaMismaCoordenadaEstabaOcupado()
   {

       Cell Cell = new Cell();
       Coordenada unaCoordenada = new Coordenada(2,2);
       Cell.asignarCoordenadas(unaCoordenada);
       Freezer freezer = new Freezer();
       freezer.asignarCoordenadas(unaCoordenada);
   }


}
