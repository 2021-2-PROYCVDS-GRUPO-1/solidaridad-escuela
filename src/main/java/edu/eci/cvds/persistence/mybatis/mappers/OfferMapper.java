package edu.eci.cvds.persistence.mybatis.mappers;


import edu.eci.cvds.entities.Offer;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

/**
 * @author Laura Valentina García León
 * @author Laura Nathalia García
 * @author Juan Sebastián Cadavid
 * @author Juan David Murillo
 * @version 19/10/2021
 */

public interface OfferMapper {
    public Offer getOfferByName(@Param("name") String name) throws PersistenceException;

    public Offer getOfferByID(@Param("idOffer") int idOffer) throws PersistenceException;

    public void registrarOferta(@Param ("offerCategory") int offerCategory, @Param ("name") String name, @Param ("description") String description, @Param ("userId") int userId) throws PersistenceException;

    public void changeStatus(@Param ("offer") Offer offer, @Param ("status") String status) throws PersistenceException;
}
