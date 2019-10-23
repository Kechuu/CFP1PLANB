/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazAlumno;

import Controlador.CtrlAlumno;
import Controlador.CtrlCurso;
import Controlador.CtrlCursoAlumno;
import Controlador.CtrlMotivoBaja;
import Controlador.CtrlPersona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import menu.Principal;
import modelo.MotivoBaja;
import modelo.Persona;
import modelo.TipoCurso;

/**
 *
 * @author Nero
 */
public class DarBajaCurso1 extends javax.swing.JInternalFrame {

    CtrlCurso ctrlCurso=new CtrlCurso();
    CtrlCursoAlumno ctrlCursoAlum= new CtrlCursoAlumno();
    CtrlAlumno ctrlAlumno=new CtrlAlumno();
    CtrlPersona ctrlPersona=new CtrlPersona();
    Persona personaModelo=new Persona();
    CtrlMotivoBaja ctrlMotivo=new CtrlMotivoBaja();
    
    java.util.Date date=new Date();
    /**
     * Creates new form Eliminar
     */
    public DarBajaCurso1() {
        initComponents();
        fecha.setDate(date);
        ctrlMotivo.cargarCombo(cbMotivoBaja);
        
        ctrlAlumno.cargarListaAlumno(listaAlumnos);
    }
    
    public DarBajaCurso1(Persona persona){
        initComponents();
        
        //btnDarBaja.setEnabled(false);
        personaModelo=persona;
        
        //txtNombre.setText(personaModelo.getApellidoPersona()+" "+personaModelo.getNombrePersona());
        obtenerDni();
        
        ctrlCursoAlum.llenarLista(ctrlAlumno.leer(persona.getIdPersona()).getIdAlumno(), listCursosInscriptos);
        
        fecha.setDate(date);
       
        ctrlMotivo.cargarCombo(cbMotivoBaja);
    }
    
    final void obtenerDni(){
        String dni=personaModelo.getCUIL().substring(3, 11);
        //txtDni.setText(dni);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        listCursosInscriptos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAlumnos = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnDarBaja = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        cbMotivoBaja = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDetalle = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dar de baja");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(48, 48, 48))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnCancelar.setBackground(new java.awt.Color(38, 86, 186));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jScrollPane3.setViewportView(listCursosInscriptos);

        listaAlumnos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAlumnosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaAlumnos);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Alumnos");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setText("Cursos inscriptos");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel15)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnDarBaja.setBackground(new java.awt.Color(38, 86, 186));
        btnDarBaja.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDarBaja.setForeground(new java.awt.Color(255, 255, 255));
        btnDarBaja.setText("Dar de baja");
        btnDarBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDarBajaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha del día:");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        cbMotivoBaja.setToolTipText("");
        cbMotivoBaja.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMotivoBajaItemStateChanged(evt);
            }
        });

        txtDetalle.setColumns(20);
        txtDetalle.setRows(5);
        txtDetalle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDetalleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDetalleFocusLost(evt);
            }
        });
        txtDetalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDetalleKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDetalle);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Otro motivo:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Motivo de baja:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbMotivoBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbMotivoBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(46, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDarBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 12, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        //JOptionPane.showMessageDialog(null, listCursos.getSelectedIndices());
            Principal.activarPanel();
            dispose();    
        
    }//GEN-LAST:event_btnCancelarActionPerformed


    @Override
    public boolean isOptimizedDrawingEnabled(){
        return false;
    }
    
    private void btnDarBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDarBajaActionPerformed
        // TODO add your handling code here:
        //ListModel<TipoCurso>modelo=listCursos.getModel();
    //CAPTURA EL ITEM QUE SE HAYA SELECCIONADO DE LA LISTA..
        int idCurso=ctrlCurso.leer(listCursosInscriptos.getSelectedValue().getIdTipoCurso()).getIdCurso();
        
        
        if(cbMotivoBaja.getSelectedIndex()!=0 && txtDetalle.getText().equals("")){
            MotivoBaja itemMotivo=(MotivoBaja) cbMotivoBaja.getSelectedItem();
            ctrlCursoAlum.alumnoBajaEgresado(listaAlumnos.getSelectedValue().getIdPersona(), idCurso, itemMotivo.getIdMotivoBaja(), 2, fecha.getDate());
        }else if (cbMotivoBaja.getSelectedIndex()==0 || cbMotivoBaja.getSelectedIndex()== -1 && !txtDetalle.getText().equals("")){
            ctrlMotivo.crear(txtDetalle.getText());
            
            ctrlCursoAlum.alumnoBajaEgresado(listaAlumnos.getSelectedValue().getIdPersona(), idCurso, ctrlMotivo.leer().getIdMotivoBaja(), 2, fecha.getDate());
        }else{
            JOptionPane.showMessageDialog(null, "Necesita seleccionar un motivo de baja. /nSi no lo encuentra entre las opciones a elegir puede ingresarlo");
        }
        
    }//GEN-LAST:event_btnDarBajaActionPerformed

    private void cbMotivoBajaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMotivoBajaItemStateChanged
        // TODO add your handling code here:
        if(cbMotivoBaja.getSelectedIndex()!=0){
            txtDetalle.setEnabled(false);
        }else{
            txtDetalle.setEnabled(true);
        }
    }//GEN-LAST:event_cbMotivoBajaItemStateChanged

    private void txtDetalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDetalleKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtDetalleKeyPressed

    private void txtDetalleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDetalleFocusGained
        // TODO add your handling code here:
        cbMotivoBaja.setEnabled(false);
    }//GEN-LAST:event_txtDetalleFocusGained

    private void txtDetalleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDetalleFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDetalleFocusLost

    private void listaAlumnosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAlumnosValueChanged
        // TODO add your handling code here:
        if(listaAlumnos.getSelectedIndex()!= -1){
            ctrlCursoAlum.llenarLista(listaAlumnos.getSelectedValue().getIdPersona(), listCursosInscriptos);
        }
        //        listaAlumnos.clearSelection();
        
    }//GEN-LAST:event_listaAlumnosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDarBaja;
    private javax.swing.JComboBox<MotivoBaja> cbMotivoBaja;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<TipoCurso> listCursosInscriptos;
    private javax.swing.JList<Persona> listaAlumnos;
    private javax.swing.JTextArea txtDetalle;
    // End of variables declaration//GEN-END:variables
}