package edu.eci.cvds.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Offer;
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
    public void registrarOferta(int offerId, String offerCategory, String name, String description) throws PersistenceException {
        try{
            offerMapper.registrarOferta(offerId, offerCategory, name, description);
        }catch (PersistenceException e) {
            throw new PersistenceException("Error al registrar la oferta");
        }
    }

    @Override
    public void changeStatus(Offer offer, String status) throws PersistenceException {
        try{
            offerMapper.changeStatus(offer, status);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new PersistenceException("Error al tratar de cambiar el estado de la oferta: " + offer.getName(), e);
        }
    }


}
