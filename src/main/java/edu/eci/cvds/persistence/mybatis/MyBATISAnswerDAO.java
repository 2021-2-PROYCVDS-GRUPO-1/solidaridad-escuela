package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.AnswerDAO;
import edu.eci.cvds.persistence.mybatis.mappers.AnswerMapper;
import edu.eci.cvds.persistence.mybatis.mappers.CategoryMapper;

import javax.inject.Inject;

public class MyBATISAnswerDAO implements AnswerDAO {
    @Inject
    private AnswerMapper answerMapper ;

    @Override
    public void addAnswer(String name, String comments, int idOffer, int idNeeds) throws PersistenceException {
        try{
            answerMapper.addAnswer(name, comments, idOffer, idNeeds);
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }
}
