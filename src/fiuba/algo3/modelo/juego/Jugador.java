package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.personajes.Personaje;

import java.util.Scanner;


public class Jugador {

    private String nombre;
    private Personaje[] equipo;
    private Jugador otroJugador;

    public Jugador(String unNombre){
        nombre = unNombre;
    }

    public void asignarOtroJugador(Jugador unJugador){ 
    	otroJugador = unJugador;
    }

    public void asignarEquipo(Personaje[] equipo) {
    	this.equipo = equipo; 
    }

    public Personaje[] obtenerEquipo() { 
    	return equipo;
    }

    public Jugador obtenerOtroJugador(){
    	return otroJugador;
    }
    
    public boolean jugadorTienePersonaje(String personajeBuscado){
    	for (int i = 0; i<this.equipo.length; i++){
    		if (this.equipo[i].obtenerNombre() == personajeBuscado){
    			return true;
    		}
    	}
    	return false;
    }
    
    public Personaje buscarPersonaje(String personajeBuscado){
    	for (int i = 0; i<this.equipo.length; i++){
    		if (this.equipo[i].obtenerNombre() == personajeBuscado){
    			return this.equipo[i];
    		}
    	}
		return null;
    }

    public boolean noTienePersonajesVivos() {
        boolean tiene = true;
        for (Personaje unPersonaje: equipo) {
            tiene = unPersonaje.estaVivo();
            if (tiene) return (!tiene);
        }
        return (!tiene);
    }

    public void elegirAccion(Tablero tablero) {
    	System.out.println("Elija accion a realizar haciendo click en el numero de la misma:\n");
    	System.out.println("1) Mover Personaje:\n");
    	System.out.println("2) Atacar con personaje:\n");
    	Scanner entradaEscaner = new Scanner (System.in);
    	if(entradaEscaner.nextInt() == 1){
        	this.accionMover(tablero);
        }else {
        	this.accionAtacar(tablero);
        }
    	entradaEscaner.close();
    }

	private void accionAtacar(Tablero tablero) {
		System.out.println("Elija con que personaje quiere atacar:\n");
		String personajeElegido = "";
        Scanner personajeEscaner = new Scanner (System.in);
        personajeElegido = personajeEscaner.nextLine();
        
        Personaje personajeAtacante = this.buscarPersonaje(personajeElegido);
        
        if (personajeAtacante != null){
        	System.out.println("Introduzca nombre del personaje al que quiere atacar:\n");
        	Scanner personajeObjetivoEscaner = new Scanner(System.in);
        	String nombrePersonajeObjetivo = personajeObjetivoEscaner.nextLine();
            
        	Personaje peronajeObjetivo = this.otroJugador.buscarPersonaje(nombrePersonajeObjetivo);
        	
        	if(peronajeObjetivo != null){
        		personajeAtacante.atacar(peronajeObjetivo);
        	}
        	personajeObjetivoEscaner.close();
        }
        personajeEscaner.close();
	}

	private void accionMover(Tablero tablero) {
		System.out.println("Elija al personaje que quiere mover:\n");
		String personajeElegido = "";
        Scanner personajeEscaner = new Scanner (System.in);
        personajeElegido = personajeEscaner.nextLine ();
        
        Personaje personajeAMover = this.buscarPersonaje(personajeElegido);
        
        if (personajeAMover != null){
        	System.out.println("Introduzca las coordenadas a las que quiere mover al personaje:\n");
        	System.out.println("Fila:\n");
        	Scanner filaEscaner = new Scanner (System.in);
        	int filaElegida = filaEscaner.nextInt();
               
        	System.out.println("Columna:\n");
        	Scanner columnaEscaner = new Scanner (System.in);
        	int columnaElegida = columnaEscaner.nextInt();
               
        	tablero.moverPersonaje(personajeAMover, filaElegida, columnaElegida);
        	filaEscaner.close();
        	columnaEscaner.close();        
        }
        personajeEscaner.close();
    }
	
}