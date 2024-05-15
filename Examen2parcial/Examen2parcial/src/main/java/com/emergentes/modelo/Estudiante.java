package com.emergentes.modelo;

import java.sql.Date;

public class Estudiante {
    private int id;
    private String nombre;
    private String apellidos;
    private String seminario;
    private boolean confirmado;
    private Date fecha_inscripcion;

    public Estudiante(int id, String nombre, String apellidos, String seminario, boolean confirmado, Date fecha_inscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.seminario = seminario;
        this.confirmado = confirmado;
        this.fecha_inscripcion = fecha_inscripcion;
    }
    
    public Estudiante() {
        this.id = 0;
        this.nombre = "";
        this.apellidos = "";
        this.seminario = "";
        this.confirmado = false;
        this.fecha_inscripcion = new Date(System.currentTimeMillis());
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminario() {
        return seminario;
    }

    public void setSeminario(String seminario) {
        this.seminario = seminario;
    }

    
    
    public boolean getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }
    
    
}
