/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import Controlador.CtrlEscuela;
import Controlador.CtrlUsuario;
import clases.CambiaPanel;
import interfazAlumno.PanelDni;
import interfazEmpleado.Registro;
import javax.swing.JOptionPane;
import menu.Principal;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import menu.ConfiguracionGeneral;
import static menu.Principal.panelSubMenu;
import modelo.Escuela;
import modelo.Usuario;
/**
 *
 * @author araa
 */
public class Login extends javax.swing.JInternalFrame {

    CtrlUsuario ctrlUsuario=new CtrlUsuario();
    CtrlEscuela ctrlEscuela=new CtrlEscuela();
    Escuela escuela=new Escuela();
    
    public static Usuario usuario=new Usuario();
    public static String nombreEscuela=null;
    
    int contador;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        
        Dimension medida1= this.getSize();
        Dimension medida2= this.getSize();
        //menu.Principal.centrarPantalla(medida1.height, medida2.width, this.getLocation());
        this.setLocation((menu.Principal.pantalla.width - medida1.width)/2,(menu.Principal.pantalla.height - medida2.height)/2);
    
        contador=0;
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
        txtUser = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtNombreEscuela = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        btnNuevoUser = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(57, 69, 140));

        txtUser.setName(""); // NOI18N
        txtUser.setVerifyInputWhenFocusTarget(false);
        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de Usuario");

        btnEntrar.setBackground(new java.awt.Color(255, 255, 255));
        btnEntrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEntrar.setText("Entrar");
        btnEntrar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                btnEntrarFocusGained(evt);
            }
        });
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");

        txtNombreEscuela.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        txtNombreEscuela.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreEscuela.setText("Centro De Formación Profesional");

        pass.setText("jPasswordField1");
        pass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passKeyPressed(evt);
            }
        });

        btnNuevoUser.setBackground(new java.awt.Color(255, 255, 255));
        btnNuevoUser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoUser.setText("¿No tienes un usuario?");
        btnNuevoUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(txtNombreEscuela, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevoUser)
                    .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreEscuela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(5, 5, 5)
                        .addComponent(btnEntrar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNuevoUser)
                .addGap(7, 7, 7))
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

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        // TODO add your handling code here:
        //confirmacion();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            pass.requestFocus();
            pass.setText("");
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void passKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            btnEntrar.requestFocus();
        }
    }//GEN-LAST:event_passKeyPressed

    private void btnEntrarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_btnEntrarFocusGained
      
        confirmacion();
    }//GEN-LAST:event_btnEntrarFocusGained

    private void btnNuevoUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUserActionPerformed
        // TODO add your handling code here:
        String clave=null;
        clave=JOptionPane.showInputDialog("Ingrese la clave dada");
        
        if(clave.equals("claveDirector")){
           this.setVisible(false);
            try {
                PanelDni.alumnoEmpleado=3;
                CambiaPanel cambiaPanel = new CambiaPanel(Principal.panelPrincipal, new PanelDniUs());

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }else{
            JOptionPane.showMessageDialog(null, "no");
        }
    }//GEN-LAST:event_btnNuevoUserActionPerformed

    void confirmacion(){
        
        usuario=ctrlUsuario.confirmar(txtUser.getText(), String.valueOf(pass.getPassword()));
        
        if(usuario.getIdUsuario()!=0){
            this.setVisible(false);
            dispose();
            
            if(usuario.getJerarquia()==3){
                Principal.menuBar.setVisible(false);
            }
            
            escuela=ctrlEscuela.leer();
            
            if(escuela.getIdEscuela()!=0){
                Principal.activarPanel();
            }else{
                if(JOptionPane.showConfirmDialog(null, "No a terminado su configuración general ¿Desea completarla antes de continuar?","", + 
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
                
                ConfiguracionGeneral confi=new ConfiguracionGeneral();
                Principal.panelPrincipal.add(confi);
                confi.setVisible(true);    
            }else{
                Principal.labelInstitucion.setText(escuela.getNombreEscuela());
                Principal.activarPanel();
            }
                
            }
        }else{
            contador++;
            txtUser.requestFocus();
            if(contador<3){
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta." + contador);
                txtUser.setText("");
                pass.setText("Incorrecto");
            }else{
                if(contador==3){
                    JOptionPane.showMessageDialog(null, "Oportunidades agotadas. \n El sistema se cerrará.");
                    System.exit(0);
                }
            }
           
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnNuevoUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pass;
    private javax.swing.JLabel txtNombreEscuela;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
