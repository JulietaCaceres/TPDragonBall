package modelo.Personajes;
import modelo.Juego.EnemigosDeLaTierra;
import modelo.Juego.ExceptionAtaqueAMismoEquipo;
import modelo.Juego.GuerrerosZ;
import modelo.Juego.Tablero;

public class Gohan extends GuerrerosZ{
		
	private EstadoGohan estado;
		
	Gohan(){
		this.nombre = "Gohan";
		this.puntosDeVida = 300;
		this.Ki = 0;
		this.estado = new EstadoGohanNormal();
	}
	
	public void convertirseEnSuperSayajin1(){
		if(this.Ki < 10){
			throw new KiInsuficienteParaTransformarseException();
		}
		this.Ki -= 10 ;
		this.estado = new EstadoGohanSuperSayajinFase1();
	}
		
	public void convertirseEnSuperSayajin2(int vidaDeGoku, int vidaDePiccolo){
		if(vidaDeGoku >= 150 || vidaDePiccolo >= 150){
			throw new AliadoEstaPorEncimaDeLaLineaDePeligroException();
		}else if(this.Ki < 30){
			throw new KiInsuficienteParaTransformarseException();
		}
		this.Ki -= 30 ;
		this.estado = new EstadoGohanSuperSayajinFase2();
	}
		
	public void mover(Tablero tablero, int filaDestino, int columnaDestino){
		estado.mover(this, filaDestino, columnaDestino, tablero);
	}

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