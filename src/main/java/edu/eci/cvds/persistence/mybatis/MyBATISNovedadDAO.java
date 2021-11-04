package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.NovedadDAO;
import edu.eci.cvds.persistence.mybatis.mappers.NovedadMapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */
public class MyBATISNovedadDAO implements NovedadDAO {
    @Inject
    private NovedadMapper novedadMapper;

    @Override
    public List<Novedad> cargarNovedades() throws PersistenceException {
        try{
            return novedadMapper.consultarNovedades();
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar las novedades.", exception );
        }
    }

    @Override
    public List<Novedad> cargarNovedadesEquipo(int idEquipo) throws PersistenceException {
        try{
            return novedadMapper.consultarNovedadEquipo( idEquipo );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar las novedades del equipo con id: "+idEquipo, exception );
        }
    }

    @Override
    public List<Novedad> cargarNovedadesElemento(int idElemento) throws PersistenceException {
        try{
            return novedadMapper.consultarNovedadElemento( idElemento );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar las novedades del elemento con id: "+idElemento, exception );
        }
    }

    @Override
    public void guardarNovedadEquipo(Novedad novedad) throws PersistenceException {
        try{
            novedadMapper.addNovedad( novedad );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al insertar la novedad.", exception );
        }
    }

    @Override
    public List<Novedad> consultarPorElementos(ArrayList<Integer> search) throws PersistenceException {
        try{
            return novedadMapper.consultarPorElementos(search);
        }
        catch (Exception exception){
            throw new PersistenceException("Error al insertar la novedad.", exception );
        }
    }

    @Override
    public List<Novedad> consultarPorEquipos(ArrayList<Integer> search) throws PersistenceException {
        try{
            return novedadMapper.consultarPorEquipos(search);
        }
        catch (Exception exception){
            throw new PersistenceException("Error al insertar la novedad.", exception );
        }
    }

}
