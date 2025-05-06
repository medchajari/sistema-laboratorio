/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Metodos;

import Entidades.HistorialObraSocial;
import Entidades.ObraSocial;
import Entidades.Paciente;
import Entidades.Protocolo;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author MeD
 */
public class obrasocialData {
     private Conexion con;
      public obrasocialData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
        pacienteData pData = new pacienteData();
        TipoProtocoloData tpData = new TipoProtocoloData();
    }
      
      
       public void agregarObraSocial(String nombre, double porcentaje, String observacion, int estado) {
        try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "INSERT INTO obra_social (nombre,porcentaje,observacion,estado) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        preparedStatement.setDouble(2, porcentaje);
        preparedStatement.setString(3, observacion); 
        preparedStatement.setInt(4, estado);
	
        
        preparedStatement.executeUpdate();
        preparedStatement.close();
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
       
         public void actualizarObra(int idObraSocial, String nombre, double porcentaje, String observacion, int estado) {
    try {
        Connection connection = con.getConexion();
        String sql = "UPDATE obra_social SET nombre=?, porcentaje=?, observacion=?, estado=? WHERE id_obra_social=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        preparedStatement.setDouble(2, porcentaje);
        preparedStatement.setString(3, observacion);
        preparedStatement.setInt(4, estado);
        preparedStatement.setInt(5, idObraSocial);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
         
          public void eliminarObraSocial(int idObraSocial) {
    try {
        Connection connection = con.getConexion();
        String sql = "DELETE FROM obra_social WHERE id_obra_social=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idObraSocial);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
         
     public ObraSocial buscarObraSocial(int id_obra_social ) {
         ObraSocial obraSocial = null;
    try {
        Connection connection = con.getConexion();
        String sql = "SELECT * FROM obra_social WHERE id_obra_social = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_obra_social);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int idObraSocial = resultSet.getInt("id_obra_social");
            String nombre = resultSet.getString("nombre");
            double porcentaje = resultSet.getDouble("porcentaje");
            String observacion = resultSet.getString("observacion");
            int estado = resultSet.getInt("estado");

            obraSocial = new ObraSocial(idObraSocial, nombre, porcentaje, observacion, estado);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return obraSocial;
    }
      
    public List<ObraSocial> listarObraSocial() {
    List<ObraSocial> listaObraSocial = new ArrayList<>();
    try {
        Connection connection = con.getConexion();
        String sql = "SELECT * FROM obra_social ORDER BY id_obra_social";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int idObraSocial = resultSet.getInt("id_obra_social");
            String nombre = resultSet.getString("nombre");
            double porcentaje = resultSet.getDouble("porcentaje"); // No necesitas Double, solo double
            String observacion = resultSet.getString("observacion");
            int estado = resultSet.getInt("estado"); // Aquí se corrige el nombre de la columna

            ObraSocial oSocial = new ObraSocial(idObraSocial, nombre, porcentaje, observacion, estado);
            listaObraSocial.add(oSocial);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listaObraSocial;
}      
    
    
    // zona historial
         
    
    
    public void agregarHistorialObraSocial(int id_obra_social, int id_paciente, String numero_protocolo, double monto, String forma_de_pago, String estado) {
        try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "INSERT INTO historial_obra_social (id_obra_social, id_paciente, numero_protocolo, monto, forma_de_pago, estado) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_obra_social);
        preparedStatement.setInt(2, id_paciente);
        preparedStatement.setString(3, numero_protocolo);
        preparedStatement.setDouble(4, monto);
        preparedStatement.setString(5, forma_de_pago);
        preparedStatement.setString(6, estado);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
        }
    
    
// public ObraSocial buscarObraSocialPorId(int idObraSocial) {
//    ObraSocial obraSocial = null;
//    try {
//        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
//        String sql = "SELECT * FROM obra_social WHERE id_obra_social = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1, idObraSocial);
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        if (resultSet.next()) {
//            String nombre = resultSet.getString("nombre");
//            double porcentaje = resultSet.getDouble("porcentaje");
//            String observacion = resultSet.getString("observacion");
//            int estado = resultSet.getInt("estado");
//
//            obraSocial = new ObraSocial();
//            obraSocial.setId_obra_social(idObraSocial);
//            obraSocial.setNombre(nombre);
//            obraSocial.setPorcentaje(porcentaje);
//            obraSocial.setObservacion(observacion);
//            obraSocial.setEstado(estado);
//        }
//
//        resultSet.close();
//        preparedStatement.close();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//    return obraSocial;
//}


    
//public List<HistorialObraSocial> buscarHistorialPorFechas(Date fechaDesde, Date fechaHasta, boolean todos, String tipoProtocolo, ObraSocial obraSocial) {
//    List<HistorialObraSocial> historialList = new ArrayList<>();
//    try {
//        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
//        StringBuilder sql = new StringBuilder("SELECT * FROM historial_obra_social WHERE fecha_solicitud BETWEEN ? AND ?");
//        
//        if (!todos) {
//            if (tipoProtocolo != null && !tipoProtocolo.isEmpty()) {
//                sql.append(" AND numero_protocolo = ?");
//            }
//            if (obraSocial != null) {
//                sql.append(" AND id_obra_social = ?");
//            }
//        }
//
//        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
//        preparedStatement.setDate(1, new java.sql.Date(fechaDesde.getTime()));
//        preparedStatement.setDate(2, new java.sql.Date(fechaHasta.getTime()));
//        
//        int paramIndex = 3;
//
//        if (!todos) {
//            if (tipoProtocolo != null && !tipoProtocolo.isEmpty()) {
//                preparedStatement.setString(paramIndex++, tipoProtocolo);
//            }
//            if (obraSocial != null) {
//                preparedStatement.setInt(paramIndex++, obraSocial.getId_obra_social());
//            }
//        }
//
//        ResultSet resultSet = preparedStatement.executeQuery();
//
//        while (resultSet.next()) {
//            int idHistorial = resultSet.getInt("id_historial_obra_social");
//            int idObraSocial = resultSet.getInt("id_obra_social");
//            int idPaciente = resultSet.getInt("id_paciente");
//            String numeroProtocolo = resultSet.getString("numero_protocolo");
//            Timestamp fechaSolicitud = resultSet.getTimestamp("fecha_solicitud");
//            double monto = resultSet.getDouble("monto");
//            String formaDePago = resultSet.getString("forma_de_pago");
//            String estado = resultSet.getString("estado");
//
//            // Cargar entidades relacionadas
//            pacienteData pacDta = new pacienteData();
//            protocoloData proData = new protocoloData();
//            ObraSocial os = buscarObraSocialPorId(idObraSocial); 
//            Paciente paciente = pacDta.buscarPacientePorId(idPaciente);
//            Protocolo protocolo = proData.buscarProtocoloPorNumero(numeroProtocolo);
//
//            HistorialObraSocial historial = new HistorialObraSocial(
//                idHistorial, os, paciente, protocolo, fechaSolicitud, monto, formaDePago, estado
//            );
//
//            historialList.add(historial);
//        }
//
//        resultSet.close();
//        preparedStatement.close();
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//    return historialList;
//}

    
    public List<HistorialObraSocial> buscarHistorialPorFechas(Date fechaDesde, Date fechaHasta, boolean todos, String tipoProtocolo, ObraSocial obraSocial) {
    List<HistorialObraSocial> historialList = new ArrayList<>();
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        StringBuilder sql = new StringBuilder("SELECT * FROM historial_obra_social WHERE fecha_solicitud BETWEEN ? AND ?");
        
        if (!todos) {
            if (tipoProtocolo != null && !tipoProtocolo.isEmpty()) {
                sql.append(" AND numero_protocolo = ?");
            }
            if (obraSocial != null) {
                sql.append(" AND id_obra_social = ?");
            }
        }

        PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
        preparedStatement.setDate(1, new java.sql.Date(fechaDesde.getTime()));
        preparedStatement.setDate(2, new java.sql.Date(fechaHasta.getTime()));
        
        int paramIndex = 3;

        if (!todos) {
            if (tipoProtocolo != null && !tipoProtocolo.isEmpty()) {
                preparedStatement.setString(paramIndex++, tipoProtocolo);
            }
            if (obraSocial != null) {
                preparedStatement.setInt(paramIndex++, obraSocial.getId_obra_social());
            }
        }

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int idHistorial = resultSet.getInt("id_historial_obra_social");
            int idObraSocial = resultSet.getInt("id_obra_social");
            int idPaciente = resultSet.getInt("id_paciente");
            String numeroProtocolo = resultSet.getString("numero_protocolo");
            Timestamp fechaSolicitud = resultSet.getTimestamp("fecha_solicitud");
            double monto = resultSet.getDouble("monto");
            String formaDePago = resultSet.getString("forma_de_pago");
            String estado = resultSet.getString("estado");

            // Cargar entidades relacionadas
            ObraSocial os = buscarObraSocialPorId(idObraSocial); 
            pacienteData pacData = new pacienteData();
            Paciente paciente = pacData.buscarPacientePorId(idPaciente);
            protocoloData proData = new protocoloData();
            Protocolo protocolo = proData.buscarProtocoloPorNumero(numeroProtocolo);

            HistorialObraSocial historial = new HistorialObraSocial(
                idHistorial, os, paciente, protocolo, fechaSolicitud, monto, formaDePago, estado
            );

            historialList.add(historial);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return historialList;
}
    
    
public ObraSocial buscarObraSocialPorId(int idObraSocial) {
    ObraSocial obraSocial = null;
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "SELECT * FROM obra_social WHERE id_obra_social = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idObraSocial);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            double porcentaje = resultSet.getDouble("porcentaje");
            String observacion = resultSet.getString("observacion");
            int estado = resultSet.getInt("estado");

            obraSocial = new ObraSocial();
            obraSocial.setId_obra_social(idObraSocial);
            obraSocial.setNombre(nombre);
            obraSocial.setPorcentaje(porcentaje);
            obraSocial.setObservacion(observacion);
            obraSocial.setEstado(estado);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return obraSocial;
}

  public ObraSocial buscarObraSocialPorId2(int idObraSocial) {
    ObraSocial obraSocial = null;
    try {
        Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
        String sql = "SELECT * FROM obra_social WHERE id_obra_social = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idObraSocial);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            double porcentaje = resultSet.getDouble("porcentaje");
            String observacion = resultSet.getString("observacion");
            int estado = resultSet.getInt("estado");
            obraSocial = new ObraSocial();
            obraSocial.setId_obra_social(idObraSocial);
            obraSocial.setNombre(nombre);
            obraSocial.setPorcentaje(porcentaje);
            obraSocial.setObservacion(observacion);
            obraSocial.setEstado(estado);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return obraSocial;
} 
}
