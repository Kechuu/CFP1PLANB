/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazAlumno;

import Controlador.CtrlAlumno;
import Controlador.CtrlCurso;
import Controlador.CtrlCursoAlumno;
import Controlador.CtrlCursoHora;
import Controlador.CtrlPersona;
import Controlador.CtrlTipoCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import menu.Principal;
import modelo.Alumno;
import modelo.Curso;
import modelo.Persona;
import modelo.TipoCurso;

/**
 *
 * @author AGUSTINA
 */
public class AsignarCurso1 extends javax.swing.JInternalFrame {
    public static int banderaAsignar=0;
    
    //ArrayList<TipoCurso>arrayCurso=new ArrayList<>();
    CtrlCurso ctrlCurso=new CtrlCurso();
    CtrlAlumno ctrlAlumno=new CtrlAlumno();
    CtrlCursoAlumno ctrlCursoAlum=new CtrlCursoAlumno();
    CtrlPersona ctrlPersona=new CtrlPersona();
    
    Alumno alumnoDatos=new Alumno();
    Persona persona=new Persona();
    DefaultListModel<TipoCurso> modeloCursos;
    DefaultListModel<TipoCurso> modeloDisponible;
    
    java.util.Date date=new Date();
    /**
     * Creates new form AsignarCurso
     * @param persona
     */
    public AsignarCurso1(/*Persona persona*/){
        initComponents();
        
        fecha.setDate(date);
        
        btnCursoAsignar.setEnabled(false);
        btnCursoDeshacer.setEnabled(false);
    
    //LAS SIGUIENTES DOS LINEAS LLENARAN LAS LISTAS PARA:
    //  -listDisponible: LOS CURSOS DISPONIBLES A LOS QUE PODRIA INSCRIBIRSE
    //  -listCursosInscriptos: SON LOS CURSOS A LOS QUE EL ALUMNO YA ESTÁ INSCRIPTO
          
    
        ctrlCurso.llenarLista(listDisponible);//se carga la lista con los cursos disponibles
        
    //modeloCursos SERVIRA PARA MANEJAR LOS CURSOS QUE SE ELIJA INSCRIBIRSE..
    //LA ListCursosInscriptos SOLO SERVIRÁ DE GUIA A QUÉ CURSOS YA PERTENECE
        modeloCursos=new DefaultListModel();
        listCursos.setModel(modeloCursos);//LISTA DE CURSOS A LOS QUE SE INSCRIBIERAN..
        
        modeloDisponible=(DefaultListModel<TipoCurso>) (listDisponible.getModel());
        
        //this.persona=persona;
        
        cargar();
        ctrlAlumno.cargarListaAlumno(listaAlumnos);
    }
    
