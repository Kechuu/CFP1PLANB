/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazAlumno;

import Controlador.CtrlPersona;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import menu.Principal;
import modelo.Persona;

/**
 *
 * @author araa
 */
public class PanelDni extends javax.swing.JPanel {
    Persona personaObj=new Persona();
    public static int validarPersona = 0;
    char sx;
    
    /**
     * Creates new form PanelDni
     * @throws java.lang.ClassNotFoundException
     */
    public PanelDni() throws ClassNotFoundException {
        initComponents();
        this.setBounds(0, 65, 400, 210);
        btnCargar.setEnabled(false);
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
        jLabel2 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        btnCargar = new javax.swing.JButton();
        masculino = new javax.swing.JRadioButton();
        femenino = new javax.swing.JRadioButton();

        jLabel2.setBackground(new java.awt.Color(21, 13, 5));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(21, 13, 5));
        jLabel2.setText("Ingrese el DNI de la persona");

        txtDni.setToolTipText("INGRESAR SIN ESPACIOS NI PUNTOS");
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDniKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDniKeyReleased(evt);
            }
        });

        btnCargar.setText("Cargar");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        masculino.setBackground(new java.awt.Color(255, 255, 255));
        masculino.setText("Masculino");
        masculino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                masculinoMouseClicked(evt);
            }
        });
        masculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculinoActionPerformed(evt);
            }
        });

        femenino.setBackground(new java.awt.Color(255, 255, 255));
        femenino.setText("Femenino");
        femenino.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                femeninoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(masculino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(femenino)
                        .addGap(12, 12, 12)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(masculino)
                    .addComponent(femenino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(btnCargar)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyPressed

        
    }//GEN-LAST:event_txtDniKeyPressed

    private void txtDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            if (txtDni.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero de DNI");
            }else{
                btnCargar.setEnabled(true);
            }
        
        }
    }//GEN-LAST:event_txtDniKeyReleased

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        CtrlPersona ctrlPersona = new CtrlPersona();
        
        // TODO add your handling code here:
        //  <VALIDACION>
        if (masculino.isSelected()==false && femenino.isSelected()==false) {
            JOptionPane.showMessageDialog(null, "Seleccione Genero");
        }
      
        validarPersona=1;
        
        //  <DESCACTIVAR PANEL>
        this.setVisible(false);
        //Principal.desactivarPanel();
        //  </FIN DESACTIVAR PANEL>
       
        int dni = Integer.parseInt(txtDni.getText());
        boolean mas;
        if (masculino.isSelected() == true && femenino.isSelected() == false) {
            mas = true;
            sx = 'm';
        } else {
            mas = false;
            sx = 'f';
        }
        //AQUI PASO LOS DATOS NECESARIOS PARA QUE SE GENERE EL CUIL Y SE GUARDE EN cuil...
        String cuil = clases.Cuil.generar(dni, sx);
       
        try {
            ctrlPersona.buscarAlumno(cuil, validarPersona);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PanelDni.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCargarActionPerformed

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
        if (txtDni.getText().length()>=8) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
        
    }//GEN-LAST:event_txtDniKeyTyped

    private void masculinoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masculinoMouseClicked
        // TODO add your handling code here:
        if (masculino.isSelected() == true) {
            femenino.setSelected(false);
        }
    }//GEN-LAST:event_masculinoMouseClicked

    private void masculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_masculinoActionPerformed

    private void femeninoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_femeninoMouseClicked
        // TODO add your handling code here:
        if (femenino.isSelected() == true) {
            masculino.setSelected(false);
        }
    }//GEN-LAST:event_femeninoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargar;
    private javax.swing.JRadioButton femenino;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton masculino;
    private javax.swing.JTextField txtDni;
    // End of variables declaration//GEN-END:variables
}
