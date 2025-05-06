package Metodos;

import Entidades.Paciente;
import Entidades.Protocolo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class protocoloData {
    private Conexion con;

    public protocoloData() {
        con = new Conexion(); 
    }

    public void agregarProtocolo(Protocolo protocolo) {
        try {
            Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "INSERT INTO protocolo (id_paciente, numero_protocolo, medico, tipo, fecha_entrada, fecha_salida, estado, monto) VALUES (?, ?, ?, ?, ?,?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, protocolo.getIdPaciente());
            preparedStatement.setString(2, protocolo.getNumero_protocolo());
            preparedStatement.setString(3, protocolo.getMedico());
            preparedStatement.setString(4, protocolo.getTipo());
            preparedStatement.setDate(5, new java.sql.Date(protocolo.getFechaEntrada().getTime()));
            preparedStatement.setDate(6, new java.sql.Date(protocolo.getFechaSalida().getTime()));
            preparedStatement.setString(7, protocolo.getEstado());
            preparedStatement.setDouble(8, protocolo.getMonto());
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public List<Protocolo> buscarProtocolos(String numeroProtocolo, String dniPaciente) {
        List<Protocolo> listaProtocolos = new ArrayList<>();
         List<Paciente> listaPacientes = new ArrayList<>();
        try {
            Connection connection = con.getConexion(); // Obtener la conexión de la instancia de Conexion
            String sql = "SELECT p.* FROM protocolo p JOIN pacientes pa ON p.id_paciente = pa.id_paciente WHERE 1=1";
            List<Object> parametros = new ArrayList<>();

            if (numeroProtocolo != null && !numeroProtocolo.isEmpty()) {
                sql += " AND p.numero_protocolo LIKE ?";
                parametros.add("%" + numeroProtocolo + "%");
            }

            if (dniPaciente != null && !dniPaciente.isEmpty()) {
                sql += " AND pa.dni LIKE ?";
                parametros.add("%" + dniPaciente + "%");
            }
            
            // Agregar la cláusula ORDER BY para ordenar por fecha_salida
        sql += " ORDER BY p.fecha_salida";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < parametros.size(); i++) {
                preparedStatement.setObject(i + 1, parametros.get(i));
            }

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
                listaProtocolos.add(protocolo);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaProtocolos;
    }
     
     
public List<Protocolo> buscarProtocolosPorIdPaciente(int idPaciente) {
    List<Protocolo> listaProtocolos = new ArrayList<>();
    try {
        Connection connection = con.getConexion(); 
        String sql = "SELECT * FROM protocolo WHERE id_paciente = ? ORDER BY fecha_salida";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idPaciente);

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
            listaProtocolos.add(protocolo);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return listaProtocolos;
}

public void actualizarHistoriaClinica(int idPaciente) {
    try {
        Connection connection = con.getConexion();
        String sql = "UPDATE pacientes SET historia_clinica = historia_clinica + 1 WHERE id_paciente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idPaciente);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



public Protocolo buscarProtocoloPorNumero(String numeroProtocolo) {
    Protocolo protocolo = null;
    try {
        Connection connection = con.getConexion();
        String sql = "SELECT * FROM protocolo WHERE numero_protocolo = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, numeroProtocolo);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            int idProtocolo = resultSet.getInt("id_protocolo");
            int idPaciente = resultSet.getInt("id_paciente");
            String medico = resultSet.getString("medico");
            String tipo = resultSet.getString("tipo");
            Date fechaEntrada = resultSet.getDate("fecha_entrada");
            Date fechaSalida = resultSet.getDate("fecha_salida");
            String estado = resultSet.getString("estado");
            double monto = resultSet.getDouble("monto");

            protocolo = new Protocolo();
            protocolo.setIdProtocolo(idProtocolo);
            protocolo.setIdPaciente(idPaciente);
            protocolo.setNumero_protocolo(numeroProtocolo);
            protocolo.setMedico(medico);
            protocolo.setTipo(tipo);
            protocolo.setFechaEntrada(fechaEntrada);
            protocolo.setFechaSalida(fechaSalida);
            protocolo.setEstado(estado);
            protocolo.setMonto(monto);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return protocolo;
}

}
