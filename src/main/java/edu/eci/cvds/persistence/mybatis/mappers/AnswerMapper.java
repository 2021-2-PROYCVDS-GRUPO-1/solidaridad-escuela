package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

public interface AnswerMapper {
    public void addAnswer(@Param("name")String name,
                          @Param("comments")String comments,
                          @Param("idOffer") int idOffer,
                          @Param("idNeeds") int idNeeds) throws PersistenceException;
}
