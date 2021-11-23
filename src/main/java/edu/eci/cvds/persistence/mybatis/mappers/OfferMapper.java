package edu.eci.cvds.persistence.mybatis.mappers;


import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */

public interface OfferMapper {
    /**
     * Get Offer by its name
     * @param name, Offer's name
     * @return Offer
     * @throws PersistenceException
     */
    public Offer getOfferByName(@Param("name") String name) throws PersistenceException;

    /**
     *
     * @param idOffer
     * @return
     * @throws PersistenceException
     */
    public Offer getOfferByID(@Param("idOffer") int idOffer) throws PersistenceException;

    public List<Offer> getAllOffers() throws PersistenceException;

    /**
     *
     * @param status
     * @return
     * @throws PersistenceException
     */
    public List<Offer> getByStatus(@Param("status") String status) throws  PersistenceException;

    /**
     *
     * @param userId
     * @return
     * @throws PersistenceException
     */
    public List<Offer> getByUserId(@Param("userId") int userId) throws  PersistenceException;

    public List<Offer> getOffers() throws PersistenceException;

    /**
     *
     * @param offerCategory
     * @param name
     * @param description
     * @param userId
     * @throws PersistenceException
     */
    public void createOffer(@Param ("offerCategory") int offerCategory,
                                @Param ("name") String name,
                                @Param ("description") String description,
                                @Param ("userId") int userId) throws PersistenceException;

    /**
     *
     * @param offerName
     * @param status
     * @throws PersistenceException
     */
    public void changeStatus(@Param ("offerName") String offerName,
                             @Param ("status") String status) throws PersistenceException;



    public void deleteOffer(@Param("id") int id) throws PersistenceException;
}
