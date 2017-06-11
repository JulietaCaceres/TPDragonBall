package modelo.Piccolo;
import Juego.Personaje;
import Juego.Tablero;

public class Piccolo extends Personaje{
	
	private EstadoPiccolo estado;
	
	Piccolo(){
		this.nombre = "Piccolo";
		this.equipo = "Guerreros Z";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.estado = new EstadoPiccoloNormal();
	}
		
	public void pasarAEstadoFortalecido(){
		this.poderDePelea = 40;
		this.Ki -= 20 ;
		this.estado = new EstadoPiccoloFortalecido();
	}
		
	public void pasarAEstadoProtector(){
		this.poderDePelea = 60;
		this.estado = new EstadoPiccoloProtector();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}
}
