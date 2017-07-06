package fiuba.algo3.vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Aplicacion extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception {


        NuestroContenedorBienvenidos contenedorBienvenidos = new NuestroContenedorBienvenidos(stage);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 700, 480);
       
        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(true);

        stage.show();


    }

}
