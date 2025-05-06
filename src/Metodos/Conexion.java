
package Metodos;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
   
//   private static final String URL = "jdbc:mariadb://26.180.193.52/laboratorio";
    private static final String URL = "jdbc:mariadb://localhost/laboratorio";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
 
    private Connection conexion;

    public Conexion() {
        conectar();
    }

    private void conectar() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            try {
                conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Conectado A BD correctamente.");
        } catch (ClassNotFoundException ex) {
            // Lanzar una excepción o imprimir un mensaje de error según sea necesario
            ex.printStackTrace();
        }
    }

    public Connection getConexion() {
       try {
        if (conexion == null || conexion.isClosed()) {
            // Si la conexión no existe o está cerrada, crea una nueva conexión
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return conexion;
    }

    public void cerrarConexion() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("Conexión A BD cerrada correctamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}