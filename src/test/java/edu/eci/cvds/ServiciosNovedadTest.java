package edu.eci.cvds;

import com.google.inject.Inject;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.fail;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/27/2020
 */
public class ServiciosNovedadTest {
    // @Inject
    // private ServiciosNovedad serviciosNovedad;

    // public ServiciosNovedadTest() {
    //     serviciosNovedad = HistorialServiciosFactory.getInstance().getSErviciosNovedadTesting();
    // }


    // @Test
    // public void deberiaConsultarNovedades() throws HistorialEquiposException {
    //     try{
    //         serviciosNovedad.consultarNovedades();
    //     }
    //     catch (Exception exception){
    //         fail();
    //     }
    // }

    // @Test
    // public void deberiaConsultarNovedadesPorElemento() throws HistorialEquiposException {
    //     try{
    //         serviciosNovedad.consultarPorElemento(1);
    //     }
    //     catch (HistorialEquiposException exception) {
    //         exception.printStackTrace();
    //     }
    // }

    // @Test
    // public void deberiaConsultarNovedadesPorEquipo() throws HistorialEquiposException {
    //     try{
    //         serviciosNovedad.consultarPorEquipo(1);
    //     }
    //     catch (HistorialEquiposException exception){
    //         exception.printStackTrace();
    //     }
    // }

    // @Test
    // public void deberiaConsultarNovedadesPorElementos() throws HistorialEquiposException {
    //     try{
    //         ArrayList<Integer>idelementos= new ArrayList<Integer>();
    //         idelementos.add(new Integer(1));
    //         idelementos.add(new Integer(2));
    //         idelementos.add(new Integer(3));
    //         serviciosNovedad.consultarPorElementos(idelementos);
    //     }
    //     catch (Exception exception){
    //         fail();
    //     }
    // }

    // @Test
    // public void deberiaConsultarNovedadesPorEquipos() throws HistorialEquiposException {
    //     try{
    //         ArrayList<Integer> idEquipos= new ArrayList<Integer>();
    //         idEquipos.add(new Integer(1));
    //         idEquipos.add(new Integer(2));
    //         idEquipos.add(new Integer(3));
    //         serviciosNovedad.consultarPorEquipos(idEquipos);
    //     }
    //     catch (Exception exception){
    //         fail();
    //     }
    // }

    // @Test( expected = HistorialEquiposException.class)
    // public void deberiaDarErrorAlConsultarNovedadesPorEquipoInexistente() throws HistorialEquiposException {
    //     // esta prueba deberia dar error ya que el equipo con id -1 no existe en la base de datos
    //     int idEquipo = -1;
    //     serviciosNovedad.consultarPorEquipo(idEquipo);
    //     fail();
    // }

    // @Test( expected = HistorialEquiposException.class)
    // public void deberiaDarErrorAlConsultarNovedadesPorElementoInexistente() throws HistorialEquiposException {
    //     // esta prueba deberia dar error ya que el elemento con id -1 no existe en la base de datos
    //     int idElemento = -1;
    //     serviciosNovedad.consultarPorElemento(idElemento);
    //     fail();
    // }


}
