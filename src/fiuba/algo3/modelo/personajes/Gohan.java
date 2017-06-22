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

	@Override
	public void atacar(GuerrerosZ oponente) {
		throw new ExceptionAtaqueAMismoEquipo();
	}

	@Override
	public void atacar(EnemigosDeLaTierra oponente) {
		estado.atacar(this, oponente);
	}
	
	public double obtenerVidaDeGoku(){
		double vida = 200;
		if(this.referenciaAGoku != null){
			vida = this.referenciaAGoku.obtenerPuntosDeVida();
		}
		return vida;
	}
	
	public double obtenerVidaDePiccolo(){
		double vida = 200;
		if(this.referenciaAPiccolo != null){
			vida = this.referenciaAPiccolo.obtenerPuntosDeVida();
		}
		return vida;
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

	}

	@Override
    public void cambiarCoordenadas(Coordenada coordenadaNueva) {
        estado.cambiarCoordenadas(coordenada,coordenadaNueva);
    }

	@Override
	public double porcentajeDeVida() { return this.puntosDeVida*300/100; }

   /* @Override
	public void asignarCoordenadas(Coordenada coordenada) {
		estado.asignarCoordenadas(this, coordenada);
		tomarConsumibleDe(coordenada.obtenerCasillero());
	}*/
}