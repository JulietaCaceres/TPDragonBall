package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Goku extends Personaje implements GuerrerosZ{
	
	private EstadoGoku estado;
	
	public Goku(){
		this.nombre = "Goku";
		this.puntosDeVida = 500;
		this.estado = new EstadoGokuNormal();
		this.estadoEsferaDragon = null;
	}
	
	
	//public void mover(Tablero tablero, int filaDestino, int columnaDestino){

	//estado.mover(this, filaDestino, columnaDestino, tablero);
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

	public double aumentoDePoderPorAdrenalina() {
		double aumento = 1;
		if(this.puntosDeVida < 150){
			aumento = 1.2;
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
	
	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		coordenada.verificarDistanciaAtaque(coordenadasDeAtacante, alcanceDeAtaque);
		this.recibirDanio(poderDePelea);
	}
	
	public void asignarEstado(EstadoGoku nuevoEstado){
		this.estado = nuevoEstado;
	}
}
