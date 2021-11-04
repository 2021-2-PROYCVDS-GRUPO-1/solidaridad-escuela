package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/29/2020
 */
public interface UsuarioMapper {

    public Usuario consultarPorCorreo(@Param("correo") String correo ) throws PersistenceException;
}
