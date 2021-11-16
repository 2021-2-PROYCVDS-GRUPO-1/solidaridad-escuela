package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.OfferDAO;
import edu.eci.cvds.persistence.mybatis.mappers.OfferMapper;

import java.util.List;

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
    public Offer getOfferByName(String name) throws PersistenceException {
        try{
            return offerMapper.getOfferByName(name);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la oferta con el nombre: " + name);
        }
    }

    @Override
    public Offer getOfferByID(int id) throws PersistenceException {
        try{
            return offerMapper.getOfferByID(id);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al consultar la oferta con el ID: " + id);
        }
    }

    @Override
    public void createOffer(int offerCategory, String name, String description, int userId) throws PersistenceException {
        try{
            offerMapper.createOffer(offerCategory, name, description,  userId);
        }catch (PersistenceException e) {
            throw new PersistenceException("Error al registrar la oferta");
        }
    }

    @Override
    public void changeStatus(String offerName, String status) throws PersistenceException {
        try{
            offerMapper.changeStatus(offerName, status);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al tratar de cambiar el estado de la oferta: " + offerName, e);
        }
    }

    @Override
    public List<Offer> getByStatus(String status) throws PersistenceException {
        try{
            return offerMapper.getByStatus(status);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al consultar las ofertas");
        }
    }

    @Override
    public List<Offer> getByUserId(int userId) throws PersistenceException {
        try{
            return offerMapper.getByUserId(userId);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al consultar las ofertas");
        }
    }


}
