package fiuba.algo3.modelo;

import static org.junit.Assert.*;

import org.junit.Assert;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.personajes.*;

import org.junit.Test; 


public class test {

	// PRIMERA ENTREGA 
	

    @Test
    public void test01seUbicaUnPersonajeEnUnCasilleroSePideQueSeMuevSeVerificaNuevaPosicionAcordeASuModo(){
        Goku goku = new Goku();
        int cantidadMovimientosRealizados = 0;
        Tablero tablero = new Tablero();
        Casillero casillero = tablero.obtenerCasillero(1,1);
        casillero.asignarPersonaje(goku);
        goku.mover(tablero, 1,2);
        cantidadMovimientosRealizados++;
        goku.mover(tablero, 1,3);
        cantidadMovimientosRealizados++;
        Assert.assertEquals(cantidadMovimientosRealizados, goku.obtenerVelocidad());
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
            fail("Deberia haber ocurrido un error");
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
    } 

    
    // SEGUNDA ENTREGA 
    
    @Test (expected = SegundaTransformacionException.class)
    public void test08CompruebaQueGohanNoPuedeLlegarALaSegundaTransformacion() { 
    	
    	// Posicionar a los Guerreros Z,
    	
    	GuerrerosZ goku = new Goku(); 
    	GuerrerosZ gohan = new Gohan(); 
    	GuerrerosZ piccolo = new Piccolo(); 
    	Tablero tablero = new Tablero(); 
    	tablero.obtenerCasillero(1, 3).asignarPersonaje(goku);
    	tablero.obtenerCasillero(2, 2).asignarPersonaje(gohan);
    	tablero.obtenerCasillero(3, 1).asignarPersonaje(piccolo); 
    	
    	// llevar a Gohan a su primera transformaci�n,
    	
    	gohan.aumentarKiEn(10); 
    	// comprobar que no puede llegar a la segunda.
    	 
    	// ????????????????????
    	
    }

    @Test
    public void test09CompruebaTransformacionCorrectaDeGohan() { 
    	
    	// Posicionar a los Guerreros Z, 
    	GuerrerosZ goku = new Goku(); 
    	GuerrerosZ gohan = new Gohan(); 
    	GuerrerosZ piccolo = new Piccolo(); 
    	EnemigosDeLaTierra cell = new Cell(); 
    	
    	Tablero tablero = new Tablero(); 
    	
    	tablero.obtenerCasillero(1, 3).asignarPersonaje(goku);
    	tablero.obtenerCasillero(2, 2).asignarPersonaje(gohan);
    	tablero.obtenerCasillero(3, 1).asignarPersonaje(piccolo); 
    	tablero.obtenerCasillero(4, 4).asignarPersonaje(cell);

    	// dejar a Goku y Piccolo con la vida necesaria 
    	// para la transformaci�n de Gohan, y comprobar que se realiza correctamente.

    	goku.disminuirPuntosDeVidaEn(355);
    	piccolo.disminuirPuntosDeVidaEn(355);

    	double puntosIniciales = cell.obtenerPuntosDeVida(); 
    	gohan.atacar(cell);
    	double puntosFinales = cell.obtenerPuntosDeVida(); 
    	Assert.assertTrue(puntosFinales == puntosIniciales - 100);

    }
    
    
    @Test (expected = SegundaTransformacionException.class)
    public void test10CompruebaQuePiccoloNoPuedeLlegarALaSegundaTransformacion() { 
    	
    	// Posicionar a Gohan y Piccolo y llevar a este �ltimo a su primera
    	// transformaci�n, luego comprobar que no puede llegar a la segunda.
    	GuerrerosZ gohan = new Gohan(); 
    	GuerrerosZ piccolo = new Piccolo(); 
    	Tablero tablero = new Tablero();
    	tablero.obtenerCasillero(1, 3).asignarPersonaje(gohan);
    	tablero.obtenerCasillero(2, 2).asignarPersonaje(piccolo);
    	
    	piccolo.aumentarKiEn(20);
    	 // ????????????
    
    }
    
    @Test 
    public void test11VerificaLaCorrectaSegundaTransformacionDePiccolo() { 
    	
    	// Posicionar a Gohan y Piccolo, dejar a Gohan con la vida necesaria 
    	// para que Piccolo pueda realizar su segunda transformaci�n, comprobar 
    	// que los cambios se hicieron correctamente.
    	GuerrerosZ gohan = new Gohan(); 
    	GuerrerosZ piccolo = new Piccolo(); 
    	EnemigosDeLaTierra cell = new Cell(); 
    	Tablero tablero = new Tablero();
    	tablero.obtenerCasillero(1, 3).asignarPersonaje(gohan);
    	tablero.obtenerCasillero(2, 2).asignarPersonaje(piccolo);
    	tablero.obtenerCasillero(5, 5);
    	
    	gohan.disminuirPuntosDeVidaEn(237);

    	double puntosIniciales = cell.obtenerPuntosDeVida(); 
    	piccolo.atacar(cell);
    	double puntosFinales = cell.obtenerPuntosDeVida(); 
    	Assert.assertTrue(puntosFinales == puntosIniciales - 60);
    	
    }
    
