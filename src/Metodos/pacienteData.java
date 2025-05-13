
package Metodos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import Entidades.Paciente;
import Entidades.Protocolo;
import java.util.List; 
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import org.mariadb.jdbc.Statement;


public class pacienteData {
    private Conexion con;
    public pacienteData() {
        con = new Conexion(); 
        
    }
    
     public void agregarPacientes(String nombre, String apellido, String fecha_nacimiento, String dni, String direccion, String telefono,String email, String genero,int historia_clinica, String observacion, double saldo) {
    try {
        Connection connection = con.getConexion(); 
        String sql = "INSERT INTO pacientes (nombre,apellido,fecha_nacimiento,dni,direccion,telefono,email,genero,historia_clinica,observacion,saldo) VALUES (?, ?, ?, ?, ?,?, ?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, apellido);
        preparedStatement.setString(3, fecha_nacimiento); 
        preparedStatement.setString(4, dni);
	 preparedStatement.setString(5, direccion);
         preparedStatement.setString(6, telefono);
        preparedStatement.setString(7, email);
        preparedStatement.setString(8, genero);
        preparedStatement.setInt(9, historia_clinica);
        preparedStatement.setString(10, observacion);
        preparedStatement.setDouble(11, saldo);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
     public void actualizarPaciente(int id, String nombre, String apellido, String fecha_nacimiento, String dni, String direccion, String telefono, String email, String genero, String observacion) {
    try {
        Connection connection = con.getConexion();
        String sql = "UPDATE pacientes SET nombre=?, apellido=?, fecha_nacimiento=?, dni=?, direccion=?, telefono=?, email=?, genero=?, observacion=? WHERE id_paciente=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nombre);
        preparedStatement.setString(2, apellido);
        preparedStatement.setString(3, fecha_nacimiento);
        preparedStatement.setString(4, dni);
        preparedStatement.setString(5, direccion);
        preparedStatement.setString(6, telefono);
        preparedStatement.setString(7, email);
        preparedStatement.setString(8, genero);
        preparedStatement.setString(9, observacion);
        preparedStatement.setInt(10, id); // ID del paciente
        preparedStatement.executeUpdate();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     
      public Paciente buscarPacientePorDNI(String dni) {
        Paciente paciente = null;
        try {
            Connection connection = con.getConexion();
            String sql = "SELECT * FROM pacientes WHERE dni = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dni);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idPaciente = resultSet.getInt("id_paciente");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String fechaNacimiento = resultSet.getString("fecha_nacimiento");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                String email = resultSet.getString("email");
                String genero = resultSet.getString("genero");
                int historiaClinica = resultSet.getInt("historia_clinica");
                String observacion = resultSet.getString("observacion");
                double saldo = resultSet.getDouble("saldo");

                paciente = new Paciente(idPaciente, nombre, apellido, fechaNacimiento, dni, direccion, telefono, email, genero, historiaClinica, observacion, saldo);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }
      
      public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();
        try {
            Connection connection = con.getConexion();
            String sql = "SELECT * FROM pacientes";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int idPaciente = resultSet.getInt("id_paciente");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String fechaNacimiento = resultSet.getString("fecha_nacimiento");
                String dni = resultSet.getString("dni");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("telefono");
                String email = resultSet.getString("email");
                String genero = resultSet.getString("genero");
                int historiaClinica = resultSet.getInt("historia_clinica");
                String observacion = resultSet.getString("observacion");
                double saldo = resultSet.getDouble("saldo");

                Paciente paciente = new Paciente(idPaciente, nombre, apellido, fechaNacimiento, dni, direccion, telefono, email, genero, historiaClinica, observacion, saldo);
                pacientes.add(paciente);
            }

            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pacientes;
    }
      
      public List<Paciente> buscarPacientesPorApellido(String apellido) {
    List<Paciente> pacientes = new ArrayList<>();
    try {
        Connection connection = con.getConexion();
        String sql = "SELECT * FROM pacientes WHERE apellido LIKE ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + apellido + "%");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int idPaciente = resultSet.getInt("id_paciente");
            String nombre = resultSet.getString("nombre");
            String apell = resultSet.getString("apellido");
            String fechaNacimiento = resultSet.getString("fecha_nacimiento");
            String dni = resultSet.getString("dni");
            String direccion = resultSet.getString("direccion");
            String telefono = resultSet.getString("telefono");
            String email = resultSet.getString("email");
            String genero = resultSet.getString("genero");
            int historiaClinica = resultSet.getInt("historia_clinica");
            String observacion = resultSet.getString("observacion");
            double saldo = resultSet.getDouble("saldo");

            Paciente paciente = new Paciente(idPaciente, nombre, apell, fechaNacimiento, dni, direccion, telefono, email, genero, historiaClinica, observacion, saldo);
            pacientes.add(paciente);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return pacientes;
}
      
      public Paciente buscarPacientePorID(int id) {
    Paciente paciente = null;
    try {
        Connection connection = con.getConexion();
        String sql = "SELECT * FROM pacientes WHERE id_paciente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String fechaNacimiento = resultSet.getString("fecha_nacimiento");
            String dni = resultSet.getString("dni");
            String direccion = resultSet.getString("direccion");
            String telefono = resultSet.getString("telefono");
            String email = resultSet.getString("email");
            String genero = resultSet.getString("genero");
            int historiaClinica = resultSet.getInt("historia_clinica");
            String observacion = resultSet.getString("observacion");
            double saldo = resultSet.getDouble("saldo");

            paciente = new Paciente(id, nombre, apellido, fechaNacimiento, dni, direccion, telefono, email, genero, historiaClinica, observacion, saldo);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return paciente;
}
      
      
  public List<Paciente> obtenerTodosLosPacientes() {
    List<Paciente> pacientes = new ArrayList<>();
    try {
        Connection connection = con.getConexion();
        String sql = "SELECT * FROM pacientes";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            int idPaciente = resultSet.getInt("id_paciente");
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String fechaNacimiento = resultSet.getString("fecha_nacimiento");
            String dni = resultSet.getString("dni");
            String direccion = resultSet.getString("direccion");
            String telefono = resultSet.getString("telefono");
            String email = resultSet.getString("email");
            String genero = resultSet.getString("genero");
            int historiaClinica = resultSet.getInt("historia_clinica");
            String observacion = resultSet.getString("observacion");
            double saldo = resultSet.getDouble("saldo");

            Paciente paciente = new Paciente(idPaciente, nombre, apellido, fechaNacimiento, dni, direccion, telefono, email, genero, historiaClinica, observacion, saldo);
            pacientes.add(paciente);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    return pacientes;
}

public Paciente buscarPacientePorId(int idPaciente) {
    Paciente paciente = null;
    try {
        Connection connection = con.getConexion(); 
        String sql = "SELECT * FROM pacientes WHERE id_paciente = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idPaciente);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            String nombre = resultSet.getString("nombre");
            String apellido = resultSet.getString("apellido");
            String fechaNacimiento = resultSet.getString("fecha_nacimiento");
            String dni = resultSet.getString("dni");
            String direccion = resultSet.getString("direccion");
            String telefono = resultSet.getString("telefono");
            String email = resultSet.getString("email");
            String genero = resultSet.getString("genero");
            int historiaClinica = resultSet.getInt("historia_clinica");
            String observacion = resultSet.getString("observacion");
            double saldo = resultSet.getDouble("saldo");

            paciente = new Paciente();
            paciente.setIdPaciente(idPaciente);
            paciente.setNombre(nombre);
            paciente.setApellido(apellido);
            paciente.setFechaNacimiento(fechaNacimiento);
            paciente.setDni(dni);
            paciente.setDireccion(direccion);
            paciente.setTelefono(telefono);
            paciente.setEmail(email);
            paciente.setGenero(genero);
            paciente.setHistoriaClinica(historiaClinica);
            paciente.setObservacion(observacion);
            paciente.setSaldo(saldo);
        }

        resultSet.close();
        preparedStatement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return paciente;
}

  
 
    
}
