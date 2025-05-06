/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


public class Profesionales {
    private int id_profesional;
    private String nombre_apellido;
    private String telefono;
    private String direccion;

    public Profesionales() {
    }

    public Profesionales(int id_profesional, String nombre_apellido, String telefono, String direccion) {
        this.id_profesional = id_profesional;
        this.nombre_apellido = nombre_apellido;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId_profesional() {
        return id_profesional;
    }

    public void setId_profesional(int id_profesional) {
        this.id_profesional = id_profesional;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Profesionales{" + "id_profesional=" + id_profesional + ", nombre_apellido=" + nombre_apellido + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }
    
    
    
    
    
    
}
