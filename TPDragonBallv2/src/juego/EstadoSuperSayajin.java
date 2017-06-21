package juego;

public class EstadoSuperSayajin extends Estado {

	public EstadoSuperSayajin(Estado estadoAnterior) {

		this.posicion = estadoAnterior.obtenerPosicion();
		this.poderDePelea = 60;
		this.distanciaDeAtaque = 4;
		this.velocidad = 5;
	}
}
