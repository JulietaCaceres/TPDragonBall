package fiuba.algo3.modelo;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.personajes.Gohan;
import fiuba.algo3.modelo.personajes.Goku;
import org.junit.Test;


import javax.management.DescriptorKey;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
public class CoordenadasTest {

    @Test
    public void creoUnaCoordenadaYVerificoQuePoseaUnCasilleroOcupado()
    {
        Coordenada coordenada = new Coordenada(2,2);
        assertTrue(!coordenada.obtenerCasillero().ocupado());
    }

    @Test
    public void creoUnaCoordenadYLeAsignoUnPersonajeAlCasilleroATravesDeEl()
    {
        Goku goku = new Goku();
        Coordenada coordenada = new Coordenada(2,2);
        coordenada.asignarPersonajeACasillero(goku);
        assertTrue(coordenada.obtenerCasillero().ocupado());
    }

    @Test
    public void vacioUnCasilleroATravesDeUnaCoordenada(){
        Goku goku = new Goku();
        Coordenada coordenada = new Coordenada(2,2);
        coordenada.asignarPersonajeACasillero(goku);
        coordenada.vaciarCasillero();
        assertTrue(!coordenada.obtenerCasillero().ocupado());

    }
    @Test
    public void leAsignoUnaCoordenadaAunCasilleroOcupadoYVerificoQueLoPuedaDesocupar(){
        Goku goku = new Goku();
        Coordenada coordenada = new Coordenada(2,2);
        Gohan gohan = new Gohan();
        gohan.asignarCoordenadas(coordenada);

    }


}
