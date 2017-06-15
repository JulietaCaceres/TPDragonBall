package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Gohan extends GuerrerosZ{
		
	private EstadoGohan estado;
		
	public Gohan(){
		this.nombre = "Gohan";
		this.puntosDeVida = 300;
		this.Ki = 0;
		this.estado = new EstadoGohanNormal();
	}
	
	public void convertirseEnSuperSayajin1(){
		if(this.Ki < 10){
			throw new ExceptionPrimeraTransformacion();
		}
		this.Ki -= 10 ;
		this.estado = new EstadoGohanSuperSayajinFase1();
	}
		
	public void convertirseEnSuperSayajin2(int vidaDeGoku, int vidaDePiccolo){
		if(vidaDeGoku >= 150 || vidaDePiccolo >= 150 || this.Ki<30){
			throw new ExceptionSegundaTransformacion();
		}
		this.Ki -= 30 ;
		this.estado = new EstadoGohanSuperSayajinFase2();
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
}