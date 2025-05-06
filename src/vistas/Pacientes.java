
package vistas;

import javax.swing.JOptionPane;
import Entidades.Paciente;
import Metodos.pacienteData;
import com.google.zxing.client.j2se.ImageReader;
import com.google.zxing.common.reedsolomon.GenericGF;
import java.awt.Desktop;
import java.awt.JobAttributes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import net.glxn.qrgen.QRCode;



public class Pacientes extends javax.swing.JFrame {
  private pacienteData pacienteData;
    private DefaultTableModel tableModel;
    
    
    public Pacientes() {
        
        pacienteData = new pacienteData();
        initComponents();
        chkBuscarDni.setSelected(true);

        tableModel = new DefaultTableModel();
        tableResultados.setModel(tableModel);

        // Agregar columnas a la tabla
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        tableModel.addColumn("Historia Clínica");
        tableModel.addColumn("id");
        
       
        tableResultados.getColumnModel().getColumn(0).setPreferredWidth(60); 
        tableResultados.getColumnModel().getColumn(1).setPreferredWidth(200); 
        tableResultados.getColumnModel().getColumn(2).setPreferredWidth(30); 
        tableResultados.getColumnModel().getColumn(3).setPreferredWidth(30);
    }
    
   

    private void buscarPacientes() {
        String criterio = cuadroBusqueda.getText();
        List<Paciente> pacientes;

        if (chkBuscarDni.isSelected() && !chkBuscarApellido.isSelected()) {
            Paciente paciente = pacienteData.buscarPacientePorDNI(criterio);
            pacientes = paciente != null ? List.of(paciente) : List.of();
        } else if (!chkBuscarDni.isSelected() && chkBuscarApellido.isSelected()) {
            pacientes = pacienteData.buscarPacientesPorApellido(criterio); // Debes implementar este método en pacienteData
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona solo un criterio de búsqueda.");
            return;
        }

        // Actualizar la tabla con los resultados
        actualizarTabla(pacientes);
    }
     private void actualizarTabla(List<Paciente> pacientes) {
        // Limpiar la tabla
        tableModel.setRowCount(0);

        // Agregar los datos de los pacientes a la tabla
        for (Paciente paciente : pacientes) {
            tableModel.addRow(new Object[]{
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getHistoriaClinica(),
                paciente.getIdPaciente()
            });
        }
    }
     

private void CrearQR() {
    String dni = campoDni.getText();
    if (dni == null || dni.isEmpty()) {
        JOptionPane.showMessageDialog(this, "DNI no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ByteArrayOutputStream outQr;
    try {
        outQr = QRCode.from(dni).withSize(120, 120).stream();
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al generar el código QR: " + e.getMessage(), "Cod. Error 25", JOptionPane.ERROR_MESSAGE);
        return;
    }

    ByteArrayInputStream inQR = new ByteArrayInputStream(outQr.toByteArray());

    BufferedImage bf = null;

    try {
        bf = ImageIO.read(inQR);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al leer el flujo del código QR: " + e.getMessage(), "Cod. Error 25", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear la carpeta si no existe
    String folderPath = "C:/Pacientes/" + dni;
    File folder = new File(folderPath);
    if (!folder.exists()) {
        folder.mkdirs();
    }

    // Guardar la imagen en la carpeta creada con el nombre del DNI
    File f = new File(folderPath + "/" + dni + ".png");
    try {
        ImageIO.write(bf, "png", f);
        Thread.sleep(2000);

        ImageIcon icono = new ImageIcon(f.getAbsolutePath());
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error al guardar el archivo del código QR: " + e.getMessage(), "Cod. Error 26", JOptionPane.ERROR_MESSAGE);
    }
}


    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        cuadroBusqueda = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        chkBuscarDni = new javax.swing.JCheckBox();
        chkBuscarApellido = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableResultados = new javax.swing.JTable();
        btnMostrarCampos = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservacion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        campoApellido = new javax.swing.JTextField();
        campoTelefono = new javax.swing.JTextField();
        campoDireccion = new javax.swing.JTextField();
        campoEmail = new javax.swing.JTextField();
        campoGenero = new javax.swing.JTextField();
        campoDni = new javax.swing.JTextField();
        campoFechaNac = new javax.swing.JTextField();
        campoNombre = new javax.swing.JTextField();
        btnEliminar1 = new javax.swing.JButton();
        btnAbrirQR = new javax.swing.JButton();
        btnAbrirCarpeta = new javax.swing.JButton();
        btnLimpiarCampos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 270, 20));

        jSeparator2.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 270, 20));

        jSeparator3.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 270, 20));

        jSeparator5.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 270, 20));

        jSeparator4.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 270, 20));

        jSeparator6.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 270, 20));

        jSeparator7.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 350, 270, 20));

        jSeparator8.setForeground(new java.awt.Color(235, 235, 235));
        jPanel2.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 270, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("NOMBRE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("APELLIDO");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("TELEFONO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("DIRECCION");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("FECHA DE NACIMIENTO");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("DNI");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("GENERO");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("EMAIL");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 380, -1, -1));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/agregar-usuario.png"))); // NOI18N
        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 480, 170, 50));

        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/actualizar-datos.png"))); // NOI18N
        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel2.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 480, 170, 50));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/lupa (1).png"))); // NOI18N
        btnBuscar.setText("BUSCAR");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 170, 120, 40));
        jPanel2.add(cuadroBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 170, 220, 40));

        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/cerrar-sesion.png"))); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 540, 170, 50));

        chkBuscarDni.setText("DNI");
        jPanel2.add(chkBuscarDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, -1));

        chkBuscarApellido.setText("APELLIDO");
        jPanel2.add(chkBuscarApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, -1, -1));

        tableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tableResultados);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 230, 350, 140));

        btnMostrarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/consultoria-en-linea.png"))); // NOI18N
        btnMostrarCampos.setText("MOSTRAR TODOS LOS DATOS");
        btnMostrarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarCamposActionPerformed(evt);
            }
        });
        jPanel2.add(btnMostrarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 350, 40));

        txtObservacion.setColumns(20);
        txtObservacion.setRows(5);
        jScrollPane3.setViewportView(txtObservacion);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 350, 120));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Observación");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, -1, -1));

        campoApellido.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoApellido.setForeground(new java.awt.Color(63, 122, 151));
        campoApellido.setBorder(null);
        jPanel2.add(campoApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 260, -1));

        campoTelefono.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoTelefono.setForeground(new java.awt.Color(63, 122, 151));
        campoTelefono.setBorder(null);
        jPanel2.add(campoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 260, -1));

        campoDireccion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoDireccion.setForeground(new java.awt.Color(63, 122, 151));
        campoDireccion.setBorder(null);
        jPanel2.add(campoDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 260, -1));

        campoEmail.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoEmail.setForeground(new java.awt.Color(63, 122, 151));
        campoEmail.setBorder(null);
        jPanel2.add(campoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, 260, -1));

        campoGenero.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoGenero.setForeground(new java.awt.Color(63, 122, 151));
        campoGenero.setBorder(null);
        jPanel2.add(campoGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 260, -1));

        campoDni.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoDni.setForeground(new java.awt.Color(63, 122, 151));
        campoDni.setBorder(null);
        jPanel2.add(campoDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 260, -1));

        campoFechaNac.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoFechaNac.setForeground(new java.awt.Color(63, 122, 151));
        campoFechaNac.setBorder(null);
        jPanel2.add(campoFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 260, -1));

        campoNombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        campoNombre.setForeground(new java.awt.Color(63, 122, 151));
        campoNombre.setBorder(null);
        jPanel2.add(campoNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 260, -1));

        btnEliminar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/quitar-usuario.png"))); // NOI18N
        btnEliminar1.setText("ELIMINAR");
        jPanel2.add(btnEliminar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 170, 50));

        btnAbrirQR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/descarga-en-la-nube.png"))); // NOI18N
        btnAbrirQR.setText("NUEVO PROTOCOO");
        btnAbrirQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirQRActionPerformed(evt);
            }
        });
        jPanel2.add(btnAbrirQR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, 190, 50));

        btnAbrirCarpeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/carpeta-abierta.png"))); // NOI18N
        btnAbrirCarpeta.setText("CARPETA DE USUARIO");
        btnAbrirCarpeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirCarpetaActionPerformed(evt);
            }
        });
        jPanel2.add(btnAbrirCarpeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 190, 50));

        btnLimpiarCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/iconos-chicos/escoba.png"))); // NOI18N
        btnLimpiarCampos.setText("LIMPIAR CAMPOS");
        btnLimpiarCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarCamposActionPerformed(evt);
            }
        });
        jPanel2.add(btnLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 430, 350, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 255));
        jLabel11.setText("NUEVO CLIENTE");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 60, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondos/marquesina-1_B.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, 0, 1020, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
      
            try {
            // Recopilar los datos del proveedor desde los campos de entrada en tu ventana
            
            String nombre = campoNombre.getText();
            String apellido = campoApellido.getText();
            String telefono = campoTelefono.getText();
            String direccion = campoDireccion.getText();
            String fechaNac = campoFechaNac.getText();
            String dni = campoDni.getText();
            String genero = campoGenero.getText();
            String email = campoEmail.getText();
            int historiaCli = 0;
            String observacion = txtObservacion.getText();
            double saldo = 0.0;
            
            

            // Validar que los campos obligatorios no estén vacíos
            if (apellido.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || dni.isEmpty() ) {
                // Mostrar un mensaje de error o realizar la lógica necesaria en caso de campos vacíos
                // Por ejemplo, mostrar una ventana de diálogo de error
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Llamar al método para agregar el proveedor en la base de datos
               pacienteData.agregarPacientes(nombre, apellido, fechaNac, dni, direccion, telefono, email, genero, historiaCli, observacion, saldo);
                CrearQR();
                // Limpia los campos de entrada después de agregar el proveedor (opcional)
                campoNombre.setText("");
                campoApellido.setText("");
                campoTelefono.setText("");
                campoDireccion.setText("");
                campoFechaNac.setText("");
                 campoDni.setText("");
                campoGenero.setText("");
                 campoEmail.setText("");
                  txtObservacion.setText("");
                  
                   
            }
        } catch (NumberFormatException e) {
            // Manejar el caso en el que la conversión falla, por ejemplo, mostrar un mensaje de error
            JOptionPane.showMessageDialog(this, "Los campos numéricos contienen valores no válidos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarPacientes();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnMostrarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarCamposActionPerformed
       // Obtener el índice de la fila seleccionada
    int selectedRow = tableResultados.getSelectedRow();

    if (selectedRow >= 0) {
        // Obtener el ID del paciente seleccionado
        int pacienteId = (int) tableModel.getValueAt(selectedRow, 3); // Columna del ID

        // Buscar el paciente por ID
        Paciente paciente = pacienteData.buscarPacientePorID(pacienteId);

        if (paciente != null) {
            // Mostrar los valores en los campos correspondientes
            campoNombre.setText(paciente.getNombre());
            campoApellido.setText(paciente.getApellido());
            campoTelefono.setText(paciente.getTelefono());
            campoDireccion.setText(paciente.getDireccion());
            campoFechaNac.setText(paciente.getFechaNacimiento());
            campoDni.setText(paciente.getDni());
            campoGenero.setText(paciente.getGenero());
            campoEmail.setText(paciente.getEmail());
            txtObservacion.setText(paciente.getObservacion());

            // Mostrar el QR correspondiente al DNI del paciente
            String dni = paciente.getDni();
            String qrPath = "C:/Pacientes/" + dni + "/" + dni + ".png";
            File qrFile = new File(qrPath);

            if (qrFile.exists()) {
                ImageIcon icono = new ImageIcon(qrFile.getAbsolutePath());
                
            } else {
                // Limpiar el icono si no se encuentra el archivo QR
              
                JOptionPane.showMessageDialog(this, "No se encontró el código QR para el DNI: " + dni, "QR no encontrado", JOptionPane.WARNING_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnMostrarCamposActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
          try {
        // Obtener el índice de la fila seleccionada
        int selectedRow = tableResultados.getSelectedRow();

        if (selectedRow >= 0) {
            // Obtener el ID del paciente seleccionado
            int pacienteId = (int) tableModel.getValueAt(selectedRow, 3); // Columna del ID

            // Recopilar los datos del paciente desde los campos de entrada en tu ventana
            String nombre = campoNombre.getText();
            String apellido = campoApellido.getText();
            String fechaNac = campoFechaNac.getText();
            String dni = campoDni.getText();
            String direccion = campoDireccion.getText();
            String telefono = campoTelefono.getText();
            String email = campoEmail.getText();
            String genero = campoGenero.getText();
            String observacion = txtObservacion.getText();

            // Validar que los campos obligatorios no estén vacíos
            if (apellido.isEmpty() || nombre.isEmpty() || direccion.isEmpty() || telefono.isEmpty() || dni.isEmpty()) {
                // Mostrar un mensaje de error en caso de campos vacíos
                JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Llamar al método para actualizar el paciente en la base de datos
                pacienteData.actualizarPaciente(pacienteId, nombre, apellido, fechaNac, dni, direccion, telefono, email, genero, observacion);

                // Limpiar los campos de entrada después de actualizar el paciente (opcional)
                campoNombre.setText("");
                campoApellido.setText("");
                campoTelefono.setText("");
                campoDireccion.setText("");
                campoFechaNac.setText("");
                campoDni.setText("");
                campoGenero.setText("");
                campoEmail.setText("");
                txtObservacion.setText("");

                // Actualizar la tabla para reflejar los cambios
                buscarPacientes();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una fila de la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } catch (NumberFormatException e) {
        // Manejar el caso en el que la conversión falla, por ejemplo, mostrar un mensaje de error
        JOptionPane.showMessageDialog(this, "Los campos numéricos contienen valores no válidos", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAbrirQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirQRActionPerformed
    nuevoProtocolo np = new nuevoProtocolo();
             np.setVisible(true);
    }//GEN-LAST:event_btnAbrirQRActionPerformed

    private void btnAbrirCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirCarpetaActionPerformed
       // Obtener el DNI del campo correspondiente
    String dni = campoDni.getText();
    
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
    }//GEN-LAST:event_btnAbrirCarpetaActionPerformed

    private void btnLimpiarCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCamposActionPerformed
       campoNombre.setText("");
                campoApellido.setText("");
                campoTelefono.setText("");
                campoDireccion.setText("");
                campoFechaNac.setText("");
                campoDni.setText("");
                campoGenero.setText("");
                campoEmail.setText("");
                txtObservacion.setText("");
                cuadroBusqueda.setText("");
    }//GEN-LAST:event_btnLimpiarCamposActionPerformed

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
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pacientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirCarpeta;
    private javax.swing.JButton btnAbrirQR;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnLimpiarCampos;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnMostrarCampos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JTextField campoApellido;
    private javax.swing.JTextField campoDireccion;
    private javax.swing.JTextField campoDni;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoFechaNac;
    private javax.swing.JTextField campoGenero;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JTextField campoTelefono;
    private javax.swing.JCheckBox chkBuscarApellido;
    private javax.swing.JCheckBox chkBuscarDni;
    private javax.swing.JTextField cuadroBusqueda;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tableResultados;
    private javax.swing.JTextArea txtObservacion;
    // End of variables declaration//GEN-END:variables
}
