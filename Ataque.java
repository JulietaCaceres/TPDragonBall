package Juego;

/**
 * Created by july on 07/06/17.
 */
public class Ataque {

    public  void atacar(Personaje atacante, Personaje  oponente , Tablero tablero,double poderDeAtaque, int distanciaAtaque )
    {
        this.validarEquipo(atacante, oponente);
        this.validarDistancia(atacante, oponente, tablero, distanciaAtaque);
        oponente.recibirDaño(poderDeAtaque);
    }

    public void validarEquipo(Personaje atacante, Personaje oponente)
    {
        if(atacante.obtenerEquipo() != oponente.obtenerEquipo())
            throw new SonDelMismoEquipoException();
    }

    public void  validarDistancia(Personaje atacante, Personaje oponente, Tablero tablero, int distanciaAtaque)
    {
        int [] casilleroAtacante = tablero.obtenerCoordenadasDe(atacante);
        int [] casilleroOponente = tablero.obtenerCoordenadasDe(oponente);
        if ( (distanciaAtaque <= Math.abs(casilleroOponente[0] - casilleroAtacante[0])) &&
           (distanciaAtaque <= Math.abs(casilleroOponente[1] - casilleroAtacante[1])))
            throw new laDistanciaNoEsValidaException();
    }
}
