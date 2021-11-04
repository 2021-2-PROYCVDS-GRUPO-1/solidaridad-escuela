package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Elemento;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 31/10/2020
 */
public interface ElementoMapper {
    public ArrayList<Elemento> consultarElementos();
    public void registrarElemento(@Param("tipo") Elemento elemento);
    public void asociarEquipo(@Param("idElemento") int idElemento,@Param("idEquipo") Integer idEquipo);
    public List<Elemento> buscarElemento(@Param("tipo") String elemento);
    public void cambiarEstadoElemento( @Param("idElemento") int idElemento, @Param("change") String change);
}
