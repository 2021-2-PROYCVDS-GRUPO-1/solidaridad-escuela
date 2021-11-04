package edu.eci.cvds.persistence.mybatis;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.UsuarioDAO;
import edu.eci.cvds.persistence.mybatis.mappers.UsuarioMapper;

import javax.inject.Inject;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/5/2020
 */
public class MyBATISUsuarioDAO implements UsuarioDAO {
    @Inject
    private UsuarioMapper usuarioMapper;

    @Override
    public Usuario consultarPorCorreo(String correo) throws PersistenceException {
        try{
            return usuarioMapper.consultarPorCorreo( correo );
        }
        catch (Exception exception){
            throw new PersistenceException("Error al consultar al usuario con correo "+ correo);
        }

    }
}
