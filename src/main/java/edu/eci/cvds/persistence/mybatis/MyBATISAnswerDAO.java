package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Answer;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.AnswerDAO;
import edu.eci.cvds.persistence.mybatis.mappers.AnswerMapper;
import edu.eci.cvds.persistence.mybatis.mappers.CategoryMapper;

import javax.inject.Inject;
import java.util.List;

public class MyBATISAnswerDAO implements AnswerDAO {
    @Inject
    private AnswerMapper answerMapper ;

    @Override
    public void addAnswer(String name, String comments, int idOffer, int idNeeds, int userId) throws PersistenceException {
        try{
            answerMapper.addAnswer(name, comments, idOffer, idNeeds, userId);
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }

    @Override
    public void addAnswerOffer(String name, String comments, int idOffer, int userId) throws PersistenceException {
        try{
            answerMapper.addAnswerOffer(name, comments, idOffer, userId);
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }

    @Override
    public void addAnswerNeeds(String name, String comments, int idNeeds, int userId) throws PersistenceException {
        try{
            answerMapper.addAnswerNeeds(name, comments, idNeeds, userId);
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al añadir la respuesta con el nombre: "+ name);
        }
    }

    @Override
    public List<Answer> getAnsOfferNeed() throws PersistenceException {
        try{
            return answerMapper.getAnsOfferNeed();
        }catch (PersistenceException e) {
            throw  new PersistenceException("Error al traer las respuestas");
        }
    }
}
