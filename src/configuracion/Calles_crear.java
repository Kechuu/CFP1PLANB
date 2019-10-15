/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import Controlador.CtrlLugar;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
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
public final class Calles_crear extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    /**
     * Creates new form crearCalle
     * @throws java.lang.ClassNotFoundException
     */
    public Calles_crear() throws ClassNotFoundException {
        initComponents();
        cbBarrio.setEnabled(false);
        cargarComboLocalidad(cbLocalidad);
        txtNuevaCalle.setFocusable(true);
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
    
    /*
    public void cargarComboBarrio(JComboBox<Lugar> cbLocalidad, int idLugar){
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM lugar WHERE nivel = 2 AND de = '"+idLugar+"'ORDER BY nombre ASC");
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
    */
    
    public Vector<Lugar> cargarBarrio(int idLugar) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Lugar> datos = new Vector<>();
        Lugar dat = null;
        try {
            String sql = "SELECT * FROM lugar WHERE nivel=2 and de =" + idLugar;
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            dat = new Lugar();
            dat.setIdLugar(0);
            dat.setNombre("Seleccionae una opción...");
            dat.setNivel(0);
            dat.setDe(0);
            datos.add(dat);
                while (rs.next()) {
                    dat = new Lugar();
                    dat.setIdLugar(rs.getInt("idLugar"));
                    dat.setNombre(rs.getString("nombre"));
                    dat.setNivel(rs.getInt("nivel"));
                    dat.setDe(rs.getInt("de"));
                    datos.add(dat);
                }
                rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
    
    public void llenarTablaCalle(JTable tabla, int idLugar){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        tabla.setModel(modelo);
        String[] dato = new String[1];
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT nombre FROM lugar WHERE nivel = 1 AND de = '"+ idLugar +"'ORDER BY nombre ASC");
            
            while (rs.next()) {                
                dato[0]=rs.getString(1);
                modelo.addRow(dato);
            }
            
            tabla.setModel(modelo);
            
        } catch (Exception e) {
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
        jLabel3 = new javax.swing.JLabel();
        cbLocalidad = new javax.swing.JComboBox<>();
        cbBarrio = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNuevaCalle = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaCalles = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREAR CALLE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Localidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Barrio");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        cbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadItemStateChanged(evt);
            }
        });
        jPanel1.add(cbLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 180, -1));

        cbBarrio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBarrioItemStateChanged(evt);
            }
        });
        jPanel1.add(cbBarrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 150, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Nueva calle");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        txtNuevaCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNuevaCalleKeyPressed(evt);
            }
        });
        jPanel1.add(txtNuevaCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 270, -1));

        btnAceptar.setBackground(new java.awt.Color(38, 86, 186));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, -1));

        btnCancelar.setBackground(new java.awt.Color(38, 86, 186));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 390, 100, -1));

        tablaCalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaCalles);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 330, 140));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Calles");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        CtrlLugar ctrlLugar = new CtrlLugar();
        Lugar lugar = new Lugar();
        if (txtNuevaCalle.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se puede cargar un registro vacio");
        }else{
            lugar = (Lugar) cbBarrio.getSelectedItem();
            ctrlLugar.crear(txtNuevaCalle.getText(), 1, lugar.getIdLugar());
            llenarTablaCalle(tablaCalles, lugar.getIdLugar());
            txtNuevaCalle.setText("");
            txtNuevaCalle.setFocusable(true);
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadItemStateChanged
        Lugar lugar = new Lugar();

        lugar = (Lugar) cbLocalidad.getSelectedItem();
        cbBarrio.setEnabled(true);
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(cargarBarrio(lugar.getIdLugar()));
        cbBarrio.setModel(modelo);
        
    }//GEN-LAST:event_cbLocalidadItemStateChanged

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameOpened

    private void cbBarrioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBarrioItemStateChanged
        Lugar lugar = new Lugar();
        lugar = (Lugar) cbBarrio.getSelectedItem();
        
        llenarTablaCalle(tablaCalles, lugar.getIdLugar());
        txtNuevaCalle.setFocusable(true);
    }//GEN-LAST:event_cbBarrioItemStateChanged

    private void txtNuevaCalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevaCalleKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAceptarActionPerformed(e);
        }
    }//GEN-LAST:event_txtNuevaCalleKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Lugar> cbBarrio;
    private javax.swing.JComboBox<Lugar> cbLocalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaCalles;
    private javax.swing.JTextField txtNuevaCalle;
    // End of variables declaration//GEN-END:variables
}
