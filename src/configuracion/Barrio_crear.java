/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import Controlador.CtrlLugar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import menu.Principal;
import modelo.Lugar;


/**
 *
 * @author RociojulietaVazquez
 */
public final class Barrio_crear extends javax.swing.JInternalFrame {
    //CtrlLugar lugar1 = new CtrlLugar();
    Connection con = clases.Conectar.conexion();
    /**
     * Creates new form crearBarrio
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Barrio_crear() throws ClassNotFoundException, SQLException {
        initComponents();
            cargarComboLocalidad(cbLocalidad);
            txtnuevoBarrio.setEnabled(false);
            btnAceptar.setEnabled(false);        
    }

    
    public void cargarComboLocalidad(JComboBox<Lugar> cbLocalidad){
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM lugar WHERE nivel = 3 ORDER BY nombre ASC");
            Lugar lugar = new Lugar();
            lugar.setIdLugar(0);
            lugar.setNombre("Seleccione una opcion...");
            lugar.setNivel(0);
            lugar.setDe(0);
            cbLocalidad.addItem(lugar);
            
            while (rs.next()) {                
                lugar = new Lugar();
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
                cbLocalidad.addItem(lugar);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento");       
        }
        
    }
    
    public void llenarTablaBarrio(JTable tabla, int idLugar){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        tabla.setModel(modelo);
        String[] dato = new String[1];
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT nombre FROM lugar WHERE nivel = 2 AND de = '"+ idLugar +"'ORDER BY nombre ASC");
            
            while (rs.next()) {                
                dato[0]=rs.getString(1);
                modelo.addRow(dato);
            }
            
            tabla.setModel(modelo);
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS BARRIOS EN LA TABLA"); 
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbLocalidad = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtnuevoBarrio = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnAgregarCalle = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaBarrios = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREAR BARRIO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Localidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        cbLocalidad.setNextFocusableComponent(txtnuevoBarrio);
        cbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadItemStateChanged(evt);
            }
        });
        jPanel1.add(cbLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Nuevo barrio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, -1, -1));
        jPanel1.add(txtnuevoBarrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 230, -1));

        btnCancelar.setBackground(new java.awt.Color(38, 86, 186));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 100, -1));

        btnAceptar.setBackground(new java.awt.Color(38, 86, 186));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 100, -1));

        btnAgregarCalle.setBackground(new java.awt.Color(38, 86, 186));
        btnAgregarCalle.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarCalle.setText("Agregar calle");
        btnAgregarCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCalleActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregarCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 330, 130, -1));

        tablaBarrios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaBarrios);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 340, 140));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Barrios");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCalleActionPerformed
        try {
            // TODO add your handling code here:
            this.setVisible(false);
            
            Principal.crearCalle();//metodo que esta en la clase Principal
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Barrio_crear.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarCalleActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        CtrlLugar ctrlLugar = new CtrlLugar();
        Lugar lugar = new Lugar();
        
        lugar = (Lugar) cbLocalidad.getSelectedItem();
        if (txtnuevoBarrio.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede cargar un registro en blanco");
        }else{
            ctrlLugar.crear(txtnuevoBarrio.getText(), 2, lugar.getIdLugar());
            llenarTablaBarrio(tablaBarrios, lugar.getIdLugar());
            txtnuevoBarrio.setText("");
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadItemStateChanged
        // TODO add your handling code here:
        Lugar lugar = new Lugar();
        lugar = (Lugar) cbLocalidad.getSelectedItem();
        llenarTablaBarrio(tablaBarrios, lugar.getIdLugar());
        txtnuevoBarrio.setEnabled(true);
        btnAceptar.setEnabled(true);
    }//GEN-LAST:event_cbLocalidadItemStateChanged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        // TODO add your handling code here:
     
    }//GEN-LAST:event_formMouseReleased

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
     
    }//GEN-LAST:event_formFocusGained

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_formMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarCalle;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Lugar> cbLocalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaBarrios;
    private javax.swing.JTextField txtnuevoBarrio;
    // End of variables declaration//GEN-END:variables
}
