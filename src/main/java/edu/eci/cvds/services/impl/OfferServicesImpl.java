package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
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
    public List<Offer> getByUserID(int userId) {
        try{
            return offerDAO.getByUserId(userId);
        }
        catch (PersistenceException e){
            System.out.println(e.getMessage());;
        }
        return null;
    }

    @Override
    public List<Offer> getAllOffers() throws ServicesException {
        try{
            return offerDAO.getAllOffers();
        }
        catch (PersistenceException e){
            throw new ServicesException( e.getMessage(), e );
        }
    }

    @Override
    public HashMap<Integer, String> getOffers() {
        HashMap<Integer, String> listOffer = new HashMap<Integer, String>();
        try {
            for (Offer newlist : offerDAO.getOffers()) {
                if ((newlist.getStatus().equals("ACTIVE")) || (newlist.getStatus().equals("IN PROCESS"))) {
                    listOffer.put(newlist.getOfferId(), newlist.getName());
                }
            }
        } catch (PersistenceException e) {
            System.out.println(e.getMessage());
        }
        return listOffer;
    }

    @Override
    public List<String> Offerbystatus(){
        List<String>  finalList = new ArrayList<>();
        try{

            List<Offer> newlist = offerDAO.getByStatus("ACTIVE");
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

    public int countByStatus(String status) {
        try{
            return offerDAO.getByStatus(status).size();
        }catch(PersistenceException e) {
            return 0;
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
    public void deleteOffer(int offerId) throws ServicesException {
        try {
            offerDAO.deleteOffer(offerId);
        } catch (PersistenceException e) {
            throw new ServicesException( e.getMessage(),e );
        }
    }

    @Override
    public List<Offer> testGetAllOffers() {
        try{
            return offerDAO.getAllOffers();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }


}
