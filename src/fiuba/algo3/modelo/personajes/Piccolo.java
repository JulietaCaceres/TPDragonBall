
package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.excepciones.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Piccolo extends Personaje implements GuerrerosZ{
	
	private EstadoPiccolo estado;
	private GuerrerosZ referenciaAGohan;
	
	public Piccolo(){
		this.nombre = "Piccolo";
		this.puntosDeVida = 2;
		this.estado = new EstadoPiccoloNormal();
	}
	
	public void referenciarAGohan(GuerrerosZ gohan){
		this.referenciaAGohan = gohan;
		estado.referenciarAGogan(gohan);
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

	@Override
	public void referenciarAGoku(GuerrerosZ goku) {

	}

	@Override
	public void referenciarAPiccolo(GuerrerosZ piccolo) {

	}

	public void asignarEstado(EstadoPiccolo nuevoEstado) {
		this.estado = nuevoEstado;
	}

    @Override
    public void tomarNubeVoladora() {
		estadoNubeVoladora = new EstadoNubeVoladora();
		estado.tomarNubeVoladora(estadoNubeVoladora);
    }

    @Override
    public void cambiarCoordenadas(Coordenada coordenadaNueva) {
       estado = estado.cambiarCoordenadas(this,coordenadaNueva);
    }

	@Override
	public double porcentajeDeVida() { 
		return this.puntosDeVida*100/500; 
	}

    @Override
    public String obtenerDireccionDeImagen() {
        return estado.obtenerDireccionDeImagen();
    }

    public boolean porcentajeDeVidaMenor30() {
		return (porcentajeDeVida() < 30);
    }

    @Override
    public boolean porcentajeDeVidaMenosde20() {
        return false;
    }

    @Override
    public double obtenerAtaque() {
        return estado.obtenerAtaque(this);
    }

    @Override
    public int obtenerDistanciaDeAtaque() {
        return estado.obtenerDistanciaDeAtaque();
    }

    @Override
    public int obtnerVelocidad() {
        return estado.obtenerVelocidad();
    }
}
