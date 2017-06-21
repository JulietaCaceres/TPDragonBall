package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.*;

public class Cell extends Personaje implements EnemigosDeLaTierra{
	
	private EstadoCell estado;
	
	public Cell(){
		this.nombre = "Cell";
		this.puntosDeVida = 500;
		this.estado = new EstadoCellNormal();
	}
	
	public void aumentarVidaEn(double vida){
		this.puntosDeVida += vida;
	}
	
	public void recibirDanio(double danio){
		estado.recibirDanio(this, danio);
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
		estado.absorberVida(this, oponente);
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}
	
	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		estado.recibirAtaque(this, coordenadasDeAtacante, alcanceDeAtaque, poderDePelea);
	}

	public void asignarEstado(EstadoCell nuevaForma) {
		this.estado = nuevaForma;
	}

    @Override
    public void cambiarCoordenadas(Coordenada coordenadaNueva) {
        estado.cambiarCoordenadas(coordenada,coordenadaNueva);
    }

    @Override
	public double porcentajeDeVida() {
		return this.puntosDeVida*100/500;
	}
}