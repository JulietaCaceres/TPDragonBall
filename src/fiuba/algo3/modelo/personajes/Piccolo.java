package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Piccolo extends Personaje implements GuerrerosZ{

	private EstadoPiccolo estado;
	private Gohan referenciaAGohan;

	public Piccolo(){
		this.nombre = "Piccolo";
		this.puntosDeVida = 500;
		this.estado = new EstadoPiccoloNormal();
	}

	public void referenciarAGohan(Gohan gohan){
		this.referenciaAGohan = gohan;
	}

	public double verVidaDeGohan(){
		double vida = 100;
		if (this.referenciaAGohan != null){
			vida = this.referenciaAGohan.obtenerPuntosDeVida();
		}
		return vida;
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
		estado.makankosappo(this, oponente);
	}

	@Override
	public void convertirseEnChocolate() {
		this.estado = new EstadoPiccoloChocolate();
	}

	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		estado.recibirAtaque(this, coordenadasDeAtacante, alcanceDeAtaque, poderDePelea);
	}

	public void asignarEstado(EstadoPiccolo nuevoEstado) {
		this.estado = nuevoEstado;
	}

    @Override
    public void tomarNubeVoladora() {

    }

    @Override
    public void cambiarCoordenadas(Coordenada coordenadaNueva) {
        estado.cambiarCoordenadas(coordenada,coordenadaNueva);
    }

	public void mover(Coordenada coordenadaSemilla) {
		// TODO Auto-generated method stub

	}
}
