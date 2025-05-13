package Metodos;

import Entidades.CuentaCorriente;
import Entidades.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;
public class CuentaCorrienteData {
    private Conexion con;

    public CuentaCorrienteData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion
    }
    
  


    public void agregarCuentaCorriente(int id_paciente, int id_caja, String usuario, Timestamp fecha, double egreso, double ingreso) throws SQLException {
        String sql = "INSERT INTO cuenta_corriente (id_paciente, id_caja, usuario, fecha, egreso, ingreso) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = con.getConexion(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_paciente);
            statement.setInt(2, id_caja);
            statement.setString(3, usuario);
            statement.setTimestamp(4, fecha);
            statement.setDouble(5, egreso);
            statement.setDouble(6, ingreso);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error al agregar registro a cuenta_corriente: " + e.getMessage());
        }
    }
    

public List<CuentaCorriente> listarTransferenciasConPaciente(Date desde, Date hasta) {
    List<CuentaCorriente> transferencias = new ArrayList<>();
    String sql = "SELECT cc.*, p.nombre, p.apellido FROM cuenta_corriente cc " +
                 "JOIN pacientes p ON cc.id_paciente = p.id_paciente " +
                 "WHERE cc.fecha BETWEEN ? AND ?";
    
    try (Connection connection = con.getConexion(); PreparedStatement ps = connection.prepareStatement(sql)) {
        
        ps.setDate(1, new java.sql.Date(desde.getTime()));
        ps.setDate(2, new java.sql.Date(hasta.getTime()));
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            // Crear el objeto Paciente con el nombre y apellido obtenidos del ResultSet
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rs.getInt("id_paciente"));
            paciente.setNombre(rs.getString("nombre"));
            paciente.setApellido(rs.getString("apellido"));
            
            // Crear el objeto CuentaCorriente con el objeto Paciente
            CuentaCorriente cc = new CuentaCorriente(
                rs.getInt("id_cc"),
                rs.getInt("id_paciente"),
                rs.getInt("id_caja"),
                rs.getString("usuario"),
                rs.getTimestamp("fecha"),
                rs.getDouble("egreso"),
                rs.getDouble("ingreso"),
                paciente  // Pasar el objeto Paciente al constructor
            );
            
            transferencias.add(cc);
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return transferencias;
}
 public List<CuentaCorriente> listarCuentasPorPaciente(int idPaciente) {
    List<CuentaCorriente> cuentas = new ArrayList<>();
    String sql = "SELECT cc.*, p.nombre, p.apellido FROM cuenta_corriente cc " +
                 "JOIN pacientes p ON cc.id_paciente = p.id_paciente " +
                 "WHERE cc.id_paciente = ?";
    
    try (Connection connection = con.getConexion(); 
         PreparedStatement ps = connection.prepareStatement(sql)) {
        
        ps.setInt(1, idPaciente);
        
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            // Crear el objeto Paciente con el nombre y apellido obtenidos del ResultSet
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(rs.getInt("id_paciente"));
            paciente.setNombre(rs.getString("nombre"));
            paciente.setApellido(rs.getString("apellido"));
            
            // Crear el objeto CuentaCorriente con el objeto Paciente
            CuentaCorriente cuentaCorriente = new CuentaCorriente(
                rs.getInt("id_cc"),
                rs.getInt("id_paciente"),
                rs.getInt("id_caja"),
                rs.getString("usuario"),
                rs.getTimestamp("fecha"),
                rs.getDouble("egreso"),
                rs.getDouble("ingreso"),
                paciente  // Pasar el objeto Paciente al constructor
            );
            
            cuentas.add(cuentaCorriente);
        }
        
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    
    return cuentas;
}


}
