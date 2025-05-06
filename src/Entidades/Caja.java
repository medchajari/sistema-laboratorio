/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.sql.Timestamp;

public class Caja {
    private int idCaja;
    private String usuario;
    private double monto;
    private String forma_de_pago;
    private String numero_protocolo;
    private Timestamp fecha;
    private double efectivo;
    private double transferencia;
    private double cuenta_corriente;
    private double obra_social;

    public Caja() {
    }

    public Caja(int idCaja, String usuario, double monto, String forma_de_pago, String numero_protocolo, Timestamp fecha, double efectivo, double transferencia, double cuenta_corriente, double obra_social) {
        this.idCaja = idCaja;
        this.usuario = usuario;
        this.monto = monto;
        this.forma_de_pago = forma_de_pago;
        this.numero_protocolo = numero_protocolo;
        this.fecha = fecha;
        this.efectivo = efectivo;
        this.transferencia = transferencia;
        this.cuenta_corriente = cuenta_corriente;
        this.obra_social = obra_social;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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

    public String getNumero_protocolo() {
        return numero_protocolo;
    }

    public void setNumero_protocolo(String numero_protocolo) {
        this.numero_protocolo = numero_protocolo;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
    
    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(double transferencia) {
        this.transferencia = transferencia;
    }

    public double getCuenta_corriente() {
        return cuenta_corriente;
    }

    public void setCuenta_corriente(double cuenta_corriente) {
        this.cuenta_corriente = cuenta_corriente;
    }

    public double getObra_social() {
        return obra_social;
    }

    public void setObra_social(double obra_social) {
        this.obra_social = obra_social;
    }

    @Override
    public String toString() {
        return "Caja{" + "idCaja=" + idCaja + ", usuario=" + usuario + ", monto=" + monto + ", forma_de_pago=" + forma_de_pago + ", numero_protocolo=" + numero_protocolo + ", fecha=" + fecha + ", efectivo=" + efectivo + ", transferencia=" + transferencia + ", cuenta_corriente=" + cuenta_corriente + ", obra_social=" + obra_social + '}';
    }

   

     
     

}
