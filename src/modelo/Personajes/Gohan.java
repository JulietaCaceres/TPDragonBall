package modelo.Personajes;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class Gohan extends GuerrerosZ{
		
	private EstadoGohan estado;
		
	Gohan(){
		this.nombre = "Gohan";
		this.puntosDeVida = 300;
		this.Ki = 0;
		this.estado = new EstadoGohanNormal();
	}
	
	public void convertirseEnSuperSayajin1(){
		this.Ki -= 10 ;
		this.estado = new EstadoGohanSuperSayajinFase1();
	}
		
	public void convertirseEnSuperSayajin2(){
		this.Ki -= 30 ;
		this.estado = new EstadoGohanSuperSayajinFase2();
	}
		
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}

	@Override
	public void atacar(GuerrerosZ oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void atacar(EnemigosDeLaTierra oponente) {
		estado.atacar(this, oponente);
	}

	@Override
	public void recibirDanio(double poderDePelea) {
		estado.recibirDanio(this, poderDePelea);		
	}

}