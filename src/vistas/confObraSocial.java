
package vistas;

import Entidades.ObraSocial;
import Metodos.Conexion;
import Metodos.obrasocialData;
import Metodos.pacienteData;
import Metodos.protocoloData;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class confObraSocial extends javax.swing.JFrame {

 private Conexion con;
 private protocoloData protocoloData;
 private pacienteData pacienteData;
 private obrasocialData osData;
 
    public confObraSocial() {
          initComponents();
          con = new Conexion();         
          protocoloData = new protocoloData(); 
          pacienteData = new pacienteData();
          osData = new obrasocialData();
          llenarComboBoxObraSocial();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtPorcentaje = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAObservacion = new javax.swing.JTextArea();
        txtEstado = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbxObraSocial = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel2.setText("Porcentaje");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel3.setText("Observación");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Estado");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 690, 260));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 100, 150, -1));

        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 260, 40));

        jLabel5.setText("Desde");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 100, 40, 20));
        jPanel1.add(jDateChooser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 150, -1));

        jLabel6.setText("Hasta");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 100, 40, -1));

        jCheckBox1.setText("Todos los pagos");
        jPanel1.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jCheckBox2.setText("Por Rango de Fecha");
        jPanel1.add(jCheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 140, 10));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 140, 10));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/lapiz.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, 170, 50));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/escoba.png"))); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 170, 50));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/boleto-electronico.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 170, 50));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/lupa (1).png"))); // NOI18N
        jButton4.setText("BUSCAR");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 150, 40));

        txtNombre.setBorder(null);
        jPanel1.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 240, -1));

        txtPorcentaje.setBorder(null);
        jPanel1.add(txtPorcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 240, -1));

        txtAObservacion.setColumns(20);
        txtAObservacion.setRows(5);
        jScrollPane2.setViewportView(txtAObservacion);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 240, -1));

        txtEstado.setBorder(null);
        jPanel1.add(txtEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 190, -1));

        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 260, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 255));
        jLabel8.setText("OBRA SOCIAL");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/marquesina-1_B.jpg"))); // NOI18N
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 150));

        jPanel1.add(cbxObraSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 190, 50));

        jLabel9.setText("Editar");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/cerrar-sesion.png"))); // NOI18N
        jButton1.setText("SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 440, 150, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
        // Recopilar los datos del proveedor desde los campos de entrada en tu ventana
        
        String nombre = txtNombre.getText();
        double porcentaje = Double.parseDouble(txtPorcentaje.getText());
        String observacion = txtAObservacion.getText();
        int estado = 1;  // Supongo que "estado" siempre es 1 en este caso, o está predefinido de alguna manera

        // Validar que los campos obligatorios no estén vacíos
        if (nombre.isEmpty() || observacion.isEmpty()) {
            // Mostrar un mensaje de error o realizar la lógica necesaria en caso de campos vacíos
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Llamar al método para agregar el proveedor en la base de datos
            osData.agregarObraSocial(nombre, porcentaje, observacion, estado);
            
            // Limpiar los campos de entrada después de agregar el proveedor (opcional)
            txtNombre.setText("");
            txtPorcentaje.setText("");
            txtAObservacion.setText("");
             llenarComboBoxObraSocial(); 
        }
    } catch (NumberFormatException e) {
        // Manejar el caso en el que la conversión falla, por ejemplo, mostrar un mensaje de error
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el porcentaje.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       try {
            ObraSocial obraSocialSeleccionada = (ObraSocial) cbxObraSocial.getSelectedItem();
            if (obraSocialSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una obra social.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idObraSocial = obraSocialSeleccionada.getId_obra_social();
            String nombre = txtNombre.getText();
            double porcentaje = Double.parseDouble(txtPorcentaje.getText());
            String observacion = txtAObservacion.getText();
            int estado = 1;

            if (nombre.isEmpty() || observacion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                osData.actualizarObra(idObraSocial, nombre, porcentaje, observacion, estado);
                txtNombre.setText("");
                txtPorcentaje.setText("");
                txtAObservacion.setText("");
                llenarComboBoxObraSocial(); // Recargar el combo box después de modificar
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el porcentaje.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      try {
            ObraSocial obraSocialSeleccionada = (ObraSocial) cbxObraSocial.getSelectedItem();
            if (obraSocialSeleccionada == null) {
                JOptionPane.showMessageDialog(this, "Por favor, seleccione una obra social.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idObraSocial = obraSocialSeleccionada.getId_obra_social();
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta obra social?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                osData.eliminarObraSocial(idObraSocial);
                txtNombre.setText("");
                txtPorcentaje.setText("");
                txtAObservacion.setText("");
                llenarComboBoxObraSocial(); // Recargar el combo box después de eliminar
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(confObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(confObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(confObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(confObraSocial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new confObraSocial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<ObraSocial> cbxObraSocial;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea txtAObservacion;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables

private void llenarComboBoxObraSocial() {
    List<ObraSocial> listaObraSocial = osData.listarObraSocial();
    DefaultComboBoxModel<ObraSocial> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (ObraSocial obraSocial : listaObraSocial) {
        model.addElement(obraSocial);
    }

    cbxObraSocial.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar nombre, observación y porcentaje
    cbxObraSocial.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof ObraSocial) {
                ObraSocial obraSocial = (ObraSocial) value;
                value = obraSocial.getId_obra_social() + " - " + obraSocial.getNombre() + " - " + obraSocial.getPorcentaje() + "%";
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });

    // Agregar ActionListener para llenar los campos de texto cuando se selecciona una obra social
    cbxObraSocial.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ObraSocial obraSocialSeleccionada = (ObraSocial) cbxObraSocial.getSelectedItem();
            if (obraSocialSeleccionada != null) {
                txtNombre.setText(obraSocialSeleccionada.getNombre());
                txtPorcentaje.setText(String.valueOf(obraSocialSeleccionada.getPorcentaje()));
                txtAObservacion.setText(obraSocialSeleccionada.getObservacion());
            } else {
                // Limpiar los campos si no se selecciona ninguna obra social
                txtNombre.setText("");
                txtPorcentaje.setText("");
                txtAObservacion.setText("");
            }
        }
    });
   
}
}
