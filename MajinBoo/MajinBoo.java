package MajinBoo;
import Juego.Personaje;
import Juego.Tablero;

public class MajinBoo extends Personaje {
	private EstadoMajinBoo estado;
	
	public MajinBoo(){
		this.nombre = "Majin Boo";
		this.equipo = "Enemigos de la Tierra";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.estado = new EstadoMajinBooNormal();
	}
	
	public void convertirseEnBooMalo(){
		this.poderDePelea = 40;
		this.Ki -= 20 ;
		this.estado = new EstadoMajinBooMalo();
	}
	
	public void regresarASerBooOriginal(){
		this.poderDePelea = 60;
		this.Ki -= 50 ;
		this.estado = new EstadoMajinBooOriginal();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}
}
