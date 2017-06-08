
public class Partida {

    private Tablero tablero; 
    private Equipo equipo1;
    private Equipo equipo2; 
	
    public Partida(string nombreEquipo1, string nombreEquipo2) { 
    this.tablero = new Tablero(); 
    this.equipo1 = new Equipo(nombreEquipo1); 
    this.equipo2 = new Equipo(nombreEquipo2); 
  }
  
  public Tablero obtenerTablero() { 
      return this.tablero; 
  } 

}
