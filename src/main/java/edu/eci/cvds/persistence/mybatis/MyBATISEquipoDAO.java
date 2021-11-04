package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.EquipoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.EquipoMapper;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/2/2020
 */
public class MyBATISEquipoDAO implements EquipoDAO {
    @Inject
    private EquipoMapper equipoMapper;

    @Override
    public void registrarEquipo(int idEquipo,int idLab) throws PersistenceException {
        try{
            equipoMapper.registrarEquipo(idEquipo,idLab);
        }
        catch (Exception exception){
            throw new PersistenceException("Surgio un error al Registrar el equipo.",exception);
        }
    }

    @Override
    public ArrayList<Equipo> consultarEquipos() throws PersistenceException {
        try{
            return equipoMapper.consultarEquipos();
        }
        catch (Exception exception){
            throw new PersistenceException("Surgio un error al consultar los equipos.",exception);
        }
    }

    @Override
    public void generarNovedades(int idEquipo, int idElemento, String titulo, String detalle, int idUsuario) throws PersistenceException {
        try{
            equipoMapper.generarNovedades(idEquipo, idElemento, titulo, detalle, idUsuario);
        }
        catch (Exception exception){
            throw new PersistenceException("Surgio un error al Registrar el equipo.",exception);
        }
    }

    @Override
    public void asociar(int idLab, int idEquipo) throws PersistenceException {
        try{
            equipoMapper.asociar(idLab, idEquipo);
        }
        catch (Exception exception){
            throw new PersistenceException("Error al asociar equipo con lab.",exception);
        }
    }
    @Override
    public List<Equipo> consultarEquiposDisponibles() throws PersistenceException{
        try{
            return equipoMapper.consultarEquiposDisponibles();
        }
        catch (Exception e){
            throw new PersistenceException("Error al consultar equipos disponibles.",e);
        }
    }

    @Override
    public Equipo consultarEquipo(int idEquipo) throws PersistenceException{
        try{
            return equipoMapper.consultarEquipo(idEquipo);
        }
        catch (Exception e) {
            throw new PersistenceException("Error al consultar equipos disponibles.", e);
        }
    }

    @Override
    public List<Equipo> consultarEquiposActivos() throws PersistenceException {
        try{
            return equipoMapper.consultarEquiposActivos();
        }
        catch (Exception e) {
            throw new PersistenceException("Error al consultar equipos disponibles.", e);
        }
    }

    @Override
    public void cambiarEstadoEquipo(int idEquipo, String change) throws PersistenceException{
        try{
            equipoMapper.cambiarEstado(idEquipo, change);
        }
        catch (Exception e) {
            throw new PersistenceException("Error al cambiar estado del equipo.", e);
        }
    }
}
