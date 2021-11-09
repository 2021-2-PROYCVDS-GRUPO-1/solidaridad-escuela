package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.OfferDAO;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.ServicesException;

public class OfferServicesImpl implements OfferServices {
    @Inject
    private OfferDAO offerDAO;

    @Override
    public Offer getOfferByName(String name) throws ServicesException {
        try{
            return offerDAO.getOfferByName(name);
        }
        catch (PersistenceException e){
            throw new ServicesException( e.getMessage(),e );
        }
    }

    @Override
    public Offer getOfferById(int offerId) throws ServicesException {
        try{
            return offerDAO.getOfferByID(offerId);
        }
        catch (PersistenceException e){
            throw new ServicesException( e.getMessage(),e );
        }
    }

    @Override
    public void registrarOferta(int offerCategory, String name, String description, int userId) throws ServicesException {
        try{
            offerDAO.registrarOferta(offerCategory, name, description, userId);
        }
        catch (PersistenceException e){
            throw new ServicesException(e.getMessage(),e );
        }
    }

    @Override
    public void changeStatus(Offer offer, String status) throws ServicesException {
        try{
            offerDAO.changeStatus(offer,status);
        }
        catch (PersistenceException e){
            throw new ServicesException(e.getMessage(),e );
        }

    }
}
