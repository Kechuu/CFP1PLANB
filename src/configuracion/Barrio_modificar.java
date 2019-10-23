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
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import menu.Principal;
import modelo.Lugar;


/**
 *
 * @author RociojulietaVazquez
 */
public final class Barrio_modificar extends javax.swing.JInternalFrame {
    CtrlLugar ctrlLugar;
    Lugar id,lugar;
    Connection con = clases.Conectar.conexion();
    int modificar;
    /**
     * Creates new form modificarbarrio
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public Barrio_modificar() throws ClassNotFoundException, SQLException {
        ctrlLugar=new CtrlLugar();
        lugar=new Lugar();
        id=new Lugar();
        
        initComponents();
        
        
        modificar = Barrio_consulta.modificar;
        
        if (modificar == 0) {

            ctrlLugar.cargarComboLocalidad(cbLocalidad);
            txtNuevoBarrio.setEnabled(false);
            btnAceptar.setEnabled(false);

        }else{
            ctrlLugar.cargarComboLocalidad(cbLocalidad);
            
            for (int i = 0; i < cbLocalidad.getItemCount(); i++) {
                if (cbLocalidad.getItemAt(i).getNombre().equalsIgnoreCase(Barrio_consulta.nombreLocalidad)) {
                    cbLocalidad.setSelectedIndex(i);
                }
            }
            //INICIO DE CARGA DE COMBO BOX
            
            lugar = (Lugar) cbLocalidad.getSelectedItem();
        
            DefaultComboBoxModel modelo = new DefaultComboBoxModel(ctrlLugar.cargarFiltrado(lugar.getIdLugar(),2));
            cbBarriosActuales.setModel(modelo);
            //JOptionPane.showMessageDialog(null, "hola");
            for (int i = 0; i < cbBarriosActuales.getItemCount(); i++) {
                if (cbBarriosActuales.getItemAt(i).getNombre().equalsIgnoreCase(Barrio_consulta.nombreBarrio)) {
                    cbBarriosActuales.setSelectedIndex(i);
                }
            }
            //FIN
            String barrio = (String) Barrio_consulta.nombreBarrio;
            id = ctrlLugar.leer(barrio, 2);
            txtNuevoBarrio.setText(id.getNombre());
            txtNuevoBarrio.setFocusable(true);
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
        txtNuevoBarrio = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbLocalidad = new javax.swing.JComboBox<>();
        cbBarriosActuales = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFICAR BARRIO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 60));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Barrio actuales:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 154, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Nuevo barrio:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 233, -1, -1));

        txtNuevoBarrio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNuevoBarrioKeyPressed(evt);
            }
        });
        jPanel1.add(txtNuevoBarrio, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 261, 274, -1));

        btnAceptar.setBackground(new java.awt.Color(38, 86, 186));
        btnAceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        btnAceptar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAceptarKeyPressed(evt);
            }
        });
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 100, -1));

        btnCancelar.setBackground(new java.awt.Color(38, 86, 186));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setText("Localidad:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 75, -1, -1));

        cbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadItemStateChanged(evt);
            }
        });
        jPanel1.add(cbLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, 202, 26));

        jPanel1.add(cbBarriosActuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 188, 248, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtNuevoBarrio.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar registros vacios");
        }else{
            
        lugar = (Lugar) cbLocalidad.getSelectedItem();
        ctrlLugar.editar(id.getIdLugar(), txtNuevoBarrio.getText(), 2, lugar.getIdLugar());
        txtNuevoBarrio.setText("");
        
        //ACTUALIZACION DE COMBO BARRIO
            lugar = (Lugar) cbLocalidad.getSelectedItem();
        
            DefaultComboBoxModel modelo = new DefaultComboBoxModel(ctrlLugar.cargarFiltrado(lugar.getIdLugar(),2));
            cbBarriosActuales.setModel(modelo);
            //FIN
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadItemStateChanged
        lugar = (Lugar) cbLocalidad.getSelectedItem();
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(ctrlLugar.cargarFiltrado(lugar.getIdLugar(),2));
        cbBarriosActuales.setModel(modelo);
    }//GEN-LAST:event_cbLocalidadItemStateChanged

    private void txtNuevoBarrioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoBarrioKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAceptarActionPerformed(e);
        }
    }//GEN-LAST:event_txtNuevoBarrioKeyPressed

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAceptarActionPerformed(e);
        }
    }//GEN-LAST:event_btnAceptarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnCancelarActionPerformed(e);
        }
    }//GEN-LAST:event_btnCancelarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox<Lugar> cbBarriosActuales;
    private javax.swing.JComboBox<Lugar> cbLocalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtNuevoBarrio;
    // End of variables declaration//GEN-END:variables
}
