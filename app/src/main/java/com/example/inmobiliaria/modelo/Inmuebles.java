package com.example.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Inmuebles implements Serializable {

    public int IdInm ;
    public Propietarios Propietarios ;
    public String Direccion;
    public String Tipo ;
    public String Uso ;
    public int CantAmbientes;
    public double Costo ;
    public boolean Disponible ;
    public String Imagen ;

    public Inmuebles(int IdInmu, String Direccion, String Uso, String Tipo, int CantAmbientes, double Costo, Propietarios propietarios, boolean Disponible, String Imagen) {
        this.IdInm = IdInmu;
        this.Direccion = Direccion;
        this.Uso = Uso;
        this.Tipo = Tipo;
        this.CantAmbientes = CantAmbientes;
        this.Costo = Costo;
        this.Propietarios = Propietarios;
        this.Disponible = Disponible;
        this.Imagen = Imagen;
    }
    public Inmuebles() {

    }
    public int getIdInm() {
        return IdInm;
    }

    public void setIdInm(int IdInm) {
        this.IdInm = IdInm;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        this.Uso = Uso;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getCantAmbientes() {
        return CantAmbientes;
    }

    public void setCantAmbientes(int CantAmbientes) {
        this.CantAmbientes = CantAmbientes;
    }

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    public Propietarios getPropietarios() {
        return getPropietarios();
    }

    public void setPropietarios(Propietarios propietarios) {
        this.Propietarios = propietarios;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inmuebles inmuebles = (Inmuebles) o;
        return IdInm == inmuebles.IdInm;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdInm);
    }
}
