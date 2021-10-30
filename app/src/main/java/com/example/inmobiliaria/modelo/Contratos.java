package com.example.inmobiliaria.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Contratos implements Serializable {

    private int IdContr ;
    private int IdInq ;
    private Inquilinos Inquilinos ;
    private int IdInm ;
    private Inmuebles Inmuebles ;
    private String FechaInicio;
    private String FechaCierre ;
    private double Monto;


    public Contratos(){}

    public Contratos(int IdContr, String fechaInicio, String fechaCierre, double monto, Inquilinos inquilinos, Inmuebles inmuebles) {
        this.IdContr = IdContr;
        this.FechaInicio = fechaInicio;
        this.FechaCierre = fechaCierre;
        this.Monto = monto;
        this.Inquilinos = inquilinos;
        this.Inmuebles = inmuebles;
    }

    public int getIdContr() {
        return IdContr;
    }

    public void setIdContr(int idContr) {
        IdContr = idContr;
    }

    public int getIdInq() {
        return IdInq;
    }

    public void setIdInq(int idInq) {
        IdInq = idInq;
    }

    public Inquilinos getInquilinos() {
        return Inquilinos;
    }

    public void setInquilinos(Inquilinos inquilinos) {
        Inquilinos = inquilinos;
    }

    public int getIdInm() {
        return IdInm;
    }

    public void setIdInm(int idInm) {
        IdInm = idInm;
    }

    public Inmuebles getInmuebles() {
        return Inmuebles;
    }

    public void setInmuebles(Inmuebles inmuebles) {
        Inmuebles = inmuebles;
    }

    public String getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public String getFechaCierre() {
        return FechaCierre;
    }

    public void setFechaCierre(String fechaCierre) {
        FechaCierre = fechaCierre;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double monto) {
        Monto = monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contratos contratos = (Contratos) o;
        return IdContr == contratos.IdContr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IdContr);
    }
}
