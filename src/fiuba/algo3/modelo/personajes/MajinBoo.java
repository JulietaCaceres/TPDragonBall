package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.juego.excepciones.ExceptionAtaqueAMismoEquipo;

public class MajinBoo extends Personaje implements EnemigosDeLaTierra {

	private EstadoMajinBoo estado;

	public MajinBoo() {
		this.nombre = "Majin Boo";
		this.puntosDeVida = 300;
		this.estado = new EstadoMajinBooNormal();

	}

	public void recibirDanio(double danio) {
		estado.recibirDanio(this, danio);
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

    @Override
	public void atacar(GuerrerosZ oponente) {
		estado.atacar(this, oponente);
	}

	@Override
	public void atacar(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void realizarAtaqueEspecial(GuerrerosZ oponente) {
		estado.convertirEnChocolate(oponente);
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		estado.recibirAtaque(this, coordenadasDeAtacante, alcanceDeAtaque, poderDePelea);
	}

	public void asignarEstado(EstadoMajinBoo nuevoEstado) {
		this.estado = nuevoEstado;
	}

    @Override
    public void tomarNubeVoladora() {
		estadoNubeVoladora = new EstadoNubeVoladora();
		estado.tomarNubeVoladora(estadoNubeVoladora);
    }

    @Override
	public void cambiarCoordenadas(Coordenada coordenadaNueva) {
		estado = estado.cambiarCoordenadas(this, coordenadaNueva);
	}

    @Override
    public double porcentajeDeVida() {
        return 0;
    }

    @Override
    public String obtenerDireccionDeImagen() {
        return estado.obtenerDireccionDePersonaje();
    }
}

