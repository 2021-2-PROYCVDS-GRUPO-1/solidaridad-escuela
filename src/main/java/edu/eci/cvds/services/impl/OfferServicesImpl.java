package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.OfferDAO;
import edu.eci.cvds.services.OfferServices;
import edu.eci.cvds.services.ServicesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
    public List<Offer> getByStatus(String status) throws ServicesException {
        try{
            return offerDAO.getByStatus(status);
        }
        catch (PersistenceException e){
            throw new ServicesException( e.getMessage(), e );
        }
    }

    @Override
    public List<Offer> getByUserID(int userId) throws ServicesException {
        try{
            return offerDAO.getByUserId(userId);
        }
        catch (PersistenceException e){
            throw new ServicesException( e.getMessage(), e );
        }
    }

    @Override
    public void createOffer(int offerCategory, String name, String description, int userId) throws ServicesException {
        try{
            offerDAO.createOffer(offerCategory, name, description, userId);
        }
        catch (PersistenceException e){
            throw new ServicesException(e.getMessage(),e );
        }
    }

    @Override
    public void changeStatus(String offerName, String status) throws ServicesException {
        try{
            offerDAO.changeStatus(offerName,status);
        }
        catch (PersistenceException e){
            throw new ServicesException(e.getMessage(),e );
        }

    }


    @Override
    public List<String> Offerbystatus(){
        List<String>  finalList = new ArrayList<>();
        try{

            List<Offer> newlist = offerDAO.getByUserId(1001184238);
            for(int i = 0; i < newlist.size(); i++){
                finalList.add(newlist.get(i).getName());
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return finalList;
    }

    @Override
    public List<String> OfferbyUserId(int userId){
        List<String>  finalList = new ArrayList<>();
        try{

            List<Offer> newlist = offerDAO.getByUserId(userId);
            for(int i = 0; i < newlist.size(); i++){
                finalList.add(newlist.get(i).getName());
            }

       }catch(Exception e){
            System.out.println(e.getMessage());

        }
        return finalList;

    }


}
