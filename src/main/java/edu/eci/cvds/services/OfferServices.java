package edu.eci.cvds.services;


import edu.eci.cvds.entities.Offer;

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

    /*
    INSERT
     */
    public void registrarOferta(int offerId, String offerCategory, String name, String description) throws ServicesException;




}


