package fiuba.algo3.vista;

import fiuba.algo3.modelo.juego.IUbicable;
import fiuba.algo3.vista.eventos.BotonAtacarEventHandler;
import fiuba.algo3.vista.eventos.BotonAtaqueEspecialEventHandler;
import fiuba.algo3.vista.eventos.BotonMoverEventHandler;

public class Controlador {

	private static Controlador instance = null;
	private BotonAtacarEventHandler botonAtacar;
	private BotonAtaqueEspecialEventHandler botonAtacarEspecial;
	private NuestroContenedorPrincipal contenedor;
	private ContenedorElegirJugadores contenedorJuego;
	private BotonMoverEventHandler botonMover;
	
	private Controlador(){
		
	}
	
	public static Controlador getControlador(){
	       if (Controlador.instance == null){
	           Controlador.instance = new Controlador();
	       }
	       return Controlador.instance;
	    }


	public ContenedorElegirJugadores getContenedorJuego(){
		return this.contenedorJuego;
	}
	
	public void darContenido(IUbicable elegido) {

		botonAtacarEspecial.recibirContenido(elegido);
		botonAtacar.recibirContenido(elegido);
		botonMover.recibirContenido(elegido);
	}
	
	public void setContenedorPrincipal(NuestroContenedorPrincipal contenedor){
		this.contenedor = contenedor;
	}

	public void setContenedroElegirJugador(ContenedorElegirJugadores unContenedor){
		this.contenedorJuego = unContenedor;
	}
	
	public void update(){
		contenedor.update();
	}

	public void recibirBotonAtaqueEspecial(BotonAtaqueEspecialEventHandler botonRealizarAtaqueEspecialEventHandler) { botonAtacarEspecial = botonRealizarAtaqueEspecialEventHandler;
	}

	public void recibirBotonAtaque(BotonAtacarEventHandler botonRealizarAtaque){botonAtacar = botonRealizarAtaque;}

	public void recibirBotonMover(BotonMoverEventHandler unBotonMover){botonMover = unBotonMover;}

}
