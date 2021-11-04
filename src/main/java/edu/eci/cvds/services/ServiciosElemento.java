package edu.eci.cvds.services;

import edu.eci.cvds.entities.Elemento;
import java.util.List;
/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */
public interface ServiciosElemento {
    /*
    SELECT / Consultar /
     */
    public List<Elemento> consultarElementos() throws HistorialEquiposException;

    public List<Elemento> buscarElemento(String elemento) throws  HistorialEquiposException;

    /*
    UPDATE / Cambiar /
     */
    public void cambiarEstadoElemento( int idUsuario, Elemento elemento )throws HistorialEquiposException;

    public void relacionarElementoEquipo(int idElemento, Integer idEquipo) throws HistorialEquiposException;

    public void asociarElementoEquipo(int idUsuario,List<Elemento> elementosSeleccionados,Integer idEquipo ) throws HistorialEquiposException;

    /*
    INSERT
     */
    public void insertarElemento(String tipo, String nombre, String descripcion) throws HistorialEquiposException;
}
