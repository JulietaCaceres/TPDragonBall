package modelo.Personajes;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class MajinBoo extends EnemigosDeLaTierra {
	private EstadoMajinBoo estado;
	
	public MajinBoo(){
		this.nombre = "Majin Boo";
		this.puntosDeVida = 500;
		this.Ki = 0;
		this.estado = new EstadoMajinBooNormal();
	}
	
	public void convertirseEnBooMalo(){
		if(this.Ki < 20){
			throw new KiInsuficienteParaTransformarseException();
		}
		this.Ki -= 20 ;
		this.estado = new EstadoMajinBooMalo();
	}
	
	public void regresarASerBooOriginal(){
		if(this.Ki < 50){
			throw new KiInsuficienteParaTransformarseException();
		}
		this.Ki -= 50 ;
		this.estado = new EstadoMajinBooOriginal();
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

	@Override
	public void realizarAtaqueEspecial(GuerrerosZ oponente) {
		oponente.convertirseEnChocolate();
		this.disminuirKiEn(30);
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}
}
