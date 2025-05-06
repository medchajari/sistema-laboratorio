/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author MeD
 */
public class ObraSocial {

                
                private int id_obra_social;
                private String nombre;
                private double porcentaje;
                private String observacion;
                private int estado;

    public ObraSocial() {
    }

    public ObraSocial(int id_obra_social, String nombre, double porcentaje, String observacion, int estado) {
        this.id_obra_social = id_obra_social;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.observacion = observacion;
        this.estado = estado;
    }

    public int getId_obra_social() {
        return id_obra_social;
    }

    public void setId_obra_social(int id_obra_social) {
        this.id_obra_social = id_obra_social;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ObraSocial{" + "id_obra_social=" + id_obra_social + ", nombre=" + nombre + ", porcentaje=" + porcentaje + ", observacion=" + observacion + ", estado=" + estado + '}';
    }
                
                
}
