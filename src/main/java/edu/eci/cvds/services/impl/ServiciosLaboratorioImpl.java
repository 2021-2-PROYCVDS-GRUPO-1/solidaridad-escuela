package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.entities.Novedad;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatis.dao.LaboratorioDAO;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosLaboratorio;
import edu.eci.cvds.services.ServiciosNovedad;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */
public class ServiciosLaboratorioImpl implements ServiciosLaboratorio {
    @Inject
    private LaboratorioDAO laboratorioDAO;

    @Inject
    private ServiciosEquipo serviciosEquipo;

    @Inject
    private ServiciosNovedad serviciosNovedad;

    /*
    SELECT
     */
    @Override
    public List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException {
        try{
            return laboratorioDAO.consultarLaboratorios();
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public Laboratorio consultarLaboratorio(int idLab) throws HistorialEquiposException{
        try{
            return laboratorioDAO.consultarLaboratorio(idLab);
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public int consultarNumeroLaboratoriosPorEstado(String estado) {
        try{
            return laboratorioDAO.consultarNumeroLaboratoriosPorEstado( estado ).size();
        }
        catch (PersistenceException persistenceException){
            return 0;
        }
    }

    /*
    INSERT
     */
    @Override
    public void registrarLaboratorio(int idUsuario,int idLab, String nombreLab, List<Equipo> aAsociar) throws HistorialEquiposException {
        try{
            laboratorioDAO.registrarLaboratorio(idLab, nombreLab);
            for (Equipo equipo: aAsociar){
                serviciosEquipo.asociarEquipo(idLab, equipo.getIdEquipo());
                serviciosNovedad.insertarNovedad(new Novedad("Asociación de equipo a laboratorio","El equipo con id "+idLab+" fue asociado al laboratorio "+nombreLab+" con id "+idLab,idUsuario,null,equipo.getIdEquipo()));
            }
        }
        catch (PersistenceException persistenceException){
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

    @Override
    public void cambiarEstado(int idUsuario, Laboratorio laboratorioSeleccionado) throws HistorialEquiposException {
        try{
            Optional<Laboratorio> laboratorioOptional = Optional.ofNullable(laboratorioSeleccionado);
            laboratorioOptional.orElseThrow( () -> new HistorialEquiposException(HistorialEquiposException.NO_SELECCION_CERRAR));
            String estado = ( laboratorioSeleccionado.getEstado().equals("ABIERTO")) ? "CERRADO":"ABIERTO";
            laboratorioDAO.cambiarEstado(laboratorioSeleccionado, estado);

            if( estado.equals("CERRADO") && laboratorioSeleccionado.getIdLaboratorio() != 1){
                for( Equipo equipo: laboratorioSeleccionado.getEquipos()){
                    serviciosEquipo.asociarEquipo(1, equipo.getIdEquipo());
                    serviciosNovedad.insertarNovedad( new Novedad(" Retiro de equipo de laboratorio","El equipo con id "+equipo.getIdEquipo()+" fue retirado del laboratorio "+laboratorioSeleccionado.getNombre()+" ya que fue cerrado.",idUsuario,null,equipo.getIdEquipo()));
                    serviciosNovedad.insertarNovedad( new Novedad(" Asociacion de equipo a un laboratorio","El equipo con id "+equipo.getIdEquipo()+" fue asociado al laboratorio Disponibles",idUsuario,null,equipo.getIdEquipo() ) );
                }
            }
        }
        catch (PersistenceException persistenceException){
            persistenceException.printStackTrace();
            throw new HistorialEquiposException(persistenceException.getMessage(),persistenceException );
        }
    }

}
