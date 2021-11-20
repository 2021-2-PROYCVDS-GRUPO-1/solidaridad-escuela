package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import java.util.List;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public interface OfferDAO {


    /**
     * Create an offer
     * @param offerCategory, The offer's category
     * @param name, The offer's name
     * @param description The offer's description
     * @param userId The offer's userId
     * @throws PersistenceException
     */
    public void createOffer(int offerCategory, String name, String description, int userId) throws PersistenceException;

    /**
     * Change the status of an offer
     * @param offerName, The offer's name
     * @param status The new status of the offer
     * @throws PersistenceException
     */
    public void changeStatus(String offerName, String status ) throws PersistenceException;

    /**
     * Get Offers by its status
     * @param status, The offers status
     * @return
     * @throws PersistenceException
     */
    public List<Offer> getByStatus(String status) throws PersistenceException;


    /**
     * Get Offers from a user
     * @param userId, The user's Id
     * @return
     * @throws PersistenceException
     */
    public List<Offer> getByUserId(int userId) throws PersistenceException;


    /**
     * Get an offer by its name
     * @param name The offer's name
     * @return
     * @throws PersistenceException
     */
    public Offer getOfferByName(String name) throws PersistenceException;

    /**
     * Get an offer by its id
     * @param id The offer's id
     * @return
     * @throws PersistenceException
     */
    public Offer getOfferByID(int id) throws PersistenceException;


}


