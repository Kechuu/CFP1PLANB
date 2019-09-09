/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import interfazAlumno.MotivoBaja;
import interfazAlumno.Modificar;
import interfazAlumno.Eliminar;
import interfazAlumno.Pago;
import interfazAlumno.ConsultaPagos;
import interfazAlumno.Inscripcion;
import interfazAlumno.PanelDni;
import java.awt.Frame;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author araa
 */
public class AlumnoMenu extends javax.swing.JPanel {

    /**
     * Creates new form AlumnoMenu
     */
    public static int pagoAlumno;
    public AlumnoMenu() throws ClassNotFoundException {
        initComponents();
        
        this.setBounds(0, 65, 240, 210);
        this.setVisible(true);
        JOptionPane.showMessageDialog(null, "constructor ALUMNO MENU");
        //menu.Principal.menuAlumno=1;
        
        PanelDni dni = new PanelDni();
        if (dni.validarPersona== 2) {
            btnInscribir.setEnabled(false);
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

        btnInscribir = new javax.swing.JButton();
        btnModificarDatos = new javax.swing.JButton();
        btnBajaAlumno = new javax.swing.JButton();
        btnMotivoBaja = new javax.swing.JButton();
        btnPagos = new javax.swing.JButton();
        btnConsultarEstado = new javax.swing.JButton();
        btnConsultarPagos = new javax.swing.JButton();

        setBackground(new java.awt.Color(239, 238, 240));

        btnInscribir.setText("Inscribir ");
        btnInscribir.setMaximumSize(new java.awt.Dimension(72, 29));
        btnInscribir.setMinimumSize(new java.awt.Dimension(72, 29));
        btnInscribir.setPreferredSize(new java.awt.Dimension(72, 29));
        btnInscribir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirActionPerformed(evt);
            }
        });

        btnModificarDatos.setText("Modificar");
        btnModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDatosActionPerformed(evt);
            }
        });

        btnBajaAlumno.setText("Dar de baja");
        btnBajaAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaAlumnoActionPerformed(evt);
            }
        });

        btnMotivoBaja.setText("Motivos de baja");
        btnMotivoBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMotivoBajaActionPerformed(evt);
            }
        });

        btnPagos.setText("Efectuar pago");
        btnPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagosActionPerformed(evt);
            }
        });

        btnConsultarEstado.setText("Consultar estado");
        btnConsultarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarEstadoActionPerformed(evt);
            }
        });

        btnConsultarPagos.setText("Consultar pago");
        btnConsultarPagos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarPagosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnModificarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnBajaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnMotivoBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnConsultarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnConsultarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnInscribir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnModificarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBajaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMotivoBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultarPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInscribirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        Principal.desactivarPanel();
        pagoAlumno=0;
        
        Inscripcion insc = null;
        try {
            insc = new Inscripcion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Principal.panelPrincipal.add(insc);
        insc.setVisible(true);
    }//GEN-LAST:event_btnInscribirActionPerformed

    private void btnModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDatosActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        Principal.desactivarPanel();
        
        Modificar modificar=new Modificar();
        Principal.panelPrincipal.add(modificar);
        modificar.setVisible(true);
    }//GEN-LAST:event_btnModificarDatosActionPerformed

    private void btnBajaAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaAlumnoActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Principal.desactivarPanel();
        menu.Principal.menuAlumno=1;
        
        Eliminar baja= new Eliminar();
        Principal.panelPrincipal.add(baja);
        baja.setVisible(true);
    }//GEN-LAST:event_btnBajaAlumnoActionPerformed

    private void btnMotivoBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMotivoBajaActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Principal.desactivarPanel();
        menu.Principal.menuAlumno=0;
        
        MotivoBaja mb=new MotivoBaja();
        Principal.panelPrincipal.add(mb);
        mb.setVisible(true);
    }//GEN-LAST:event_btnMotivoBajaActionPerformed

    private void btnPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagosActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        Principal.desactivarPanel();
        pagoAlumno=1;
        
        Frame f= JOptionPane.getFrameForComponent(Principal.panelPrincipal);
        
        Frame e= JOptionPane.getRootFrame();
        
        Pago dial=new Pago(f, true);
        
        dial.setVisible(true);
    }//GEN-LAST:event_btnPagosActionPerformed

    private void btnConsultarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarEstadoActionPerformed

    private void btnConsultarPagosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPagosActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        Principal.desactivarPanel();
        
        ConsultaPagos consul=new ConsultaPagos();
        Principal.panelPrincipal.add(consul);
        consul.setVisible(true);
    }//GEN-LAST:event_btnConsultarPagosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBajaAlumno;
    private javax.swing.JButton btnConsultarEstado;
    private javax.swing.JButton btnConsultarPagos;
    private javax.swing.JButton btnInscribir;
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JButton btnMotivoBaja;
    private javax.swing.JButton btnPagos;
    // End of variables declaration//GEN-END:variables
}
