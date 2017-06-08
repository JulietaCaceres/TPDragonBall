package Tests;
package libs;
import analysis.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class test {

    @Test
       public void test01seUbicaUnPersonajeEnUnCasilleroSePideQueSeMuevSeVerificaNuevaPosiciónAcordeASuModo(){


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
    test02seVerificaQueDosPersonajesNoEntranEnUnMismoCasillero()
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
    test04SeUbicaUnPersonajeSeLoTransformaSeVerificaQueSePuedaTransformar()
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
    test05SeUbicaAUnPersonajeSeLoTransformaSeLoMueveYSeVerificaQueElMovimientoSeaAcorde()
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

    @Test
    test06seIniciaUnJuegoCon2JugadoresCadaUnoDeEllosConSus3PersonajesDistribuidosEnElTableroSegunElEnunciado()
    {
        Juego juego = new Juego();


        juego.iniciarPartida();
        Partida partida = juego.obtenerPartida();
        Tablero tablero = juego.obtenerTablero();
        Casillero  casillero1 = tablero.obtenerCasillero(0,2);
        Casillero  casillero2 = tablero.obtenerCasillero(1,1);
        Casillero  casillero3 = tablero.obtenerCasillero(2,0);
        Casillero  casillero4 = tablero.obtenerCasillero(29,31);
        Casillero  casillero5 = tablero.obtenerCasillero(30,30);
        Casillero  casillero6 = tablero.obtenerCasillero(29,31);
        boolean posicionCorrecta =  (casillero1.ocupado() && casillero2.ocupado() && casillero2.ocupado() && casillero3.ocupado()
                                     && casillero4.ocupado() && casillero5.ocupado() && casillero6.ocupado())
        Assert.assertTrue (posicionCorrecta);

    @Test

}


