package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Answer;
import edu.eci.cvds.persistence.PersistenceException;

import java.util.List;

public interface AnswerDAO {

    public void addAnswer(String name, String comments, int idOffer, int idNeeds, int userId) throws PersistenceException;

    public void addAnswerOffer(String name, String comments, int idOffer, int userId) throws PersistenceException;

    public void addAnswerNeeds(String name, String comments,int idNeeds, int userId) throws PersistenceException;

    public List<Answer> getAnsOfferNeed() throws PersistenceException;

}