    /*void llenarArray(){
        for(int i=0; i<modeloCursos.getSize();i++){
            arrayCurso.add(i, modeloCursos.getElementAt(i));
        }
    }*/
    void cargar(){
        //txtNombreCompleto.setText(persona.getApellidoPersona()+" "+persona.getNombrePersona());
    
        //filtrar();
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelCompleto = new javax.swing.JPanel();
        btnInscribirCursos = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPago = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        listCursosInscriptos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaAlumnos = new javax.swing.JList<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaHorario = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        listDetalle = new javax.swing.JList<>();
        jLabel11 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asignacion a Cursos");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 0, -1, -1));

        jLayeredPane1.setLayout(new java.awt.BorderLayout());

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

        btnPago.setBackground(new java.awt.Color(38, 86, 186));
        btnPago.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPago.setForeground(new java.awt.Color(255, 255, 255));
        btnPago.setText("Realizar pago");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jScrollPane6.setViewportView(listCursosInscriptos);

        listaAlumnos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAlumnosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaAlumnos);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Cursos inscriptos");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setText("Alumnos");

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane6))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel13))
                    .addComponent(txtBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Curso disponibles");

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
        jLabel12.setText("Cursos a inscribir");

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
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCursoDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCursoAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5))))
                    .addComponent(jLabel9))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnCursoAsignar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCursoDeshacer)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Datos del curso")));

        tablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Día", "Desde", "Hasta"
            }
        ));
        tablaHorario.setEnabled(false);
        tablaHorario.setFocusable(false);
        jScrollPane1.setViewportView(tablaHorario);

        listDetalle.setEnabled(false);
        listDetalle.setFocusable(false);
        jScrollPane5.setViewportView(listDetalle);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("Fecha actual:");

        javax.swing.GroupLayout panelCompletoLayout = new javax.swing.GroupLayout(panelCompleto);
        panelCompleto.setLayout(panelCompletoLayout);
        panelCompletoLayout.setHorizontalGroup(
            panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletoLayout.createSequentialGroup()
                .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCompletoLayout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(btnInscribirCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCompletoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelCompletoLayout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompletoLayout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCompletoLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        panelCompletoLayout.setVerticalGroup(
            panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompletoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCompletoLayout.createSequentialGroup()
                        .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(12, 12, 12)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCompletoLayout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelCompletoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInscribirCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCompleto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane1)
                    .addComponent(panelCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        // TODO add your handling code here:
        banderaAsignar=1;
        if(listaAlumnos.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(null, "Necesita seleccionar a un alumno");
        }else{
            Persona item = (Persona) listaAlumnos.getSelectedValue();
            PagoAlumno pago = new PagoAlumno(item);
            Principal.panelPrincipal.add(pago);

            this.setComponentZOrder(pago, 0);
            this.isOptimizedDrawingEnabled();

            pago.setVisible(true);         
        }
 
    }//GEN-LAST:event_btnPagoActionPerformed

    @Override
    public boolean isOptimizedDrawingEnabled(){
        return false;
    }
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        /*switch(Inscripcion.bandera){
            case 1:
                dispose();
            break;
            
            case 2:
                Principal.activarPanel();
                dispose();
            break;
            
            default:
                Principal.activarPanel();
                dispose();

                break;
        }*/
        Principal.activarPanel();
        dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnInscribirCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInscribirCursosActionPerformed
        // TODO add your handling code here:
        CtrlCursoAlumno cursoAlumno=new CtrlCursoAlumno();
        CtrlCurso ctrlCursoC=new CtrlCurso();
        ListModel<TipoCurso> listaCursos=listCursos.getModel();

        if(modeloCursos.isEmpty()){
            JOptionPane.showMessageDialog(null, "No a elegido algún curso para inscribir");
        }else{
            //int idAlumno=ctrlAlumno.leer(persona.getIdPersona()).getIdAlumno();

            //int idAlumno=listaAlumnos.getSelectedValue().getIdPersona();
            
            int idAlumno=ctrlAlumno.leer(listaAlumnos.getSelectedValue().getIdPersona()).getIdAlumno();
            
            for(int i=0; i<listaCursos.getSize();i++){
                
                cursoAlumno.crear(listaCursos.getElementAt(i).getCosto(), fecha.getDate(), idAlumno, 1, ctrlCursoC.leer(listaCursos.getElementAt(i).getIdTipoCurso()).getIdCurso());                    
                
            }
            //ctrlCursoAlum.llenarLista(ctrlAlumno.leer(persona.getIdPersona()).getIdAlumno(), listCursosInscriptos);
            modeloCursos.removeAllElements();
            listaAlumnos.clearSelection();
            listCursosInscriptos.removeAll();
            ctrlAlumno.cargarListaAlumno(listaAlumnos);
        }        
    }//GEN-LAST:event_btnInscribirCursosActionPerformed

    void filtrar(){
        //modeloDisponible... los que trae de BD
        ListModel<TipoCurso>lista1=listCursosInscriptos.getModel();
        
        for(int i=0; i<lista1.getSize();i++){
            for(int j=0; j<modeloDisponible.getSize();j++){
                TipoCurso item=null;
                item=modeloDisponible.elementAt(j);
                
                if(lista1.getElementAt(i).getIdTipoCurso()==item.getIdTipoCurso()){
                    modeloDisponible.removeElementAt(j);
                }
            }
        }
    }
    private void listDisponibleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDisponibleValueChanged

        if(listDisponible.getSelectedIndex()!= -1){
            btnCursoAsignar.setEnabled(true);

            listDetalle.setModel(detalleCurso(listDisponible));

        }
    }//GEN-LAST:event_listDisponibleValueChanged

    private void listDisponibleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listDisponibleKeyPressed

    }//GEN-LAST:event_listDisponibleKeyPressed

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
            
            modeloDisponible.addElement((TipoCurso)listCursos.getSelectedValue());
            
            modeloCursos.remove(listCursos.getSelectedIndex());

            btnCursoAsignar.setEnabled(true);
        }

        if(modeloCursos.isEmpty()){
            btnCursoDeshacer.setEnabled(false);
        }
    }//GEN-LAST:event_btnCursoDeshacerActionPerformed

    private void listCursosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listCursosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_listCursosKeyPressed

    private void listCursosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listCursosValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_listCursosValueChanged

    private void listaAlumnosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaAlumnosValueChanged
        // TODO add your handling code here:
        if(listaAlumnos.getSelectedIndex()!= -1){
            int idAlumno=ctrlAlumno.leer(listaAlumnos.getSelectedValue().getIdPersona()).getIdAlumno();
            ctrlCursoAlum.llenarLista(idAlumno, listCursosInscriptos);
        }
