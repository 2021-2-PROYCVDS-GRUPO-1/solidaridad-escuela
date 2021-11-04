package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */
public interface NovedadMapper {

    /**
     * Metodo que consulta todas la novedades que se encuentran en la base de datos ordenada de la mas reciente a las mas antigua.
     * @return List<Novedad>, lista de novedades.
     */
    public List<Novedad> consultarNovedades() throws PersistenceException;

    /**
     * Metodo que consulta el historial de novedades que ha tenido un equipo especifico
     * @param idEquipo, int que representa el identificador del equipo
     * @return  List<Novedad>, la lista de novedades que posee ese equipo
     */
    public List<Novedad> consultarNovedadEquipo( @Param("idEquipo") int idEquipo )  throws PersistenceException;


    /**
     * Metodo que consulta el historial de novedades que ha tenido un elemento especifico
     * @param idElemento, int que representa el identificador del elemento
     * @return  List<Novedad>, la lista de novedades que posee ese equipo
     */
    public List<Novedad> consultarNovedadElemento( @Param("idElemento") int idElemento ) throws PersistenceException;

    /**
     * Metodo que se encarga de añadir una nueva novedad base de datos
     * @param novedad, Novedad novedad a insertar en la base de datos
     */
    public void addNovedad( @Param("novedad") Novedad novedad ) throws PersistenceException;

    public List<Novedad> consultarPorElementos(@Param("search") ArrayList<Integer> search) throws PersistenceException;

    public List<Novedad> consultarPorEquipos(@Param("search") ArrayList<Integer> search) throws PersistenceException;

}
