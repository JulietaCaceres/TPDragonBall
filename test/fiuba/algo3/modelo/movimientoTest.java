package fiuba.algo3.modelo;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionLaDistanciaEntreLasCoordenadasNoEsValida;
import fiuba.algo3.modelo.personajes.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class movimientoTest {

@Test
    public void suponiendoQueLaDistanciaPermtidaDeMovimientoEsDosSeIntentaCambiarDeCoordenadasValidas()

   {   Coordenada unaCoordenada = new Coordenada(4,4);
       Coordenada otraCoordenada = new Coordenada(6,4);
       unaCoordenada.cambiarCoordenadas(otraCoordenada);
       assertEquals(6,unaCoordenada.obtenerFila());
   }

   @Test
   public void ColocoUnPersonajeEnUnCasilleroLoMuevoYVerificoQueElCasilleroOrigenSeEncuentrVacio()
   {
       GuerrerosZ goku = new Goku();
       Tablero tablero = new Tablero();
       tablero.ubicarPersonaje(goku,2,2);
       tablero.moverPersonaje(goku,3,2);
       assertTrue(!(tablero.obtenerCasillero(2,2).ocupado()));
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
    public void ubicoPersonajeEnTableroYVerificoQueElCasilleroQuedeOcupado(){
       Tablero unTablero = new Tablero();
       Goku goku = new Goku();
       unTablero.ubicarPersonaje(goku,2,2);
       assertTrue(unTablero.obtenerCasillero(2,2).ocupado());
    }

    @Test

    public void ubicoPersonajeEnTableroYPidoQueSeMuevaAUnaDistanciaValidaYVerificoQueElCasilleroInicialSeHayaVaciado()
    {
        Tablero tablero = new Tablero();
        Piccolo piccolo = new Piccolo();
        tablero.ubicarPersonaje(piccolo,2,2);
        tablero.moverPersonaje(piccolo,3,2);
        assertTrue(!tablero.obtenerCasillero(2,2).ocupado());
    }

    @Test
    public void ubicoPersonajeEnTableroYPidoQueSeMuevaAUnaDistanciaValidaYVerificoQueElCasilleroDestinoSeHayaOcupado()
    {
        Tablero tablero = new Tablero();
        EnemigosDeLaTierra cell = new Cell();
        tablero.ubicarPersonaje(cell,2,2);
        tablero.moverPersonaje(cell,3,2);
        assertTrue(tablero.obtenerCasillero(3,2).ocupado());
    }
}