//        listaAlumnos.clearSelection();
        filtrar();
    }//GEN-LAST:event_listaAlumnosValueChanged

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    
    DefaultListModel detalleCurso(JList<TipoCurso> lista ){
        DefaultListModel model=new DefaultListModel();
        
        try {
            CtrlCurso curso= new CtrlCurso();
            CtrlCursoHora cursoHora=new CtrlCursoHora();
            Curso obj=new Curso();
            
            obj=curso.leer(lista.getSelectedValue().getIdTipoCurso());
            
                //JOptionPane.showMessageDialog(null, obj);
            
            model.addElement("Ciclo Lectivo: "+String.valueOf(obj.getCicloLectivo()));
           
            switch(obj.getTurno()){
                
                case 1:
                    model.addElement("Turno: Matutino");
                break;
                    
                case 2:
                    model.addElement("Turno: Tarde");
                break;
                   
                case 3:
                    model.addElement("Turno: Vespertino");
                break;
                    
                case 4:
                    model.addElement("Turno: Nocturno");
                break;
            }
            
            model.addElement("Costo: "+String.valueOf(obj.getCosto()));
            model.addElement("Cupo actual: "+String.valueOf(obj.getCupo()));
            model.addElement("Fecha de inicio: "+ String.valueOf(obj.getFechaInicio()));
            model.addElement("Finalización: "+ String.valueOf(obj.getFechaFinalizacion()));
            model.addElement("Lugar de cursado: "+String.valueOf(obj.getIdLugarCurso().getDetalle()));
  
            
            curso.llenarTabla(curso.leer(listDisponible.getSelectedValue().getIdTipoCurso()).getIdCurso(), tablaHorario);
        
        } catch (SQLException ex) {
            Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return model;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCursoAsignar;
    private javax.swing.JButton btnCursoDeshacer;
    private javax.swing.JButton btnInscribirCursos;
    private javax.swing.JButton btnPago;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JList<TipoCurso> listCursos;
    private javax.swing.JList<TipoCurso> listCursosInscriptos;
    private javax.swing.JList<String> listDetalle;
    private javax.swing.JList<TipoCurso> listDisponible;
    private javax.swing.JList<Persona> listaAlumnos;
    private javax.swing.JPanel panelCompleto;
    private javax.swing.JTable tablaHorario;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
