package modelo;

import fiuba.algo3.modelo.juego.ExceptionCasilleroOcupado;

import org.junit.Test;

import fiuba.algo3.modelo.personajes.Cell;
import static org.junit.Assert.*;
import fiuba.algo3.modelo.personajes.Goku;
import fiuba.algo3.modelo.juego.Tablero;
import fiuba.algo3.modelo.juego.Casillero;
import fiuba.algo3.modelo.juego.ExceptionCasilleroOcupado;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class test {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01seMueveAGokuAUnCasilleroEncontradoAUnaVelocidadAcordeASuModoYSeVerificaQueElCasilleroQuedeOcupado(){
        Goku goku = new Goku();
        Casillero casilleroInicial = new Casillero(2,2);
        casilleroInicial.asignarPersonaje(goku);
        Casillero casilleroFinal = new Casillero(2,4);
        casilleroFinal.asignarPersonaje(goku);
        assertTrue(casilleroFinal.ocupado());

    }

    @Test (expected = ExceptionCasilleroOcupado.class)
    public void tet02seVerificaQueNoPuedenHaberDosPersonajesEnElMismoCasillero()
    {
        Goku goku = new Goku();
        Casillero unCasillero = new Casillero(2,2);
        unCasillero.asignarPersonaje(goku);
        Cell cell = new Cell();
        unCasillero.asignarPersonaje(cell);

    }

   /* @Test
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
        Assert.assertEquals(personaje.obtenerNombre(),"Goku");
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
        MajinBoo majinBoo = new MajinBoo();
        int cantidadMovimientosRealizados = 0;
        Casillero casillero = tablero.obtenerCasillero(3,3);
        casillero.asignarPersonaje(majinBoo);
        majinBoo.aumentarKiEn(30);
        majinBoo.convertirseEnBooMalo();
        majinBoo.mover(tablero, 3, 4);
        cantidadMovimientosRealizados++;
        majinBoo.mover(tablero, 3, 5);
        cantidadMovimientosRealizados++;
        majinBoo.mover(tablero, 4, 5);
        cantidadMovimientosRealizados++;
        assertEquals(cantidadMovimientosRealizados,majinBoo.obtenerVelocidad());

    }
    
    @Test
    public void test06seIniciaUnJuegoCon2JugadoresCadaUnoDeEllosConSus3PersonajesDistribuidosEnElTableroSegunElEnunciado()
    {
        Juego juego = new Juego();
        Tablero tablero = juego.obtenerTablero();
        Casillero casillero1 = tablero.obtenerCasillero(0,2);
        Casillero casillero2 = tablero.obtenerCasillero(1,1);
        Casillero casillero3 = tablero.obtenerCasillero(2,0);
        Casillero casillero4 = tablero.obtenerCasillero(29,31);
        Casillero casillero5 = tablero.obtenerCasillero(30,30);
        Casillero casillero6 = tablero.obtenerCasillero(29,31);
        boolean posicionCorrecta = (casillero1.ocupado() && casillero2.ocupado() && casillero3.ocupado()
                                     && casillero4.ocupado() && casillero5.ocupado() && casillero6.ocupado());
        Assert.assertTrue (posicionCorrecta);
    }

    
    @Test 
    public void test07VerificaDaniosLuegoDeAtaques () { 
        Personaje goku = new Goku(); 
        Personaje freezer = new Freezer(); 
        Tablero tablero = new Tablero(); 
        Casillero casilleroGoku = tablero.obtenerCasillero(1,1);  
        casilleroGoku.asignarPersonaje(goku); 
        Casillero casilleroFreezer = tablero.obtenerCasillero(2,2); 
        casilleroFreezer.asignarPersonaje(freezer); 
        
        int puntosInicialesDeVidaFreezer = freezer.obtenerPuntosDeVida(); 
        goku.atacar(freezer, tablero); 
        assertEquals(freezer.obtenerPuntosDeVida(), puntosInicialesDeVidaFreezer - 20); 
        
        Personaje piccolo = new Piccolo(); 
        Personaje cell = new Cell(); 
        Casillero casilleroPiccolo = tablero.obtenerCasillero(3,3); 
        casilleroPiccolo.asignarPersonaje(piccolo); 
        Casillero casilleroCell = tablero.obtenerCasilero(15,15); 
        casilleroCell.asignarPersonaje(cell); 

        int puntosInicialesDeVidaCell = cell.obtenerPuntosDeVida(); 
        try { 
            piccolo.atacar(cell, tablero); 
        } catch (Exception e) { 
            fail ("Los personajes estan muy lejos"); 
        } 
        assertEquals(cell.obtenerPuntosDeVida(), puntosInicialesDeVidaCell); 
    }*/
}


