package fiuba.algo3.modelo;

import static org.junit.Assert.assertTrue;

import fiuba.algo3.modelo.juego.ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado;
import org.junit.Test;
import fiuba.algo3.modelo.juego.Casillero;
import fiuba.algo3.modelo.juego.ExceptionCasilleroOcupado;
import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Goku;

public class UbicacionEnCasillerosTest {

    @Test
    public void test00ubicoUnPersonajeEnUnCasilleroVerificoCasilleroOcupado() {
        Goku unPersonaje = new Goku();
        Casillero unCasillero = new Casillero();
        unCasillero.asignarPersonaje(unPersonaje);
        assertTrue(unCasillero.ocupado());
    }

    @Test
    public void test01seMueveAGokuAUnCasilleroEncontradoAUnaVelocidadAcordeASuModoYSeVerificaQueElCasilleroQuedeOcupado(){
        Goku goku = new Goku();
        Casillero casilleroInicial = new Casillero();
        casilleroInicial.asignarPersonaje(goku);
        Casillero casilleroFinal = new Casillero();
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
