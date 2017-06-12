package modelo.Personajes;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.Tablero;

public class Cell extends Personaje{
	
	private EstadoCell estado;
	private int cantidadDeAbsorciones;
	
	public Cell(){
		this.nombre = "Cell";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.cantidadDeAbsorciones = 0;
		this.estado = new EstadoCellNormal();
	}
	
	public void absorberA17(){
		this.poderDePelea = 40;
		this.cantidadDeAbsorciones -= 4 ;
		this.estado = new EstadoCellSemiPerfecto();
	}
	
	public void absorberA18(){
		this.poderDePelea = 80;
		this.cantidadDeAbsorciones -= 8;
		this.estado = new EstadoCellPerfecto();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}
	
	@Override
	public void recibirDanioDe(Gohan gohan, double poderDePelea) {
		gohan.recibirDanio(poderDePelea);		
	}

	@Override
	public void recibirDanioDe(Goku goku, double poderDePelea) {
		goku.recibirDanio(poderDePelea);
	}

	@Override
	public void recibirDanioDe(Piccolo piccolo, double poderDePelea) {
		piccolo.recibirDanio(poderDePelea);
	}

	@Override
	public void recibirDanioDe(Freezer freezer, double poderDePelea) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void recibirDanioDe(Cell cell, double poderDePelea) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void recibirDanioDe(MajinBoo majinBoo, double poderDePelea) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void recibirDanioDe(Personaje atacante, double poderDeAtaque) {
		// TODO Auto-generated method stub		
	}

}