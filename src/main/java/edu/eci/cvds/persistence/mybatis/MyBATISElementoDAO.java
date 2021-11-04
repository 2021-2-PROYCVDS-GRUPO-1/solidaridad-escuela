package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.ElementoDAO;
import edu.eci.cvds.persistence.mybatis.mappers.ElementoMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 31/10/2020
 */
public class MyBATISElementoDAO implements ElementoDAO {
    @Inject
    private ElementoMapper elementoMapper;

    @Override
    public void registrarElemento(Elemento elemento)  throws PersistenceException {
        try{
            elementoMapper.registrarElemento(elemento);
        }
        catch (Exception exception){
            throw new PersistenceException("Error al registar el elemento", exception );
        }
    }

    @Override
    public ArrayList<Elemento> consultarElementos()  throws PersistenceException {
        try{
            return elementoMapper.consultarElementos();
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar los elementos", exception );
        }
    }

    @Override
    public void asociarEquipo(int idElemento, Integer idEquipo)  throws PersistenceException {
        try{
            elementoMapper.asociarEquipo(idElemento,idEquipo);
        }
        catch (Exception exception){
            throw new PersistenceException("Error al asociar el equipo con id: " + idEquipo, exception );
        }
    }

    @Override
    public List<Elemento> buscarElemento(String elemento) throws PersistenceException{
        try{
            return elementoMapper.buscarElemento(elemento);
        }
        catch (Exception e){
            throw new PersistenceException("Error al buscar el elemento", e );
        }
    }

    @Override
    public void cambiarEstadoElemento(int idElemento, String change) throws PersistenceException {
        try{
            elementoMapper.cambiarEstadoElemento( idElemento, change );
        }
        catch (Exception e){
            throw new PersistenceException("Error al dar de baja el elemento con id: "+idElemento, e );
        }
    }
}
