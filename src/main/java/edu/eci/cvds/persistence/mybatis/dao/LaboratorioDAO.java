package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.persistence.PersistenceException;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/6/2020
 */
public interface LaboratorioDAO {
    /**
     * Metodo que consulta los laboratorios existentes en la base de datos
     * @throws PersistenceException, en caso que ocurra un error de persistencia
     */
    public List<Laboratorio> consultarLaboratorios() throws PersistenceException;

    public Laboratorio consultarLaboratorio( int idLab )throws PersistenceException;
    public List<Laboratorio> consultarNumeroLaboratoriosPorEstado( String estado) throws PersistenceException;

    public void registrarLaboratorio(int idLab, String nombreLab) throws PersistenceException;

    public void cambiarEstado(Laboratorio laboratorio, String estado) throws PersistenceException;

}
