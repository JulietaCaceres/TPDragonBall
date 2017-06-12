package modelo.Personajes;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.Tablero;

public class Piccolo extends Personaje{
	
	private EstadoPiccolo estado;
	
	Piccolo(){
		this.nombre = "Piccolo";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.estado = new EstadoPiccoloNormal();
	}
		
	public void pasarAEstadoFortalecido(){
		this.poderDePelea = 40;
		this.Ki -= 20 ;
		this.estado = new EstadoPiccoloFortalecido();
	}
		
	public void pasarAEstadoProtector(){
		this.poderDePelea = 60;
		this.estado = new EstadoPiccoloProtector();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}
	
	@Override
	public void recibirDanioDe(Gohan gohan, double poderDePelea) {
		throw new ExceptionAtaqueAMismoEquipo();		
	}

	@Override
	public void recibirDanioDe(Goku goku, double poderDePelea) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void recibirDanioDe(Piccolo piccolo, double poderDePelea) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void recibirDanioDe(Freezer freezer, double poderDePelea) {
		freezer.recibirDanio(poderDePelea);
	}

	@Override
	public void recibirDanioDe(Cell cell, double poderDePelea) {
		cell.recibirDanio(poderDePelea);
	}

	@Override
	public void recibirDanioDe(MajinBoo majinBoo, double poderDePelea) {
		majinBoo.recibirDanio(poderDePelea);
	}

	@Override
	public void recibirDanioDe(Personaje atacante, double poderDeAtaque) {
		// TODO Auto-generated method stub
	}
}
