package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Need;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.NeedDAO;
import edu.eci.cvds.persistence.mybatis.mappers.NeedMapper;

import java.util.List;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */

public class MyBATISNeedDAO implements NeedDAO {
    @Inject
    private NeedMapper needMapper;

    @Override
    public void addNecessity(int categoryId,
                             String name,
                             String description,
                             String urgency,
                             String status,
                             int createdByUser) throws PersistenceException {
        try {
            needMapper.registerNeed(categoryId,
                    name,
                    description,
                    urgency,
                    status,
                    createdByUser);
        } catch (PersistenceException e){
            if(e.getMessage().contains("el numero de necesidades registradas alcanzo su maximo")){
                throw new PersistenceException("Número máximo de necesidades registradas", e);
            }
            else {
                throw new PersistenceException("Error al registrar la necesidad", e);
            }
        }
    }

    @Override
    public void updateStatus(String name, String status) throws PersistenceException{
        try {
            needMapper.updateStatus(name,status);
        }catch (Exception exception){
            throw new PersistenceException("Error al actualizar el estado de la enecesidad");
        }
    }

    @Override
    public Need getNeedByName(String name) throws PersistenceException {
        try{
            return needMapper.getNeedByName(name);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la necesidad con el nombre: " + name);
        }
    }

    @Override
    public Need getNeedByID(int id) throws PersistenceException {
        try{
            return needMapper.getNeedByID(id);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la necesidad con el ID: " + id);
        }
    }

    @Override
    public List<Need> getNeeds() throws PersistenceException {
        try{
            return needMapper.getNeeds();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar las necesidades: ");
        }
    }

}
