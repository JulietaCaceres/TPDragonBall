package modelo.Personajes;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class Goku extends GuerrerosZ{
	
	private EstadoGoku estado;
	
	public Goku(){
		this.nombre = "Goku";
		this.puntosDeVida = 500;
		this.Ki = 0;
		this.estado = new EstadoGokuNormal();
		this.estadoEsferaDragon = null;
	}
	
	public void usarKaioKen(){
		this.Ki -= 20 ;
		this.estado = new EstadoGokuKaioKen();
	}
	
	public void convertirseEnSuperSayajin(){
		this.Ki -= 50 ;
		this.estado = new EstadoGokuSuperSayajin();
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
