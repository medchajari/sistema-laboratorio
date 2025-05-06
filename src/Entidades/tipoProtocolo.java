/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


public class tipoProtocolo {
    
    private int id_tipo;
    private String estudio;
     private String profesional;

    public tipoProtocolo() {
    }

    public tipoProtocolo(int id_tipo, String estudio, String profesional) {
        this.id_tipo = id_tipo;
        this.estudio = estudio;
        this.profesional = profesional;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getProfesional() {
        return profesional;
    }

    public void setProfesional(String profesional) {
        this.profesional = profesional;
    }

    @Override
    public String toString() {
        return "tipoProtocolo{" + "id_tipo=" + id_tipo + ", estudio=" + estudio + ", profesional=" + profesional + '}';
    }
     
     
    
    
}
