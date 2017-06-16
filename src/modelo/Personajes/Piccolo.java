package modelo.Personajes;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class Piccolo extends GuerrerosZ{
	
	private EstadoPiccolo estado;
	
	Piccolo(){
		this.nombre = "Piccolo";
		this.puntosDeVida = 500;
		this.Ki = 0;
		this.estado = new EstadoPiccoloNormal();
	}
		
	public void pasarAEstadoFortalecido(){
		if(this.Ki < 20){
			throw new KiInsuficienteParaTransformarseException();
		}
		this.Ki -= 20 ;
		this.estado = new EstadoPiccoloFortalecido();
	}
		
	public void pasarAEstadoProtector(int puntosDeVidaDeGohan){
		if(puntosDeVidaDeGohan >= 60){
			throw new AliadoEstaPorEncimaDeLaLineaDePeligroException();
		}
		
		this.estado = new EstadoPiccoloProtector();
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

	@Override
	public void realizarAtaqueEspecial(GuerrerosZ oponente) {
		throw new ExceptionAtaqueAMismoEquipo();		
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		estado.makankosappo(this, oponente);		
	}

	@Override
	public void convertirseEnChocolate() {
		this.estado = new EstadoPiccoloChocolate(); 		
	}

	@Override
	public void volverAEstadoNormal() {
		this.estado = new EstadoPiccoloNormal();
	}
}
