package fiuba.algo3.modelo;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.personajes.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class movimientoTests {

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
