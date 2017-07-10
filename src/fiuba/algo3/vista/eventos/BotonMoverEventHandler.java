package fiuba.algo3.vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.personajes.GuerreroZConvertidoEnChocolateException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import fiuba.algo3.modelo.juego.excepciones.*;
import fiuba.algo3.vista.ContenedorTablero;
import fiuba.algo3.vista.Controlador;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private Equipo unPersonaje = null;
    private Coordenada unaCoordenada= null;
    private ContenedorTablero contenedorTablero;
    private Juego juego;

    public BotonMoverEventHandler(Juego juego, ContenedorTablero contenedorTablero) {
        this.juego = juego;
        this.contenedorTablero = contenedorTablero;
    }

    public void recibirContenido(IUbicable unContenido)
    {

        if (!unContenido.esUnPersonaje()){
            unaCoordenada = unContenido.obtenerCoordenadas();

        }
        if (unContenido.esUnPersonaje() && (unPersonaje == null)){
            unPersonaje = ( (Equipo) unContenido );
        }else{
            unaCoordenada = unContenido.obtenerCoordenadas();
        }
    }

    @Override
    public void handle(ActionEvent arg0) {
        if ((unPersonaje == null) || (unaCoordenada == null)){
            this.mostrarFaltaElegirAlgo();
        }
        if ((unPersonaje != null) && (unaCoordenada != null))
        {  try {
                juego.obtenerTurno().moverPersonaje(unPersonaje,unaCoordenada.obtenerFila(),unaCoordenada.obtenerColumna());
            }catch (ExceptionElPersonajeNoLePertenece e){
                mostrarAlertaPerteneceOtroJugador();
                unPersonaje = null;
            }
            catch (ExceptionFueraDeRango e){
                mostrarAlertaFueraDeRango();
                unPersonaje = null;
            }catch (ExceptionLaDistanciaEntreLasCoordenadasNoEsValida e){
                mostrarExcepcionDistanciaEntreLasCoordenadasNoEsValida();
                unPersonaje = null;
            }catch (ExcptionLaCoordenadaLePerteneceAUnCasilleroOcupado e){
                mostrarExcepcionElCasilleroEstaOcupado();
                unPersonaje = null;
            }catch (GuerreroZConvertidoEnChocolateException e){
                mostrarGuerreroZConvertidoEnChocolateEsception();
                unPersonaje = null;
            }
        }
        this.contenedorTablero.dibujar(juego);
        Controlador.getControlador().update();
        unPersonaje = null;
        unaCoordenada = null;

    }


    private void mostrarGuerreroZConvertidoEnChocolateEsception() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Personaje Chocolate");
        String mensaje = "El personaje no puede moverse ya que ha sido convertido en chocolate."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();

    }

    private void mostrarExcepcionElCasilleroEstaOcupado() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Casillero Ocupado");
        String mensaje = "El personaje no puede moverse hacia el casillero seleccionado porque esta ocupado."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();

    }

    private void mostrarExcepcionDistanciaEntreLasCoordenadasNoEsValida() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Distancia invalida");
        String mensaje = "El personaje no puede alcanzar la posicion seleccionada."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();


    }

    private void mostrarAlertaFueraDeRango(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Fuera de rango");
        String mensaje = "El personaje no puede alcanzar la posici�n seleccionada."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void mostrarFaltaElegirAlgo(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Falta elegir algo");
        String mensaje = "HOLA";
        if ((this.unPersonaje == null) && (this.unaCoordenada == null)){
            mensaje = "Ambos son nulos";
        }else if (this.unPersonaje == null){
            mensaje = "El personaje es nulo. POSICION fila: " + this.unaCoordenada.obtenerFila() + "columna:" + this.unaCoordenada.obtenerColumna();
        }else if (this.unaCoordenada == null){
            mensaje = "posicion nula. PERSONAJE columna: " + this.unPersonaje.obtenerCoordenadas().obtenerFila()
                    + "fila" + this.unPersonaje.obtenerCoordenadas().obtenerColumna();
        }
        alert.setContentText(mensaje);
        alert.show();
    }


    private void mostrarAlertaPerteneceOtroJugador(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Personaje del otro equipo");
        String mensaje = "Ha elegido un personaje del otro jugador."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }



}

