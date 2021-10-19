package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.User;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.OfferDAO;
import edu.eci.cvds.persistence.mybatis.mappers.OfferMapper;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public class MyBATISOfferDAO implements OfferDAO {
    @Inject
    private OfferMapper offerMapper;


    @Override
    public User getOfferByName(String name) throws PersistenceException {
        try{
            return offerMapper.getOfferByName(name);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la oferta con el nombre: " + name);
        }
    }

    @Override
    public User getOfferByID(String id) throws PersistenceException {
        try{
            return offerMapper.getOfferByID(id);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la oferta con el ID: " + id);
        }
    }
}
