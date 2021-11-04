package edu.eci.cvds.services;

import edu.eci.cvds.entities.Equipo;
import edu.eci.cvds.entities.Laboratorio;
import java.util.List;
/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */

public interface ServiciosLaboratorio {
    /*
    SELECT
     */
    public List<Laboratorio> consultarLaboratorios() throws HistorialEquiposException;

    public Laboratorio consultarLaboratorio(int idLab) throws HistorialEquiposException;

    public int consultarNumeroLaboratoriosPorEstado( String estado );

    /*
    INSERT
     */
    public void registrarLaboratorio(int idUsuario,int idLab, String nombreLab, List<Equipo> aAsociar) throws HistorialEquiposException;

    public void cambiarEstado(int idUsuario, Laboratorio laboratorioSeleccionado )throws HistorialEquiposException;
}
