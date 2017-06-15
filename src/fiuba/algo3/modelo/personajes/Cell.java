package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Cell extends EnemigosDeLaTierra{
	
	private EstadoCell estado;
	private int cantidadDeAbsorciones;
	
	public Cell(){
		this.nombre = "Cell";
		this.puntosDeVida = 500;
		this.Ki = 0;
		this.cantidadDeAbsorciones = 0;
		this.estado = new EstadoCellNormal();
	}
	
	public void aumentarVidaEn(double vida){
		this.puntosDeVida += vida;
	}
	
	public void absorberA17(){
		if(this.cantidadDeAbsorciones < 4){
			throw new ExceptionPrimeraTransformacion();
		}
		this.cantidadDeAbsorciones -= 4 ;
		this.estado = new EstadoCellSemiPerfecto();
	}
	
	public void absorberA18(){
		if(this.cantidadDeAbsorciones < 8){
			throw new ExceptionSegundaTransformacion();
		}
		this.cantidadDeAbsorciones -= 8;
		this.estado = new EstadoCellPerfecto();
	}
	
	public void recibirDanio(double danio){
		estado.recibirDanio(this, danio);
	}
	
	//public void mover(Tablero tablero, int filaDestino, int columnaDestino){
	//	estado.mover(this, filaDestino, columnaDestino, tablero);
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
		estado.absorberVida(this, oponente);
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

}