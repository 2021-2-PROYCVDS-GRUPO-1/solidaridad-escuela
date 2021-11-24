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

    // CREATE
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

    // READ
    @Override
    public List<Need> getAllNeeds() throws PersistenceException {
        try{
            return needMapper.getAllNeeds();
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la lista de necesidades");
        }
    }

    @Override
    public List<Need> getByStatus(String status) throws PersistenceException {
        try{
            return needMapper.getByStatus(status);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al consultar las ofertas");
        }
    }

    // UPDATE
    @Override
    public void updateStatus(int id, String status) throws PersistenceException{
        try {
            needMapper.updateStatus(id, status);
        }catch (Exception exception){
            throw new PersistenceException("Error al actualizar el estado de la necesidad");
        }
    }

    // DELETE
    @Override
    public void deleteNeed(int needId) throws PersistenceException {
        try{
            needMapper.deleteNeed(needId);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al eliminar la necesidad con ID: " + needId);
        }
    }
}
