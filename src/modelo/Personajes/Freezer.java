package modelo.Personajes;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class Freezer extends EnemigosDeLaTierra{
	private EstadoFreezer estado;
	
	Freezer(){
		this.nombre = "Freezer";
		this.puntosDeVida = 400;
		this.Ki = 0;
		this.estado = new EstadoFreezerNormal();
	}
	
	public void primeraTransformacion(){
		this.Ki -= 20 ;
		this.estado = new EstadoFreezerSegundaForma();
	}
	
	public void transformarEnLaAparienciaOriginal(){
		this.Ki -= 50 ;
		this.estado = new EstadoFreezerFormaOriginal();
	}
	
	public void recibirDanio(double danio){
		estado.recibirDanio(this, danio);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}

	@Override
	public void atacar(GuerrerosZ oponente) {
		estado.atacar(this, oponente);
	}

	@Override
	public void atacar(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}
}