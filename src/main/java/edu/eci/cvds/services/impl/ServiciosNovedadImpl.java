package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.NovedadDAO;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.ServiciosNovedad;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */
public class ServiciosNovedadImpl implements ServiciosNovedad {
    @Inject
    private NovedadDAO novedadDAO;

    /*
    SELECT
     */
    @Override
    public List<Novedad> consultarNovedades() throws HistorialEquiposException {
        try{
            return novedadDAO.cargarNovedades();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Novedad> consultarPorElemento(int idElemento) throws HistorialEquiposException {
        try{
            return novedadDAO.cargarNovedadesElemento(idElemento);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Novedad> consultarPorEquipo(int idEquipo) throws HistorialEquiposException {
        try{
            return novedadDAO.cargarNovedadesEquipo(idEquipo);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Novedad> consultarPorElementos(ArrayList<Integer> search) throws HistorialEquiposException {
        try{
            return novedadDAO.consultarPorElementos(search);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Novedad> consultarPorEquipos(ArrayList<Integer> search) throws HistorialEquiposException {
        try{
            return novedadDAO.consultarPorEquipos(search);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    /*
    INSERT
     */
    @Override
    public void insertarNovedad(Novedad novedad) throws HistorialEquiposException {
        try{
            novedadDAO.guardarNovedadEquipo( novedad );
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }
}
