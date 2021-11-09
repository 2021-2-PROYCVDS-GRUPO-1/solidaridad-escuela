package edu.eci.cvds.managedbeans;


//import edu.eci.cvds.entities.Elemento;
//import edu.eci.cvds.entities.Novedad;
//import edu.eci.cvds.entities.Usuario;
//import edu.eci.cvds.services.HistorialEquiposException;
//import edu.eci.cvds.services.HistorialServicios;
//import edu.eci.cvds.services.ServiciosElemento;
//import edu.eci.cvds.services.ServiciosNovedad;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.subject.Subject;
//import org.checkerframework.checker.units.qual.A;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 29/10/2020
 */
/*
@SuppressWarnings("deprecation")
@ManagedBean(name = "elementoBean")
@SessionScoped
public class ElementoBean extends BasePageBean {
    @Inject
    private ServiciosElemento serviciosElemento;

    @Inject
    private ServiciosNovedad serviciosNovedad;

    @Inject HistorialServicios historialServicios;

    private int idEquipo;
    private String message;
    private FacesMessage.Severity estado;
    private String tipo;
    private String nombre;
    private String descripcion;
    private String[] opciones = {"Torre","Pantalla","Mouse","Teclado"};
    private List<Elemento> elementos;
    private List<Elemento> elementosSeleccionados;
    private Usuario usuario;
    private Subject subject = SecurityUtils.getSubject();
    private List<Novedad> novedades;

    @PostConstruct
    public void init(){
        super.init();
        try{
            usuario= historialServicios.consultarUsuarioPorCorreo((String) subject.getSession().getAttribute("correo"));
            elementos = serviciosElemento.consultarElementos();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void registrarElemento(){
        try {
            sinErrores();
            serviciosElemento.insertarElemento( tipo, nombre, descripcion);
            restablecer();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void asociarEquipo(){
        try {
            sinErrores();
            serviciosElemento.asociarElementoEquipo(usuario.getIdUsuario(), elementosSeleccionados, idEquipo );
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void restablecer(){
        tipo = null ;
        nombre =null;
        descripcion = null;
    }

    public void actualizar(){
        try{
            sinErrores();
            elementos = serviciosElemento.consultarElementos();
        }
        catch (Exception exception) {
            conErrores( exception.getMessage());
        }
    }

    public void cambiarEstadoElemento(){
        try {
            sinErrores();
            for (Elemento e: elementosSeleccionados){
                serviciosElemento.cambiarEstadoElemento(usuario.getIdUsuario(),e);
            }
        }
        catch (Exception exception) {
            conErrores(exception.getMessage());
        }
    }

    public void actualizarNovedades(){
        ArrayList<Integer> search = new ArrayList<Integer>();
        for (Elemento e: elementosSeleccionados){
            search.add(e.getIdElemento());
        }
        try {
            novedades = serviciosNovedad.consultarPorElementos(search);
        } catch (HistorialEquiposException e) {
        }
    }


    public void info() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(estado, "Registrar", message));
    }

    public void conErrores( String message){
        this.message = message;
        estado = FacesMessage.SEVERITY_WARN;
    }

    public void sinErrores( ){
        this.message = "Se registro de forma exitosa.";
        estado = FacesMessage.SEVERITY_INFO;
    }

    public String[] getOpciones() { return opciones; }

    public void setOpciones(String[] opciones) { this.opciones = opciones; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public List<Elemento> getElementos() { return elementos; }

    public void setElementos(List<Elemento> elementos) { this.elementos = elementos; }

    public int getIdEquipo() { return idEquipo; }

    public void setIdEquipo(int idEquipo) { this.idEquipo = idEquipo; }

    public List<Elemento> getElementosSeleccionados() { return elementosSeleccionados; }

    public void setElementosSeleccionados(List<Elemento> elementosSeleccionados) { this.elementosSeleccionados = elementosSeleccionados; }

    public List<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(List<Novedad> novedades) {
        this.novedades = novedades;
    }
}*/
