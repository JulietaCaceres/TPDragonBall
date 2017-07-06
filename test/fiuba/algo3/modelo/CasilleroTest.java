package fiuba.algo3.modelo;

import fiuba.algo3.modelo.juego.Casillero;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.personajes.Gohan;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CasilleroTest {

    @Test
    public void colocoUnPersonajeEnElCasilleroYMeAseguroQueQuedeOcupado()
    {
        Coordenada unaCoordenada = new Coordenada(2,2);
        Casillero casillero = new Casillero(unaCoordenada);
        Gohan gohan = new Gohan();
        casillero.asignarPersonaje(gohan);
        assertTrue(casillero.ocupado());
    }

    @Test
    public void colococuUnPersonajeEnUnCasilleroLoSacoYVerificoQueElCasilleroQuedeDesocupado()
    {   Coordenada unaCoordenada = new Coordenada(2,2);
        Casillero casillero = new Casillero(unaCoordenada);
        Gohan gohan = new Gohan();
        casillero.asignarPersonaje(gohan);
        casillero.liberarDePersonaje();
        assertTrue(!casillero.ocupado());
    }
}
