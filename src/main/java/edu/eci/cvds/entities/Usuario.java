package edu.eci.cvds.entities;

import java.util.ArrayList;

/**
 * @author Ana Gabriela Silva
 * @author Juan Andrés Pico
 * @author Leonardo Galeano
 * @author Iván Camilo Rincón Saavedra
 * @version 28/10/2020
 */
public class Usuario {
    private int idUsuario;
    private int estado;
    private String nombre;
    private String correo;
    private String contraseña;
    private String rol;
    private ArrayList<Novedad> novedades;

    public Usuario(){}

    public Usuario(int idUsuario, int estado, String nombre, String correo, String rol ){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.estado = estado;
        this.rol = rol;
        novedades = new ArrayList<Novedad>();
    }

    public Usuario(int idUsuario, int estado, String nombre, String correo, String rol, ArrayList<Novedad> novedades){
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.estado = estado;
        this.rol = rol;
        this.novedades = novedades;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public ArrayList<Novedad> getNovedades() {
        return novedades;
    }

    public void setNovedades(ArrayList<Novedad> novedades) {
        this.novedades = novedades;
    }
}
