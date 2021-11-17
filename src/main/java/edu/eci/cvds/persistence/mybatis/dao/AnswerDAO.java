package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.persistence.PersistenceException;

public interface AnswerDAO {

    public void addAnswer(String name, String comments, int idOffer, int idNeeds) throws PersistenceException;
}
