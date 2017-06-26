package vista;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import juego.*;

public class Controller  {

	private Partida partida;


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


		/*
		 *
		 *
		this.casilleros[0][2].ubicarPersonaje(goku);
		this.casilleros[1][1].ubicarPersonaje(piccolo);
		this.casilleros[2][0].ubicarPersonaje(gohan);
		this.casilleros[TAM-3][TAM-1].ubicarPersonaje(freezer);
		this.casilleros[TAM-2][TAM-2].ubicarPersonaje(majinboo);
		this.casilleros[TAM-1][TAM-3].ubicarPersonaje(cell);
		 */


		root.getChildrenUnmodifiable().add(new ImageView("Goku.png"));
		root.getChildrenUnmodifiable().add(new ImageView("Gohan.png"));
		root.getChildrenUnmodifiable().add(new ImageView("Piccolo.png"));
		root.getChildrenUnmodifiable().add(new ImageView("Freezer.png"));
		root.getChildrenUnmodifiable().add(new ImageView("Cell.png"));
		root.getChildrenUnmodifiable().add(new ImageView("MajinBoo.png"));
	}

	public void gridClicked() {
		System.out.println("Grid clicked");
	}

	public void btnSalir() {
		System.exit(0);
	}
}
