package edu.eci.cvds.services;


import edu.eci.cvds.entities.Offer;

import java.util.HashMap;
import java.util.List;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 28/10/2021
 */
public interface OfferServices {

    /*
    SELECT
     */

    public Offer getOfferByName(String name) throws ServicesException;

    public Offer getOfferById(int idLab) throws ServicesException;

    public List<Offer> getByStatus(String status) throws  ServicesException;

    public List<Offer> getByUserID(int userId) ;

    public List<Offer> getAllOffers() throws ServicesException;

    public List<String> Offerbystatus();

    public List<String> OfferbyUserId(int userId);

    public HashMap<Integer, String> getOffers();

    public int countByStatus(String status);

    public List<Offer> testGetAllOffers();

    /*
    INSERT
     */
    public void createOffer(int offerCategory, String name, String description, int userId) throws ServicesException;


    /*
    UPDATE
     */

    public void changeStatus(String offerName, String status) throws ServicesException;




    /*
    DELETE
     */
    public void deleteOffer(int offerId) throws ServicesException;
}


