package juego;

public class EstadoKaioKen extends Estado {

	public EstadoKaioKen(Estado estadoAnterior) {

		this.posicion = estadoAnterior.posicion;
		this.poderDePelea = 40;
		this.distanciaDeAtaque = 4;
		this.velocidad = 5;
	}
}
