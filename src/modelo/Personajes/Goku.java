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
		if(this.Ki < 20){
			throw new KiInsuficienteParaTransformarseException();
		}
		this.Ki -= 20 ;
		this.estado = new EstadoGokuKaioKen();
	}
	
	public void convertirseEnSuperSayajin(){
		if(this.Ki < 50){
			throw new KiInsuficienteParaTransformarseException();
		}
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

	public int aumentoDePoderPorAdrenalina() {
		int aumento = 1;
		if(this.puntosDeVida < this.puntosDeVida*30/100){
			aumento = 1 + 20/100;
		}
		return aumento;
	}

	@Override
	public void realizarAtaqueEspecial(GuerrerosZ oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		estado.kamehameha(this, oponente);
	}

	@Override
	public void convertirseEnChocolate() {
		this.estado = new EstadoGokuChocolate();
	}

	@Override
	public void volverAEstadoNormal() {
		this.estado = new EstadoGokuNormal();
	}
}
