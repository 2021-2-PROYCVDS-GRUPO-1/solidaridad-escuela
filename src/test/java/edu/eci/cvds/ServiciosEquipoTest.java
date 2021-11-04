package edu.eci.cvds;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Laboratorio;
import edu.eci.cvds.services.HistorialEquiposException;
import edu.eci.cvds.services.HistorialServiciosFactory;
import edu.eci.cvds.services.ServiciosEquipo;
import edu.eci.cvds.services.ServiciosLaboratorio;
import org.junit.Assert;
import org.junit.Test;
import edu.eci.cvds.entities.Equipo;

import static org.junit.Assert.fail;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 11/12/2020
 */
public class ServiciosEquipoTest {
    @Inject
    private ServiciosEquipo serviciosEquipo;

    @Inject
    private ServiciosLaboratorio serviciosLaboratorio;

    public ServiciosEquipoTest() {
        serviciosEquipo = HistorialServiciosFactory.getInstance().getServiciosEquipoTesting();
        serviciosLaboratorio = HistorialServiciosFactory.getInstance().getServiciosLaboratorioTesting();
    }

    @Test( expected = HistorialEquiposException.class )
    public void deberiaFallarAlRegistrarElEquipoPorElementoInvalido() throws HistorialEquiposException{
        //deberia dar error ya que no existe el elemnto con id 101
        int[] elementos = {101,6,7,8};
        serviciosEquipo.insertarEquipo( 14,elementos, 1 ,10048240);
        fail();
    }

    @Test
    public void deberiaFallarAlRegistrarElEquipoPorElementoYaAsignado() throws HistorialEquiposException{
        //esta prueba deberia fallar ya que los elementos que se intentan asociar al equipo, No se encuentran disponibles
        // torre, mouse, pantalla , teclado
        int[] elementos = {1,3,2,4};
        serviciosEquipo.insertarEquipo( 14,elementos, 1,10048240 );
    }

    @Test
    public void deberiaFallarAlRegistrarElEquipoPorLaboratorioCerrado() throws HistorialEquiposException{
        int[] elementos = {5,6,7,8};
        int idLaboratorio= 5;
        String message ="No se puede asociar un equipo a un laboratorio cerrado.";

        try {
            Laboratorio laboratorio = serviciosLaboratorio.consultarLaboratorio( 5 );
            if( laboratorio.getEstado().equals("ABIERTO") ){ serviciosLaboratorio.cambiarEstado(10048240,laboratorio); }
            serviciosEquipo.insertarEquipo(new Integer(100),elementos,idLaboratorio,10048240);
            fail();
        }
        catch (HistorialEquiposException historialEquiposException){
            Assert.assertTrue( historialEquiposException.getMessage().equals(message));
        }

    }

    @Test
    public void deberiaRegistrarElEquipo() throws HistorialEquiposException{
        int[] elementos = {5,6,7,8};
        try {
            serviciosEquipo.insertarEquipo(new Integer(99),elementos,1,10048240);
        }
        catch (HistorialEquiposException historialEquiposException){
        }
        finally {
            Assert.assertTrue(serviciosEquipo.consultarEquipo(99) !=null);
        }
    }

    @Test
    public void deberiaConsultarEquipos() throws HistorialEquiposException{
        serviciosEquipo.consultarEquipos();
    }

    @Test
    public void noDeberiaEncontrarEquipo() throws HistorialEquiposException{
        Assert.assertEquals(serviciosEquipo.consultarEquipo(-1),null);
    }

    @Test
    public void deberiaConsultarEquiposDisponibles() throws HistorialEquiposException{
        serviciosEquipo.consultarEquiposDisponibles();
    }

    @Test
    public void deberiaConsultarEquipo() throws HistorialEquiposException{
        Equipo equipo = serviciosEquipo.consultarEquipo(1);
        Assert.assertFalse(null == equipo);
    }

    @Test
    public void deberiaCambiarEstadoEquipo()throws HistorialEquiposException{
        Equipo equipo = serviciosEquipo.consultarEquipo(1);
        serviciosEquipo.cambiarEstadoEquipo(10048240,equipo);
        String estado = ( equipo.getEstado().equals("INACTIVO")) ? "ACTIVO":"INACTIVO";
        Assert.assertEquals(estado,serviciosEquipo.consultarEquipo(1).getEstado());
    }

    @Test
    public void deberiaAsociarEquipoLab()throws HistorialEquiposException{
        int idLab = new Integer(2);
        int idEquipo = 1;

        serviciosEquipo.asociarEquipo(idLab,idEquipo);
        Equipo equipo = serviciosEquipo.consultarEquipo(idEquipo);
        Assert.assertTrue(idLab == equipo.getIdLab());
    }

    @Test( expected = HistorialEquiposException.class )
    public void deberiaFallarAlAsociarEquipoLabNoExistente()throws HistorialEquiposException{
        int idLab = new Integer(-1);
        int idEquipo = 1;

        serviciosEquipo.asociarEquipo(idLab,idEquipo);
        Equipo equipo = serviciosEquipo.consultarEquipo(idEquipo);
        Assert.assertTrue(idLab == equipo.getIdLab());
    }

}
