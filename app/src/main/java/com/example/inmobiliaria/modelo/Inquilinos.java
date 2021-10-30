package com.example.inmobiliaria.modelo;

import java.io.Serializable;

public class Inquilinos implements Serializable {

    public int IdInq ;
    public String Nombre ;
    public String Apellido ;
    public String Dni ;
    public String Telefono ;
    public String DireccionTrabajo ;
    public String Nombre_Garante ;
    public String Dni_Garante ;

    public Inquilinos(int IdInq, int i,String Noelia, String Antonio, String lugarDeTrabajo, String Telefono, String Marcos_Solis, String Dni_Garante) {}

    public Inquilinos(int idInq, String Nombre, String Apellido, String DireccionTrabajo, String Telefono, String Nombre_Garante, String Dni_Garante) {
        this.IdInq = IdInq;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.DireccionTrabajo = DireccionTrabajo;
        this.Telefono = Telefono;
        this.Nombre_Garante = Nombre_Garante;
        this.Dni_Garante = Dni_Garante;
    }

    public int getIdInq() {
        return IdInq;
    }

    public void setIdInq(int IdInq) {
        this.IdInq = IdInq;
    }


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDireccionTrabajo() {
        return DireccionTrabajo;
    }

    public void setDireccionTrabajo(String DireccionTrabajo) {
        this.DireccionTrabajo = DireccionTrabajo;
    }


    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getNombreGarante() {
        return Nombre_Garante;
    }

    public void setNombre_Garante(String Nombre_Garante) {
        this.Nombre_Garante = Nombre_Garante;
    }

    public String getDni_Garante() {
        return  Dni_Garante;
    }

    public void setDni_Garante(String  Dni_Garante) {
        this. Dni_Garante =  Dni_Garante;
    }

}
