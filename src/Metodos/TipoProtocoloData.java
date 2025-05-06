/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Entidades.Paciente;
import Entidades.Profesionales;
import Entidades.Protocolo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Entidades.tipoProtocolo;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MeD
 */
public class TipoProtocoloData {
   private Conexion con;
    public TipoProtocoloData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        
    } 
    
         public void agregarTipoProtocolo(String estudio, String profesional) {
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "INSERT INTO tipo_protocolo (estudio,profesional) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, estudio);
        preparedStatement.setString(2, profesional);
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
     public void actualizarTipoProtocolo(int id_tipo, String estudio, String profesional) {
    try {
        Connection connection = con.getConexion();
        String sql = "UPDATE tipo_protocolo SET estudio=?, profesional=?  WHERE id_tipo=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, estudio);
        preparedStatement.setString(2, profesional);
        preparedStatement.setInt(3, id_tipo); // ID del paciente
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
          
     
       public List<tipoProtocolo> listarTipoProtocolo() {
        List<tipoProtocolo> tipoprotocolo = new ArrayList<>();
        try {
            Connection connection = con.getConexion();
            String sql = "SELECT * FROM tipo_protocolo";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_tipo = resultSet.getInt("id_tipo");
                String estudio = resultSet.getString("estudio");                
                String profesional = resultSet.getString("profesional");
               

                tipoProtocolo tipprot = new tipoProtocolo(id_tipo,estudio,profesional);
                tipoprotocolo.add(tipprot);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipoprotocolo;
    }
       
       public tipoProtocolo buscarTipoProtocoloPorId(int id_tipo) {
    tipoProtocolo tipoProtocolo = null;
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "SELECT * FROM tipo_protocolo WHERE id_tipo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_tipo);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            // Extraer los datos del ResultSet
            String estudio = resultSet.getString("estudio");
            String profesional = resultSet.getString("profesional");

            // Crear un nuevo objeto tipoProtocolo y establecer sus campos
            tipoProtocolo = new tipoProtocolo();
            tipoProtocolo.setId_tipo(id_tipo);
            tipoProtocolo.setEstudio(estudio);
            tipoProtocolo.setProfesional(profesional);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tipoProtocolo;
}
       
      public List<Protocolo> obtenerProtocolosConObraSocialPorFechaYTipo(Date fechaDesde, Date fechaHasta, int idTipoProtocolo) {
    List<Protocolo> protocolos = new ArrayList<>();

    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "SELECT p.*, tp.estudio, c.obra_social " +
                     "FROM protocolo p " +
                     "JOIN tipo_protocolo tp ON p.tipo = tp.estudio " +
                     "JOIN caja c ON p.numero_protocolo = c.numero_protocolo " +
                     "WHERE c.obra_social IS NOT NULL " +
                     "AND c.obra_social != 0 " +
                     "AND p.fecha_entrada BETWEEN ? AND ? " +
                     "AND tp.id_tipo = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, new java.sql.Date(fechaDesde.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(fechaHasta.getTime()));
        preparedStatement.setInt(3, idTipoProtocolo);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Protocolo protocolo = new Protocolo();
            protocolo.setIdProtocolo(resultSet.getInt("id_protocolo"));
            protocolo.setIdPaciente(resultSet.getInt("id_paciente"));
            protocolo.setNumero_protocolo(resultSet.getString("numero_protocolo"));
            protocolo.setMedico(resultSet.getString("medico"));
            protocolo.setTipo(resultSet.getString("tipo"));
            protocolo.setFechaEntrada(resultSet.getDate("fecha_entrada"));
            protocolo.setFechaSalida(resultSet.getDate("fecha_salida"));
            protocolo.setEstado(resultSet.getString("estado"));
            protocolo.setMonto(resultSet.getDouble("monto"));

            // Asignar el estudio desde tipoProtocolo como tipo en Protocolo
            protocolo.setTipo(resultSet.getString("estudio"));

            protocolos.add(protocolo);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return protocolos;
}

      
         public List<Protocolo> obtenerProtocolosConObraSocialPorFechaYTipo2(Date fechaDesde, Date fechaHasta, int idTipoProtocolo) {
    List<Protocolo> protocolos = new ArrayList<>();

    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "SELECT p.*, tp.estudio, c.obra_social " +
                     "FROM protocolo p " +
                     "JOIN tipo_protocolo tp ON p.tipo = tp.estudio " +
                     "JOIN caja c ON p.numero_protocolo = c.numero_protocolo " +
                     "WHERE c.obra_social IS NOT NULL " +
                     "AND c.obra_social != 0 " +
                     "AND p.fecha_entrada BETWEEN ? AND ? " +
                     "AND tp.id_tipo = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, new java.sql.Date(fechaDesde.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(fechaHasta.getTime()));
        preparedStatement.setInt(3, idTipoProtocolo);

        ResultSet resultSet = preparedStatement.executeQuery();
Paciente pac = new Paciente();
        while (resultSet.next()) {
            Protocolo protocolo = new Protocolo();
            protocolo.setIdProtocolo(resultSet.getInt("id_protocolo"));
            protocolo.setIdPaciente(resultSet.getInt("id_paciente"));
            pac.setApellido(resultSet.getString("Apellido"));
            protocolo.setNumero_protocolo(resultSet.getString("numero_protocolo"));
            protocolo.setMedico(resultSet.getString("medico"));
            protocolo.setTipo(resultSet.getString("tipo"));
            protocolo.setFechaEntrada(resultSet.getDate("fecha_entrada"));
            protocolo.setFechaSalida(resultSet.getDate("fecha_salida"));
            protocolo.setEstado(resultSet.getString("estado"));
            protocolo.setMonto(resultSet.getDouble("monto"));

            // Asignar el estudio desde tipoProtocolo como tipo en Protocolo
            protocolo.setTipo(resultSet.getString("estudio"));

            protocolos.add(protocolo);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return protocolos;
}


}
