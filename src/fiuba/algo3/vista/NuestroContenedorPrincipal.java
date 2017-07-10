package fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.juego.Jugador;

public class NuestroContenedorPrincipal extends ScrollPane {

	 private Juego juego;
	 private Stage stage;
	 private ContenedorTablero contenedorTablero;
	 private VBox pantalla;
	 private HBox contenedorJuego;
	 
	 public NuestroContenedorPrincipal(Stage stage, Juego unJuego){
		 this.pantalla = new VBox();
		 this.contenedorJuego = new HBox();
		 this.juego = unJuego;
		 juego.iniciarTablero();
		 this.dibujar();
		 this.setContent(pantalla);
		 Controlador.getControlador().setContenedorPrincipal(this);
	 }
	
	 private Botonera setBotonera() {
		 Botonera botonera = new Botonera(juego, contenedorTablero);
		 return botonera;
	}

	private void setMenu(Stage stage) {
		
	    pantalla.getChildren().add(new BarraDeMenu(stage));
	}

	private VBox setNombreJugadorActual(){
		Jugador jugadorActual = juego.obtenerTurno().obtenerJugadorActual();
		Label nombre = new Label();
		String texto = "Turno: " + jugadorActual.obtenerNombre();
        nombre.setText(texto);
        nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 16));
        nombre.setTextFill(Color.BLUE);
        VBox contenedor = new VBox(nombre);
        return contenedor;
	}
	
	 private void setJuego(){
		 
		 this.contenedorTablero = new ContenedorTablero(juego);
		 VBox contenedorVertical = new VBox(contenedorTablero);
		 HBox contenedorHorizontal = new HBox();
		 if (juego.obtenerTurno().ganoJugador()){
			 contenedorHorizontal.getChildren().add(this.anunciarGanador());
			 contenedorVertical.getChildren().add(contenedorHorizontal);
		 } else{
			 contenedorHorizontal.setSpacing(10);
		     contenedorHorizontal.getChildren().add(this.setNombreJugadorActual());
			 contenedorHorizontal.getChildren().add(this.setBotonera());
			 contenedorVertical.getChildren().add(contenedorHorizontal);
		 }
		 contenedorJuego.getChildren().add(contenedorVertical);
		 
	 }
	 
	 private VBox anunciarGanador(){

		 Jugador jugadorGanador = juego.obtenerTurno().obtenerJugadorActual();
	     String nombreGanador = jugadorGanador.obtenerNombre();
	     Label nombre = new Label();
		 String texto = "GANADOR: " + nombreGanador;
	     nombre.setText(texto);
	     nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 20));
	     nombre.setTextFill(Color.BLACK);
	     VBox contenedor = new VBox(nombre);
	     return contenedor;
	 }
	 
	 private void setJugador1(){
		
		Label nombreJugador1 = new Label();
		nombreJugador1.setText(juego.obtenerJugadorGuerrero().obtenerNombre());
		nombreJugador1.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		nombreJugador1.setTextFill(Color.BLACK);

		
     	VBox contenedorVertical1 = new VBox(nombreJugador1);
		contenedorVertical1.setSpacing(10);
		contenedorVertical1.setPadding(new Insets(15));	 
	     
	     for  (int i=0; i < juego.obtenerJugadorGuerrero().obtenerEquipoGuerreros().size(); i++){
	    	 ContenedorPersonaje unContenedor = new ContenedorPersonaje(juego.obtenerTurno().obtenerJugadorGuerrero().obtenerEquipoGuerreros().get(i), Color.BLUE);
	    	 contenedorVertical1.getChildren().add(unContenedor);
	     }
	     contenedorJuego.getChildren().add(contenedorVertical1);
	 }
	 
	 private void setJugador2(){
		
		Label nombreJugador2 = new Label();
		nombreJugador2.setText(juego.obtenerJugadorEnemigo().obtenerNombre());
		nombreJugador2.setFont(Font.font("courier new", FontWeight.BOLD, 24));
		nombreJugador2.setTextFill(Color.BLACK);

		
     	VBox contenedorVertical1 = new VBox(nombreJugador2);
		contenedorVertical1.setSpacing(10);
		contenedorVertical1.setPadding(new Insets(15));

	     for  (int i=0; i < juego.obtenerJugadorEnemigo().obtenerEquipoEnemigo().size(); i++){
	    	 ContenedorPersonaje unContenedor = new ContenedorPersonaje(juego.obtenerJugadorEnemigo().obtenerEquipoEnemigo().get(i), Color.RED);
	    	 contenedorVertical1.getChildren().add(unContenedor);
	     }
	     
	     contenedorJuego.getChildren().add(contenedorVertical1);

	 }

	public void update() {
		this.juego.obtenerTurno().borrarPersonajesMuertos();
		this.dibujar();

	}

	public void dibujar() {
		this.pantalla = new VBox();
		this.contenedorJuego = new HBox();
		this.setMenu(stage);
		this.setContenedorJuego();
		this.setContent(pantalla);
	}
	

	private void setContenedorJuego(){
		this.setJugador1();
		this.setJuego();
		this.setJugador2();
		pantalla.getChildren().add(contenedorJuego);
	}
		 
}

