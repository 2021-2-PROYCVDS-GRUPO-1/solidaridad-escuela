package edu.eci.cvds.services;

import edu.eci.cvds.entities.Answer;
import edu.eci.cvds.entities.Category;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.List;

public interface AnswerServices {
    /*
    SELECT
     */

    public List<Answer> getAnsOfferNeed() throws ServicesException;

    /*
    INSERT
     */
    public void addAnswer(String name, String comments, int idOffer, int idNeeds, int userId) throws ServicesException;

    public void addAnswerOffer(String name, String comments, int idOffer, int userId) throws ServicesException;

    public void addAnswerNeeds(String name, String comments,int idNeeds, int userId) throws ServicesException;

    /*
    UPDATE
     */

}
