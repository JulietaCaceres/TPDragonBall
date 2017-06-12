package modelo.Personajes;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.Tablero;

public class MajinBoo extends Personaje {
	private EstadoMajinBoo estado;
	
	public MajinBoo(){
		this.nombre = "Majin Boo";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.estado = new EstadoMajinBooNormal();
	}
	
	public void convertirseEnBooMalo(){
		this.poderDePelea = 40;
		this.Ki -= 20 ;
		this.estado = new EstadoMajinBooMalo();
	}
	
	public void regresarASerBooOriginal(){
		this.poderDePelea = 60;
		this.Ki -= 50 ;
		this.estado = new EstadoMajinBooOriginal();
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
