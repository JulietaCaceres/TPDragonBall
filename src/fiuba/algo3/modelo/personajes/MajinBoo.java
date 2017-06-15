package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;
import fiuba.algo3.modelo.juego.Tablero;

public class MajinBoo extends EnemigosDeLaTierra {
	private EstadoMajinBoo estado;
	
	public MajinBoo(){
		this.nombre = "Majin Boo";
		this.puntosDeVida = 500;
		this.Ki = 0;
		this.estado = new EstadoMajinBooNormal();
	}
	
	public void convertirseEnBooMalo(){
		this.Ki -= 20 ;
		this.estado = new EstadoMajinBooMalo();
	}
	
	public void regresarASerBooOriginal(){
		this.Ki -= 50 ;
		this.estado = new EstadoMajinBooOriginal();
	}
	
	public void recibirDanio(double danio){
		estado.recibirDanio(this, danio);
	}
	
	//public void mover(Tablero tablero, int filaDestino, int columnaDestino){
	//	estado.mover(this, filaDestino, columnaDestino, tablero);
   //	}

	@Override
	public void atacar(GuerrerosZ oponente) {
		estado.atacar(this, oponente);
	}

	@Override
	public void atacar(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void verificarDistancia(int distancia){ estado.verificarDistancia(this,distancia);}

}
