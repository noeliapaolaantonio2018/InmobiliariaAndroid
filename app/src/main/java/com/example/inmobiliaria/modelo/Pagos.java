package com.example.inmobiliaria.modelo;

import java.io.Serializable;

public class Pagos implements Serializable {

    private int  IdPago ;
    private int  NumPago ;
   // public  int  IdContr ;
   private Contratos  Contratos ;
    private String  FechaPago;
    private Double  Importe ;


    public Pagos() {}

    public Pagos(int IdPago, int NumPago, Contratos Contratos, double Importe, String FechaPago) {
        this.IdPago = IdPago;
        this.NumPago = NumPago;
        this.Contratos = Contratos;
        this.Importe = Importe;
        this.FechaPago = FechaPago;
    }


    public int getIdPago() {
        return IdPago;
    }

    public void setIdPago(int idPago) {
        IdPago = idPago;
    }

    public int getNumPago() {
        return NumPago;
    }

    public void setNumPago(int numPago) {
        NumPago = numPago;
    }

    public com.example.inmobiliaria.modelo.Contratos getContratos() {
        return Contratos;
    }

    public void setContratos(com.example.inmobiliaria.modelo.Contratos contratos) {
        Contratos = contratos;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String fechaPago) {
        FechaPago = fechaPago;
    }

    public Double getImporte() {
        return Importe;
    }

    public void setImporte(Double importe) {
        Importe = importe;
    }
}
