package Gohan;
import Juego.Personaje;
import Juego.Tablero;

public class Gohan extends Personaje{
		
	private EstadoGohan estado;
		
	Gohan(){
		this.nombre = "Gohan";
		this.puntosDeVida = 300;
		this.poderDePelea = 15;
		this.Ki = 0;
		this.equipo = "Guerreros Z";
		this.estado = new EstadoGohanNormal();
	}
	
	public void convertirseEnSuperSayajin1(){
		this.poderDePelea = 30;
		this.Ki -= 10 ;
		this.estado = new EstadoGohanSuperSayajinFase1();
	}
		
	public void convertirseEnSuperSayajin2(){
		this.poderDePelea = 100;
		this.Ki -= 30 ;
		this.estado = new EstadoGohanSuperSayajinFase2();
	}
		
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
		
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}

}
