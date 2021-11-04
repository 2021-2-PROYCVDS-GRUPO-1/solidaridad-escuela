package edu.eci.cvds.entities;

import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Elemento {
    private int idElemento;
    private Integer idEquipo;
    private String tipo;
    private String nombre;
    private String descripcion;
    private int disponible;
    private String estado;
    private ArrayList<Novedad> novedades;


    public Elemento(){}

    public Elemento( String tipo, String nombre, String descripcion){
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.novedades = new ArrayList<Novedad>();
        this.estado = "ACTIVO";
    }
    public Elemento( String tipo, String nombre, String descripcion, String estado){
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.novedades = new ArrayList<Novedad>();
        this.estado = estado;
    }

    public Elemento(int id, String tipo, String nombre, String descripcion, ArrayList<Novedad> novedades,int disponible, String estado){
        this.idElemento = id;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.novedades = novedades;
        this.disponible = disponible;
        this.estado = estado;
    }

    public int getIdElemento() {
        return idElemento;
    }

    public void setIdElemento(int idElemento) {
        this.idElemento = idElemento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(ArrayList<Novedad> novedades) {
        this.novedades = novedades;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getDisponible() {
        return disponible;
    }

    public void setDisponible(int disponible) {
        this.disponible = disponible;
    }

    public String getEstado() { return estado; }

    public void setEstado(String estado) { this.estado = estado; }
}