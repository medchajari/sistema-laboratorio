/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author MeD
 */
public class FormaDePago {

    
     private int id_forma_de_pago;
     private int id_protocolo;
     private String metodo;
     private double monto;

    public FormaDePago() {
    }

    public FormaDePago(int id_forma_de_pago, int id_protocolo, String metodo, double monto) {
        this.id_forma_de_pago = id_forma_de_pago;
        this.id_protocolo = id_protocolo;
        this.metodo = metodo;
        this.monto = monto;
    }

    public int getId_forma_de_pago() {
        return id_forma_de_pago;
    }

    public void setId_forma_de_pago(int id_forma_de_pago) {
        this.id_forma_de_pago = id_forma_de_pago;
    }

    public int getId_protocolo() {
        return id_protocolo;
    }

    public void setId_protocolo(int id_protocolo) {
        this.id_protocolo = id_protocolo;
    }
    
    

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "FormaDePago{" + "id_forma_de_pago=" + id_forma_de_pago + ", numero_protocolo=" + id_protocolo + ", metodo=" + metodo + ", monto=" + monto + '}';
    }

     
     
}
