package Tests;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class test {

    @Test
    public void test01seUbicaUnPersonajeEnUnCasilleroSePideQueSeMuevSeVerificaNuevaPosiciónAcordeASuModo(){
        Goku goku = new Goku();
        Tablero tablero = new Tablero();
        Casillero casillero = tablero.obtenerCasillero(1,1);
        casillero.asignarPersonaje(goku);
        goku.mover(tablero, 1,2);
        goku.mover(tablero, 1,3);
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
        assertEquals(personaje.obtenerNombre(),"Goku");
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
        casillero.asignarPersonaje(cell);
        try{
            cell.mover(tablero, 2,2);
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
        majinBoo.mover(tablero, 3,4);
        majinBoo.mover(tablero, 3,5);
        majinBoo.mover(tablero, 4,5);
        assertEquals(mover.obtenerCantidadDeMovimientos(),majinBoo.obtenerVelocidad());
    }

}


