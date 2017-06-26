package vista;

import java.util.Map;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import juego.*;

public class Controller  {

	private Partida partida;
	private Stage stage;
	private Personaje personajeSeleccionado;


	public void iniciarPartida() throws Exception {

		System.out.println("Inicio juego");
		Juego juego = new Juego();
		juego.iniciarPartida();
		this.partida = juego.obtenerPartidaActual();
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("juego.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		Stage stage = new Stage();
		stage.setTitle("DragonAlgoBall");
		stage.setScene(new Scene(root));

		stage.show();

	}

	private void jugar(Turno turno) {
		this.elegirOpcionDeJuego(turno.obtenerEquipoActual());
	}

	private void elegirOpcionDeJuego(Equipo equipo ) {

	}

	public void insertarMenuOpciones(Scene scene) {

	}

	public void gridClicked() {
		System.out.println("Grid clicked");
	}


	public void selectedGoku() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("juego.fxml"));
		Map<String, Object> fxmlNamespace = loader.getNamespace();
		ImageView goku2 = (ImageView) fxmlNamespace.get("goku2");
		goku2.resize(600, 600);
		System.out.println("Hola");
	}

	public void selectedPiccolo() {

	}

	public void selectedGohan() {

	}

	public void selectedFreezer() {

	}

	public void selectedCell() {

	}

	public void selectedMajinBoo() {

	}

	public void btnSalir() {
		System.exit(0);
	}
}
