package usuario;

import Controlador.CtrlCargo;
import Controlador.CtrlEmpleado;
import Controlador.CtrlEmpleadoCargo;
import Controlador.CtrlPersona;
import Controlador.CtrlUsuario;
import interfazAlumno.PanelDni;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import menu.Principal;
import modelo.Cargo;
import modelo.Persona;
import modelo.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author araa
 */
public class CrearUsuario extends javax.swing.JInternalFrame {
    /**
     * Creates new form CrearUsuario
     * @throws java.lang.ClassNotFoundException
     */
    Connection con=clases.Conectar.conexion();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    CtrlPersona ctrlPersona=new CtrlPersona();
    CtrlCargo ctrlCargo=new CtrlCargo();
    CtrlUsuario ctrlUsuario=new CtrlUsuario();

    CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
    CtrlEmpleadoCargo ctrlECargo=new CtrlEmpleadoCargo();
    
    Usuario usuarioDatos=new Usuario();
    int jerarquia=0;
    int idEmpleado=0;
    
<<<<<<< HEAD
=======
    
>>>>>>> 607323d8c395e87653bf771c79fb7647eb7dd5a0
    public CrearUsuario() throws ClassNotFoundException {
        initComponents();
        
        //cargarCombo(cbUsuario);
        ctrlCargo.cargarCombo(cbJerarquia);  
        JOptionPane.showMessageDialog(null, "hola");
        
    }
    
