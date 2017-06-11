package modelo.Cell;
import Juego.Personaje;
import Juego.Tablero;

public class Cell extends Personaje{
	
	private EstadoCell estado;
	private int cantidadDeAbsorciones;
	
	public Cell(){
		this.nombre = "Cell";
		this.equipo = "Enemigos de la Tierra";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.cantidadDeAbsorciones = 0;
		this.estado = new EstadoCellNormal();
	}
	
	public void absorberA17(){
		this.poderDePelea = 40;
		this.cantidadDeAbsorciones -= 4 ;
		this.estado = new EstadoCellSemiPerfecto();
	}
	
	public void absorberA18(){
		this.poderDePelea = 80;
		this.cantidadDeAbsorciones -= 8;
		this.estado = new EstadoCellPerfecto();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}

}