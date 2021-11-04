package edu.eci.cvds.persistence.mybatis.dao;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;


/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/5/2020
 */
public interface UsuarioDAO {
    public Usuario consultarPorCorreo( String correo ) throws PersistenceException;
}
