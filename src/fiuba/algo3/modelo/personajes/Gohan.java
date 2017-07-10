package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;
import fiuba.algo3.modelo.juego.EstadoNubeVoladora;
import fiuba.algo3.modelo.juego.excepciones.ExceptionAtaqueAMismoEquipo;
import fiuba.algo3.modelo.juego.GuerrerosZ;

public class Gohan extends Personaje implements GuerrerosZ{
		
	private EstadoGohan estado;
	private GuerrerosZ referenciaAGoku;
	private GuerrerosZ referenciaAPiccolo;
		
	public Gohan(){
		this.nombre = "Gohan";
		this.puntosDeVida = 300;
		this.estado = new EstadoGohanNormal();
			}
	
	public void referenciarAGoku(GuerrerosZ goku){
		this.referenciaAGoku = goku;
		estado.referenciarAGoku(goku);
	}
	
	public void referenciarAPiccolo(GuerrerosZ piccolo){
		this.referenciaAPiccolo = piccolo;
		estado.referenciarAPiccolo(piccolo);
	}

	@Override
	public boolean porcentajeDeVidaMenor30() {
		return  false;
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
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		estado.recibirAtaque(this, coordenadasDeAtacante, alcanceDeAtaque, poderDePelea);
	}

	public void asignarEstado(EstadoGohan nuevaForma) {
		this.estado = nuevaForma;
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
		return this.puntosDeVida*300/100;
	}

    @Override
    public String obtenerDireccionDeImagen() {
        return estado.obtenerDireccionDeImagen();
    }

    public boolean porcentajeDeVidaMenosde20() {
		return (porcentajeDeVida() < 20);
    }

    @Override
    public double obtenerAtaque() {return estado.obtenerAtaque(this);
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