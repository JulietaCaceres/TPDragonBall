package fiuba.algo3.modelo.juego;

public class Juego {
	
	private Menu menuDeJuego; 
	
	public Juego() { 
		this.menuDeJuego = new Menu();  
	}
	
	public Menu obtenerMenu() { 
		return this.menuDeJuego; 
	}
	
}
