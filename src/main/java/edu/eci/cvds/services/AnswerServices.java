package edu.eci.cvds.services;

import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;

public interface AnswerServices {
    /*
    SELECT
     */

    /*
    INSERT
     */
    public void addAnswer(String name, String comments, int idOffer, int idNeeds) throws ServicesException;

    public void addAnswerOffer(String name, String comments, int idOffer) throws ServicesException;

    public void addAnswerNeeds(String name, String comments,int idNeeds) throws ServicesException;

    /*
    UPDATE
     */

}
