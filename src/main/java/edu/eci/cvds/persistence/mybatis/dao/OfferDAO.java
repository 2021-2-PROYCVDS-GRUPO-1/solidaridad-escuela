package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */
public interface OfferDAO {
    /**
     * Get the offer by its name
     * @param name The offer's name
     * @return
     * @throws PersistenceException
     */
    public Offer getOfferByName(String name) throws PersistenceException;

    /**
     * Get the offer by its id
     * @param id The offer's id
     * @return
     * @throws PersistenceException
     */
    public Offer getOfferByID(int id) throws PersistenceException;

    /**
     *
     * @param offerId The offer's Id
     * @param offerCategory The offer's category
     * @param name The offer's name
     * @param description The offer's description
     * @throws PersistenceException
     */
    public void registrarOferta(int offerId, String offerCategory, String name, String description) throws PersistenceException;


    public void changeStatus(Offer offer, String status ) throws PersistenceException;
}


