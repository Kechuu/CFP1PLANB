/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import Controlador.CtrlCodigoPostal;
import Controlador.CtrlLugar;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import menu.Principal;
import modelo.CodigoPostal;
import modelo.Lugar;


/**
 *
 * @author 
 */
public class Localidad_modificar extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    public int idCodigoPostal;
    public int bandera = 0;
    CodigoPostal codigoPostal = new CodigoPostal();
    CtrlCodigoPostal ctrlCodigoPostal = new CtrlCodigoPostal();
    int c=0;
    /**
     * Creates new form modificarlocalidad
     * @throws java.lang.ClassNotFoundException
     */
    
    public Localidad_modificar() throws ClassNotFoundException {
        initComponents();
        bandera=1;
        cargarComboLocalidad(cbLocalidadActual);
        txtCodigoActual.setEnabled(false);
        for (int i = 0; i < cbLocalidadActual.getItemCount(); i++) {
                if (cbLocalidadActual.getItemAt(i).getNombre().equalsIgnoreCase(Localidad_consulta.nombreLocalidad)) {
                    cbLocalidadActual.setSelectedIndex(i);
                }
            }
        codigoPostal = ctrlCodigoPostal.leer(Localidad_consulta.idLocalidad);
        bandera=0;
        idCodigoPostal = codigoPostal.getIdCodigoPostal();
        txtLocalidad.setText(Localidad_consulta.nombreLocalidad);
        txtCodigoActual.setText(codigoPostal.getCodigoPostal());
        txtCambiarCodigo.setText(codigoPostal.getCodigoPostal());
        txtLocalidad.setFocusable(true);
    }

    
    public void cargarComboLocalidad(JComboBox<Lugar> cbLocalidadActual){
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM lugar WHERE nivel = 3 ORDER BY nombre ASC");
            Lugar lugar = new Lugar();
            lugar.setIdLugar(0);
            lugar.setNombre("Seleccione una opcion...");
            lugar.setNivel(0);
            lugar.setDe(0);
            cbLocalidadActual.addItem(lugar);
            
            while (rs.next()) {                
                lugar = new Lugar();
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
                cbLocalidadActual.addItem(lugar);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento");       
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtLocalidad = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbLocalidadActual = new javax.swing.JComboBox<>();
        txtCodigoActual = new javax.swing.JTextField();
        txtCambiarCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFICAR LOCALIDAD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addContainerGap(347, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Localidad actual:");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Cambiar Código postal");

        btnAceptar.setBackground(new java.awt.Color(38, 86, 186));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(38, 86, 186));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cbLocalidadActual.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadActualItemStateChanged(evt);
            }
        });

        txtCodigoActual.setEditable(false);
        txtCodigoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActualActionPerformed(evt);
            }
        });

        txtCambiarCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCambiarCodigoKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setText("Cambiar localidad:");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("Código postal actual");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLocalidadActual, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtLocalidad, javax.swing.GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCodigoActual, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCambiarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addComponent(jLabel5)
                    .addContainerGap(345, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigoActual, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbLocalidadActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCambiarCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(158, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addGap(141, 141, 141)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        CtrlLugar ctrlLugar = new CtrlLugar();
        CtrlCodigoPostal ctrlCodigoPostal = new CtrlCodigoPostal();
        CodigoPostal codigoPostal = new CodigoPostal();
        
        if (txtLocalidad.getText().equalsIgnoreCase("") || txtCambiarCodigo.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar registros vacios");
        }else{
            bandera=1;
            Lugar lugar = new Lugar();
            lugar = (Lugar) cbLocalidadActual.getSelectedItem();
            ctrlLugar.editar(lugar.getIdLugar(), txtLocalidad.getText(), 3, 1);
            ctrlCodigoPostal.editar(lugar.getIdLugar(), txtCambiarCodigo.getText());
            cbLocalidadActual.removeAllItems();
            bandera=1;
            cargarComboLocalidad(cbLocalidadActual);
            bandera=0;
            txtCodigoActual.setText("");
            txtLocalidad.setText("");
            txtCambiarCodigo.setText("");
            bandera=0;
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCodigoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActualActionPerformed
        // TODO add your handling code here:-
    }//GEN-LAST:event_txtCodigoActualActionPerformed

    private void cbLocalidadActualItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadActualItemStateChanged
        CtrlCodigoPostal ctrlCodigoPostal = new CtrlCodigoPostal();
        CodigoPostal codigoPostal1 = new CodigoPostal();
        Lugar lugar = new Lugar();
        
        if (bandera==0) {
        lugar = (Lugar) cbLocalidadActual.getSelectedItem();
        codigoPostal1 = ctrlCodigoPostal.leer(lugar.getIdLugar());
        txtCodigoActual.setText(codigoPostal1.getCodigoPostal());
        }
    }//GEN-LAST:event_cbLocalidadActualItemStateChanged

    private void txtCambiarCodigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCambiarCodigoKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAceptarActionPerformed(e);
        }
    }//GEN-LAST:event_txtCambiarCodigoKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Lugar> cbLocalidadActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCambiarCodigo;
    private javax.swing.JTextField txtCodigoActual;
    private javax.swing.JTextField txtLocalidad;
    // End of variables declaration//GEN-END:variables
}
