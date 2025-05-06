/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Timestamp;

public class CuentaCorriente {
    private int id_cc;
    private int id_paciente;
    private int id_caja;
    private String usuario;
    private Timestamp fecha;
    private double egreso;
    private double ingreso;
    private Paciente paciente;

    public CuentaCorriente() {
    }

    public CuentaCorriente(int id_cc, int id_paciente, int id_caja, String usuario, Timestamp fecha, double egreso, double ingreso, Paciente paciente) {
        this.id_cc = id_cc;
        this.id_paciente = id_paciente;
        this.id_caja = id_caja;
        this.usuario = usuario;
        this.fecha = fecha;
        this.egreso = egreso;
        this.ingreso = ingreso;
        this.paciente = paciente;
    }

    public int getId_cc() {
        return id_cc;
    }

    public void setId_cc(int id_cc) {
        this.id_cc = id_cc;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_caja() {
        return id_caja;
    }

    public void setId_caja(int id_caja) {
        this.id_caja = id_caja;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

  

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public double getEgreso() {
        return egreso;
    }

    public void setEgreso(double egreso) {
        this.egreso = egreso;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }
    
     public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" + "id_cc=" + id_cc + ", id_paciente=" + id_paciente + ", id_caja=" + id_caja + ", usuario=" + usuario + ", fecha=" + fecha + ", egreso=" + egreso + ", ingreso=" + ingreso + ", paciente=" + paciente + '}';
    }

   
    
    
    
    
    
    
    
    
    
} 