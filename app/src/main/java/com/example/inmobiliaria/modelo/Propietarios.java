package com.example.inmobiliaria.modelo;

public class Propietarios {

    private int IdProp ;
    private String Nombre ;
    private String Apellido ;
    private String Dni ;
    private String Email ;
    private String Telefono ;
    private String Clave ;


    public Propietarios(){}
    public Propietarios(int IdProp , String Dni, String Nombre, String Apellido, String Email, String Clave, String Telefono) {
        this.IdProp= IdProp;
        this.Dni = Dni;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.Clave = Clave;
        this.Telefono = Telefono;
    }

    public int getIdProp() {
        return IdProp;
    }

    public void setIdProp(int idProp) {
        IdProp = idProp;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getDni() {
        return Dni;
    }

    public void setDni(String dni) {
        Dni = dni;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String clave) {
        Clave = clave;
    }
}
