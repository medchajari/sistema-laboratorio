
package vistas;
import Entidades.Paciente;
import Entidades.Profesionales;
import Entidades.Protocolo;
import Metodos.Conexion;
import Metodos.pacienteData;
import Metodos.profesionalesData;
import Metodos.protocoloData;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import net.glxn.qrgen.QRCode;

public class nuevoProtocolo extends javax.swing.JFrame {
    private Conexion con;
 private protocoloData protocoloData;
  private pacienteData pacienteData;
  private profesionalesData profData;
    public nuevoProtocolo() {
        initComponents();
        con = new Conexion();
         
          protocoloData = new protocoloData(); 
          pacienteData = new pacienteData();
          profData = new profesionalesData();
          llenarComboBoxRazonSocial();
          agregarActionListenerComboBox();
          llenarComboBoxmedico();
          
          //busqueda
          
      
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbxRazonSocial = new javax.swing.JComboBox<>();
        cbxMedico = new javax.swing.JComboBox<>();
        cbxTipoProtocolo = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        dcFechaEntrada = new com.toedter.calendar.JDateChooser();
        dcFechaSalida = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDatos = new javax.swing.JTable();
        chkNProtocolo = new javax.swing.JCheckBox();
        chkDni = new javax.swing.JCheckBox();
        txtCuadroBusqueda = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnAbrirHistorial = new javax.swing.JButton();
        btnGuardarProtocolo = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnGenerarQr = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtNumeroProtocolo = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();
        btnActualizarDatos1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtQr = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 204));
        jLabel2.setText("Nº PROTOCOLO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 204));
        jLabel3.setText("RAZON SOCIAL");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setText("MEDICO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 204));
        jLabel5.setText("TIPO DE PROTOCOLO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 10));

        jPanel1.add(cbxRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 170, -1));

        jPanel1.add(cbxMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 170, -1));

        cbxTipoProtocolo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Anatomía Patológica", "Diagnostico Citologia" }));
        jPanel1.add(cbxTipoProtocolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 170, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 204));
        jLabel6.setText("FECHA DE ENTRADA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, -1, -1));
        jPanel1.add(dcFechaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 170, -1));
        jPanel1.add(dcFechaSalida, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 170, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 204));
        jLabel8.setText("FECHA DE SALIDA");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        tableDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableDatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 970, 160));

        chkNProtocolo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chkNProtocolo.setText("Nº PROTOCOLO");
        jPanel1.add(chkNProtocolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, -1, -1));

        chkDni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chkDni.setText("DNI");
        jPanel1.add(chkDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 310, -1, -1));

        txtCuadroBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuadroBusquedaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCuadroBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, 220, 40));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/lupa (1).png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 300, 130, 40));

        btnAbrirHistorial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/informacion-personal.png"))); // NOI18N
        btnAbrirHistorial.setText("Abrir Historial");
        btnAbrirHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirHistorialActionPerformed(evt);
            }
        });
        jPanel1.add(btnAbrirHistorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, 150, 40));

        btnGuardarProtocolo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/moverse.png"))); // NOI18N
        btnGuardarProtocolo.setText("   GUARDAR");
        btnGuardarProtocolo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProtocoloActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarProtocolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 170, 140, 70));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 970, -1));

        btnGenerarQr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/codigo-qr (1).png"))); // NOI18N
        btnGenerarQr.setText("Generar QR");
        btnGenerarQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarQrActionPerformed(evt);
            }
        });
        jPanel1.add(btnGenerarQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 40));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/adelante.png"))); // NOI18N
        btnSalir.setText("  SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 530, 210, 40));

        txtNumeroProtocolo.setBorder(null);
        jPanel1.add(txtNumeroProtocolo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 160, -1));

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 20, 90));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("Dni Razon Social:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, -1, -1));

        jLabel9.setText("id:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 126, 20, 20));

        txtDni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtDni.setForeground(new java.awt.Color(51, 51, 51));
        txtDni.setBorder(null);
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        jPanel1.add(txtDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, 120, 20));

        txtIdUsuario.setBorder(null);
        jPanel1.add(txtIdUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 120, 50, 30));

        btnActualizarDatos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-azules/30/cargador.png"))); // NOI18N
        btnActualizarDatos1.setText("ACTUALIZAR DATOS");
        btnActualizarDatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarDatos1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnActualizarDatos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 530, 210, 40));

        jLabel11.setText("Costo $ :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 220, -1, -1));

        txtMonto.setBorder(null);
        jPanel1.add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 210, 120, 20));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 240, 140, 10));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 255));
        jLabel10.setText("NUEVO PROTOCOLO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/marquesina-1_B.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 110));
        jPanel1.add(txtQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 270, 110, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void llenarComboBoxRazonSocial() {
    List<Paciente> pacientes = pacienteData.obtenerTodosLosPacientes();
    DefaultComboBoxModel<Paciente> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Paciente paciente : pacientes) {
        model.addElement(paciente);
    }

    cbxRazonSocial.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxRazonSocial.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Paciente) {
                Paciente paciente = (Paciente) value;
                value = paciente.getApellido() + ", " + paciente.getNombre();
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}
    
     private void llenarComboBoxmedico(){
    List<Profesionales> pro = profData.listarProfesionales();
    DefaultComboBoxModel<Profesionales> model = new DefaultComboBoxModel<>();

    // Agregar un elemento vacío al inicio
    model.addElement(null);

    for (Profesionales profesionales : pro) {
        model.addElement(profesionales);
    }

    cbxMedico.setModel(model);

    // Configurar el renderizado del JComboBox para mostrar apellido, nombre
    cbxMedico.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            if (value instanceof Profesionales) {
                Profesionales profe = (Profesionales) value;
                value = profe.getNombre_apellido();
            } else if (value == null) {
                value = ""; // Mostrar una cadena vacía para el elemento vacío
            }
            return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        }
    });
}
  

  private void agregarActionListenerComboBox() {
    cbxRazonSocial.addActionListener(new java.awt.event.ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            Paciente pacienteSeleccionado = (Paciente) cbxRazonSocial.getSelectedItem();
            if (pacienteSeleccionado != null) {
                txtDni.setText(pacienteSeleccionado.getDni());
                txtIdUsuario.setText(String.valueOf(pacienteSeleccionado.getIdPaciente()));
            } else {
                txtDni.setText("");
                txtIdUsuario.setText("");
            }
        }
    });
}

    
    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void btnGuardarProtocoloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProtocoloActionPerformed

 try {
        // Obtener los datos de los campos de entrada
        String numeroProtocolo = txtNumeroProtocolo.getText();
        Date fechaEntrada = dcFechaEntrada.getDate();
        Date fechaSalida = dcFechaSalida.getDate();
        Profesionales medico = (Profesionales) cbxMedico.getSelectedItem(); // Cambiar a Profesionales
        String tipoProtocolo = (String) cbxTipoProtocolo.getSelectedItem();
        int idPaciente = Integer.parseInt(txtIdUsuario.getText());
        double monto = Double.parseDouble(txtMonto.getText());
        String estado = "En espera";

        // Validar que los campos obligatorios no estén vacíos
        if (numeroProtocolo.isEmpty() || fechaEntrada == null || fechaSalida == null || medico == null || tipoProtocolo == null || idPaciente == 0) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear un objeto Protocolo con los datos recopilados
        Protocolo protocolo = new Protocolo();
        protocolo.setNumero_protocolo(numeroProtocolo);
        protocolo.setFechaEntrada(fechaEntrada);
        protocolo.setFechaSalida(fechaSalida);
        protocolo.setMedico(medico.getNombre_apellido()); // Obtener el nombre completo del médico
        protocolo.setTipo(tipoProtocolo);
        protocolo.setIdPaciente(idPaciente);
        protocolo.setEstado(estado);
        protocolo.setMonto(monto);

        // Llamar al método para agregar el protocolo en la base de datos
        protocoloData.agregarProtocolo(protocolo);

        // Actualizar la historia clínica del paciente
        protocoloData.actualizarHistoriaClinica(idPaciente);

        CrearCarpeta();
       
        GenerarQR qr = new GenerarQR();
        qr.setVisible(true);
         abrirCarpeta();
        // Limpiar los campos de entrada después de agregar el protocolo
        txtNumeroProtocolo.setText("");
        dcFechaEntrada.setDate(null);
        dcFechaSalida.setDate(null);
        cbxMedico.setSelectedIndex(0);
        cbxTipoProtocolo.setSelectedIndex(0);
        txtIdUsuario.setText("");
        txtMonto.setText("");

        JOptionPane.showMessageDialog(this, "Protocolo agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese valores válidos para los campos numéricos", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al agregar el protocolo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnGuardarProtocoloActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed


  // Obtener el texto del campo de búsqueda
    String busqueda = txtCuadroBusqueda.getText().trim();
    
    // Determinar el tipo de búsqueda
    boolean buscarPorDni = chkDni.isSelected();
    boolean buscarPorProtocolo = chkNProtocolo.isSelected();
    
    List<Protocolo> resultados = new ArrayList<>();
    
    if (buscarPorDni && !buscarPorProtocolo) {
        // Búsqueda solo por DNI
        resultados = protocoloData.buscarProtocolos(null, busqueda);
    } else if (!buscarPorDni && buscarPorProtocolo) {
        // Búsqueda solo por número de protocolo
        resultados = protocoloData.buscarProtocolos(busqueda, null);
    } else if (buscarPorDni && buscarPorProtocolo) {
        // Búsqueda por número de protocolo y DNI
        resultados = protocoloData.buscarProtocolos(busqueda, busqueda);
    } else {
        // Mostrar mensaje de error si no se selecciona ninguna opción
        JOptionPane.showMessageDialog(null, "Seleccione una opción de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Definir las columnas de la tabla
    String[] columnas = {"ID",  "Id Paciente","Número de Protocolo","Médico", "Tipo", "Fecha de Entrada", "Fecha de Salida","Estado", "Monto"};

    // Crear el modelo de tabla con las columnas
    DefaultTableModel model = new DefaultTableModel(columnas, 0);

    // Llenar el modelo con los resultados de la búsqueda
    for (Protocolo protocolo : resultados) {
        Object[] fila = new Object[]{
            protocolo.getIdProtocolo(),
            protocolo.getIdPaciente(),
            protocolo.getNumero_protocolo(),
            protocolo.getMedico(),
            protocolo.getTipo(),
            protocolo.getFechaEntrada(),
            protocolo.getFechaSalida(),
            protocolo.getEstado(),
            protocolo.getMonto()
        };
        model.addRow(fila);
    }
    

    // Asignar el modelo a la tabla
    tableDatos.setModel(model);
    
     // Ajustar el tamaño de las columnas
    TableColumnModel columnModel = tableDatos.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(20);  // ID
    columnModel.getColumn(1).setPreferredWidth(30); // Número de Protocolo
    columnModel.getColumn(2).setPreferredWidth(80); // Id Paciente
    columnModel.getColumn(3).setPreferredWidth(100); // Médico
    columnModel.getColumn(4).setPreferredWidth(200); // Tipo
    columnModel.getColumn(5).setPreferredWidth(100); // Fecha de Entrada
    columnModel.getColumn(6).setPreferredWidth(100); // Fecha de Salida
    columnModel.getColumn(7).setPreferredWidth(100); // Estado
    columnModel.getColumn(8).setPreferredWidth(100); // Monto
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGenerarQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarQrActionPerformed
    GenerarQR qr = new GenerarQR();
        qr.setVisible(true);
    }//GEN-LAST:event_btnGenerarQrActionPerformed

    private void btnAbrirHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirHistorialActionPerformed
          // Obtener el DNI del campo correspondiente
    String dni = txtDni.getText();
    
    if (!dni.isEmpty()) {
        // Crear la ruta completa a la carpeta del paciente
        String folderPath = "C:/Pacientes/" + dni;
        File folder = new File(folderPath);

        // Verificar si la carpeta existe
        if (folder.exists() && folder.isDirectory()) {
            try {
                // Abrir la carpeta con el explorador de archivos predeterminado del sistema operativo
                Desktop.getDesktop().open(folder);
            } catch (IOException e) {
                // Manejar la excepción en caso de que ocurra un error al abrir la carpeta
                JOptionPane.showMessageDialog(this, "No se pudo abrir la carpeta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Mostrar un mensaje de error si la carpeta no se encuentra
            JOptionPane.showMessageDialog(this, "No se encontró la carpeta para el DNI: " + dni, "Carpeta no encontrada", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        // Mostrar un mensaje de error si el campo DNI está vacío
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI válido.", "DNI vacío", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btnAbrirHistorialActionPerformed

    private void btnActualizarDatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarDatos1ActionPerformed
      llenarComboBoxRazonSocial();
          agregarActionListenerComboBox();
    }//GEN-LAST:event_btnActualizarDatos1ActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtCuadroBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuadroBusquedaActionPerformed
       
  // Obtener el texto del campo de búsqueda
    String busqueda = txtCuadroBusqueda.getText().trim();
    
    // Determinar el tipo de búsqueda
    boolean buscarPorDni = chkDni.isSelected();
    boolean buscarPorProtocolo = chkNProtocolo.isSelected();
    
    List<Protocolo> resultados = new ArrayList<>();
    
    if (buscarPorDni && !buscarPorProtocolo) {
        // Búsqueda solo por DNI
        resultados = protocoloData.buscarProtocolos(null, busqueda);
    } else if (!buscarPorDni && buscarPorProtocolo) {
        // Búsqueda solo por número de protocolo
        resultados = protocoloData.buscarProtocolos(busqueda, null);
    } else if (buscarPorDni && buscarPorProtocolo) {
        // Búsqueda por número de protocolo y DNI
        resultados = protocoloData.buscarProtocolos(busqueda, busqueda);
    } else {
        // Mostrar mensaje de error si no se selecciona ninguna opción
        JOptionPane.showMessageDialog(null, "Seleccione una opción de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Definir las columnas de la tabla
    String[] columnas = {"ID",  "Id Paciente","Número de Protocolo","Médico", "Tipo", "Fecha de Entrada", "Fecha de Salida","Estado", "Monto"};

    // Crear el modelo de tabla con las columnas
    DefaultTableModel model = new DefaultTableModel(columnas, 0);

    // Llenar el modelo con los resultados de la búsqueda
    for (Protocolo protocolo : resultados) {
        Object[] fila = new Object[]{
            protocolo.getIdProtocolo(),
            protocolo.getIdPaciente(),
            protocolo.getNumero_protocolo(),
            protocolo.getMedico(),
            protocolo.getTipo(),
            protocolo.getFechaEntrada(),
            protocolo.getFechaSalida(),
            protocolo.getEstado(),
            protocolo.getMonto()
        };
        model.addRow(fila);
    }
    

    // Asignar el modelo a la tabla
    tableDatos.setModel(model);
    
     // Ajustar el tamaño de las columnas
    TableColumnModel columnModel = tableDatos.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(20);  // ID
    columnModel.getColumn(1).setPreferredWidth(30); // Número de Protocolo
    columnModel.getColumn(2).setPreferredWidth(80); // Id Paciente
    columnModel.getColumn(3).setPreferredWidth(100); // Médico
    columnModel.getColumn(4).setPreferredWidth(200); // Tipo
    columnModel.getColumn(5).setPreferredWidth(100); // Fecha de Entrada
    columnModel.getColumn(6).setPreferredWidth(100); // Fecha de Salida
    columnModel.getColumn(7).setPreferredWidth(100); // Estado
    columnModel.getColumn(8).setPreferredWidth(100); // Monto
    }//GEN-LAST:event_txtCuadroBusquedaActionPerformed

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
            java.util.logging.Logger.getLogger(Protocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Protocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Protocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Protocolo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new nuevoProtocolo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirHistorial;
    private javax.swing.JButton btnActualizarDatos1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGenerarQr;
    private javax.swing.JButton btnGuardarProtocolo;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<Profesionales> cbxMedico;
    private javax.swing.JComboBox<Paciente> cbxRazonSocial;
    private javax.swing.JComboBox<String> cbxTipoProtocolo;
    private javax.swing.JCheckBox chkDni;
    private javax.swing.JCheckBox chkNProtocolo;
    private com.toedter.calendar.JDateChooser dcFechaEntrada;
    private com.toedter.calendar.JDateChooser dcFechaSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tableDatos;
    private javax.swing.JTextField txtCuadroBusqueda;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtIdUsuario;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNumeroProtocolo;
    private javax.swing.JLabel txtQr;
    // End of variables declaration//GEN-END:variables


//private void CrearCarpeta() {
//    String numeroProtocol = txtNumeroProtocolo.getText();
//    String dni = txtDni.getText();
//    if (numeroProtocol == null || numeroProtocol.isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Número de protocolo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
//        return;
//    }
//
//    // Crear la carpeta si no existe
//    String folderPath = "\\\\C\\Pacientes\\" + dni + "/" + numeroProtocol;
//    File folder = new File(folderPath);
//    if (!folder.exists()) {
//        folder.mkdirs();
//    }
//
//    // Notificar que la carpeta ha sido creada
//    JOptionPane.showMessageDialog(this, "Carpeta creada en: " + folderPath, "Información", JOptionPane.INFORMATION_MESSAGE);
//}
private void CrearCarpeta() {
    String numeroProtocol = txtNumeroProtocolo.getText();
    String dni = txtDni.getText();
    if (numeroProtocol == null || numeroProtocol.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Número de protocolo no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (dni == null || dni.isEmpty()) {
        JOptionPane.showMessageDialog(this, "DNI no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear la carpeta si no existe
    String folderPath = "C:\\Pacientes\\" + dni + "\\" + numeroProtocol;
    File folder = new File(folderPath);
    if (!folder.exists()) {
        if (folder.mkdirs()) {
            JOptionPane.showMessageDialog(this, "Carpeta creada en: " + folderPath, "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudo crear la carpeta", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "La carpeta ya existe: " + folderPath, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
}

//private void abrirCarpeta(){
//String dni = txtDni.getText();
//    
//    if (!dni.isEmpty()) {
//        // Crear la ruta completa a la carpeta del paciente
////        String folderPath = "C:/Pacientes/" + dni;
//        String folderPath = "\\\\C:\\Pacientes\\" + dni;
////        \\\\26.180.193.52\\C\\Pacientes\\
//        File folder = new File(folderPath);
//
//        // Verificar si la carpeta existe
//        if (folder.exists() && folder.isDirectory()) {
//            try {
//                // Abrir la carpeta con el explorador de archivos predeterminado del sistema operativo
//                Desktop.getDesktop().open(folder);
//            } catch (IOException e) {
//                // Manejar la excepción en caso de que ocurra un error al abrir la carpeta
//                JOptionPane.showMessageDialog(this, "No se pudo abrir la carpeta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//            }
//        } else {
//            // Mostrar un mensaje de error si la carpeta no se encuentra
//            JOptionPane.showMessageDialog(this, "No se encontró la carpeta para el DNI: " + dni, "Carpeta no encontrada", JOptionPane.WARNING_MESSAGE);
//        }
//    } else {
//        // Mostrar un mensaje de error si el campo DNI está vacío
//        JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI válido.", "DNI vacío", JOptionPane.WARNING_MESSAGE);
//    }
//
//
//}
private void abrirCarpeta(){
    String dni = txtDni.getText();
    if (!dni.isEmpty()) {
        String folderPath = "C:\\Pacientes\\" + dni;
        File folder = new File(folderPath);

        if (folder.exists() && folder.isDirectory()) {
            try {
                Desktop.getDesktop().open(folder);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "No se pudo abrir la carpeta: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la carpeta para el DNI: " + dni, "Carpeta no encontrada", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, ingrese un DNI válido.", "DNI vacío", JOptionPane.WARNING_MESSAGE);
    }
}


private String convertirImagenABase64(BufferedImage imagen) {
    String base64Image = "";
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        ImageIO.write(imagen, "png", baos);
        byte[] imageBytes = baos.toByteArray();
        base64Image = Base64.getEncoder().encodeToString(imageBytes);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return base64Image;
}




}
