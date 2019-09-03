package interfazAlumno;

import menu.Principal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Karen Rodriguez
 */
public class ConsultaPagos extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaPagos
     */
    public ConsultaPagos() {
        initComponents();
        
        /*Aqui se llenara la tabla por defecto de los ultimos pagos que se hayan realizado
     por el mismo usuario que está usando el sistema..   
        */
    
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
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtdni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btnpagadas = new javax.swing.JButton();
        btndeudas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstado = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        btnregistrarpago = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        btnbaja = new javax.swing.JButton();
        btnanterior = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Consultar estado de alumno");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 12, -1, 22));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Por Alumno"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("DNI");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 38, -1, -1));
        jPanel3.add(txtdni, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 58, 107, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Apellido y Nombre:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, -1));

        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });
        jPanel3.add(txtapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 57, 220, 30));

        btnbuscar.setBackground(new java.awt.Color(38, 86, 186));
        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 57, 106, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 12, 553, 93));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("En General"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnpagadas.setBackground(new java.awt.Color(38, 86, 186));
        btnpagadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnpagadas.setForeground(new java.awt.Color(255, 255, 255));
        btnpagadas.setText("Pagadas");
        btnpagadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpagadasActionPerformed(evt);
            }
        });
        jPanel4.add(btnpagadas, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 118, -1));

        btndeudas.setBackground(new java.awt.Color(38, 86, 186));
        btndeudas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndeudas.setForeground(new java.awt.Color(255, 255, 255));
        btndeudas.setText("Deudas");
        btndeudas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeudasActionPerformed(evt);
            }
        });
        jPanel4.add(btndeudas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 118, -1));

        tablaEstado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaEstado);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 490, 120));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Motivos:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 29, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 111, 530, 210));

        btnregistrarpago.setBackground(new java.awt.Color(38, 86, 186));
        btnregistrarpago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnregistrarpago.setForeground(new java.awt.Color(255, 255, 255));
        btnregistrarpago.setText("Registrar Pago");
        btnregistrarpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarpagoActionPerformed(evt);
            }
        });
        jPanel1.add(btnregistrarpago, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 167, -1));

        btncancelar.setBackground(new java.awt.Color(38, 86, 186));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btncancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 146, -1));

        btnbaja.setBackground(new java.awt.Color(38, 86, 186));
        btnbaja.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbaja.setForeground(new java.awt.Color(255, 255, 255));
        btnbaja.setText("Dar de baja Alumno");
        btnbaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbajaActionPerformed(evt);
            }
        });
        jPanel1.add(btnbaja, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 167, -1));

        btnanterior.setBackground(new java.awt.Color(38, 86, 186));
        btnanterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnanterior.setForeground(new java.awt.Color(255, 255, 255));
        btnanterior.setText("Anterior");
        btnanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanteriorActionPerformed(evt);
            }
        });
        jPanel1.add(btnanterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 141, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnbajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbajaActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        Eliminar eliminar=new Eliminar();
        Principal.panelPrincipal.add(eliminar);
        eliminar.setVisible(true);
    }//GEN-LAST:event_btnbajaActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        //Llamar metodo de busqueda por dni...
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnregistrarpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregistrarpagoActionPerformed

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanteriorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnpagadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpagadasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpagadasActionPerformed

    private void btndeudasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeudasActionPerformed
        // TODO add your handling code here:

        /*  InterfazPagoConsulta ip= new InterfazPagoConsulta();
        Principal.panelPrincipal.add(ip);
        ip.setVisible(true);
        */
    }//GEN-LAST:event_btndeudasActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnanterior;
    private javax.swing.JButton btnbaja;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btndeudas;
    private javax.swing.JButton btnpagadas;
    private javax.swing.JButton btnregistrarpago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEstado;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtdni;
    // End of variables declaration//GEN-END:variables
}
