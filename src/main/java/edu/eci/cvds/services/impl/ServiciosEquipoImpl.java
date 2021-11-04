package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Elemento;
import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.EquipoDAO;
import edu.eci.cvds.services.*;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiciosEquipoImpl implements ServiciosEquipo {
    @Inject
    private EquipoDAO equipoDAO;

    @Inject
    private ServiciosLaboratorio serviciosLaboratorio;

    @Inject
    private ServiciosNovedad serviciosNovedad;

    @Inject
    private ServiciosElemento serviciosElemento;


    private Laboratorio validarLaboratorio( int idLab) throws HistorialEquiposException{
        Optional<Laboratorio> optionalLaboratorio = Optional.ofNullable( serviciosLaboratorio.consultarLaboratorio( idLab ) );
        optionalLaboratorio.orElseThrow(() -> new HistorialEquiposException(HistorialEquiposException.NO_LAB));
        return optionalLaboratorio.get();
    }
    /*
    SELECT
     */
    @Override
    public Equipo consultarEquipo(int idEquipo) throws HistorialEquiposException {
        try{
            return equipoDAO.consultarEquipo(idEquipo);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException);
        }
    }

    @Override
    public List<Equipo> consultarEquiposDisponibles() throws HistorialEquiposException{
        try{
            return equipoDAO.consultarEquiposDisponibles();
        }
        catch(PersistenceException e){
            throw new HistorialEquiposException(e.getMessage(),e);
        }
    }
    @Override
    public List<Equipo> consultarEquipos() throws HistorialEquiposException {
        try{
            return equipoDAO.consultarEquipos();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public List<Equipo> consultarEquiposActivos() throws HistorialEquiposException {
        try {
            return equipoDAO.consultarEquiposActivos();
        }
        catch (PersistenceException e) {
            throw new HistorialEquiposException(e.getMessage(),e );
        }
    }


    /*
    INSERT
     */
    @Override
    public void insertarEquipo(Integer idEquipo,int[] elementos, int idLab, int idUsuario ) throws HistorialEquiposException{
        try {
            Laboratorio laboratorio = validarLaboratorio( idLab);
            if( laboratorio.getEstado().equals("CERRADO")){
                throw new HistorialEquiposException("No se puede asociar un equipo a un laboratorio cerrado.");
            }
            equipoDAO.registrarEquipo(idEquipo,idLab);
            String cadena ="";
            for( int elemento : elementos){
                serviciosElemento.relacionarElementoEquipo(elemento,idEquipo);
                cadena+= elemento+", ";
                serviciosNovedad.insertarNovedad(new Novedad("Asociación de elemento a equipo ","El elemento con id "+elemento+" fue asociado al equipo "+idEquipo,idUsuario,elemento,idEquipo));
            }
            serviciosNovedad.insertarNovedad( new Novedad("Registro del Equipo", "El equipo con id "+idEquipo+" fue registrado y se le asignaron los elementos: "+cadena,idEquipo, idUsuario));
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    /*
    UPDATE
     */
    @Override
    public void asociarEquipo(Integer idLab, int idEquipo) throws HistorialEquiposException {
        try {
            if( idLab != null ){
                Laboratorio laboratorio = validarLaboratorio( idLab);
                if( laboratorio.getEstado().equals("CERRADO") ){
                    throw new HistorialEquiposException("No se puede asociar un equipo a un laboratorio cerrado.");
                }
            }
            equipoDAO.asociar(idLab, idEquipo);
        } catch (PersistenceException e) {
            throw new HistorialEquiposException(e.getMessage(),e );
        }
    }

    @Override
    public void asociarEquipoLabExistente(List<Equipo> equipos, int idUsuario, Integer idLab) throws HistorialEquiposException {
        Laboratorio laboratorio = validarLaboratorio(idLab);
        if( laboratorio.getEstado().equals("CERRADO") ){
            throw new HistorialEquiposException("No se puede asociar un equipo a un laboratorio cerrado.");
        }
        for( Equipo equipo: equipos){
            asociarEquipo(idLab,equipo.getIdEquipo());
            serviciosNovedad.insertarNovedad( new Novedad(" Retiro de equipo de laboratorio","El equipo con id "+equipo.getIdEquipo()+" fue retirado del laboratorio con id "+equipo.getIdLab(),idUsuario,null,equipo.getIdEquipo()));
            serviciosNovedad.insertarNovedad( new Novedad(" Asociacion de equipo a un laboratorio","El equipo con id "+equipo.getIdEquipo()+" fue asociado al laboratorio con id "+idLab,idUsuario,null,equipo.getIdEquipo() ) );
        }
    }

    @Override
    public void cambiarEstadoEquipo(int idUsuario, Equipo equipo) throws HistorialEquiposException{
        try{
            String change = equipo.getEstado().equals("ACTIVO") ? "INACTIVO" : "ACTIVO";
            if (equipo.getIdLab() != 1){
                asociarEquipo(1,equipo.getIdEquipo());
            }
            equipoDAO.cambiarEstadoEquipo(equipo.getIdEquipo(), change);
            if (change.equals("ACTIVO")){
                serviciosNovedad.insertarNovedad(new Novedad("Equipo activo","El equipo con id "+ equipo.getIdEquipo() +" fue activado otra vez.",idUsuario,null, equipo.getIdEquipo()));
            }
            else if( change.equals("INACTIVO")){
                ArrayList<Elemento> elementos = equipo.getElementos();
                serviciosNovedad.insertarNovedad(new Novedad("Equipo dado de baja","El equipo con id "+ equipo.getIdEquipo() +" fue dado de baja.",idUsuario,null, equipo.getIdEquipo()));
                for (Elemento e: elementos){
                    serviciosElemento.relacionarElementoEquipo(e.getIdElemento(),null);
                    serviciosNovedad.insertarNovedad( new Novedad("Retiro de elemento","El elemento con id " + e.getIdElemento() + " de tipo " + e.getTipo() + " fue retirado del equipo"+ e.getIdEquipo() +".",idUsuario,e.getIdElemento(),null));
                    e.setDisponible(1);
                    serviciosElemento.cambiarEstadoElemento(idUsuario,e);
                }
            }
        }
        catch (PersistenceException e) {
            throw new HistorialEquiposException(e.getMessage(),e );
        }
    }
}