package modelo.Juego;

public class ExcepcionAtaque extends RuntimeException {

   public ExcepcionAtaque (String mensaje)
    {
        super(mensaje);
    }

    static void laDistanciaNoEsValidaException() throws Exception
    {
        throw new ExcepcionAtaque("El oponente se encuentra en una distancia superior a su distancia de ataque");

    }

    static void SonDelMismoEquipoException() throws Exception
    {
        throw new ExcepcionAtaque(" No se puede atacar a personajes de un mismo equipo"); 
    }
}

