package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 31/10/2020
 */
public interface ElementoDAO {
    public void registrarElemento(Elemento elemento) throws PersistenceException;
    public ArrayList<Elemento> consultarElementos()  throws PersistenceException;
    public void asociarEquipo(int idElemento,Integer idEquipo)  throws PersistenceException;
    public List<Elemento> buscarElemento(String elemento) throws PersistenceException;
    public void cambiarEstadoElemento( int idElemento, String change ) throws PersistenceException;
}