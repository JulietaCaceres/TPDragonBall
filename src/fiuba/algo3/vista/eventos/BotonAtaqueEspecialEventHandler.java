package fiuba.algo3.vista.eventos;

import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.personajes.ExceptionAtaqueEspecial;
import fiuba.algo3.modelo.personajes.GuerreroZConvertidoEnChocolateException;
import fiuba.algo3.vista.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import fiuba.algo3.modelo.juego.excepciones.*;
import fiuba.algo3.vista.ContenedorTablero;

public class BotonAtaqueEspecialEventHandler implements EventHandler<ActionEvent> {

        private ContenedorTablero contenedorTablero;
        private Equipo unPersonaje = null;
        private Juego juego;
        private Coordenada unaCoordenada;

        public BotonAtaqueEspecialEventHandler(Juego juego, ContenedorTablero contenedorTablero) {
            this.juego = juego;
            this.contenedorTablero = contenedorTablero;
        }

        public void recibirContenido(IUbicable unContenido){
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
            { try { juego.obtenerTurno().realzarAtaqueEspecialA(unPersonaje, unaCoordenada.obtenerCasillero().obtenerPersonaje());
                }catch (ExceptionNoHayPersonajeEnElCasilleroSeleccionado e) {
                    mostrarAlertaNoSeleccionoPersonajeParaAtacar();
                    unPersonaje = null;
                }catch (ExceptionElPersonajeNoLePertenece e) {
                    mostrarAlertaPerteneceOtroJugador();
                    unPersonaje = null;
                } catch (GuerreroZConvertidoEnChocolateException e) {
                    this.mostrarGuerreroZConvertidoEnChocolateEsception();
                    unPersonaje = null;
                    //return;
                } catch (ExceptionNoAlcanzaAlOponente e) {
                    this.mostrarExcepcionNoAlcanzaAlOponente();
                    unPersonaje = null;
                    //return;
                } catch (ExceptionAtaqueAMismoEquipo e) {
                    this.mostrarExcepcionAtaqueAlMismoEquipo();
                    unPersonaje = null;
                    //return;
                }catch (ExceptionAtaqueEspecial e){
                mostrarAlertaNoTieneLasCondicionesParaElAtaqueEspecial();
                unPersonaje = null;
            }
            }
            this.contenedorTablero.dibujar(juego);
            Controlador.getControlador().update();
            unPersonaje = null;
            unaCoordenada = null;
        }

    private void mostrarAlertaNoTieneLasCondicionesParaElAtaqueEspecial() {
     Alert alert = new Alert(AlertType.INFORMATION);
     alert.setTitle("Error");
     String mensaje = "No tiene las condiciones para realizar el atque especial";
     alert.setContentText(mensaje);
     alert.show();
    }


    private void mostrarAlertaNoSeleccionoPersonajeParaAtacar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("No sepuede atacar ");
        String mensaje = "El personaje no puede atacar ya que no ha elegido un personaje"
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }



    private void mostrarExcepcionAtaqueAlMismoEquipo() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Error");
        alert.setHeaderText("Ataque Invalido");
        String mensaje = "El personaje no puede atacar ya que el oponete es de su mismo equipo."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();

    }

    private void mostrarExcepcionNoAlcanzaAlOponente() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Ataque Invalido");
        String mensaje = "El personaje no puede atacar ya que el oponete se encuentra muy lejos."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();

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
