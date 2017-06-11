package modelo.Goku;
import Juego.Personaje;
import Juego.Tablero;

public class Goku extends Personaje{
	
	private EstadoGoku estado;
	
	public Goku(){
		this.nombre = "Goku";
		this.equipo = "Guerreros Z";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.estado = new EstadoGokuNormal();
		this.estadoEsferaDragon = null;
	}
	
	public void usarKaioKen(){
		this.poderDePelea = 40;
		this.Ki -= 20 ;
		this.estado = new EstadoGokuKaioKen();
	}
	
	public void convertirseEnSuperSayajin(){
		this.poderDePelea = 60;
		this.Ki -= 50 ;
		this.estado = new EstadoGokuSuperSayajin();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}

}
