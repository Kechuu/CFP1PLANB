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
import menu.Principal;
import modelo.Lugar;


/**
 *
 * @author RociojulietaVazquez
 */
public class Calles_modificar extends javax.swing.JInternalFrame {
    CtrlLugar lugar = new CtrlLugar();
    Lugar id = new Lugar();
    Connection con = clases.Conectar.conexion();
    int modificar;
    /**
     * Creates new form modificarcalle
     */
    public Calles_modificar() throws ClassNotFoundException {
        initComponents();
        modificar = Calles_consulta.modificar;
        
        if (modificar==0) {
            cargarComboLocalidad(cbLocalidad);
            txtCambiarCalle.setText("");
            btnAceptar.setEnabled(false);
            
        }else{
            cargarComboLocalidad(cbLocalidad);
            
            for (int i = 0; i < cbLocalidad.getItemCount(); i++) {
                if (cbLocalidad.getItemAt(i).getNombre().equalsIgnoreCase(Calles_consulta.nombreLocalidad)) {
                    cbLocalidad.setSelectedIndex(i);
                }
            }
            
            //INICIO DE CARGA DE COMBO BOX BARRIO
            Lugar barrio = new Lugar();
            
            barrio = (Lugar) cbLocalidad.getSelectedItem();
            
            DefaultComboBoxModel modelo = new DefaultComboBoxModel(cargarBarrio(barrio.getIdLugar()));
            cbBarrios.setModel(modelo);
            
            for (int i = 0; i < cbBarrios.getItemCount(); i++) {
                if (cbBarrios.getItemAt(i).getNombre().equalsIgnoreCase(Calles_consulta.nombreBarrio)) {
                    cbBarrios.setSelectedIndex(i);
                }
            }
            //FIN
            
            //INICIO DE CARGA DE COMBO BOX CALLE
            Lugar calle = new Lugar();
            
            calle = (Lugar) cbBarrios.getSelectedItem();
            
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(cargarCalle(calle.getIdLugar()));
            
            cbCalles.setModel(modelo2);
            
            for (int i = 0; i < cbCalles.getItemCount(); i++) {
                if (cbCalles.getItemAt(i).getNombre().equalsIgnoreCase(Calles_consulta.idCalle)) {
                    cbCalles.setSelectedIndex(i);
                }
            }
            //FIN
            
            id = lugar.leer(Calles_consulta.idCalle, 1);
            txtCambiarCalle.setText(id.getNombre());
            txtCambiarCalle.setFocusable(true);
            
        }
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
    
    public Vector<Lugar> cargarCalle(int idLugar) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Lugar> datos = new Vector<>();
        Lugar dat = null;
        try {
            String sql = "SELECT * FROM lugar WHERE nivel=1 and de =" + idLugar;
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
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCambiarCalle = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbLocalidad = new javax.swing.JComboBox<>();
        cbBarrios = new javax.swing.JComboBox<>();
        cbCalles = new javax.swing.JComboBox<>();

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MODIFICAR CALLE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 21, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 60));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Calles actuales:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 215, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Cambiar calle:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 279, -1, -1));

        txtCambiarCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCambiarCalleKeyPressed(evt);
            }
        });
        jPanel1.add(txtCambiarCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 307, 274, -1));

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
        jPanel1.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 100, -1));

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
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 100, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setText("Barrios:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 148, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("Localidades:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 81, -1, -1));

        cbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadItemStateChanged(evt);
            }
        });
        jPanel1.add(cbLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 109, 220, -1));

        cbBarrios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBarriosItemStateChanged(evt);
            }
        });
        jPanel1.add(cbBarrios, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 176, 220, -1));

        cbCalles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCallesActionPerformed(evt);
            }
        });
        jPanel1.add(cbCalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 246, 225, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        CtrlLugar ctrlLugar = new CtrlLugar();
        Lugar lugar = new Lugar();
        if (txtCambiarCalle.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "No se pueden cargar registros vacios");
        }else{
            lugar = (Lugar) cbBarrios.getSelectedItem();
            ctrlLugar.editar(id.getIdLugar(), txtCambiarCalle.getText(), 1, lugar.getIdLugar());
            txtCambiarCalle.setText("");
            cargarComboLocalidad(cbLocalidad);
            //ACTUALIZACION DEL COMBO BARRIO
            Lugar barrio = new Lugar();
            
            barrio = (Lugar) cbLocalidad.getSelectedItem();
            
            DefaultComboBoxModel modelo = new DefaultComboBoxModel(cargarBarrio(barrio.getIdLugar()));
            cbBarrios.setModel(modelo);
            //FIN
            
            //ACTUALIZACION DEL COMBO CALLE
            Lugar calle = new Lugar();
            
            calle = (Lugar) cbBarrios.getSelectedItem();
            
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel(cargarCalle(calle.getIdLugar()));
            
            cbCalles.setModel(modelo2);
            //FIN
            
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void cbCallesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCallesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCallesActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbBarriosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBarriosItemStateChanged

        Lugar lugar2 = new Lugar();
        
        lugar2 = (Lugar) cbBarrios.getSelectedItem();
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(cargarCalle(lugar2.getIdLugar()));
        cbCalles.setModel(modelo);
        
        
    }//GEN-LAST:event_cbBarriosItemStateChanged

    private void cbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadItemStateChanged
    
        Lugar lugar1 = new Lugar();
        
        lugar1 = (Lugar) cbLocalidad.getSelectedItem();
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(cargarBarrio(lugar1.getIdLugar()));
        cbBarrios.setModel(modelo);
        
    
    }//GEN-LAST:event_cbLocalidadItemStateChanged

    private void txtCambiarCalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCambiarCalleKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAceptarActionPerformed(e);
        }
    }//GEN-LAST:event_txtCambiarCalleKeyPressed

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
    private javax.swing.JComboBox<Lugar> cbBarrios;
    private javax.swing.JComboBox<Lugar> cbCalles;
    private javax.swing.JComboBox<Lugar> cbLocalidad;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCambiarCalle;
    // End of variables declaration//GEN-END:variables
}
