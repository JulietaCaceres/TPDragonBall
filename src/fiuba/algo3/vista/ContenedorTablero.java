package fiuba.algo3.vista;

import fiuba.algo3.modelo.juego.Juego;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import fiuba.algo3.modelo.juego.IUbicable;

public class ContenedorTablero extends BorderPane {

	private int filas;
	private int columnas;
	
	public ContenedorTablero(Juego juego){

		this.filas =  juego.obtenerTablero().obtenerCantidadDeFilas();
		this.columnas =  juego.obtenerTablero().obtenerCantidadDeColumnas();
		this.dibujar(juego);
	}
	   
public void dibujar(Juego juego){
	 HBox contenedorHorizontal = new HBox();


	 for (int i = 0; i < columnas; i++){
	    	VBox contenedorVertical = new VBox();
			for (int j = 0; j < filas; j++){

				IUbicable contenido = juego.obtenerTablero().obtenerCoordenada(i,j).obtenerCasillero().obtenerContenido();
				VistaContenido contenedorContenido = new VistaContenido(contenido);


					StackPane contenedorImagenesSuperpuestas = new StackPane();
					contenedorImagenesSuperpuestas.setBackground(new Background(new BackgroundFill(Color.BLUE,CornerRadii.EMPTY,Insets.EMPTY)));
					contenedorImagenesSuperpuestas.getChildren().addAll(contenedorContenido);
					contenedorVertical.getChildren().add(contenedorImagenesSuperpuestas);
					contenedorVertical.setSpacing(2);
			}
			contenedorHorizontal.getChildren().add(contenedorVertical);
			contenedorHorizontal.setSpacing(2);
		}
	    this.setCenter(contenedorHorizontal);
		
	}




}