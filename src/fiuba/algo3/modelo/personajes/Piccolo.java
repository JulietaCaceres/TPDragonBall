package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Piccolo extends Personaje implements GuerrerosZ{
	
	private EstadoPiccolo estado;
	private Gohan referenciaAGohan;
	
	public Piccolo(){
		this.nombre = "Piccolo";
		this.puntosDeVida = 500;
		this.estado = new EstadoPiccoloNormal();
	}
	
	public void referenciarAGohan(Gohan gohan){
		this.referenciaAGohan = gohan;
	}
	
	public double verVidaDeGohan(){
		return this.referenciaAGohan.obtenerPuntosDeVida();
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

	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		coordenada.verificarDistanciaAtaque(coordenadasDeAtacante, alcanceDeAtaque);
		this.recibirDanio(poderDePelea);
	}

	public void asignarEstado(EstadoPiccolo nuevoEstado) {
		this.estado = nuevoEstado;
	}	
}