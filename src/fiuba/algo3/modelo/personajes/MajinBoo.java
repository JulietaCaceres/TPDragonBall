package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class MajinBoo extends Personaje implements EnemigosDeLaTierra{
	private EstadoMajinBoo estado;
	
	public MajinBoo(){
		this.nombre = "Majin Boo";
		this.puntosDeVida = 300;
		this.estado = new EstadoMajinBooNormal();
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
	public void realizarAtaqueEspecial(GuerrerosZ oponente) {
		estado.convertirEnChocolate(oponente);
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}
	
	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		coordenada.verificarDistanciaAtaque(coordenadasDeAtacante, alcanceDeAtaque);
		this.recibirDanio(poderDePelea);
	}
	
	public void asignarEstado(EstadoMajinBoo nuevoEstado){
		this.estado = nuevoEstado;
	}

	@Override
	public void mover(Coordenada coordenada){
		estado.mover(this, this.obtenerCoordenadas(), coordenada);
	}
}
