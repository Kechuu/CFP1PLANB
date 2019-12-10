/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licencia;

import Controlador.CtrlCaracter;
import Controlador.CtrlCurso;
import Controlador.CtrlCursoProfesor;
import Controlador.CtrlEmpleado;
import Controlador.CtrlEmpleadoLicencia;
import Controlador.CtrlLicencia;
import Controlador.CtrlTipoCurso;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import principal.Principal;
import modelo.Empleado;
import modelo.Licencia;
import modelo.Persona;
import modelo.Caracter;
import modelo.Curso;
import modelo.CursoProfesor;
import modelo.TipoCurso;
/**
 *
 * @author RociojulietaVazquez
 */
public final class AsignarLicencia extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    public int bandera=0;
    CtrlLicencia ctrlLicencia = null;
    Licencia licencia = null;
    DefaultListModel modelo = null,modelo1=null;
    Persona persona = null;
    Empleado empleado=null;
    Date fechaInicio1=null;
    Date fechaFinalizacion1=null;
    CtrlEmpleado ctrlEmpleado=null;
    CtrlEmpleadoLicencia ctrlEmpleadoLicencia=null;
    CtrlTipoCurso ctrlTipoCurso =null;
    CtrlCurso ctrlCurso=null;
    TipoCurso tipoCurso=null,tipoCurso1;
    Curso curso = null;
    CtrlCursoProfesor ctrlCursoProfesor=null;
    CursoProfesor cursoProfesor=null;
    Caracter caracter=null;
    /**
     * Creates new form asignarLicencia
     */
    public AsignarLicencia() {
        ctrlLicencia = new CtrlLicencia();
        licencia = new Licencia();
        persona = new Persona();
        empleado = new Empleado();
        fechaInicio1=new Date();
        fechaFinalizacion1=new Date();
        ctrlEmpleado=new CtrlEmpleado();
        ctrlEmpleadoLicencia=new CtrlEmpleadoLicencia();
        ctrlTipoCurso=new CtrlTipoCurso();
        ctrlCurso = new CtrlCurso();
        tipoCurso = new TipoCurso();
        tipoCurso1=new TipoCurso();
        curso = new Curso();
        ctrlCursoProfesor =new CtrlCursoProfesor();
        modelo = new DefaultListModel();
        modelo1=new DefaultListModel();
        cursoProfesor = new CursoProfesor();
        caracter =new Caracter();
        
        initComponents();
        bandera=1;
        //ctrlLicencia.cargarCombo(cbxLicencia);
        ctrlLicencia.cargarComboEmpleado(cbxEmpleado);
        bandera=0;
        listaCursosaTomar.setModel(modelo1);
    }
    
    public void cargarListaCursoProfesor(int idEmpleado,int idCaracter){
        List<CursoProfesor>lista = new ArrayList();
        
        lista = ctrlCursoProfesor.cargarListaCursoProfesor(idEmpleado,idCaracter);
        
        for (int i = 0; i < lista.size(); i++) {
            modelo.addElement(lista.get(i).getIdCurso().getIdTipoCurso().getDetalle());
        }
        listaCursosaCargo.setModel(modelo);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxEmpleado = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        fechaFinalizacion = new com.toedter.calendar.JDateChooser();
        btnAceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaDetalle = new javax.swing.JTextArea();
        cbxLicencia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaCursosaTomar = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaCursosaCargo = new javax.swing.JList<>();
        btnAsignar = new javax.swing.JButton();
        btnDesAsignar = new javax.swing.JButton();
        cbCaracter = new javax.swing.JComboBox<>();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Caracter:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("INICIO:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("FIN:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setText("Profesor:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        cbxEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpleadoActionPerformed(evt);
            }
        });
        jPanel2.add(cbxEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 211, -1));

        jPanel1.setBackground(new java.awt.Color(38, 86, 186));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ASIGNAR LICENCIA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(649, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 1, 930, 50));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel7.setText("Detalle:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 200, -1, -1));
        jPanel2.add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, -1));
        jPanel2.add(fechaFinalizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, -1, -1));

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
        jPanel2.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 320, 100, -1));

        jButton2.setBackground(new java.awt.Color(38, 86, 186));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 320, 100, -1));

        areaDetalle.setColumns(20);
        areaDetalle.setRows(5);
        jScrollPane1.setViewportView(areaDetalle);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 210, 224, 79));

        cbxLicencia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLicenciaItemStateChanged(evt);
            }
        });
        jPanel2.add(cbxLicencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 220, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("Articulo:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        listaCursosaTomar.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "A tomar licencia", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane2.setViewportView(listaCursosaTomar);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 200, 170));

        listaCursosaCargo.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cursos a Cargo", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jScrollPane3.setViewportView(listaCursosaCargo);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 220, 170));

        btnAsignar.setText(">>");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, -1, -1));

        btnDesAsignar.setText("<<");
        btnDesAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDesAsignarActionPerformed(evt);
            }
        });
        jPanel2.add(btnDesAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, -1, -1));

        cbCaracter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCaracterActionPerformed(evt);
            }
        });
        jPanel2.add(cbCaracter, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 80, 220, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        bandera=1;
        if (cbxEmpleado.getSelectedIndex() != 0) {

            persona = (Persona) cbxEmpleado.getSelectedItem();
            empleado = ctrlEmpleado.leer(persona.getIdPersona());
            if (cbxLicencia.getSelectedIndex() != -1 && cbxLicencia.getSelectedIndex()!= 0) {
                String articulo = (String) cbxLicencia.getSelectedItem();
                licencia = (Licencia) ctrlLicencia.leer(Integer.parseInt(articulo));

                if (cbxLicencia.getSelectedIndex() == 0 || cbxEmpleado.getSelectedIndex() == 0
                        || fechaInicio.getDate()==null
                        || fechaFinalizacion.getDate()==null || modelo1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Haga la carga correspondiente para poder guardar registros");
                } else {

                    fechaInicio1 = fechaInicio.getDate();
                    fechaFinalizacion1 = fechaFinalizacion.getDate();
                    long i = fechaInicio1.getTime();
                    long f = fechaFinalizacion1.getTime();
                    java.sql.Date fecha1 = new java.sql.Date(i);
                    java.sql.Date fecha2 = new java.sql.Date(f);

                    for (int j = 0; j < modelo1.size(); j++) {
                        tipoCurso = ctrlTipoCurso.leer(modelo1.get(j).toString());
                        curso = ctrlCurso.leer(tipoCurso.getIdTipoCurso());
                        ctrlEmpleadoLicencia.crear(fecha1, fecha2, empleado.getIdEmpleado(), licencia.getIdLicencia(),curso.getIdCurso());
                    }
                    cbCaracter.removeAllItems();
                    cbxEmpleado.removeAllItems();
                    cbxLicencia.removeAllItems();
                    ctrlLicencia.cargarComboEmpleado(cbxEmpleado);
                    //ctrlLicencia.cargarCombo(cbxLicencia); //FALTA AGREGAR PARAMETRO PARA CARACTER
                    modelo.clear();
                    modelo1.clear();
                    listaCursosaCargo.setModel(modelo);
                    listaCursosaTomar.setModel(modelo1);
                    fechaInicio.setDate(null);
                    fechaFinalizacion.setDate(null);
                    areaDetalle.setText("");
                    cbCaracter.setEnabled(true);

                }
            }
        }
        bandera=0;
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cbxLicenciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLicenciaItemStateChanged
        if (bandera==0) {
            if (cbxLicencia.getSelectedIndex()==0) {
                areaDetalle.setText("");
            }else{
                
        String articulo = (String) cbxLicencia.getSelectedItem();
        
        licencia = ctrlLicencia.leer(Integer.parseInt(articulo));
        areaDetalle.setText(licencia.getDetalle());
            }
        }
        
    }//GEN-LAST:event_cbxLicenciaItemStateChanged

    private void btnAceptarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnAceptarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnAceptarActionPerformed(e);
        }
    }//GEN-LAST:event_btnAceptarKeyPressed

    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.jButton2ActionPerformed(e);
        }
    }//GEN-LAST:event_jButton2KeyPressed

    private void cbxEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpleadoActionPerformed
        if (bandera != 1) {
            if (cbxEmpleado.getSelectedIndex() != 0) {
                bandera=1;
                cbCaracter.removeAllItems();
                
                cbxLicencia.removeAllItems();
                modelo.clear();
                modelo1.clear();
                listaCursosaCargo.setModel(modelo);
                listaCursosaTomar.setModel(modelo1);
                areaDetalle.setText("");
                    
            persona = (Persona) cbxEmpleado.getSelectedItem();
            empleado = ctrlEmpleado.leer(persona.getIdPersona());
                ctrlCursoProfesor.cargarCombo(cbCaracter, empleado.getIdEmpleado());
                bandera=0;
            }//cargarListaCursoProfesor(empleado.getIdEmpleado());
        }else{
                    cbCaracter.removeAllItems();
                    cbxLicencia.removeAllItems();
                    modelo.clear();
                    modelo1.clear();
                    listaCursosaCargo.setModel(modelo);
                    listaCursosaTomar.setModel(modelo1);
                    fechaInicio.setDate(null);
                    fechaFinalizacion.setDate(null);
                    areaDetalle.setText("");
                    cbCaracter.setEnabled(true);
        }
    }//GEN-LAST:event_cbxEmpleadoActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        if (listaCursosaCargo.getSelectedIndex() != -1) {;
            
            modelo1.addElement(listaCursosaCargo.getSelectedValue());
            for (int i = 0; i < modelo.size(); i++) {
                if (modelo.get(i)==listaCursosaCargo.getSelectedValue()) {
                    modelo.remove(i);
                }
            }
            cbCaracter.setEnabled(false);
            //Tengo que hacer un metodo que me recorra de nuevo la lista y que me elimine un valor, que es el que seleccione
            //y a la vez esa lista modificada que se cargue en la lista, sin el elemento que seleccione
        }
    }//GEN-LAST:event_btnAsignarActionPerformed

    private void btnDesAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDesAsignarActionPerformed
        if (listaCursosaTomar.getSelectedIndex()!= -1) {
            modelo.addElement(listaCursosaTomar.getSelectedValue());
            for (int i = 0; i < modelo1.size(); i++) {
                if (modelo1.get(i)==listaCursosaTomar.getSelectedValue()) {
                    modelo1.remove(i);
                }
            }
        }
    }//GEN-LAST:event_btnDesAsignarActionPerformed

    private void cbCaracterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCaracterActionPerformed
        if (bandera != 1) {
            if (cbCaracter.getSelectedIndex() != 0) {
                persona = (Persona) cbxEmpleado.getSelectedItem();
                empleado = ctrlEmpleado.leer(persona.getIdPersona());
                caracter = (Caracter) cbCaracter.getSelectedItem();
                modelo.clear();
                cargarListaCursoProfesor(empleado.getIdEmpleado(), caracter.getIdCaracter());
                ctrlLicencia.cargarComboFiltrado(cbxLicencia, caracter.getIdCaracter());
            }
        }
    }//GEN-LAST:event_cbCaracterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDetalle;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnDesAsignar;
    private javax.swing.JComboBox<Caracter> cbCaracter;
    private javax.swing.JComboBox<Persona> cbxEmpleado;
    private javax.swing.JComboBox<String> cbxLicencia;
    private com.toedter.calendar.JDateChooser fechaFinalizacion;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<TipoCurso> listaCursosaCargo;
    private javax.swing.JList<TipoCurso> listaCursosaTomar;
    // End of variables declaration//GEN-END:variables
}
