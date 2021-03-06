/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazEmpleado;

import Controlador.CtrlCaracter;
import Controlador.CtrlCargo;
import Controlador.CtrlCurso;
import Controlador.CtrlCursoHora;
import Controlador.CtrlCursoProfesor;
import Controlador.CtrlEmpleado;
import Controlador.CtrlPersona;
import interfazAlumno.Inscripcion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import principal.Principal;
import modelo.Caracter;
import modelo.Cargo;
import modelo.Curso;
import modelo.Empleado;
import modelo.Persona;
import modelo.TipoCurso;

/**
 *
 * @author AGUSTINA
 */
public class AsignarCursoAcargo extends javax.swing.JInternalFrame {

    CtrlCursoProfesor ctrlCursoP=new CtrlCursoProfesor();
    CtrlCurso ctrlCurso=new CtrlCurso();
    CtrlPersona ctrlPersona=new CtrlPersona();
    CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
    CtrlCargo ctrlCargo=new CtrlCargo();
    CtrlCaracter ctrlCaracter=new CtrlCaracter();
    
    DefaultListModel<TipoCurso> modeloCursos;
    DefaultListModel<TipoCurso> modeloDisponible;
    
    Cargo cargo=new Cargo();
    Persona persona=new Persona();
    Empleado empleadoObj=new Empleado();
    /**
     * Creates new form AsignarCurso
     */
    public AsignarCursoAcargo(){
    }

    public AsignarCursoAcargo(Persona persona){
        initComponents();
        
        this.persona=persona;
        ctrlCaracter.cargarCombo(cbCaracter);
        
        cargar();
    }
    
    void cargar(){
        empleadoObj=ctrlEmpleado.leer(persona.getIdPersona());
        
        txtNombreCompleto.setText(persona.getApellidoPersona()+" "+persona.getNombrePersona());
        ctrlCargo.cargoEmpleado(empleadoObj.getIdEmpleado(), cbCargo);
        
        
        ctrlCurso.llenarLista(listDisponible);//se carga la lista con los cursos disponibles
        ctrlCursoP.llenarLista(empleadoObj.getIdEmpleado(), listCursosActuales);//SON LOS CURSOS QUE EL EMPLEADO YA TIENE A CARGO
        
        modeloCursos=new DefaultListModel();
        listCursos.setModel(modeloCursos);//CURSOS A LOS QUE SE INSCRIBIRAN
        
        modeloDisponible=(DefaultListModel<TipoCurso>) listDisponible.getModel();        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelCompleto = new javax.swing.JPanel();
        btnInscribirCursos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listDisponible = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        listCursos = new javax.swing.JList<>();
        btnCursoAsignar = new javax.swing.JButton();
        btnCursoDeshacer = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listCursosActuales = new javax.swing.JList<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombreCompleto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbCargo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbCaracter = new javax.swing.JComboBox<>();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        jMenu2.setText("jMenu2");

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText("jCheckBoxMenuItem2");

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asignacion de Cursos a cargo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCompleto.setBackground(new java.awt.Color(255, 255, 255));

        btnInscribirCursos.setBackground(new java.awt.Color(38, 86, 186));
        btnInscribirCursos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInscribirCursos.setForeground(new java.awt.Color(255, 255, 255));
        btnInscribirCursos.setText("Inscribir a curso/s");
        btnInscribirCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInscribirCursosActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(38, 86, 186));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Cursos disponibles");

