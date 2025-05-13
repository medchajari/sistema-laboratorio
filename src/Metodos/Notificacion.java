
package Metodos;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class Notificacion {

    PopupMenu popup = new PopupMenu();
    private Image image = new ImageIcon(getClass().getResource("/correcto.png")).getImage();
    private final TrayIcon trayIcon = new TrayIcon(image, "Aplicación Java", popup);
   
    final SystemTray systemtray = SystemTray.getSystemTray();
    //para el Timer
    private Timer timer;
    public static boolean band;

    public Notificacion() {
       
        if (SystemTray.isSupported()) {

            
            MouseListener mouseListener = new MouseListener() {

                @Override
                public void mouseClicked(MouseEvent evt) {
                    //si se presiono el boton izquierdo y la aplicacion esta minimizada
                    if (evt.getButton() == MouseEvent.BUTTON1)// && miframe.getExtendedState()==JFrame.ICONIFIED )
                    {
                        MensajeTrayIcon("Por favor verifique la información", TrayIcon.MessageType.WARNING);
                    }
                }

                @Override
                public void mouseEntered(MouseEvent evt) {
                }

                @Override
                public void mouseExited(MouseEvent evt) {
                }

                @Override
                public void mousePressed(MouseEvent evt) {
                }

                @Override
                public void mouseReleased(MouseEvent evt) {
                }
            };

            //ACCIONES DEL MENU POPUP
            ActionListener salir = (ActionEvent e) -> {
                //System.exit(0);
                //systemtray.remove(trayIcon);
                Notificacion.band = true;
            };

            ActionListener verinformacion = (ActionEvent e) -> {
                JOptionPane.showMessageDialog(null, "Imprimendo ", "Aplicación Java",
                        JOptionPane.INFORMATION_MESSAGE);
                band = true;
            };
          
            MenuItem SalirItem = new MenuItem("Salir");
            SalirItem.addActionListener(salir);
            popup.add(SalirItem);

            MenuItem Itemverinfo = new MenuItem("Ver informacion");
            Itemverinfo.addActionListener(verinformacion);
            popup.add(Itemverinfo);
            trayIcon.setImageAutoSize(true);
            trayIcon.addMouseListener(mouseListener);

           
            try {
                systemtray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println("Error:" + e.getMessage());
            }
        } else {
            System.err.println("Error: SystemTray no es soportado");
        }
    }

 
    public void MensajeTrayIcon(String texto, TrayIcon.MessageType tipo) {
        trayIcon.displayMessage("Notificación Sistema Java:", texto, tipo);
    }

    
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
            String prod = "";
            if (Notificacion.band) {//Termina Timer
                timer.cancel();
            } else {//realiza acción
                    prod += "* " + vistas.notificacionesMeD.mensaje + "\n";
                notificacion(prod);
            }
        }

      
        public void notificacion(String nomprod) {
            MensajeTrayIcon("Notificación\n" + nomprod + " texto prueba notificación. ", TrayIcon.MessageType.INFO);
        }
    }

    public void mje() throws AWTException {
        Notificacion.band = false;
        timer = new Timer();
        timer.schedule(new MyTimerTask(), 0, 50000);//Se ejecuta cada 50 segundos
    }
}
