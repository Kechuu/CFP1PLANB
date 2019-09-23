/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import Controlador.CtrlCurso;
import Controlador.CtrlLugarCurso;
import Controlador.CtrlTipoCurso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import menu.Principal;
import modelo.LugarCurso;
import modelo.TipoCurso;


/**
 *
 * @author araa
 */
public final class EliminarCurso extends javax.swing.JInternalFrame {
   
    Connection con = clases.Conectar.conexion();
    /**
     * Creates new form NewJInternalFrame
     */
    public EliminarCurso() {
        initComponents();
        llenarTablaCurso(TablaCursos);
      }
  
    public void llenarTablaCurso(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Ciclo Lectivo");
        modelo.addColumn("Turno");
        modelo.addColumn("Costo");
        modelo.addColumn("Cupo");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("FechaFinalizacion");
        modelo.addColumn("Lugar");
        tabla.setModel(modelo);
                
        String[] dato = new String[8];
        String turno="";
        try {
            java.util.Date fecha = new java.util.Date();
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT idTipoCurso,cicloLectivo,turno,"
                    + "costo,cupo,fechaInicio,fechaFinalizacion,idLugarCurso FROM curso WHERE borrado=FALSE");
            
            while (rs.next()) {                
                CtrlTipoCurso ctrlTipoCurso = new CtrlTipoCurso();
                TipoCurso tipoCurso = new TipoCurso();
                
                int idTipoCurso = rs.getInt(1);
                //JOptionPane.showMessageDialog(null, idTipoCurso);
                tipoCurso = ctrlTipoCurso.leer(idTipoCurso);
                //JOptionPane.showMessageDialog(null, tipoCurso.getDetalle());
                dato[0]=tipoCurso.getDetalle();
                
                dato[1]=rs.getString(2);
    
                 switch(rs.getInt(3)){
                    case 1:
                        turno="Mañana";
                        
                        break;
                        
                    case 2:
                        turno="Tarde";
                        
                        break;
                    
                    case 3:
                        turno="Noche";
                        
                        break;
                        
                }
                
                dato[2]=turno;
                
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[5]=rs.getString(6);
                dato[6]=rs.getString(7);
                
                CtrlLugarCurso ctrlLugarCurso = new CtrlLugarCurso();
                LugarCurso lugarCurso = new LugarCurso();
                int idLugarCurso = rs.getInt(8);
                
                lugarCurso = ctrlLugarCurso.leer(idLugarCurso);
                dato[7]= lugarCurso.getDetalle();
                modelo.addRow(dato);
            }
            
            tabla.setModel(modelo);
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getLocalizedMessage()); 
        }
    }
         
    
    public void eliminarCurso(){
        CtrlTipoCurso ctrlTipoCurso = new CtrlTipoCurso();
        CtrlCurso ctrlCurso = new CtrlCurso();
        TipoCurso tipoCurso = new TipoCurso();
        int filaSeleccionada = TablaCursos.getSelectedRow();
        
        if (filaSeleccionada>=0) {
        
            String detalle = (String) TablaCursos.getValueAt(filaSeleccionada, 0).toString();
            String cicloLectivo = (String) TablaCursos.getValueAt(filaSeleccionada, 1).toString();
            String turno = (String) TablaCursos.getValueAt(filaSeleccionada, 2).toString();
        
            tipoCurso = ctrlTipoCurso.leer(detalle);
            
            switch(turno){
                case "Mañana":
                    ctrlCurso.borrar(tipoCurso.getIdTipoCurso(), 1, Integer.parseInt(cicloLectivo));
                    break;
                case "Tarde":
                    ctrlCurso.borrar(tipoCurso.getIdTipoCurso(), 2, Integer.parseInt(cicloLectivo));
                    break;
                case "Noche":
                    ctrlCurso.borrar(tipoCurso.getIdTipoCurso(), 3, Integer.parseInt(cicloLectivo));
                    break;
                
            }
            
        
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaCursos = new javax.swing.JTable();
        txtidCurso = new javax.swing.JLabel();
        btnCancelar1 = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Detalle", "Ciclolectivo", "Turno", "Costo", "Cupo", "Inicio", "Finalizacion", "Lugar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCursosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaCursos);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 57, 780, 260));
        jPanel2.add(txtidCurso, new org.netbeans.lib.awtextra.AbsoluteConstraints(664, 280, 49, 26));

        btnCancelar1.setBackground(new java.awt.Color(38, 86, 186));
        btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 324, 100, -1));

        btnEliminar.setBackground(new java.awt.Color(38, 86, 186));
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Elimnar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(479, 324, 100, -1));

        jPanel3.setBackground(new java.awt.Color(38, 86, 186));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(102, 102, 255));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Eliminar Curso");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 12, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 827, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        // TODO add your handling code here:
          Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        eliminarCurso();
        llenarTablaCurso(TablaCursos);
        //Principal.activarPanel();
        //dispose();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void TablaCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCursosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaCursosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaCursos;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel txtidCurso;
    // End of variables declaration//GEN-END:variables
//Conectar x = new Conectar();
  //   Connection con = x.conexion();
}
