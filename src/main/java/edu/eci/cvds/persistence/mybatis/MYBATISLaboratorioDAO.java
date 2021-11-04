package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.LaboratorioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.LaboratorioMapper;

import javax.inject.Inject;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/6/2020
 */
public class MYBATISLaboratorioDAO implements LaboratorioDAO {
    @Inject
    private LaboratorioMapper laboratorioMapper;

    @Override
    public List<Laboratorio> consultarLaboratorios() throws PersistenceException {
        try{
            return laboratorioMapper.consultarLaboratorios();
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar los laboratorios en la base de datos",exception );
        }

    }

    @Override
    public Laboratorio consultarLaboratorio(int idLab) throws PersistenceException {
        try{
            return laboratorioMapper.consultarLaboratorio( idLab );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar el laboratorio con id: "+idLab,exception );
        }
    }

    @Override
    public List<Laboratorio> consultarNumeroLaboratoriosPorEstado(String estado) throws PersistenceException {
        try{
            return laboratorioMapper.consultarNumeroLaboratoriosPorEstado( estado );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar los laboratorios ",exception );
        }
    }

    @Override
    public void registrarLaboratorio(int idLab, String nombreLab) throws PersistenceException {
        try{
            laboratorioMapper.registrarLaboratorio(idLab, nombreLab);
        }
        catch (Exception exception){
            throw new PersistenceException("Error al tratar de registrar el laboratorio: "+ nombreLab,exception );
        }
    }

    @Override
    public void cambiarEstado(Laboratorio laboratorio, String estado) throws PersistenceException {
        try{
            laboratorioMapper.cambiarEstado(laboratorio, estado);
        }
        catch (Exception exception){
            exception.printStackTrace();
            throw new PersistenceException("Error al tratar de cambiar el estado del laboratorio: "+ laboratorio.getNombre(),exception );
        }
    }

}
