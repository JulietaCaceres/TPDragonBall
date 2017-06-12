package modelo.Juego;

import modelo.Personajes.Personaje;

/**
 * Created by July on 07/06/17.
 */
public class Ataque {

    public  void atacar(Personaje atacante, Personaje  oponente , Tablero tablero,double poderDeAtaque, int distanciaAtaque )
    {
        this.validarDistancia(atacante, oponente, tablero, distanciaAtaque);
        oponente.recibirDanioDe(atacante, poderDeAtaque);
    }

    public void  validarDistancia(Personaje atacante, Personaje oponente, Tablero tablero, int distanciaAtaque)
    {
        int [] casilleroAtacante = tablero.obtenerCoordenadasDe(atacante);
        int [] casilleroOponente = tablero.obtenerCoordenadasDe(oponente);
        if ( (distanciaAtaque <= Math.abs(casilleroOponente[0] - casilleroAtacante[0])) &&
           (distanciaAtaque <= Math.abs(casilleroOponente[1] - casilleroAtacante[1])))
            throw new LaDistanciaNoEsValidaException();
    }
}