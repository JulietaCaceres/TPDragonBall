package modelo;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.juego.Casillero;

public class TableroTest {
    @Test
    public void test01ubicoUnPersonajeEnUnCasilleroVerificoCasilleroOcupado() {
        Goku unPersonaje = new Goku();
        Casillero unCasillero = new Casillero(2,2);
        unCasillero.asignarPersonaje(unPersonaje);
        assertTrue(unCasillero.ocupado());
    }


}
