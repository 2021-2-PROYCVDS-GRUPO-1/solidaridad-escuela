package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

public interface AnswerMapper {
    public void addAnswer(@Param("name")String name,
                          @Param("comments")String comments,
                          @Param("idOffer") int idOffer,
                          @Param("idNeeds") int idNeeds) throws PersistenceException;

    public void addAnswerOffer(@Param("name")String name,
                          @Param("comments")String comments,
                          @Param("idOffer") int idOffer) throws PersistenceException;

    public void addAnswerNeeds(@Param("name")String name,
                          @Param("comments")String comments,
                          @Param("idNeeds") int idNeeds) throws PersistenceException;
}
