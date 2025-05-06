
package lab;

import java.io.IOException;
import java.util.PrimitiveIterator;
import javax.swing.JOptionPane;
import vistas.Principal;

/**
 *
 * @author MeD
 */
public class Lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         // Iniciar servicios de XAMPP sin abrir el panel
        try {
            Runtime.getRuntime().exec("cmd /c start \"\" C:\\xampp\\apache_start.bat");
            Runtime.getRuntime().exec("cmd /c start \"\" C:\\xampp\\mysql_start.bat");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "❌ No se pudieron iniciar Apache/MySQL.");
        }
         Principal prin = new Principal();

        // Hace visible la ventana de login
        prin.setVisible(true);
    }
    
}
