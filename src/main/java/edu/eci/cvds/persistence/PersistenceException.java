package edu.eci.cvds.persistence;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 *
 * Class in charge of handling the persistence exceptions
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