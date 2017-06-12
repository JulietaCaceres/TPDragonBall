package modelo.Personajes;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.Tablero;

public class Gohan extends Personaje{
		
	private EstadoGohan estado;
		
	Gohan(){
		this.nombre = "Gohan";
		this.puntosDeVida = 300;
		this.poderDePelea = 15;
		this.Ki = 0;
		this.estado = new EstadoGohanNormal();
	}
	
	public void convertirseEnSuperSayajin1(){
		this.poderDePelea = 30;
		this.Ki -= 10 ;
		this.estado = new EstadoGohanSuperSayajinFase1();
	}
		
	public void convertirseEnSuperSayajin2(){
		this.poderDePelea = 100;
		this.Ki -= 30 ;
		this.estado = new EstadoGohanSuperSayajinFase2();
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
