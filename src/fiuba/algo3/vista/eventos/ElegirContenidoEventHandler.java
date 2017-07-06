package fiuba.algo3.vista.eventos;

import fiuba.algo3.modelo.juego.IUbicable;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import fiuba.algo3.vista.Controlador;

public class ElegirContenidoEventHandler implements EventHandler<MouseEvent> {
	
	private IUbicable unContenido;

	
	public ElegirContenidoEventHandler(IUbicable unContenido){
		this.unContenido = unContenido;

	}
	
	@Override
	public void handle(MouseEvent arg0) {
		Controlador.getControlador().darContenido(unContenido);
		
	}

}
