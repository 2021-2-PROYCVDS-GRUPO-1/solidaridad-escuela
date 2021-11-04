package edu.eci.cvds.services;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 *
 * Clase que representa las posibles excepciones que pueden encontrarse en el servicio Historial de Equipos
 */
public class HistorialEquiposException extends Exception{
    public static final  String NO_CLIENTE = "No existe un cliente con ese id en la base de datos.";
    public static final  String NO_LAB = "No existe un laboratorio con ese id en la base de datos.";
    public static final  String NO_ElEMENTO = "No existe un elemento con ese id en la base de datos.";
    public static final  String NO_EQUIPO = "No existe un equipo con ese id en la base de datos.";;
    public static final String NO_SELECCION_CERRAR = "Debe seleccionar algun elemento para cambiar su estado.";

    public HistorialEquiposException(String message,Exception exception){
        super(message,exception);
    }
    public HistorialEquiposException(){
        super();
    }
    public HistorialEquiposException(String message){
        super(message);
    }
}
