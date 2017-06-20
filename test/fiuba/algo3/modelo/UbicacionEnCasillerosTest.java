import static org.junit.Assert.assertTrue;

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

    @Test (expected = ExceptionCasilleroOcupado.class)
    public void tet02seVerificaQueNoPuedenHaberDosPersonajesEnElMismoCasillero()
    {
        Goku goku = new Goku();
        Casillero unCasillero = new Casillero();
        unCasillero.asignarPersonaje(goku);
        Cell cell = new Cell();
        unCasillero.asignarPersonaje(cell);
    }

    @Test(expected = ExceptionCasilleroOcupado.class)
    public void test03unPersonajeIntentaMoversePeroNoPuedePasarPorEncimaDeOtro()
    {
        Goku goku = new Goku();
        Cell cell =new Cell();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku, 2,2);
        tablero.ubicarPersonaje(cell,2,3);
        cell.mover(tablero.obtenerCoordenada(2, 2));
    }

}
