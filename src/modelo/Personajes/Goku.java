package modelo.Personajes;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.Tablero;

public class Goku extends Personaje{
	
	private EstadoGoku estado;
	
	public Goku(){
		this.nombre = "Goku";
		this.puntosDeVida = 500;
		this.poderDePelea = 20;
		this.Ki = 0;
		this.estado = new EstadoGokuNormal();
		this.estadoEsferaDragon = null;
	}
	
	public void usarKaioKen(){
		this.poderDePelea = 40;
		this.Ki -= 20 ;
		this.estado = new EstadoGokuKaioKen();
	}
	
	public void convertirseEnSuperSayajin(){
		this.poderDePelea = 60;
		this.Ki -= 50 ;
		this.estado = new EstadoGokuSuperSayajin();
	}
	
	public void atacar(Personaje oponente, Tablero tablero){
		this.estado.atacar(this, oponente, tablero);
	}
	
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		this.estado.mover(this, filaDestino, columnaDestino, tablero);
	}

	public int obtenerVelocidad() {
		return this.estado.obtenerVelocidad();
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
