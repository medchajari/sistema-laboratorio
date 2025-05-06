
package vistas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends javax.swing.JFrame {

   
    public Principal() {
        initComponents();
        customizeFrame();
    }

   private void customizeFrame() {
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // Deshabilitar el botón de cerrar
        setResizable(false); // Deshabilitar el botón de maximizar
//        setUndecorated(true); // Quitar la barra de título predeterminada

        // Crear un panel que actuará como el nuevo borde de la ventana
        CustomTitleBar customTitleBar = new CustomTitleBar(this);
        setLayout(new BorderLayout());
        add(customTitleBar, BorderLayout.NORTH);

        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuConfObraSocial = new javax.swing.JMenuItem();
        menuConfCliente = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/o10Xn-SvSUCdy3F85PReNQ.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));
        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuBar1.setMargin(new java.awt.Insets(10, 10, 10, 10));
        jMenuBar1.setMinimumSize(new java.awt.Dimension(538, 60));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(207, 60));

        jMenu1.setText("  ");
        jMenuBar1.add(jMenu1);

        jMenu4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/papel_2.png"))); // NOI18N
        jMenu4.setText("Protocolo    ");
        jMenu4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu4.setIconTextGap(8);
        jMenu4.setMinimumSize(new java.awt.Dimension(124, 44));
        jMenu4.setPreferredSize(new java.awt.Dimension(134, 44));

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/documento (1).png"))); // NOI18N
        jMenuItem2.setText("Nuevo Protocolo");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(200, 46));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/documento (3).png"))); // NOI18N
        jMenuItem3.setText("Entregar Protocolo");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(200, 46));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuItem4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/codigo-qr (1).png"))); // NOI18N
        jMenuItem4.setText("Crear QR");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(200, 46));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuBar1.add(jMenu4);

        jMenu3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/lista.png"))); // NOI18N
        jMenu3.setText(" Configuración   ");
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu3.setMinimumSize(new java.awt.Dimension(163, 44));
        jMenu3.setPreferredSize(new java.awt.Dimension(163, 44));
        jMenu3.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                jMenu3MenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        jMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu3ActionPerformed(evt);
            }
        });
        jMenu3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jMenu3KeyPressed(evt);
            }
        });

        menuConfObraSocial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/inversion.png"))); // NOI18N
        menuConfObraSocial.setText("Obra Social");
        menuConfObraSocial.setPreferredSize(new java.awt.Dimension(200, 46));
        menuConfObraSocial.addMenuKeyListener(new javax.swing.event.MenuKeyListener() {
            public void menuKeyPressed(javax.swing.event.MenuKeyEvent evt) {
                menuConfObraSocialMenuKeyPressed(evt);
            }
            public void menuKeyReleased(javax.swing.event.MenuKeyEvent evt) {
            }
            public void menuKeyTyped(javax.swing.event.MenuKeyEvent evt) {
            }
        });
        menuConfObraSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfObraSocialActionPerformed(evt);
            }
        });
        jMenu3.add(menuConfObraSocial);

        menuConfCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/agregar-usuario.png"))); // NOI18N
        menuConfCliente.setText("Cliente");
        menuConfCliente.setPreferredSize(new java.awt.Dimension(200, 46));
        menuConfCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuConfClienteMouseClicked(evt);
            }
        });
        menuConfCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuConfClienteActionPerformed(evt);
            }
        });
        jMenu3.add(menuConfCliente);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/usuario.png"))); // NOI18N
        jMenuItem1.setText("Profesionales");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(200, 46));
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseClicked(evt);
            }
        });
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/informacion-personal.png"))); // NOI18N
        jMenuItem12.setText("Tipo Protocolo");
        jMenuItem12.setPreferredSize(new java.awt.Dimension(130, 46));
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem12);

        jMenuBar1.add(jMenu3);

        jMenu2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/informes_2.png"))); // NOI18N
        jMenu2.setText(" Informes   ");
        jMenu2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenu2.setMinimumSize(new java.awt.Dimension(200, 44));
        jMenu2.setPreferredSize(new java.awt.Dimension(120, 44));

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/economico.png"))); // NOI18N
        jMenuItem5.setText("Obra Social");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(200, 36));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/informe.png"))); // NOI18N
        jMenuItem7.setText("Cajas por Tipo");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(131, 36));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/informe-seo.png"))); // NOI18N
        jMenuItem8.setText("Protocolos por Tipo");
        jMenuItem8.setPreferredSize(new java.awt.Dimension(230, 36));
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/verificado.png"))); // NOI18N
        jMenuItem10.setText("Cuentas Corrientes");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(152, 36));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuItem11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/analisis-de-mercado.png"))); // NOI18N
        jMenuItem11.setText("Transferencias");
        jMenuItem11.setPreferredSize(new java.awt.Dimension(127, 36));
        jMenu2.add(jMenuItem11);

        jMenuBar1.add(jMenu2);

        menuSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/funcion.png"))); // NOI18N
        menuSalir.setText("    Salir    ");
        menuSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menuSalir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        menuSalir.setIconTextGap(2);
        menuSalir.setMargin(new java.awt.Insets(3, 6, 13, 6));
        menuSalir.setMinimumSize(new java.awt.Dimension(120, 44));
        menuSalir.setPreferredSize(new java.awt.Dimension(120, 44));
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalirMouseClicked(evt);
            }
        });
        menuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSalirActionPerformed(evt);
            }
        });
        menuSalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuSalirKeyPressed(evt);
            }
        });
        jMenuBar1.add(menuSalir);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSalirActionPerformed
        dispose();
    }//GEN-LAST:event_menuSalirActionPerformed

    private void menuSalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuSalirKeyPressed
     dispose();
    }//GEN-LAST:event_menuSalirKeyPressed

    private void menuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMouseClicked
    int response = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    if (response == JOptionPane.YES_OPTION) {
        dispose();
    }
    }//GEN-LAST:event_menuSalirMouseClicked

    private void menuConfObraSocialMenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_menuConfObraSocialMenuKeyPressed
    
    }//GEN-LAST:event_menuConfObraSocialMenuKeyPressed

    private void menuConfClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuConfClienteMouseClicked
     
    }//GEN-LAST:event_menuConfClienteMouseClicked

    private void menuConfObraSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfObraSocialActionPerformed
         confObraSocial cos = new confObraSocial();
        cos.setVisible(true);
    }//GEN-LAST:event_menuConfObraSocialActionPerformed

    private void menuConfClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuConfClienteActionPerformed
         Pacientes pas = new Pacientes();
        pas.setVisible(true);
    }//GEN-LAST:event_menuConfClienteActionPerformed

    private void jMenu3MenuKeyPressed(javax.swing.event.MenuKeyEvent evt) {//GEN-FIRST:event_jMenu3MenuKeyPressed
       
    }//GEN-LAST:event_jMenu3MenuKeyPressed

    private void jMenu3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jMenu3KeyPressed
       ;
    }//GEN-LAST:event_jMenu3KeyPressed

    private void jMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu3ActionPerformed
      
    }//GEN-LAST:event_jMenu3ActionPerformed

    private void jMenuItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseClicked
       
    }//GEN-LAST:event_jMenuItem1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
      AgregarMedico am = new AgregarMedico();
        am.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        GenerarQR gqr = new GenerarQR();
        gqr.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
          nuevoProtocolo np = new nuevoProtocolo();
        np.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
       entregarProtocolo ep = new entregarProtocolo();
        ep.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        informeOS iOS = new informeOS();
        iOS.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
    TipoProtocolo tp = new TipoProtocolo();
        tp.setVisible(true);       
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
      Protocolo_por_tipo tp = new Protocolo_por_tipo();
        tp.setVisible(true); 
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
       Cajas tp = new Cajas();
        tp.setVisible(true); 
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
          CueCorriente cc = new CueCorriente();
        cc.setVisible(true); 
    }//GEN-LAST:event_jMenuItem10ActionPerformed

     @SuppressWarnings("unchecked")
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JMenuItem menuConfCliente;
    private javax.swing.JMenuItem menuConfObraSocial;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables

// Clase personalizada para el título de la ventana


class CustomTitleBar extends JPanel {

        private JFrame frame;

        public CustomTitleBar(JFrame frame) {
            this.frame = frame;
            setLayout(new FlowLayout(FlowLayout.RIGHT));
            setBackground(Color.LIGHT_GRAY);

            // Botón minimizar
            JButton minimizeButton = new JButton("-");
            minimizeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setState(Frame.ICONIFIED);
                }
            });

            add(minimizeButton);
        }
    }
}