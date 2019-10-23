/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configuracion;

import Controlador.CtrlCaracter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import menu.Principal;
import modelo.Caracter;

/**
 *
 * @author jesus
 */
public final class Caracter_Consulta extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    public static String nombreCaracter;
    DefaultListModel modelo = null;
    CtrlCaracter ctrlCaracter = null;
    /**
     * Creates new form Caracter_Consulta
     */
    public Caracter_Consulta() {
        modelo = new DefaultListModel();
        ctrlCaracter = new CtrlCaracter();
        
        initComponents();
        cargarListaCargo();
        btnModificar.setEnabled(false);
    }
    
    public void cargarListaCargo(){
        List<Caracter> lista = new ArrayList();
        
        lista = ctrlCaracter.cargarListaCargo();
        
            for (int i = 0; i < lista.size(); i++) {
                modelo.addElement(lista.get(i).getDetalle());
           }
        
            listaCaracter.setModel(modelo);    
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCaracter = new javax.swing.JList<>();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CARACTER ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 28, 190, 24));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 565, -1));

        listaCaracter.setToolTipText("");
        listaCaracter.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaCaracterValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaCaracter);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 370, 210));

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
        jPanel1.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 100, -1));

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
        jPanel1.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 100, -1));

        jButton1.setBackground(new java.awt.Color(38, 86, 186));
        jButton1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listaCaracterValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaCaracterValueChanged

        btnModificar.setEnabled(true);

    }//GEN-LAST:event_listaCaracterValueChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            Principal.crearCaracter();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Caracter_Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAgregarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAgregarActionPerformed(e);
        }
    }//GEN-LAST:event_btnAgregarKeyPressed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        String nombre = (String) listaCaracter.getSelectedValuesList().toString();
        nombreCaracter = nombre.substring(1, nombre.length()-1);

        this.setVisible(false);

        try {
            Principal.modificarCaracter();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Caracter_Consulta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnModificarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnModificarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnModificarActionPerformed(e);
        }
    }//GEN-LAST:event_btnModificarKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.jButton1ActionPerformed(e);
        }
    }//GEN-LAST:event_jButton1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Caracter> listaCaracter;
    // End of variables declaration//GEN-END:variables
}
