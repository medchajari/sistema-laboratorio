/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Entidades.Paciente;
import Entidades.Profesionales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class profesionalesData {
      private Conexion con;
    public profesionalesData() {
        con = new Conexion(); 
        
    }
    
     public void agregarProfesional(String nombre_apellido, String telefono, String direccion) {
    try {
        Connection connection = con.getConexion(); 
        String sql = "INSERT INTO profesionales (nombre_apellido,telefono,direccion) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nombre_apellido);
        preparedStatement.setString(2, telefono);
        preparedStatement.setString(3, direccion); 
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
     public void actualizarProfesional(int id_profesional, String nombre_apellido, String telefono, String direccion) {
    try {
        Connection connection = con.getConexion();
        String sql = "UPDATE profesionales SET nombre_apellido=?, telefono=?, direccion=? WHERE id_profesional=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nombre_apellido);
        preparedStatement.setString(2, telefono);
        preparedStatement.setString(3, direccion); 
        preparedStatement.setInt(4, id_profesional); // ID del paciente
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
     
       public List<Profesionales> listarProfesionales() {
        List<Profesionales> profesionales = new ArrayList<>();
        try {
            Connection connection = con.getConexion();
            String sql = "SELECT * FROM profesionales";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_profesional = resultSet.getInt("id_profesional");
                String nombre_apellido = resultSet.getString("nombre_apellido");                
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
               

                Profesionales prof = new Profesionales(id_profesional,nombre_apellido,telefono, direccion);
                profesionales.add(prof);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return profesionales;
    }
     
     
     
     
     
     
}
