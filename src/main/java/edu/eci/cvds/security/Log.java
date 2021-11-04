package edu.eci.cvds.security;

import edu.eci.cvds.services.HistorialEquiposException;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 *
 * Interfaz la cual representa uno de los mecanismo de seguridad para el logueo de los usuarios
 */
public interface Log {
    /**
     * Metodo que se encarga del login del usuario
     * @param correo, String que representa el correo ingresado por el usuario
     * @param constraseña, String constraseña que fue ingresada por el usuario
     * @param recordarme, boolean que representa si el usuario se va a recordar
     */
    public void login(String correo, String constraseña,boolean recordarme) throws HistorialEquiposException;

    /**
     * Metodo encargado de salir de la cuenta
     */
    public void logout() throws HistorialEquiposException;

    /**
     * Metodo encargado de saber si el usuario esta logueado
     */
    public boolean isLogged();
}
