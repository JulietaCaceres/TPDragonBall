package fiuba.algo3.vista;


import fiuba.algo3.modelo.juego.IUbicable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import fiuba.algo3.vista.eventos.ElegirContenidoEventHandler;

public class VistaContenido extends ImageView {
	
	private IUbicable contenido;
	private Image imagenContenido ;
	
	public VistaContenido(IUbicable unContenido){
		imagenContenido = null;
		this.contenido = unContenido;
		String direccionContenido = contenido.obtenerDireccionDeImagen();
		this.imagenContenido = new Image(direccionContenido);
		this.setVistaContenido();
		this.setOnMouseClicked(new ElegirContenidoEventHandler(this.getContenido()));
	}

	public IUbicable getContenido() {
		return contenido;
	}
	
	public void setVistaContenido(){
		this.setFitHeight(32);
		this.setFitWidth(32);
		this.setImage(imagenContenido);
		if (contenido.esVacio()){
			this.setOpacity(0);
			return;
		}
		this.setOpacity(1);
	}

}