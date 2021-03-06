/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import Controlador.CtrlLugar;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import principal.Principal;
import modelo.Lugar;


/**
 *
 * @author RociojulietaVazquez
 */
public final class Calles_consulta extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    public static String nombreCalle="";
    public static String nombreBarrio="";
    public static String nombreLocalidad="";
    public static int modificar = 0;
    DefaultListModel modelo =null;
    CtrlLugar ctrlLugar = null;
    Lugar lugar = null, lugar1 =null;
    /**
     * Creates new form calles
     * @throws java.lang.ClassNotFoundException
     */
    public Calles_consulta() throws ClassNotFoundException {
        modelo = new DefaultListModel();
        ctrlLugar = new CtrlLugar();
        lugar = new Lugar();
        lugar1 = new Lugar();
        
        initComponents();
        btnModificar.setEnabled(true);
        ctrlLugar.cargarComboLocalidad(cbLocalidad);
    }
    
    
    public void cargarListaCalles(){
        
        if (cbBarrio.getSelectedIndex() != 0) {
            List<Lugar> lista = new ArrayList();
            lugar = (Lugar) cbBarrio.getSelectedItem();

            lista = ctrlLugar.cargarListaCalles(lugar.getIdLugar());

            for (int i = 0; i < lista.size(); i++) {
                modelo.addElement(lista.get(i).getNombre());
            }

            listaCalle.setModel(modelo);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        cbLocalidad = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbBarrio = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCalle = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnAtras = new javax.swing.JButton();

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadItemStateChanged(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CALLES");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 23, -1, -1));

        cbBarrio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBarrioItemStateChanged(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Localidad");

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Barrio");

        listaCalle.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCalleValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaCalle);

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Calles");

        btnAgregar.setBackground(new java.awt.Color(38, 86, 186));
        btnAgregar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        btnAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAgregarKeyPressed(evt);
            }
        });

        btnModificar.setBackground(new java.awt.Color(38, 86, 186));
        btnModificar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnModificar.setForeground(new java.awt.Color(255, 255, 255));
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        btnModificar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnModificarKeyPressed(evt);
            }
        });

        btnAtras.setBackground(new java.awt.Color(38, 86, 186));
        btnAtras.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnAtras.setForeground(new java.awt.Color(255, 255, 255));
        btnAtras.setText("Atras");
        btnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtrasActionPerformed(evt);
            }
        });
        btnAtras.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnAtrasKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtras)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnAgregar)
                        .addGap(31, 31, 31)
                        .addComponent(btnModificar)))
                .addGap(30, 30, 30)
                .addComponent(btnAtras))
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

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        //this.setVisible(false);
//            Principal.crearCalle();
        try{
            Calles_crear cr=new Calles_crear();
            Principal.principal.add(cr);
            cr.setVisible(true);
            cr.toFront();
        }catch(ClassNotFoundException e){
            
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        lugar = (Lugar) cbLocalidad.getSelectedItem();
        lugar1 = (Lugar) cbBarrio.getSelectedItem();
        
        modificar=1;
        String nombre = (String) listaCalle.getSelectedValuesList().toString();
        nombreLocalidad = lugar.getNombre();
        nombreBarrio = lugar1.getNombre();
        nombreCalle = nombre.substring(1, nombre.length()-1);
        
        //this.setVisible(false);
        //    Principal.modificarCalle();
        try{
            Calles_modificar md=new Calles_modificar();
            Principal.principal.add(md);
            md.setVisible(true);
            md.toFront();
        }catch(ClassNotFoundException e){
            
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtrasActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnAtrasActionPerformed

    private void cbBarrioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBarrioItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            modelo.clear();
            cargarListaCalles();
        }
    }//GEN-LAST:event_cbBarrioItemStateChanged

    private void cbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadItemStateChanged
        
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (cbLocalidad.getSelectedIndex() != 0) {
                
                lugar = (Lugar) cbLocalidad.getSelectedItem();
                DefaultComboBoxModel modelo1 = new DefaultComboBoxModel(ctrlLugar.cargarFiltrado(lugar.getIdLugar(), 2));

                cbBarrio.setModel(modelo1);
            }
        }
    }//GEN-LAST:event_cbLocalidadItemStateChanged

    private void listaCalleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCalleValueChanged
        
        btnModificar.setEnabled(true);
        
    }//GEN-LAST:event_listaCalleValueChanged

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAgregarActionPerformed(e);
        }
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnModificarActionPerformed(e);
        }
    }//GEN-LAST:event_btnModificarKeyPressed

    private void btnAtrasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAtrasKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAtrasActionPerformed(e);
        }
    }//GEN-LAST:event_btnAtrasKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAtras;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<Lugar> cbBarrio;
    private javax.swing.JComboBox<Lugar> cbLocalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Lugar> listaCalle;
    // End of variables declaration//GEN-END:variables
}
