package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;
import fiuba.algo3.modelo.juego.Tablero;

public class Piccolo extends GuerrerosZ{
	
	private EstadoPiccolo estado;
	
	Piccolo(){
		this.nombre = "Piccolo";
		this.puntosDeVida = 500;
		this.Ki = 0;
		this.estado = new EstadoPiccoloNormal();
	}
		
	public void pasarAEstadoFortalecido(){
		this.Ki -= 20 ;
		this.estado = new EstadoPiccoloFortalecido();
	}
		
	public void pasarAEstadoProtector(){
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

}