        listDisponible.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listDisponibleKeyPressed(evt);
            }
        });
        listDisponible.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDisponibleValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(listDisponible);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Cursos a asignar");

        listCursos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listCursosKeyPressed(evt);
            }
        });
        listCursos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listCursosValueChanged(evt);
            }
        });
        jScrollPane8.setViewportView(listCursos);

        btnCursoAsignar.setBackground(new java.awt.Color(38, 86, 186));
        btnCursoAsignar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCursoAsignar.setForeground(new java.awt.Color(255, 255, 255));
        btnCursoAsignar.setText(">");
        btnCursoAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoAsignarActionPerformed(evt);
            }
        });

        btnCursoDeshacer.setBackground(new java.awt.Color(38, 86, 186));
        btnCursoDeshacer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCursoDeshacer.setForeground(new java.awt.Color(255, 255, 255));
        btnCursoDeshacer.setText("<");
        btnCursoDeshacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoDeshacerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCursoAsignar, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(btnCursoDeshacer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnCursoAsignar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCursoDeshacer)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jScrollPane6.setViewportView(listCursosActuales);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Cursos inscriptos");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Nombre:");

        txtNombreCompleto.setEditable(false);
        txtNombreCompleto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Cargo");

        cbCargo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Caracter");

        cbCaracter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbCaracter, 0, 199, Short.MAX_VALUE)
                            .addComponent(cbCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbCaracter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombreCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelCompletoLayout = new javax.swing.GroupLayout(panelCompleto);
        panelCompleto.setLayout(panelCompletoLayout);
        panelCompletoLayout.setHorizontalGroup(
            panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletoLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCompletoLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInscribirCursos, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        panelCompletoLayout.setVerticalGroup(
            panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCompletoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(panelCompletoLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(btnInscribirCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCursoAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoAsignarActionPerformed
        // TODO add your handling code here:

        if(listDisponible.getSelectedIndex()!= -1){
            modeloCursos.addElement((TipoCurso)listDisponible.getSelectedValue());

            modeloDisponible.remove(listDisponible.getSelectedIndex());

            btnCursoDeshacer.setEnabled(true);

        }

        if(modeloDisponible.isEmpty()){
            btnCursoAsignar.setEnabled(false);
        }
    }//GEN-LAST:event_btnCursoAsignarActionPerformed

    private void btnCursoDeshacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoDeshacerActionPerformed
        // TODO add your handling code here:
        if(listCursos.getSelectedIndex()!= -1){
            modeloDisponible.addElement((TipoCurso)listCursosActuales.getSelectedValue());
            modeloCursos.remove(listCursos.getSelectedIndex());

            btnCursoAsignar.setEnabled(true);
        }

        if(modeloCursos.isEmpty()){
            btnCursoDeshacer.setEnabled(false);
        }
    }//GEN-LAST:event_btnCursoDeshacerActionPerformed

    private void listDisponibleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponibleKeyPressed

    }//GEN-LAST:event_listDisponibleKeyPressed

    private void listDisponibleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDisponibleValueChanged

        if(listDisponible.getSelectedIndex()!= -1){
            btnCursoAsignar.setEnabled(true);

            //listDetalle.setModel(detalleCurso(listDisponible));

        }
    }//GEN-LAST:event_listDisponibleValueChanged

    private void btnInscribirCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirCursosActionPerformed
       // TODO add your handling code here:
        
        ListModel<TipoCurso> listaCurso=listCursos.getModel();
        
        if(modeloCursos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No a elegido ningún curso para asignar");
        }else{    
            if(cbCargo.getSelectedIndex()==0 || cbCaracter.getSelectedIndex()==0){
                JOptionPane.showMessageDialog(null, "No ha seleccionado el cargo y/o caracter del empleado");
            }else{
                for (int i = 0; i < listaCurso.getSize(); i++) {
                    Caracter item = null;
                    item = (Caracter) cbCaracter.getSelectedItem();

                    ctrlCursoP.crear(ctrlCurso.leer(listaCurso.getElementAt(i).getIdTipoCurso()).getIdCurso(), empleadoObj.getIdEmpleado(), item.getIdCaracter());
                }                
            }
        }
    }//GEN-LAST:event_btnInscribirCursosActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        switch(Registro.banderaEmpleado){
            case 1:
                dispose();
            break;
            
            case 2:
                dispose();
            break;
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void listCursosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listCursosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_listCursosKeyPressed

    private void listCursosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCursosValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listCursosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCursoAsignar;
    private javax.swing.JButton btnCursoDeshacer;
    private javax.swing.JButton btnInscribirCursos;
    private javax.swing.JComboBox<Caracter> cbCaracter;
    private javax.swing.JComboBox<Cargo> cbCargo;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<TipoCurso> listCursos;
    private javax.swing.JList<TipoCurso> listCursosActuales;
    private javax.swing.JList<TipoCurso> listDisponible;
    private javax.swing.JPanel panelCompleto;
    private javax.swing.JTextField txtNombreCompleto;
    // End of variables declaration//GEN-END:variables
}
