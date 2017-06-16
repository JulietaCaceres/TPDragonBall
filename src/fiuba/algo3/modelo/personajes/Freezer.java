package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Freezer extends Personaje implements EnemigosDeLaTierra{
	private EstadoFreezer estado;
	
	public Freezer(){
		this.nombre = "Freezer";
		this.puntosDeVida = 400;
		this.estado = new EstadoFreezerNormal();
	}
	
	public void recibirDanio(double danio){
		estado.recibirDanio(this, danio);
	}

	//public void mover(Tablero tablero, int filaDestino, int columnaDestino){
	//estado.mover(this, filaDestino, columnaDestino, tablero);
	//}

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
	
	@Override
	public void realizarAtaqueEspecial(GuerrerosZ oponente) {
		estado.rayoMortal(this, oponente);		
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

	public void asignarEstado(EstadoFreezer nuevaForma) {
		this.estado = nuevaForma;
	}
}
