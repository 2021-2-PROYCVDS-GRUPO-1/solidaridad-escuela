package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.persistence.PersistenceException;

public interface AnswerDAO {

    public void addAnswer(String name, String comments, int idOffer, int idNeeds) throws PersistenceException;

    public void addAnswerOffer(String name, String comments, int idOffer) throws PersistenceException;

    public void addAnswerNeeds(String name, String comments,int idNeeds) throws PersistenceException;
}
