package modelo.Juego;

public class Equipo {

    private String nombre;
    private String[] participantes; 
    
    public Equipo(String[] participantes, String nombreEquipo) { 
        this.nombre = nombreEquipo;
        this.participantes = participantes; 
    } 
   
    public Equipo() { 

    }

}
