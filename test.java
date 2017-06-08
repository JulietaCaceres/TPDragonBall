package Tests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class test {

    @Test
       public void test01seUbicaUnPersonajeEnUnCasilleroSePideQueSeMuevSeVerificaNuevaPosiciónAcordeASuModo(){

        /*Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();
        jugador1.asignarNombre("july");
        jugador2.asignarNombre("fede");
        jugador1.asignarEquipo("Guerreros Z");
        jugador2.asignarEquipo("Enemigos de la Tierra");
        Partida partida = new Partida (jugador1,jugador2);
        partida.ubicar(goku, 1,1);*/
        Goku goku = new Goku();
        Tablero tablero = new Tablero();
        Casillero casillero = tablero.obtenerCasillero(1,1);
        casillero.asignarPersonaje(goku);
        Movimiento mover  = new Mover();
        mover.a(Goku, 1,1, 1,2, tablero);
        mover.a(Goku, 1,2, 1,3, tablero);
        goku.mover(1,3);
        assertEquals(mover.obtenerCantidadDeMovimientos(),goku.obtenerVelocidad());

    }

    @Test
    	public void test02seVerificaQueDosPersonajesNoEntranEnUnMismoCasillero()
    {
        Tablero tablero = new Tablero ();
        Goku goku = new Goku();
        Cell cell = new Cell();
        Casillero casillero = tablero.obtenerCasillero(3,3);
        casillero.asignarPersonaje(goku);
        try
        {
            casillero.asignarPersonaje(cell);
            fail("Debería haber ocurrido un error");
        } catch(Exception e){
            fail("Casillero ocupado");
        }

        Personaje personaje = casillero.obtenerPersonaje();
        assertEquals(personaje.obtenerNombre,"Goku");
    }

    @Test
    	public void Test03SeUbicanDosPersonajesYSeVerificaQueNoPuedanPasarUnoEncimaDelOtro()
    {
        Tablero tablero = new Tablero();
        Goku goku = new Goku ();
        Casillero casillero = tablero.obtenerCasillero(2,2);
        casillero.asignarPersonaje(goku);
        Cell cell = new Cell();
        casillero = tablero.obtenerCasillero(2,3);
        casillero.asignarPersonaje(Cell);
        Movimiento mover = new Movimiento();
        try{
            mover.a(Cell, 2,3, 2,2, tablero);
            fail("Deberia haber dado un error");
           } catch(Exception e)
             {
                fail("no puede pasar por casillero ocupado");
             }
    }

    @Test
    	public void test04SeUbicaUnPersonajeSeLoTransformaSeVerificaQueSePuedaTransformar()
    {
        Tablero tablero = new Tablero();
        Goku goku = new Goku ();
        Casillero casillero = tablero.obtenerCasillero(2,2);
        casillero.asignarPersonaje(goku);
        goku.aumentarKiEn(20);
        try
        {
            goku.usarKaioKen();
            fail("Cumple la condicion para transformarse");
        } catch(Exception e){}

    }

    @Test
    	public void test05SeUbicaAUnPersonajeSeLoTransformaSeLoMueveYSeVerificaQueElMovimientoSeaAcorde()
    {
        Tablero tablero = new Tablero();
        MajinBoo majinBoo = new Freezer();
        Casillero casillero = tablero.obtenerCasillero(3,3);
        casillero.asignarPersonaje(majinBoo);
        majinBoo.aumentarKiEn(30);
        majinBoo.transformarEnBooMalo();
        Movimiento mover  = new Mover();
        mover.a(majinBoo, 3,3, 3,4, tablero);
        mover.a(majinBoo, 3,4, 3,5, tablero);
        mover.a(majinBoo, 3,5, 4,5, tablero);
        assertEquals(mover.obtenerCantidadDeMovimientos(),majinBoo.obtenerVelocidad());

    }

}


