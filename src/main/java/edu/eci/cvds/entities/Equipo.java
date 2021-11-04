package edu.eci.cvds.entities;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Equipo {

    private Integer idEquipo;
    private Integer disponible;
    private Integer idLab;
    private String lab;
    private Date fechaRegistro;
    private String estado;
    private ArrayList<Elemento> elementos;
    private ArrayList<Novedad> novedades;

    public Equipo(){
    }
    public Equipo(Integer idEquipo, Integer idLab, Date fechaRegistro, Integer disponible, ArrayList<Novedad>novedades){
        this.idEquipo = idEquipo;
        this.fechaRegistro = fechaRegistro;
        this.disponible = disponible;
        this.elementos = new ArrayList<Elemento>();
        this.idLab = idLab;
        this.novedades = novedades;
    }

    public Equipo(Integer idEquipo, Integer idLab, Date fechaRegistro, Integer disponible, ArrayList<Elemento>elementos, ArrayList<Novedad> novedades ){
       this.idEquipo = idEquipo;
       this.fechaRegistro = fechaRegistro;
       this.disponible = disponible;
       this.elementos = elementos;
       this.idLab = idLab;
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

    public Integer getIdLab() {
        return idLab;
    }

    public void setIdLab(Integer idLab) {
        this.idLab = idLab;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public ArrayList<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(ArrayList<Novedad> novedades) {
        this.novedades = novedades;
    }

    public String getLab() {
        return lab;
    }

    public void setLab(String lab) {
        this.lab = lab;
    }
}
