package fiuba.algo3.vista;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import fiuba.algo3.vista.eventos.BotonBorrarEventHandler;
import fiuba.algo3.vista.eventos.BotonEntrarEventHandler;

public class ContenedorElegirJugadores extends HBox{
	
	private TextField campoNombreJugador1;
	private TextField campoNombreJugador2;
	private Button botonEntrar;
	
	public ContenedorElegirJugadores(Stage stage){
		this.setSpacing(30);
		this.setMaxWidth(700);
        this.setColumnaGuerrerosZ();
        this.setColumnaEnemigosDeLaTierra();
        this.setBotonEntrar(stage);
        Controlador.getControlador().setContenedroElegirJugador(this);

        
	}
	
	private void setBotonEntrar(Stage stage) {
        
		VBox contenedorVertical = new VBox();
        contenedorVertical.setSpacing(15);
		botonEntrar = new Button();
        botonEntrar.setText("Entrar");
        botonEntrar.setMinSize(75, 25);
		BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage);
        botonEntrar.setOnAction(botonEntrarHandler);
        
        Button botonBorrar = new Button();
        botonBorrar.setText("Borrar");
        botonBorrar.setMinSize(75, 25);
        BotonBorrarEventHandler botonBorrarEventHandler = new BotonBorrarEventHandler();
        botonBorrar.setOnAction(botonBorrarEventHandler);
		contenedorVertical.getChildren().addAll(botonEntrar, botonBorrar);
        this.getChildren().add(contenedorVertical);

	}
	

	public TextField getCampoNombreJugador1() {
		return campoNombreJugador1;
	}

	public TextField getCampoNombreJugador2() {
		return campoNombreJugador2;
	}

	public String getNombreJugador1(){	
		return (campoNombreJugador1.getText());
	}

	public String getNombreJugador2(){
		return (campoNombreJugador2.getText());
	}
	
	private void setColumnaGuerrerosZ() {
		
		VBox guerrerosZ = new VBox();
		HBox elegirNombre = new HBox();
		
		Label titulo = new Label();
		titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
		titulo.setText("GUERREROSZ");
		titulo.setTextFill(Color.BLUE);
		
		Label jugador1 = new Label();
        jugador1.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        jugador1.setText("NOMBRE: ");
        jugador1.setTextFill(Color.BLACK);
        
        elegirNombre.setSpacing(10);
		this.campoNombreJugador1 = new TextField();
		
		elegirNombre.getChildren().add(jugador1);
		elegirNombre.getChildren().add(campoNombreJugador1);
		
		guerrerosZ.setSpacing(10);
		guerrerosZ.getChildren().add(titulo);
		guerrerosZ.getChildren().add(elegirNombre);
		
		this.getChildren().add(guerrerosZ);
	}
	
	private void setColumnaEnemigosDeLaTierra() {
		
		VBox enemigosDeLaTierra = new VBox();
		HBox elegirNombre = new HBox();
		
		Label titulo = new Label();
		titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 28));
		titulo.setText("ENEMIGOSDELATIERRA");
		titulo.setTextFill(Color.RED);
		
		Label jugador2 = new Label();
        jugador2.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        jugador2.setText("NOMBRE: ");

        jugador2.setTextFill(Color.BLACK);
        
        elegirNombre.setSpacing(10);
        
		this.campoNombreJugador2 = new TextField();
		
		elegirNombre.getChildren().add(jugador2);
		elegirNombre.getChildren().add(campoNombreJugador2);
		
		enemigosDeLaTierra.getChildren().add(titulo);
		enemigosDeLaTierra.getChildren().add(elegirNombre);
		enemigosDeLaTierra.setSpacing(10);
		this.getChildren().add(enemigosDeLaTierra);
		
	}
}
