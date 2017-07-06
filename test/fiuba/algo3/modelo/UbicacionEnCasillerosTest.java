package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.excepciones.ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado;
import org.junit.Test;

import fiuba.algo3.modelo.juego.Casillero;
import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Goku;

public class UbicacionEnCasillerosTest {

    @Test
    public void test00ubicoUnPersonajeEnUnCasilleroVerificoCasilleroOcupado() {
        Goku unPersonaje = new Goku();
        Coordenada coordenada = new Coordenada(2,2);
        Casillero unCasillero = new Casillero(coordenada);
        unCasillero.asignarPersonaje(unPersonaje);
        assertTrue(unCasillero.ocupado());
    }

    @Test
    public void test01seMueveAGokuAUnCasilleroEncontradoAUnaVelocidadAcordeASuModoYSeVerificaQueElCasilleroQuedeOcupado(){
        Goku goku = new Goku();
        Coordenada coordenada = new Coordenada(2,2);
        Casillero casilleroInicial = new Casillero(coordenada);
        casilleroInicial.asignarPersonaje(goku);
        Coordenada otraCoordenada = new Coordenada(2,3);
        Casillero casilleroFinal = new Casillero(otraCoordenada);
        casilleroFinal.asignarPersonaje(goku);
        assertTrue(casilleroFinal.ocupado());
    }

    @Test (expected = ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado.class)
    public void tet02seVerificaQueNoPuedenHaberDosPersonajesEnElMismoCasillero()
    {
        Goku goku = new Goku();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku,2,2);
        Cell cell = new Cell();
        tablero.ubicarPersonaje(cell,2,2);
    }
}
