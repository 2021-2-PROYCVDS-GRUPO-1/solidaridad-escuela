package edu.eci.cvds;


import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServiciosFactory;
import edu.eci.cvds.services.ServiciosLaboratorio;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/19/2020
 */
public class ServiciosLaboratorioTest {
    @Inject
    private ServiciosLaboratorio serviciosLaboratorio;

    public ServiciosLaboratorioTest() {
        serviciosLaboratorio = HistorialServiciosFactory.getInstance().getServiciosLaboratorioTesting();
    }

    /*
    CONSULTAR
    */
    @Test
    public void consultarLaboratorios() throws HistorialEquiposException {
        List<Laboratorio> laboratorios = serviciosLaboratorio.consultarLaboratorios();
        Assert.assertTrue( laboratorios.size() != 0 );
    }

    @Test
    public void deberiaConsultarLaboratorio() throws HistorialEquiposException{
        int idLab = 2;

        Laboratorio laboratorio = serviciosLaboratorio.consultarLaboratorio( idLab );
        Assert.assertEquals(laboratorio.getIdLaboratorio().intValue(),idLab);
    }

    @Test
    public void noDeberiaEncontrarLaboratorio() throws HistorialEquiposException{
        int idLab = -1;

        Laboratorio laboratorio = serviciosLaboratorio.consultarLaboratorio( idLab );
        Assert.assertTrue(laboratorio == null );
    }

    /*
    INSERT
     */
    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRegistrarLaboratorioPoridRepetido() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = new Integer(2);
        String nombreLab = "Laboratorio Prueba";
        serviciosLaboratorio.registrarLaboratorio(idUsuario,idLab,nombreLab,null);
        fail();
    }

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaRegistrarLaboratorioPornombreRepetido() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = new Integer(2);
        String nombreLab = "Ingeniería de Software";
        serviciosLaboratorio.registrarLaboratorio(idUsuario,idLab,nombreLab,null);
        fail();

    }

    @Test
    public void deberiaRegistrarLaboratorio() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = new Integer(77);
        String nombreLab = "Laboratorio Prueba";
        try{
            serviciosLaboratorio.registrarLaboratorio(idUsuario, idLab, nombreLab, null );
        }
        catch (Exception exception){
        }
        finally {
            Assert.assertTrue( serviciosLaboratorio.consultarLaboratorio(idLab) != null );
        }
    }

    @Test
    public void deberiaCambiarEstadoLaboratorio() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = 4;
        try{
            Laboratorio laboratorio = serviciosLaboratorio.consultarLaboratorio(idLab);
            String estado = laboratorio.getEstado();
            serviciosLaboratorio.cambiarEstado(idUsuario, laboratorio);
            laboratorio = serviciosLaboratorio.consultarLaboratorio(idLab);

            Assert.assertFalse(estado.equals(laboratorio.getEstado()));
        }
        catch (Exception exception){
            fail();
        }
    }

    /**@Test
    public void deberiaConsultarNumeroLaboratoriosPorEstado() throws HistorialEquiposException {
        try{
            int idUsuario = 10048240;
            int idLab = new Integer(77);
            String nombreLab = "Laboratorio Prueba";
            serviciosLaboratorio.registrarLaboratorio(idUsuario, idLab, nombreLab, null );

            Assert.assertTrue(serviciosLaboratorio.consultarNumeroLaboratoriosPorEstado("ABIERTO"));
        }
        catch (Exception exception){
            fail();
        }
    }**/

    @Test( expected = HistorialEquiposException.class)
    public void noDeberiaCrearseUnLaboratorioCerrado() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = new Integer(77);
        String nombreLab = "Laboratorio Prueba";
        serviciosLaboratorio.registrarLaboratorio(idUsuario, idLab, nombreLab, null );
        Assert.assertEquals(serviciosLaboratorio.consultarNumeroLaboratoriosPorEstado("CERRADO"),1);
    }

    @Test
        public void deberiaGenerarUnLaboratorioConTodosLosMetodos() throws HistorialEquiposException {
        int idUsuario = 10048240;
        int idLab = 4;
        String nombreLab = "Laboratorio Prueba";
        try{
            //serviciosLaboratorio.registrarLaboratorio(idUsuario, idLab, nombreLab, null );
            serviciosLaboratorio.registrarLaboratorio(1193156116, 3, "Laboratorio Prueba 2", null );
            serviciosLaboratorio.cambiarEstado(idUsuario, serviciosLaboratorio.consultarLaboratorio(idLab));
            int numeroLabsCerrado = serviciosLaboratorio.consultarNumeroLaboratoriosPorEstado("CERRADO");
            List<Laboratorio> LaboratoriosActuales = serviciosLaboratorio.consultarLaboratorios();
            ArrayList<Object> LaboratorioServer = new ArrayList<Object>();
            LaboratorioServer.add(numeroLabsCerrado);
            LaboratorioServer.add(LaboratoriosActuales);
            LaboratorioServer.add(serviciosLaboratorio.consultarLaboratorio(4));
            Assert.assertEquals(LaboratorioServer.get(1),1);

        }
        catch (HistorialEquiposException exception){
            exception.printStackTrace();
        }
    }

}