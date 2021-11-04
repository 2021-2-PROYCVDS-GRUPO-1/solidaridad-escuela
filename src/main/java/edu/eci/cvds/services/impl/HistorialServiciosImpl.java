package edu.eci.cvds.services.impl;



import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.UsuarioDAO;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServicios;
import javax.inject.Inject;
import java.util.Optional;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 10/31/2020
 */
public class HistorialServiciosImpl implements HistorialServicios{

    @Inject
    private UsuarioDAO usuarioDAO;

    /*
    Consultar / SELECT / Buscar
     */

    @Override
    public Usuario getUserByEmail(String correo) throws HistorialEquiposException {
        try{
            Optional<Usuario> usuarioOptional = Optional.ofNullable(usuarioDAO.consultarPorCorreo( correo ));
            usuarioOptional.orElseThrow(() -> new HistorialEquiposException(HistorialEquiposException.NO_CLIENTE));
            return usuarioOptional.get();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    /*
    Insertar / INSERT / Agregar
     */

    /*
    Actualizar / UPDATE
     */
}
