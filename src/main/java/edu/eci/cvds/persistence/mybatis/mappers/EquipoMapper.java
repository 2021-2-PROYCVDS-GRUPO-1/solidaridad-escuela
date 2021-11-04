package edu.eci.cvds.persistence.mybatis.mappers;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.persistence.PersistenceException;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface EquipoMapper {

    public void registrarEquipo( @Param("idEquipo") int idEquipo,@Param("lab") int idLab) throws PersistenceException;
    public ArrayList<Equipo> consultarEquipos()  throws PersistenceException;
    public void generarNovedades( @Param("idEquipo") int idEquipo, @Param("idElemento") int idElemento, @Param("titulo") String titulo, @Param("detalle") String detalle, @Param("idUsuario") int idUsuario )  throws PersistenceException;
    public void asociar(@Param("idLab") int idLab, @Param("idEquipo") int idEquipo) throws PersistenceException;
    public List<Equipo> consultarEquiposDisponibles() throws PersistenceException;
    public Equipo consultarEquipo(@Param("idEquipo") int idEquipo) throws PersistenceException;
    public List<Equipo> consultarEquiposActivos() throws PersistenceException;
    public void cambiarEstado(@Param("idEquipo") int idEquipo, @Param("change") String change) throws PersistenceException;
}