    public CrearUsuario(Persona persona) throws ClassNotFoundException {
        initComponents();
       
    //SE OBTIENE EL ID-EMPLEADO POR MEDIO DEL ID-PERSONA PASADO POR PARAMETRO    
        idEmpleado=ctrlEmpleado.leer(persona.getIdPersona()).getIdEmpleado();
    
        ctrlCargo.cargoEmpleado(idEmpleado, cbJerarquia);
        
        cbEmpleado.addItem(persona);
        
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
        txtPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPass2 = new javax.swing.JPasswordField();
        txtUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbEmpleado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbJerarquia = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btnCrearUser = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CREAR USUARIO");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        txtPass.setText("jPasswordField1");
        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel3.setText("Contraseña:");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel4.setText("Repetir Contraseña:");

        txtPass2.setText("jPasswordField1");
        txtPass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPass2KeyPressed(evt);
            }
        });

        txtUser.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel6.setText("Nombre de usuario:");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel2.setText("Empleados:");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        jLabel5.setText("Cargo:");

        cbJerarquia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJerarquiaItemStateChanged(evt);
            }
        });
        cbJerarquia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbJerarquiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(cbJerarquia, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 158, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbJerarquia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnCrearUser.setBackground(new java.awt.Color(38, 86, 186));
        btnCrearUser.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearUser.setText("Aceptar");
        btnCrearUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearUserActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(btnCrearUser, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtPass2))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(55, 55, 55)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtUser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUserActionPerformed
        // TODO add your handling code here:
        Persona idPersona=(Persona) cbEmpleado.getSelectedItem();
        idEmpleado=ctrlEmpleado.leer(idPersona.getIdPersona()).getIdEmpleado();
    /*
    EL USUARIO SE PUEDE CREAR DESDE DOS PARTIDAS... DESDE EL LOGIN ANTES DE ENTRAR AL SISTEMA
        Y CUANDO YA SE ESTE EN EL SISTEMA
        */
        //HACER UNA BUSQUEDA PREVIA SI EXISTE UN USS CON EL MISMO ID DE PERSONA..!
        if(PanelDni.alumnoEmpleado!=3){
    //si no es 3 quiere decir que entro estando ya en el sistema... por lo tal se tendria que hacer una busqueda previa en caso de que
    //el usuario a crear hacia un empleado, ya esté creado...
            if(ctrlUsuario.leer(idPersona.getIdPersona()).getIdUsuario()!=0){
                if(Arrays.equals(txtPass.getPassword(), txtPass2.getPassword())){
                Cargo item=(Cargo) cbJerarquia.getSelectedItem();
                jerarquia(item.getDetalle());
            
                ctrlUsuario.crear(txtUser.getText(), String.copyValueOf(txtPass.getPassword()),jerarquia, idEmpleado);
            
                if(ctrlUsuario.verificar(txtUser.getText(), String.copyValueOf(txtPass.getPassword()))){
                    JOptionPane.showMessageDialog(null, "EL usuario ya ha sido creado... ");
                    dispose();
                    Principal.activarPanel();
                }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Vuelva a ingresar su contraseña..");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe un usuario para ese empleado");
            }
            
        }else{
            if(Arrays.equals(txtPass.getPassword(), txtPass2.getPassword())){
                Cargo item=(Cargo) cbJerarquia.getSelectedItem();
                jerarquia(item.getDetalle());
            
                ctrlUsuario.crear(txtUser.getText(), String.copyValueOf(txtPass.getPassword()),jerarquia, idEmpleado);
            
                if(ctrlUsuario.verificar(txtUser.getText(), String.copyValueOf(txtPass.getPassword()))){
                    JOptionPane.showMessageDialog(null, "EL usuario ya ha sido creado... ");
                    dispose();
                    Login log=new Login();
                    Principal.panelPrincipal.add(log);
                    log.setVisible(true);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Vuelva a ingresar su contraseña..");
            }
        }
        
        
    }//GEN-LAST:event_btnCrearUserActionPerformed

    void jerarquia(String cargo){
        switch(cargo){
            case "DIRECTOR":
                jerarquia=1;
            break;
            
            case "SECRETARIO":
                jerarquia=2;
            break;
            
            case "PRECEPTOR":
                jerarquia=2;
            break;
            
            case "PROFESOR":
                jerarquia=3;
            break;
        }
    }
    private void cbJerarquiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJerarquiaItemStateChanged
        // TODO add your handling code here:
        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(cbJerarquia.getSelectedIndex()!=0 && PanelDni.alumnoEmpleado!=3){
                
                Cargo item;
                item=(Cargo)cbJerarquia.getSelectedItem();               
                DefaultComboBoxModel modelo=new DefaultComboBoxModel(cargarFiltrado(item.getIdCargo()));
                cbEmpleado.setModel(modelo);
            }
        }
        
    }//GEN-LAST:event_cbJerarquiaItemStateChanged

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            
            if(ctrlUsuario.confirmar(txtUser.getText())){
                JOptionPane.showMessageDialog(null, "Ya existe un usuario igual, eliga otro nombre de usuario");
            }else{
                txtPass.requestFocus();
                txtPass.setText("");
            }
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtPass2.requestFocus();
            txtPass2.setText("");
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtPass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPass2KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btnCrearUser.requestFocus();
        }
    }//GEN-LAST:event_txtPass2KeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
        if(PanelDni.alumnoEmpleado==3){
            dispose();
            Login log=new Login();
            Principal.panelPrincipal.add(log);
            log.setVisible(true);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cbJerarquiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbJerarquiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbJerarquiaActionPerformed

    public Vector<Persona> cargarFiltrado(int cargo) {
        //CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
        
        Vector<Persona> datos = new Vector<>();
        Persona dat=null;
        
        try {
            String sql = "SELECT persona.idPersona, persona.nombrePersona, persona.apellidoPersona FROM persona"
                    + " INNER JOIN empleado ON persona.idPersona = empleado.idPersona"
                    + " INNER JOIN empleadoCargo ON empleado.idEmpleado = empleadoCargo.idEmpleado"
                    + " WHERE empleadoCargo.idCargo=? AND empleado.borrado=false";
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, cargo);
            
            rs = ps.executeQuery();
            
            dat=new Persona();
            dat.setIdPersona(0);
            dat.setApellidoPersona("Seleccione una persona");
            datos.add(dat);
            
                while (rs.next()) {
                    dat=new Persona();
                    
                    dat.setIdPersona(rs.getInt("idPersona"));
                    dat.setApellidoPersona(rs.getString("apellidoPersona")+" "+rs.getString("nombrePersona"));
                    datos.add(dat);
                }
                rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearUser;
    private javax.swing.JComboBox<Persona> cbEmpleado;
    private javax.swing.JComboBox<Cargo> cbJerarquia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
