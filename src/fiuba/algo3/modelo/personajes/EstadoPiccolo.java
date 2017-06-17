package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.juego.Coordenada;
import fiuba.algo3.modelo.juego.EnemigosDeLaTierra;

public interface EstadoPiccolo {
	public abstract void atacar(Piccolo piccolo, EnemigosDeLaTierra oponente);

	public abstract void recibirDanio(Piccolo piccolo, double danio);

	public abstract void makankosappo(Piccolo piccolo, EnemigosDeLaTierra oponente);

	public abstract void mover(Piccolo piccolo, Coordenada coordenadaInicial, Coordenada coordenadaFinal);
}
