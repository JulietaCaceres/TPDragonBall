package fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;
import fiuba.algo3.vista.Controlador;
import fiuba.algo3.vista.NuestroContenedorPrincipal;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent>{


    Stage stage;
    Scene proximaEscena;
    private Jugador jugador1;
    private Jugador jugador2;

    public BotonEntrarEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.setTablero();
    }
    
    public void setTablero(){
    	 Juego juego = new Juego(Controlador.getControlador().getContenedorJuego().getNombreJugador1(), Controlador.getControlador().getContenedorJuego().getNombreJugador2());
         NuestroContenedorPrincipal contenedorPrincipal = new NuestroContenedorPrincipal(stage, juego);
         Scene escenaJuego = new Scene(contenedorPrincipal, 640, 480);
         stage.setScene(escenaJuego);
         stage.setFullScreen(true);
         stage.show();
    }
    
}
