
package Metodos;




import Entidades.Caja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class cajaData {
    private Conexion con;

    public cajaData() {
        con = new Conexion(); // Crear una instancia de la clase Conexion        
    }      

    public void agregarEntradaCaja1(String usuario, double monto, String formaDePago, String numeroProtocolo, Timestamp fecha, double efectivo, double transferencia, double cuentaCorriente, double obraSocial) throws SQLException {
        String sql = "INSERT INTO caja (usuario, monto, forma_de_pago, numero_protocolo, fecha, efectivo, transferencia, cuenta_corriente, obra_social) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = con.getConexion(); PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario);
            statement.setDouble(2, monto);
            statement.setString(3, formaDePago);
            statement.setString(4, numeroProtocolo);
            statement.setTimestamp(5, fecha);
            statement.setDouble(6, efectivo);
            statement.setDouble(7, transferencia);
            statement.setDouble(8, cuentaCorriente);
            statement.setDouble(9, obraSocial);
            statement.executeUpdate();
        }
    }
    
    public int agregarEntradaCaja(String usuario, double monto, String formaDePago, String numeroProtocolo, Timestamp fecha, double efectivo, double transferencia, double cuentaCorriente, double obraSocial) throws SQLException {
        String sql = "INSERT INTO caja (usuario, monto, forma_de_pago, numero_protocolo, fecha, efectivo, transferencia, cuenta_corriente, obra_social) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int idCaja = -1;

        try (Connection connection = con.getConexion(); PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, usuario);
            statement.setDouble(2, monto);
            statement.setString(3, formaDePago);
            statement.setString(4, numeroProtocolo);
            statement.setTimestamp(5, fecha);
            statement.setDouble(6, efectivo);
            statement.setDouble(7, transferencia);
            statement.setDouble(8, cuentaCorriente);
            statement.setDouble(9, obraSocial);
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    idCaja = generatedKeys.getInt(1);
                }
            }
        }
        return idCaja;
    }
    
    
    public List<Caja> buscarPorFormaDePago(String formaDePago) {
        List<Caja> listaCajas = new ArrayList<>();
        try {
            Connection connection = con.getConexion();  // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT * FROM caja WHERE forma_de_pago = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, formaDePago);  // Establecer el parámetro de la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Caja caja = new Caja();
                caja.setIdCaja(resultSet.getInt("idCaja"));
                caja.setUsuario(resultSet.getString("usuario"));
                caja.setMonto(resultSet.getDouble("monto"));
                caja.setForma_de_pago(resultSet.getString("forma_de_pago"));
                caja.setNumero_protocolo(resultSet.getString("numero_protocolo"));
                caja.setFecha(resultSet.getTimestamp("fecha"));
                caja.setEfectivo(resultSet.getDouble("efectivo"));
                caja.setTransferencia(resultSet.getDouble("transferencia"));
                caja.setCuenta_corriente(resultSet.getDouble("cuenta_corriente"));
                caja.setObra_social(resultSet.getDouble("obra_social"));
                
                listaCajas.add(caja);  // Añadir el objeto Caja a la lista
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaCajas;  // Retornar la lista de resultados
    }
    
    public List<Caja> buscarPorFormaDePagoYFechas(String formaDePago, Date fechaDesde, Date fechaHasta) {
    List<Caja> listaCajas = new ArrayList<>();
    try {
        Connection connection = con.getConexion();
        String sql = "SELECT * FROM caja WHERE forma_de_pago = ? AND fecha BETWEEN ? AND ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, formaDePago);
        preparedStatement.setDate(2, new java.sql.Date(fechaDesde.getTime()));
        preparedStatement.setDate(3, new java.sql.Date(fechaHasta.getTime()));
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            Caja caja = new Caja();
            caja.setIdCaja(resultSet.getInt("idCaja"));
            caja.setUsuario(resultSet.getString("usuario"));
            caja.setMonto(resultSet.getDouble("monto"));
            caja.setForma_de_pago(resultSet.getString("forma_de_pago"));
            caja.setNumero_protocolo(resultSet.getString("numero_protocolo"));
            caja.setFecha(resultSet.getTimestamp("fecha"));
            caja.setEfectivo(resultSet.getDouble("efectivo"));
            caja.setTransferencia(resultSet.getDouble("transferencia"));
            caja.setCuenta_corriente(resultSet.getDouble("cuenta_corriente"));
            caja.setObra_social(resultSet.getDouble("obra_social"));
            
            listaCajas.add(caja);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listaCajas;
}
    
}
      
      
      
