package PackageEmpleados.PackageOpciones;

import PackageEmpleados.Empleados_Controlador;
import PackageEmpleados.Empleados_Object;
import PackageEmpleados.Empleados_Vista;
import PackageEmpresas.Empresas_Controlador;
import PackageEmpresas.Empresas_Object;
import PackageTools.Validaciones;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Empleados_Actualizar_Vista extends javax.swing.JFrame {

    // CONTROLADOR DE EMPLEADO Y EMPRESA
    private final Empleados_Controlador controladorEmpleado = new Empleados_Controlador();
    private final Empresas_Controlador controladorEmpresa = new Empresas_Controlador();   

    // VARIABLE VISTA-EMPLEADO PRINCIPAL
    private final Empleados_Vista vistaE;

    // VARIABLE-EMPLEADO
    private Empleados_Object empleado;

    // INDICE-TABLA
    private int indice;

    // MODELO DE LA TABLA
    private DefaultTableModel modelo;

    // CONSTRUCTOR
    public Empleados_Actualizar_Vista(Empleados_Vista vistaE, Empleados_Object empleado, int indice) {
        initComponents();
        this.setLocationRelativeTo(null);
        
        // APLICAMOS LAS VARIABLES EMPLEADO
        this.vistaE = vistaE;
        this.empleado = empleado;
        
        // APLICAMOS EL INDICE-TABLA
        this.indice = indice;

        // CARGAMOS LAS EMPRESAS Y DATOS DE EMPLEADO
        cargarDatos();
    }
    
    // GETTERS AND SETTERS
    public Empleados_Object getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados_Object empleado) {
        this.empleado = empleado;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    // METODO PARA CARGAR LAS EMPRESAS EN LA TABLA Y LOS DATOS DEL EMPLEADO
    public void cargarDatos() {

        // CARGAMOS LOS DATOS DEL EMPLEADO
        this.txtDni.setText(this.empleado.getDni());
        this.txtNombre.setText(this.empleado.getNombre());
        this.txtTelefono.setText(String.valueOf(this.empleado.getTelefono()));
        this.spnEdad.setValue(this.empleado.getEdad());

        // SE APLICA LAS COLUMNAS
        String columnas[] = {"ID", "NOMBRE"};
        this.modelo = new DefaultTableModel(columnas, 0);
        
        // LIMPIAMOS LA TABLA
        this.modelo.setRowCount(0);
        
        // TOTAL DE EMPRESAS
        int totalEmpresas = this.controladorEmpresa.totalEmpresas().join();
        
        if(totalEmpresas != 0){
            
            // OBTENEMOS LAS EMPRESAS
            this.controladorEmpresa.obtenerTodasEmpresas_C().thenAccept(listaEmpresas -> {
            
                // CARGAMOS TODOS LOS DATOS           
                Object arrayObjetos[] = new Object[2];
                for (Empresas_Object aux : listaEmpresas) {
                    arrayObjetos[0] = aux.getId_empresa();
                    arrayObjetos[1] = aux.getNombre();
                    this.modelo.addRow(arrayObjetos);
                }

                this.tablaEmpresas.setModel(this.modelo);

                // SELECCIONAMOS FILA DE LA TABLA
                if (this.indice != -1) {
                    this.tablaEmpresas.setRowSelectionInterval(indice, indice);
                }
            
            }).exceptionally(ex ->{
                return null;
            });

        }else{
            this.tablaEmpresas.setModel(this.modelo);
        }

    }

    // COMPONENTES DE LA INTERFAZ
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpresas = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        spnEdad = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ACTUALIZAR EMPLEADO");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("--- ACTUALIZAR EMPLEADO ---");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel2.setText("DNI :");

        txtDni.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtDni.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDni.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel3.setText("EDAD :");

        btnActualizar.setBackground(new java.awt.Color(0, 0, 0));
        btnActualizar.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        btnActualizar.setFocusable(false);
        btnActualizar.setIconTextGap(15);
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnActualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnActualizarMouseExited(evt);
            }
        });
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel4.setText("* SELECCIONA UNA EMPRESA :");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jScrollPane1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N

        tablaEmpresas.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        tablaEmpresas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "NOMBRE"
            }
        ));
        tablaEmpresas.setFocusable(false);
        tablaEmpresas.setRowHeight(40);
        tablaEmpresas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tablaEmpresas);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel5.setText("NOMBRE :");

        txtNombre.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jLabel6.setText("TELEFONO :");

        txtTelefono.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtTelefono.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        spnEdad.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        spnEdad.setModel(new javax.swing.SpinnerNumberModel(16, 16, 99, 1));
        spnEdad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtDni)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                    .addComponent(spnEdad))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    // METODO-ESTETICO
    private void btnActualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseEntered
        this.btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.btnActualizar.setBackground(Color.GRAY);
    }//GEN-LAST:event_btnActualizarMouseEntered

    // METODO-ESTETICO
    private void btnActualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseExited
        this.btnActualizar.setBackground(Color.BLACK);
    }//GEN-LAST:event_btnActualizarMouseExited

    // METODO PARA ACTUALIZAR EL EMPLEADO
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        try {
            
            String dni = this.txtDni.getText().toUpperCase();
            String nombre = this.txtNombre.getText().toUpperCase();
            int edad = (int)this.spnEdad.getValue();
            String telefono = this.txtTelefono.getText().toUpperCase();
            
            if(Validaciones.validarEmpleado(dni, nombre, telefono)){
                
                this.controladorEmpleado.verificarDniYTelefono(dni, telefono).thenAccept(verificaciones -> {                
                    if((!verificaciones[0] || dni.equals(this.empleado.getDni())) && (!verificaciones[1] || telefono.equals(String.valueOf(this.empleado.getTelefono())))){
                        
                        if (this.tablaEmpresas.getRowCount() != 0) {

                            if (this.tablaEmpresas.getSelectedRow() != -1) {
                                
                                this.controladorEmpresa.obtenerEmpresa_C((int) this.tablaEmpresas.getValueAt(this.tablaEmpresas.getSelectedRow(), 0)).thenAccept(empresa -> {                            
                                    if(empresa != null){
                                        
                                        this.empleado.setDni(dni);
                                        this.empleado.setNombre(nombre);
                                        this.empleado.setEdad(edad);
                                        this.empleado.setTelefono(Integer.parseInt(telefono));
                                        this.empleado.setEmpresas_id_empresa(empresa);
                                        this.controladorEmpleado.actualizarEmpleado_C(this.empleado).thenRun(() -> {
                                            this.vistaE.actualizarDatos(this.empleado.getId_empleado());
                                        }).exceptionally(ex ->{
                                            return null;
                                        });
                                        this.txtDni.setText("");
                                        this.txtNombre.setText("");
                                        this.txtTelefono.setText("");
                                        this.dispose();
                                                                                
                                    }                                
                                }).exceptionally(ex ->{
                                    return null;
                                });
                                
                            } else {
                                JOptionPane.showMessageDialog(null, "TIENES QUE SELECCIONAR UNA EMPRESA DE LA TABLA", "ACTUALIZAR EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
                            }

                        } else {
                            this.empleado.setDni(dni);
                            this.empleado.setNombre(nombre);
                            this.empleado.setEdad(edad);
                            this.empleado.setTelefono(Integer.parseInt(telefono));
                            this.controladorEmpleado.actualizarEmpleado_C(this.empleado).thenRun(() -> {
                                this.vistaE.actualizarDatos(this.empleado.getId_empleado());
                            });
                            this.txtDni.setText("");
                            this.txtNombre.setText("");
                            this.txtTelefono.setText("");
                            this.dispose();
                            
                        }
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "DNI O TELEFONO YA EXISTENTE", "ACTUALIZAR EMPLEADO", JOptionPane.INFORMATION_MESSAGE);
                    }                   
                }).exceptionally(ex ->{
                    return null;
                });
                
            }else{
                JOptionPane.showMessageDialog(null, "HAS INTRODUCIDO UN DATO ERRONEO", "ACTUALIZAR EMPLEADO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "HAS INTRODUCIDO UN DATO ERRONEO", "ACTUALIZAR EMPLEADO", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnEdad;
    private javax.swing.JTable tablaEmpresas;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
