/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author MeD
 */
public class HistorialObraSocial {
    

    private int id_historial_obra_social;
    private ObraSocial id_obra_social;
    private Paciente id_paciente;
    private Protocolo numero_protocolo;
    private Timestamp fecha_solicitud;
    private double monto;
    private String forma_de_pago;
    private String estado;

    public HistorialObraSocial() {
    }
    
    public HistorialObraSocial(int id_historial_obra_social, ObraSocial id_obra_social, Paciente id_paciente, Protocolo numero_protocolo, Timestamp fecha_solicitud, double monto, String forma_de_pago, String estado) {
    this.id_historial_obra_social = id_historial_obra_social;
    this.id_obra_social = id_obra_social;
    this.id_paciente = id_paciente;
    this.numero_protocolo = numero_protocolo;
    this.fecha_solicitud = fecha_solicitud;
    this.monto = monto;
    this.forma_de_pago = forma_de_pago;
    this.estado = estado;
}

  

    

    

   

    public int getId_historial_obra_social() {
        return id_historial_obra_social;
    }

    public void setId_historial_obra_social(int id_historial_obra_social) {
        this.id_historial_obra_social = id_historial_obra_social;
    }

    public ObraSocial getId_obra_social() {
        return id_obra_social;
    }

    public void setId_obra_social(ObraSocial id_obra_social) {
        this.id_obra_social = id_obra_social;
    }

    public Paciente getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Paciente id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Protocolo getNumero_protocolo() {
        return numero_protocolo;
    }

    public void setNumero_protocolo(Protocolo numero_protocolo) {
        this.numero_protocolo = numero_protocolo;
    }

    

    public Timestamp getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Timestamp fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getForma_de_pago() {
        return forma_de_pago;
    }

    public void setForma_de_pago(String forma_de_pago) {
        this.forma_de_pago = forma_de_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "HistorialObraSocial{" + "id_historial_obra_social=" + id_historial_obra_social + ", id_obra_social=" + id_obra_social + ", id_paciente=" + id_paciente + ", numero_protocolo=" + numero_protocolo + ", fecha_solicitud=" + fecha_solicitud + ", monto=" + monto + ", forma_de_pago=" + forma_de_pago + ", estado=" + estado + '}';
    }

   


   

    
    
    
}
