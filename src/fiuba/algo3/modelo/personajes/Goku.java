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

	@Override
	public void referenciarAGoku(GuerrerosZ goku) {

	}

	@Override
	public void referenciarAPiccolo(GuerrerosZ piccolo) {

	}

	public void asignarEstado(EstadoGoku nuevoEstado){
		this.estado = nuevoEstado;
	}

	@Override
	public void tomarNubeVoladora() {
		estadoNubeVoladora = new EstadoNubeVoladora();
		estado.tomarNubeVoladora(estadoNubeVoladora);
	}

	@Override
    public void cambiarCoordenadas(Coordenada nuevaCoordenada) {
		estado = estado.cambiarCoordenadas(this, nuevaCoordenada);

	}

    @Override
    public double porcentajeDeVida() {
			return this.puntosDeVida*100/500;
	}

	public boolean porcentajeDeVidaMenor30() {
		return (porcentajeDeVida() < 30);
	}

	@Override
	public boolean porcentajeDeVidaMenosde20() {
		return false;
	}
}
