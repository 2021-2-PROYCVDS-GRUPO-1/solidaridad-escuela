package edu.eci.cvds.services;

import edu.eci.cvds.entities.Category;

public interface AnswerServices {
    /*
    SELECT
     */

    /*
    INSERT
     */
    public void addAnswer(String name, String comments, int idOffer, int idNeeds) throws ServicesException;

    /*
    UPDATE
     */

}