    @Test (expected = KiInsuficienteException.class)
    public void test12CompruebaQueCellNoPuedeRealizarTransformaciones() { 
    	
    	// Posicionar a Cell y comprobar que no puede realizar sus transformaciones
    	EnemigosDeLaTierra cell = new Cell(); 
    	Tablero tablero = new Tablero(); 
    	tablero.obtenerCasillero(5, 5); 
    	cell.aumentarKiEn(20); // debe absorber 4 veces, lo cual requiere 20 ki 
    	
    }
    
    @Test 
    public void test13VerificaFuncionamientoDeAbsorberVida() { 
    	
    	// Posicionar a Cell y a un Guerrero Z, comprobar el correcto 
    	// funcionamiento de �absorber vida�.
    	
    	EnemigosDeLaTierra cell = new Cell(); 
    	GuerrerosZ goku = new Goku();
    	Tablero tablero = new Tablero(); 
    	tablero.obtenerCasillero(3, 3).asignarPersonaje(cell);
    	tablero.obtenerCasillero(4, 4).asignarPersonaje(goku);

    	cell.aumentarKiEn(10);

    	int kiInicialCell = cell.obtenerKi(); 
    	double vidaInicialCell = cell.obtenerPuntosDeVida(); 
    	double vidaInicialGoku = goku.obtenerPuntosDeVida(); 
    	cell.absorberVida(goku); 
    	int kiFinalCell = cell.obtenerKi(); 
    	double vidaFinalCell = cell.obtenerPuntosDeVida(); 
    	double vidaFinalGoku = goku.obtenerPuntosDeVida(); 
    	Assert.assertTrue(vidaFinalCell - vidaInicialCell == 20 && 
    					  kiInicialCell - kiFinalCell == 5 &&
    					  vidaInicialGoku - vidaFinalGoku == 20);

    } 
    
    @Test 
    public void test14AbsorbeVidaParaEfectuarTransformacion() { 
    	
    	// Posicionar a Cell y a un Guerrero Z, efectuar �absorber vida� 
    	// las veces necesarias para que pueda transformarse y comprobar que 
    	// los cambios se hicieron correctamente.

    	EnemigosDeLaTierra cell = new Cell(); 
    	GuerrerosZ goku = new Goku();
    	Tablero tablero = new Tablero(); 
    	tablero.obtenerCasillero(3, 3).asignarPersonaje(cell);
    	tablero.obtenerCasillero(4, 4).asignarPersonaje(goku);

    	cell.aumentarKiEn(20);
    	double vidaInicialGoku = goku.obtenerPuntosDeVida(); 
    	for (int i = 1; i <= 4; i++) 
    		cell.absorberVida(goku); 
    	cell.atacar(goku);
    	double vidaMediaGoku = goku.obtenerPuntosDeVida(); 
    	Assert.assertTrue(vidaMediaGoku == vidaInicialGoku - 120);//estado semiperfecto 
    	for (int i = 1; i <= 4; i++)
    		cell.absorberVida(goku); 
    	cell.atacar(goku);
    	double vidaFinalGoku = goku.obtenerPuntosDeVida(); 
    	Assert.assertTrue(vidaFinalGoku == vidaMediaGoku - 160);
    	

    }
    
    @Test 
    public void test15VerificaFuncionamientoDeConvierteteEnChocolate() { 
    	
    	// Posicionar a Majin Boo, y a un Guerrero Z, comprobar el correcto
    	// funcionamiento de �Convi�rtete en chocolate�
    	
    	EnemigosDeLaTierra majinboo = new MajinBoo(); 
    	GuerrerosZ goku = new Goku(); 
    	Tablero tablero = new Tablero(); 
    	tablero.obtenerCasillero(2, 2).asignarPersonaje(majinboo);
    	tablero.obtenerCasillero(4, 4).asignarPersonaje(goku);

    	majinboo.aumentarKiEn(30);

    	majinboo.convierteteEnChocolate(goku); // inmoviliza a goku por 3 turnos 
    											// como se implementa esto?? 
    	
    }
    
    @Test 
    public void test16VerificarAumentoDeDanoAlReducirVida() { 
    	
    	// Posicionar a Goku y verificar que su da�o aumenta, 
    	// al reducir su vida por debajo del 20%.
    	
    	GuerrerosZ goku = new Goku(); 
    	EnemigosDeLaTierra cell = new Cell();
    	
    	double vidaInicialGoku = goku.obtenerPuntosDeVida(); 
    	cell.atacar(goku);
    	double danoInicial = vidaInicialGoku - goku.obtenerPuntosDeVida(); 
    	double vidaMediaGoku = goku.obtenerPuntosDeVida(); 
    	
    	goku.disminuirPuntosDeVidaEn(400);
    	cell.atacar(goku);
    	double danoFinal = goku.obtenerPuntosDeVida(); 
    	
    	Assert.assertTrue(danoFinal > danoInicial);
    	
    	
    } 

 
} 