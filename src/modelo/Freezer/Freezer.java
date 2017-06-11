package modelo.Freezer;

import Juego.Personaje;
import Juego.Tablero;

public class Freezer extends Personaje{
	private EstadoFreezer estado;
	
	Freezer(){
		this.nombre = "Freezer";
		this.equipo = "Enemigos de la Tierra";
		this.puntosDeVida = 400;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.estado = new EstadoFreezerNormal();
	}
	
	public void primeraTransformacion(){
		this.poderDePelea = 40;
		this.Ki -= 20 ;
		this.estado = new EstadoFreezerSegundaForma();
	}
	
	public void transformarEnLaAparienciaOriginal(){
		this.poderDePelea = 50;
		this.Ki -= 50 ;
		this.estado = new EstadoFreezerFormaOriginal();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}

}
