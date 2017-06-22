package fiuba.algo3.modelo.personajes;
import fiuba.algo3.modelo.juego.*;

public class Goku extends Personaje implements GuerrerosZ{
	
	private EstadoGoku estado;
	
	public Goku(){
		this.nombre = "Goku";
		this.puntosDeVida = 500;
		this.estado = new EstadoGokuNormal();
		this.estadoEsferaDragon = null;
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

	public double aumentoDePoderPorAdrenalina() {
		double aumento = 1;
		if(this.puntosDeVida < 150){
			aumento = 1.2;
		}
		return aumento;
	}

	@Override
	public void realizarAtaqueEspecial(GuerrerosZ oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void realizarAtaqueEspecial(EnemigosDeLaTierra oponente) {
		estado.kamehameha(this, oponente);
	}

	@Override
	public void convertirseEnChocolate() {
		estado.convertir(this);
	}
	
	@Override
	public void recibirAtaqueDe(Coordenada coordenadasDeAtacante, double poderDePelea, int alcanceDeAtaque) {
		estado.recibirAtaque(this, coordenadasDeAtacante, alcanceDeAtaque, poderDePelea);
	}
	
	public void asignarEstado(EstadoGoku nuevoEstado){
		this.estado = nuevoEstado;
	}

	@Override
	public void mover(Coordenada coordenada) {
		estado.mover(this, coordenada);
		tomarConsumibleDe(coordenada.obtenerCasillero());
	}

	@Override
	public void tomarNubeVoladora() {

			estadoNubeVoladora = new EstadoNubeVoladora();
			estado.tomarNubeVoladora(estadoNubeVoladora);

	}

	@Override
    public void cambiarCoordenadas(Coordenada nuevaCoordenada) {
		estado.cambiarCoordenadas(coordenada, nuevaCoordenada);
    }


}
