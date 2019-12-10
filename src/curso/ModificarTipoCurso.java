/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;


import Controlador.CtrlPeriodo;
import Controlador.CtrlTipoCurso;
import principal.Principal;
import configuracion.Periodo_modificar;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Periodo;
import modelo.TipoCurso;
/**
 *
 * @author araa
 */
public final class ModificarTipoCurso extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    public int bandera=0;
    CtrlTipoCurso ctrlTipoCurso = null;
    CtrlPeriodo ctrlPeriodo = null;
    Periodo periodo=null;
    TipoCurso tipoCurso = null;
    /**
     * Creates new form NewJInternalFrame
     */
    public ModificarTipoCurso() {
        ctrlTipoCurso = new CtrlTipoCurso();
        ctrlPeriodo = new CtrlPeriodo();
        periodo = new Periodo();
        tipoCurso = new TipoCurso();
        
        initComponents();
        bandera=1;
        ctrlTipoCurso.cargarCombo(cbxNombreCurso);
        bandera=0;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtcosto = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxPeriodo = new javax.swing.JComboBox<Periodo>();
        btnPeriodo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cbxNombreCurso = new javax.swing.JComboBox<TipoCurso>();
        jLabel2 = new javax.swing.JLabel();
        txtNombreNuevo = new javax.swing.JTextField();
        btnActualizarPlanes1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Costo del curso");

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Nombre del curso");

        txtcosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcostoActionPerformed(evt);
            }
        });

        jLabel10.setText("Periodo");

        cbxPeriodo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxPeriodoItemStateChanged(evt);
            }
        });
        cbxPeriodo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxPeriodoMouseClicked(evt);
            }
        });
        cbxPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPeriodoActionPerformed(evt);
            }
        });

        btnPeriodo.setBackground(new java.awt.Color(38, 86, 186));
        btnPeriodo.setForeground(new java.awt.Color(255, 255, 255));
        btnPeriodo.setText("Nuevo Periodo");
        btnPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPeriodoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(38, 86, 186));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
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
        btnCancelar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnCancelarKeyPressed(evt);
            }
        });

        cbxNombreCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNombreCursoItemStateChanged(evt);
            }
        });

        jLabel2.setText("Nuevo Nombre");

        btnActualizarPlanes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar(2).png"))); // NOI18N
        btnActualizarPlanes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPlanes1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(16, 16, 16)
                .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(txtNombreNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10))
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarPlanes1)
                        .addGap(15, 15, 15)
                        .addComponent(btnPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2))
                    .addComponent(txtNombreNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(cbxPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPeriodo)
                    .addComponent(btnActualizarPlanes1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(38, 86, 186));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(102, 102, 255));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modificar Curso");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 12, 320, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        bandera=1;
        tipoCurso = (TipoCurso) cbxNombreCurso.getSelectedItem();
        periodo = (Periodo) cbxPeriodo.getSelectedItem();
        ctrlTipoCurso.editar(tipoCurso.getIdTipoCurso(), txtNombreNuevo.getText(), Float.parseFloat(txtcosto.getText()), periodo.getIdPeriodo());
        cbxNombreCurso.removeAllItems();
        ctrlTipoCurso.cargarCombo(cbxNombreCurso);
        vaciarCampos();
        bandera=0;
         /*
        this.setVisible(false);
        Principal.desactivarPanel();
        
         CrearCurso curso=new CrearCurso();
        Principal.panelPrincipal.add(curso);
        curso.setVisible(true);
        */
         
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPeriodoActionPerformed
        try {
            // TODO add your handling code here:
            
            Periodo_modificar curso=new Periodo_modificar();
            Principal.principal.add(curso);
            this.setComponentZOrder(curso, 0);
            curso.setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModificarTipoCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPeriodoActionPerformed

    private void txtcostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcostoActionPerformed

    private void cbxPeriodoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxPeriodoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPeriodoMouseClicked

    private void cbxPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPeriodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPeriodoActionPerformed

    private void cbxPeriodoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxPeriodoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPeriodoItemStateChanged

    private void cbxNombreCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNombreCursoItemStateChanged
        if (cbxNombreCurso.getSelectedIndex()==0) {
            vaciarCampos();
        }else{
            if (bandera==0) {
            tipoCurso = (TipoCurso) cbxNombreCurso.getSelectedItem();
            txtNombreNuevo.setText(tipoCurso.getDetalle());
            //periodo = ctrlPeriodo.leer(Integer.parseInt(tipoCurso.getIdPeriodo().toString()));
            String nombrePeriodo = tipoCurso.getIdPeriodo().getDetalle();
            cargarPeriodo(nombrePeriodo);
            txtcosto.setText(String.valueOf(ctrlTipoCurso.leer(tipoCurso.getIdTipoCurso()).getCosto()));
        }
        }
        
    }//GEN-LAST:event_cbxNombreCursoItemStateChanged

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnGuardarActionPerformed(e);
        }
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode()==com.sun.glass.events.KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnCancelarActionPerformed(e);
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnActualizarPlanes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPlanes1ActionPerformed
        cbxPeriodo.removeAllItems();
        ctrlPeriodo.cargarCombo(cbxPeriodo);
    }//GEN-LAST:event_btnActualizarPlanes1ActionPerformed

    public void vaciarCampos(){
        txtNombreNuevo.setText("");
        txtcosto.setText("");
        cbxPeriodo.removeAllItems();
    }
    
    public void cargarPeriodo(String detalle){
        cbxPeriodo.removeAllItems();
        ctrlPeriodo.cargarCombo(cbxPeriodo);
        for (int i = 0; i < cbxPeriodo.getItemCount(); i++) {
                if (cbxPeriodo.getItemAt(i).getDetalle().equalsIgnoreCase(detalle)) {
                    cbxPeriodo.setSelectedIndex(i);
                }
            }
    }
    
    @Override
    public boolean isOptimizedDrawingEnabled(){
        return false;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizarPlanes1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPeriodo;
    private javax.swing.JComboBox<TipoCurso> cbxNombreCurso;
    private javax.swing.JComboBox<Periodo> cbxPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txtNombreNuevo;
    private javax.swing.JTextField txtcosto;
    // End of variables declaration//GEN-END:variables
//Conectar x = new Conectar();
  //   Connection con = x.conexion();
}
