package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Gohan extends Personaje implements GuerrerosZ{
		
	private EstadoGohan estado;
	private Goku referenciaAGoku;
	private Piccolo referenciaAPiccolo;
		
	public Gohan(){
		this.nombre = "Gohan";
		this.puntosDeVida = 300;
		this.estado = new EstadoGohanNormal();
	}
	
	public void referenciarAGoku(Goku goku){
		this.referenciaAGoku = goku;
	}
	
	public void referenciarAPiccolo(Piccolo piccolo){
		this.referenciaAPiccolo = piccolo;
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
	
	public double obtenerVidaDeGoku(){
		return this.referenciaAGoku.obtenerPuntosDeVida();
	}
	
	public double obtenerVidaDePiccolo(){
		return this.referenciaAPiccolo.obtenerPuntosDeVida();
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
		estado.masenko(this, oponente);
	}

	@Override
	public void convertirseEnChocolate() {
		this.estado = new EstadoGohanChocolate();		
	}

	@Override
	public void volverAEstadoNormal() {
		this.estado = new EstadoGohanNormal();
	}
	
	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		coordenada.verificarDistanciaAtaque(coordenadasDeAtacante, alcanceDeAtaque);
		this.recibirDanio(poderDePelea);
	}

	public void asignarEstado(EstadoGohan nuevaForma) {
		this.estado = nuevaForma;
	}
}