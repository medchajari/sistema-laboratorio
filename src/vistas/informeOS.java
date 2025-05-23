
package vistas;

import Entidades.HistorialObraSocial;
import Entidades.ObraSocial;
import Entidades.Protocolo;
import Entidades.tipoProtocolo;
import Metodos.TipoProtocoloData;
import Metodos.obrasocialData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Timestamp;
import java.util.ArrayList;
public class informeOS extends javax.swing.JFrame {

     private TipoProtocoloData tiproData;
      private obrasocialData obData;
    public informeOS() {
        initComponents();
        tiproData = new TipoProtocoloData();
        obData = new obrasocialData();
        llenarComboBoxtip();
        llenarComboBoxObraSocial();

        cbxTipo.setEnabled(false);
cbxObraSocial.setEnabled(false);

chkTipo.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbxTipo.setEnabled(chkTipo.isSelected());
    }
});

chkObra.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        cbxObraSocial.setEnabled(chkObra.isSelected());
    }
});

DefaultTableModel model = new DefaultTableModel();
model.addColumn("ID");
model.addColumn("Obra Social");
model.addColumn("Paciente");
model.addColumn("Protocolo");
model.addColumn("Fecha Solicitud");
model.addColumn("Monto");
model.addColumn("Forma de Pago");
model.addColumn("Estado");

// Asignar el modelo a la tabla
tableInformes.setModel(model);


