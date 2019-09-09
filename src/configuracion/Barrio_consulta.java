/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import menu.Principal;
import modelo.Lugar;


/**
 *
 * @author RociojulietaVazquez
 */
public class Barrio_consulta extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    
    public static String idBarrio;
    public static String nombreLocalidad = "";
    public static int modificar = 0;
    /**
     * Creates new form barrio
     */
    public Barrio_consulta() throws SQLException, ClassNotFoundException {
        initComponents();
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
        cargarComboLocalidad(cbLocalidad);
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
    
        public void cargarListaBarrios(int idLugar){
        DefaultListModel<Lugar> modelo = new DefaultListModel<>();
        
        try {
            Statement st=(Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM lugar WHERE nivel = 2 AND de = '"+ idLugar +"'ORDER BY nombre ASC");
            
            while (rs.next()) {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
                
                modelo.addElement(lugar);
            }
            
            listaBarrios.setModel(modelo);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaBarrios = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAtras = new javax.swing.JButton();
        cbLocalidad = new javax.swing.JComboBox<>();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setBackground(new java.awt.Color(38, 86, 186));
        btnEliminar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 100, -1));

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BARRIOS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 24, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, -1));

        btnModificar.setBackground(new java.awt.Color(38, 86, 186));
        btnModificar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 240, 100, -1));

        btnAgregar.setBackground(new java.awt.Color(38, 86, 186));
        btnAgregar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 180, 100, -1));

        listaBarrios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaBarriosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaBarrios);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 192, 370, 140));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Localidad");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 91, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Barrios");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 164, -1, -1));

        btnAtras.setBackground(new java.awt.Color(38, 86, 186));
        btnAtras.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnAtras, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        cbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadItemStateChanged(evt);
            }
        });
        cbLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLocalidadActionPerformed(evt);
            }
        });
        jPanel1.add(cbLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 230, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();//Activa los paneles donde estan los menus... Alumno, Curso.. Listado..
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            Principal.crearBarrio();//Llama al frame de Crear barrio
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Barrio_consulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Barrio_consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        Lugar lugarModificar = new Lugar();
        
        lugarModificar = listaBarrios.getSelectedValue();
        
        idBarrio = lugarModificar.getNombre();
        nombreLocalidad = cbLocalidad.getSelectedItem().toString();
        modificar = 1;
        
        
        this.setVisible(false);
        
        try {
            Principal.modificarBarrio();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Barrio_consulta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Barrio_consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void cbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadItemStateChanged
        Lugar lugar = new Lugar();
        
        lugar = (Lugar) cbLocalidad.getSelectedItem();
        
        
        cargarListaBarrios(lugar.getIdLugar());
        
    }//GEN-LAST:event_cbLocalidadItemStateChanged

    private void cbLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLocalidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLocalidadActionPerformed

    private void listaBarriosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaBarriosValueChanged
        
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
        
    }//GEN-LAST:event_listaBarriosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<Lugar> cbLocalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Lugar> listaBarrios;
    // End of variables declaration//GEN-END:variables
}
