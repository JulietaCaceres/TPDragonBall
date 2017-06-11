package modelo;

public class Equipo {

    private string nombre;
    private string[] participantes; 
    
    public Equipo(string[] participantes, string nombreEquipo) { 
        this.nombre = nombreEquipo;
        this.participantes = participantes; 
    } 

}
