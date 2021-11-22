package edu.eci.cvds.services;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 17/10/2021
 */
public class ServicesException extends Exception {
    public static final  String USER_NOT_FOUND = "No existe un usuario con ese id en la base de datos.";
    // public static final  String NO_LAB = "No existe un laboratorio con ese id en la base de datos.";
    // public static final  String NO_ElEMENTO = "No existe un elemento con ese id en la base de datos.";
    // public static final  String NO_EQUIPO = "No existe un equipo con ese id en la base de datos.";
    // public static final String NO_SELECCION_CERRAR = "Debe seleccionar algun elemento para cambiar su estado.";

    public ServicesException(String message,Exception exception){
        super(message,exception);
    }
    public ServicesException(){
        super();
    }
    public ServicesException(String message){
        super(message);
    }
}
