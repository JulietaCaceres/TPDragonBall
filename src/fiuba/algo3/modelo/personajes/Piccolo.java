package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Piccolo extends GuerrerosZ{
	
	private EstadoPiccolo estado;
	
	public Piccolo(){
		this.nombre = "Piccolo";
		this.puntosDeVida = 500;
		this.Ki = 0;
		this.estado = new EstadoPiccoloNormal();
	}
		
	public void pasarAEstadoFortalecido(){
		if(this.Ki < 20){
			throw new ExceptionPrimeraTransformacion();
		}
		this.Ki -= 20 ;
		this.estado = new EstadoPiccoloFortalecido();
	}
		
	public void pasarAEstadoProtector(int puntosDeVidaDeGohan){
		if(puntosDeVidaDeGohan >= 60){
			throw new ExceptionSegundaTransformacion();
		}
		
		this.estado = new EstadoPiccoloProtector();
	}
	
	
	//public void mover(Tablero tablero, int filaDestino, int columnaDestino){
	//	estado.mover(this, filaDestino, columnaDestino, tablero);
	//}
	
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
	public void verificarDistancia(int distancia){ estado.verificarDistancia(this,distancia);}
	
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
