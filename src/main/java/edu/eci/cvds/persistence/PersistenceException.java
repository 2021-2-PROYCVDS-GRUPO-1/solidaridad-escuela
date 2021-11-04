package edu.eci.cvds.persistence;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/28/2020
 *
 * Clase que representa las posibles excepciones que pueden encontrarse al momento de estar realizando persistencia
 */
public class PersistenceException extends Exception {
    public PersistenceException(String message,Exception exception){
        super(message,exception);
    }
    public PersistenceException(){
        super();
    }
    public PersistenceException(String message){
        super(message);
    }
}