btnVer.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVerActionPerformed(evt);
    }
});
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbxTipo = new javax.swing.JComboBox<>();
        chkTodos = new javax.swing.JCheckBox();
        chkTipo = new javax.swing.JCheckBox();
        dcDesde = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        dcHasta = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableInformes = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cbxObraSocial = new javax.swing.JComboBox<>();
        chkObra = new javax.swing.JCheckBox();
        btnBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtSuma = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnVer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.add(cbxTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 180, 30));

        chkTodos.setText("Todos ");
        jPanel1.add(chkTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        chkTipo.setText("Tipo de Protocolo");
        jPanel1.add(chkTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 160, -1, -1));
        jPanel1.add(dcDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 180, -1));

        jLabel2.setText("Desde");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        jLabel3.setText("Hasta");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));
        jPanel1.add(dcHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 180, -1));

        tableInformes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableInformes);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 730, 320));

        jLabel4.setText("Buscar facturacion de obra social");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jPanel1.add(cbxObraSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 180, -1));

        chkObra.setText("Obra Social");
        jPanel1.add(chkObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/lupa (1).png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 170, 50));

        jLabel5.setText("Total");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 540, -1, -1));

        txtSuma.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtSuma.setForeground(new java.awt.Color(0, 102, 204));
        txtSuma.setBorder(null);
        jPanel1.add(txtSuma, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 532, 140, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/adelante.png"))); // NOI18N
        jButton1.setText("  SALIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(842, 530, 130, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 255));
        jLabel6.setText("Listar pagos de Obra Social");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/marquesina-1_B.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, 130));

        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/reporte.png"))); // NOI18N
        btnVer.setText("  VER");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        jPanel1.add(btnVer, new org.netbeans.lib.awtextra.AbsoluteConstraints(845, 160, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
        Date fechaDesde = dcDesde.getDate();
        Date fechaHasta = dcHasta.getDate();

        if (fechaDesde == null || fechaHasta == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione las fechas de búsqueda", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean todos = chkTodos.isSelected();
        String tipoProtocolo = chkTipo.isSelected() ? (String) cbxTipo.getSelectedItem() : null;
        ObraSocial obraSocial = chkObra.isSelected() ? (ObraSocial) cbxObraSocial.getSelectedItem() : null;

        List<HistorialObraSocial> resultados = obData.buscarHistorialPorFechas(fechaDesde, fechaHasta, todos, tipoProtocolo, obraSocial);

        mostrarResultadosEnTabla(resultados);
        sumarMontosDesdeTabla();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
         try {
        // Obtener las fechas desde los DateChooser
        Date fechaDesde = dcDesde.getDate();
        Date fechaHasta = dcHasta.getDate();

        // Validar que las fechas no sean nulas
        if (fechaDesde == null || fechaHasta == null) {
            JOptionPane.showMessageDialog(this, "Por favor seleccione las fechas", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Variables para almacenar los resultados
        List<Protocolo> protocolos = new ArrayList<>();

        if (chkTipo.isSelected()) {
            // Obtener el tipo de protocolo seleccionado
            tipoProtocolo tipoSeleccionado = (tipoProtocolo) cbxTipo.getSelectedItem();
            if (tipoSeleccionado != null) {
                int idTipoProtocolo = tipoSeleccionado.getId_tipo();
                // Llamar al método para obtener los protocolos por fecha y tipo
                protocolos = tiproData.obtenerProtocolosConObraSocialPorFechaYTipo(fechaDesde, fechaHasta, idTipoProtocolo);
            } else {
                JOptionPane.showMessageDialog(this, "Por favor seleccione un tipo de protocolo", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else {
            // Lógica para otros checks si es necesario
            JOptionPane.showMessageDialog(this, "Por favor seleccione una opción válida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Limpiar la tabla antes de agregar los nuevos resultados
        DefaultTableModel model = (DefaultTableModel) tableInformes.getModel();
        model.setRowCount(0);

        // Agregar los datos a la tabla
        for (Protocolo protocolo : protocolos) {
            ObraSocial obraSocial = obData.buscarObraSocialPorId(protocolo.getIdProtocolo()); // Puedes ajustar según tu lógica

            model.addRow(new Object[]{
                protocolo.getIdProtocolo(),
                obraSocial != null ? obraSocial.getNombre() : "N/A",  // Nombre de la obra social
                protocolo.getIdPaciente(),  // Id del paciente
                protocolo.getNumero_protocolo(),  // Número de protocolo
                protocolo.getFechaEntrada(),  // Fecha de solicitud
                protocolo.getMonto(),  // Monto
                "Forma de Pago",  // Debes ajustar esta parte con la forma de pago si tienes esa información
                protocolo.getEstado() , // Estado del protocolo
                   
            });
        }

        // Sumar los montos y mostrar en txtResultado
        double totalMonto = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalMonto += (double) model.getValueAt(i, 5); // Suma los valores de la columna "Monto"
        }
        txtSuma.setText(String.valueOf(totalMonto));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al realizar la búsqueda: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnVerActionPerformed

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
            java.util.logging.Logger.getLogger(informeOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informeOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informeOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informeOS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informeOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox<ObraSocial> cbxObraSocial;
    private javax.swing.JComboBox<tipoProtocolo> cbxTipo;
    private javax.swing.JCheckBox chkObra;
    private javax.swing.JCheckBox chkTipo;
    private javax.swing.JCheckBox chkTodos;
    private com.toedter.calendar.JDateChooser dcDesde;
    private com.toedter.calendar.JDateChooser dcHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableInformes;
    private javax.swing.JTextField txtSuma;
    // End of variables declaration//GEN-END:variables

private void llenarComboBoxtip() {
    List<tipoProtocolo> tipoP = tiproData.listarTipoProtocolo();
    DefaultComboBoxModel<tipoProtocolo> model = new DefaultComboBoxModel<>();

//    // Agregar un elemento vacío al inicio
//    model.addElement(null);

    for (tipoProtocolo tipoprotocolo : tipoP) {
        model.addElement(tipoprotocolo);
    }

    cbxTipo.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxTipo.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof tipoProtocolo) {
                tipoProtocolo tipoProtocolo = (tipoProtocolo) value;
                value = tipoProtocolo.getEstudio()+ " - " + tipoProtocolo.getId_tipo();
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}

  
  private void llenarComboBoxObraSocial() {
    List<ObraSocial> listaObraSocial = obData.listarObraSocial();
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

    // Agregar ItemListener para calcular el descuento cuando se selecciona una obra social
    cbxObraSocial.addItemListener(new java.awt.event.ItemListener() {
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            }
        }
    });
}
  
  
  private void configurarInterfaz() {
    // Deshabilitar los JComboBox al inicio
    cbxTipo.setEnabled(false);
    cbxObraSocial.setEnabled(false);

    // Añadir ActionListener a los JCheckBox
    chkTipo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbxTipo.setEnabled(chkTipo.isSelected());
        }
    });

    chkObra.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cbxObraSocial.setEnabled(chkObra.isSelected());
        }
    });
}
  
  
 private void mostrarResultadosEnTabla(List<HistorialObraSocial> resultados) {
    DefaultTableModel model = (DefaultTableModel) tableInformes.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de mostrar los nuevos resultados

    for (HistorialObraSocial historial : resultados) {
        Object[] row = new Object[8];
        row[0] = historial.getId_historial_obra_social();
        row[1] = historial.getId_obra_social().getNombre(); // Asume que tienes un método getNombre() en ObraSocial
        row[2] = historial.getId_paciente().getApellido(); // Asume que tienes un método getNombre_apellido() en Paciente
        row[3] = historial.getNumero_protocolo().getNumero_protocolo(); // Asume que tienes un método getNumero_protocolo() en Protocolo
        row[4] = historial.getFecha_solicitud(); // Podrías formatear la fecha si es necesario
        row[5] = historial.getMonto();
        row[6] = historial.getForma_de_pago();
        row[7] = historial.getEstado();
       

        model.addRow(row);
    }
}
 
 private void mostrarResultadosEnTabla2(List<Protocolo> resultados) {
    DefaultTableModel model = (DefaultTableModel) tableInformes.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de agregar los nuevos resultados

    for (Protocolo protocolo : resultados) {
        Object[] fila = new Object[]{
            protocolo.getIdProtocolo(),
            protocolo.getIdPaciente(),
            protocolo.getNumero_protocolo(),
            protocolo.getMedico(),
            protocolo.getTipo(), // O protocolo.getEstudio() si decides usar "estudio"
            protocolo.getFechaEntrada(),
            protocolo.getFechaSalida(),
            protocolo.getEstado(),
            protocolo.getMonto()
        };
        model.addRow(fila);
    }
}
 
  
 public void sumarMontosDesdeTabla() {
    double totalMonto = 0.0;

    // Obtener el modelo de la tabla
    DefaultTableModel model = (DefaultTableModel) tableInformes.getModel();

    // Recorrer las filas de la tabla
    for (int i = 0; i < model.getRowCount(); i++) {
        // Suponiendo que la columna "monto" es la quinta columna (índice 4)
        double monto = Double.parseDouble(model.getValueAt(i, 5).toString());
        totalMonto += monto;
    }

    // Mostrar el total en txtResultado
    txtSuma.setText(String.valueOf(totalMonto));
}
 

}
