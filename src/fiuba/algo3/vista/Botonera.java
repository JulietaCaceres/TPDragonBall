
package fiuba.algo3.vista;

import fiuba.algo3.vista.eventos.BotonAtacarEventHandler;
import fiuba.algo3.vista.eventos.BotonAtaqueEspecialEventHandler;
import fiuba.algo3.vista.eventos.BotonMoverEventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import fiuba.algo3.modelo.juego.Juego;

public class Botonera extends BorderPane {
	
	private Juego juego;
	private ContenedorTablero contenedorTablero;
	
	public Botonera (Juego juego, ContenedorTablero tablero){
		this.contenedorTablero= tablero;
		this.juego = juego;
		HBox contenedorBotones = new HBox();
		contenedorBotones.getChildren().add(this.setBotonAtaqueEspecial());
		contenedorBotones.getChildren().add(this.setBotonAtacar());
		contenedorBotones.getChildren().add(this.setBotonMover());
	    contenedorBotones.setSpacing(10);
	    contenedorBotones.setPadding(new Insets(15));
		this.setCenter(contenedorBotones);

	}

	private Node setBotonMover() {
		Button botonMover = new Button("Mover");
		BotonMoverEventHandler moverEventHandler= new BotonMoverEventHandler(juego,contenedorTablero);
		botonMover.setOnAction(moverEventHandler);
		Controlador.getControlador().recibirBotonMover(moverEventHandler);
		return botonMover;
	}

	private Node setBotonAtacar() {
		Button botonAtacar = new Button("Atacar");
		BotonAtacarEventHandler atacarEventHandler= new BotonAtacarEventHandler(juego,contenedorTablero);
		botonAtacar.setOnAction(atacarEventHandler);
		Controlador.getControlador().recibirBotonAtaque(atacarEventHandler);
		return  botonAtacar;
	}


	private Button setBotonAtaqueEspecial() {
		Button botonAtaqueEspecial = new Button("Ataque Especial");
		BotonAtaqueEspecialEventHandler realizarAtaqueEspecialEventHandler = new BotonAtaqueEspecialEventHandler(juego, contenedorTablero);
		botonAtaqueEspecial.setOnAction(realizarAtaqueEspecialEventHandler);
		Controlador.getControlador().recibirBotonAtaqueEspecial(realizarAtaqueEspecialEventHandler);
		return botonAtaqueEspecial;
	}

}
