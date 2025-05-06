
package Entidades;

import java.util.Date;


public class Protocolo {
    
     private int idProtocolo;
    private int idPaciente;
    private String numero_protocolo;
    private String medico;
    private String tipo;
    private Date fechaEntrada;
    private Date fechaSalida;
    private String estado;
    private double monto;

 
    public Protocolo() {
    }

 
    public Protocolo(int idProtocolo, int idPaciente, String numero_protocolo, String medico, String tipo, Date fechaEntrada, Date fechaSalida, String estado, double monto) {
        this.idProtocolo = idProtocolo;
        this.idPaciente = idPaciente;
        this.numero_protocolo = numero_protocolo;
        this.medico = medico;
        this.tipo = tipo;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.estado = estado;
        this.monto = monto;
    }

  
    public int getIdProtocolo() {
        return idProtocolo;
    }

    public void setIdProtocolo(int idProtocolo) {
        this.idProtocolo = idProtocolo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNumero_protocolo() {
        return numero_protocolo;
    }

    public void setNumero_protocolo(String numero_protocolo) {
        this.numero_protocolo = numero_protocolo;
    }

    

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Protocolo{" + "idProtocolo=" + idProtocolo + ", idPaciente=" + idPaciente + ", numero_protocolo=" + numero_protocolo + ", medico=" + medico + ", tipo=" + tipo + ", fechaEntrada=" + fechaEntrada + ", fechaSalida=" + fechaSalida + ", estado=" + estado + ", monto=" + monto + '}';
    }

    
    
    
    
}
