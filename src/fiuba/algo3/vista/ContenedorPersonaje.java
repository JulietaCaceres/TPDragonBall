package fiuba.algo3.vista;

import fiuba.algo3.modelo.juego.Equipo;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ContenedorPersonaje extends BorderPane {


	private Image imagen;
	private ImageView contenedorImagen;
	private Equipo personaje;
	
	public ContenedorPersonaje(Equipo unPersonaje, Color unColor){

		this.personaje = unPersonaje;
		this.imagen = new Image(unPersonaje.obtenerDireccionDeImagen());
		this.dibujar(unColor);
	}
	public void dibujar(Color unColor){

		this.contenedorImagen = new ImageView();
		contenedorImagen.setFitHeight(100);
		contenedorImagen.setFitWidth(70);
		contenedorImagen.setImage(imagen);
		this.setLeft(contenedorImagen);

        Label nombre = new Label();
        nombre.setText(personaje.obtenerNombre());
        nombre.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        nombre.setTextFill(unColor);
        
        Label vida = new Label();
        vida.setText("Vida = " + personaje.obtenerPuntosDeVida());
        vida.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        vida.setTextFill(unColor);

        Label ataque = new Label();
        ataque.setText("Ataque = " + personaje.obtenerAtaque());
        ataque.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        ataque.setTextFill(unColor);
        
        Label distanciaDeAtaque = new Label();
        distanciaDeAtaque.setText("Distancia de Ataque = " + personaje.obtenerDistanciaDeAtaque());
        distanciaDeAtaque.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        distanciaDeAtaque.setTextFill(unColor);
        
        Label velocidadDeDesplazamiento = new Label();
        velocidadDeDesplazamiento.setText("Velocidad = " + personaje.obtnerVelocidad());
        velocidadDeDesplazamiento.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        velocidadDeDesplazamiento.setTextFill(unColor);

	    VBox texto = new VBox(nombre, vida, ataque, distanciaDeAtaque, velocidadDeDesplazamiento);

        this.setRight(texto);

	}
}
