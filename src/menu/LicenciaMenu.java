/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.util.logging.Level;
import java.util.logging.Logger;
import licencia.*;
/**
 *
 * @author araa
 */
public class LicenciaMenu extends javax.swing.JPanel {

    /**
     * Creates new form LicenciaMenu
     */
    public LicenciaMenu() {
        initComponents();
        this.setBounds(0, 145, 240, 138);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnArticulos = new javax.swing.JButton();
        btnAsignarProfesor = new javax.swing.JButton();
        btnConsultas = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();

        setBackground(new java.awt.Color(239, 238, 240));

        btnArticulos.setText("Ver Artículos");
        btnArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosActionPerformed(evt);
            }
        });

        btnAsignarProfesor.setText("Asignar Profesor");
        btnAsignarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarProfesorActionPerformed(evt);
            }
        });

        btnConsultas.setText("Consultar Licencia");
        btnConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultasActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar Licencia");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnAsignarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAsignarProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Principal.desactivarPanel();
        
        CrearLicencia crear = null;
        try {
            crear = new CrearLicencia();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LicenciaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.panelPrincipal.add(crear);
        crear.setVisible(true);
    }//GEN-LAST:event_btnArticulosActionPerformed

    private void btnAsignarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarProfesorActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        Principal.desactivarPanel();
        
        AsignarLicencia asignar=new AsignarLicencia();
        Principal.panelPrincipal.add(asignar);
        asignar.setVisible(true);
    }//GEN-LAST:event_btnAsignarProfesorActionPerformed

    private void btnConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Principal.desactivarPanel();
        
        Licencia_consulta art = null;
        try {
            art = new Licencia_consulta();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LicenciaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.panelPrincipal.add(art);
        art.setVisible(true);
    }//GEN-LAST:event_btnConsultasActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Principal.desactivarPanel();
        
        ModificarLicencia modificar = null;
        try {
            modificar = new ModificarLicencia();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LicenciaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.panelPrincipal.add(modificar);
        modificar.setVisible(true);
    }//GEN-LAST:event_btnModificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArticulos;
    private javax.swing.JButton btnAsignarProfesor;
    private javax.swing.JButton btnConsultas;
    private javax.swing.JButton btnModificar;
    // End of variables declaration//GEN-END:variables
}
