package fiuba.algo3.modelo;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.GuerrerosZ;
import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.personajes.Cell;
import fiuba.algo3.modelo.personajes.Gohan;
import fiuba.algo3.modelo.personajes.Goku;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TableroTest {

    @Test
    public void creoUnTableroLeUbicoUnPersonajeEnUnCasilleroYMeAseguroQueSeHayaOcupado()
    {
        Tablero unTablero = new Tablero();
        Goku goku = new Goku();
        unTablero.ubicarPersonaje(goku,2,2);
        assertTrue(unTablero.obtenerCasillero(2,2).ocupado());
    }

    @Test
    public  void creoUnTableroOcupoUnCasilleroConUnPersonajeLoDesocupoYVerificoQueSeHayaDesocupado()
    {
        GuerrerosZ goku = new Goku();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(goku,2,2);
        tablero.obtenerCasillero(2,2).liberarDePersonaje();
        assertTrue(!tablero.obtenerCasillero(2,2).ocupado());

    }

    @Test
    public void liberoUnCasilleroOcupadoYLoOcupoConOtroPersonaje(){
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(gohan,2,2);
        tablero.obtenerCasillero(2,2).liberarDePersonaje();
        tablero.ubicarPersonaje(goku,2,2);
        assertTrue(tablero.obtenerCasillero(2,2).ocupado());

    }

    @Test
    public void ubicoUnPersonajeEnElTableroYVerificoQueSeLeAsignenLasCoordenasCorrespondientesAlCasillero()
    {

        Gohan gohan = new Gohan();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(gohan,2,2);
        assertTrue(gohan.obtenerCoordenadas().obtenerFila() == 2 && gohan.obtenerCoordenadas().obtenerColumna() == 2);
    }

    @Test
    public void ubicoUnPersonajeEnElTableroLoMuevoYVerificoQueElCasilleroDestinoQuedeOcupado()
    {
        Gohan gohan = new Gohan();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(gohan,2,2);
        tablero.moverPersonaje(gohan,4,2);
        assertTrue(tablero.obtenerCasillero(4,2).ocupado());

    }

    @Test
    public void ubicoUnPersonajeEnElTableroLoMuevoYVerificoQueElCasilleroOrigenQuedeDesocupado()
    {
        EnemigosDeLaTierra cell = new Cell();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(cell,2,2);
        tablero.moverPersonaje(cell,4,2);
        assertTrue(!(tablero.obtenerCasillero(2,2).ocupado()));

    }

    @Test
    public void muevoUnPersonajeYverificoQueOtroPersonajePuedaUbicarseEnElCasilleroQueDesocupa(){
        Cell cell = new Cell();
        Gohan gohan = new Gohan();
        Tablero tablero = new Tablero();
        tablero.ubicarPersonaje(gohan,4,4);
        tablero.ubicarPersonaje(cell,3,4);
        tablero.moverPersonaje(gohan,5,4);
        tablero.moverPersonaje(cell,4,4);
        assertTrue(tablero.obtenerCasillero(4,4).ocupado());
    }

    @Test
    public void creoUnTableroYObtengoUnaCoordenadaVacia(){

        Tablero tablero = new Tablero();
        Coordenada coordenadaVacia = tablero.obtenerCoordenada(31,31);
        assertTrue(coordenadaVacia.obtenerCasillero().obtenerContenido().esVacio());
    }
}
