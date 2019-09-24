/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import Controlador.CtrlCurso;
import Controlador.CtrlCursoHora;
import Controlador.CtrlHorario;
import menu.Principal;
import configuracion.Cursado_modificar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.TipoCurso;
import modelo.LugarCurso;

/**
 *
 * @author araa
 */
public class ModificarCurso extends javax.swing.JInternalFrame {
    Connection con = clases.Conectar.conexion();
    public DefaultTableModel modelo2 = new DefaultTableModel();
    public int bandera = 0;
    public int banderaTabla = 0;
    /**
     * Creates new form NewJInternalFrame
     */
    public ModificarCurso() {
        initComponents();
        bandera = 1;
        cargarComboTipoCurso(cbxNombreCurso);
        bandera=0;
        llenarTablaHorario2(TablaHorario2);
        btnAgregarHorario.setEnabled(false);
    }
    
    public void llenarTablaHorario2(JTable tabla){
        modelo2.addColumn("Dia");
        modelo2.addColumn("Desde");
        modelo2.addColumn("Hasta");
        tabla.setModel(modelo2);
        banderaTabla=0;
    }
    
    public void cargarComboTipoCurso(JComboBox<TipoCurso> cbTipoCurso){
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM tipoCurso ORDER BY detalle ASC");
            TipoCurso tipoCurso = new TipoCurso();
            tipoCurso.setIdTipoCurso(0);
            tipoCurso.setDetalle("Seleccione una opcion...");
            cbTipoCurso.addItem(tipoCurso);
            
            while (rs.next()) {
                tipoCurso = new TipoCurso();
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                cbTipoCurso.addItem(tipoCurso);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS CARGOS");       
        }
        
    }
    
    public void cargarComboLugarCurso(JComboBox<LugarCurso> cbLugarCurso){
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM lugarCurso ORDER BY detalle ASC");
            LugarCurso lugarCurso = new LugarCurso();
            lugarCurso.setIdLugarCurso(0);
            lugarCurso.setDetalle("Seleccione una opcion...");
            cbLugarCurso.addItem(lugarCurso);
            
            while (rs.next()) {                
                lugarCurso = new LugarCurso();
                lugarCurso.setIdLugarCurso(rs.getInt("idLugarCurso"));
                lugarCurso.setDetalle(rs.getString("detalle"));
                cbLugarCurso.addItem(lugarCurso);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS CARGOS");       
        }
        
    }
    
    public void llenarTablaHorario(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Dia");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        tabla.setModel(modelo);
                
        String[] dato = new String[3];
        String dia="";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT dia,desde,hasta FROM horario ORDER BY dia ASC");
            
            while (rs.next()) {                
                
                 switch(rs.getInt(1)){
                    case 1:
                        dia="Lunes";
                        
                        break;
                        
                    case 2:
                        dia="Martes";
                        
                        break;
                    
                    case 3:
                        dia="Miercoles";
                        
                        break;
                        
                    case 4:
                        dia="Jueves";
                        
                        break;
                        
                    case 5:
                        dia="Viernes";
                        
                        break;
                        
                    case 6:
                        dia="Sábado";
                        
                        break;
                        
                    case 7:
                        dia="Domingo";
                        
                        break;
                }
                
                dato[0]=dia;
                
                dato[1]=rs.getString(2);
                dato[2]=rs.getString(3);
                modelo.addRow(dato);
            }
            
            tabla.setModel(modelo);
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS BARRIOS EN LA TABLA"); 
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
        txtcosto2 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fechaFinalizacion = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtcosto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCicloLectivo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCupo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxNombreCurso = new javax.swing.JComboBox<>();
        btnNuevoTurno = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        cbxTurno = new javax.swing.JComboBox<>();
        cbxLugarCurso = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        btnNuevoTurno1 = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaHorario2 = new javax.swing.JTable();
        txtidCurso = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane6 = new javax.swing.JScrollPane();
        TablaHorario1 = new javax.swing.JTable();
        cboxNuevoHorario = new javax.swing.JCheckBox();
        btnAgregarHorario = new javax.swing.JButton();
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

        txtcosto2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcosto2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Costo del curso");

        jLabel4.setText("Fecha de Inicio");

        jLabel1.setBackground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Nombre del curso");

        jLabel5.setText("Fecha de Finalizacion");

        txtcosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcostoActionPerformed(evt);
            }
        });
        txtcosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcostoKeyTyped(evt);
            }
        });

        jLabel2.setText("Ciclo Lectivo");

        txtCicloLectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCicloLectivoKeyTyped(evt);
            }
        });

        jLabel7.setText("Cupo");

        txtCupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCupoActionPerformed(evt);
            }
        });
        txtCupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCupoKeyTyped(evt);
            }
        });

        jLabel10.setText("Turno");

        cbxNombreCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxNombreCursoItemStateChanged(evt);
            }
        });
        cbxNombreCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxNombreCursoMouseClicked(evt);
            }
        });
        cbxNombreCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNombreCursoActionPerformed(evt);
            }
        });

        btnNuevoTurno.setBackground(new java.awt.Color(38, 86, 186));
        btnNuevoTurno.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoTurno.setText("Nuevo Curso");
        btnNuevoTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTurnoActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(38, 86, 186));
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Modificar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar", "Mañana", "Tarde", "Noche" }));
        cbxTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTurnoActionPerformed(evt);
            }
        });

        cbxLugarCurso.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxLugarCursoItemStateChanged(evt);
            }
        });
        cbxLugarCurso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxLugarCursoMouseClicked(evt);
            }
        });
        cbxLugarCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLugarCursoActionPerformed(evt);
            }
        });

        jLabel15.setText("Lugar del curso");

        btnNuevoTurno1.setBackground(new java.awt.Color(38, 86, 186));
        btnNuevoTurno1.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevoTurno1.setText("Agregar Lugar");
        btnNuevoTurno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTurno1ActionPerformed(evt);
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

        TablaHorario2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaHorario2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaHorario2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TablaHorario2);

        TablaHorario1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaHorario1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaHorario1MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(TablaHorario1);

        cboxNuevoHorario.setText("Nuevo Horario");
        cboxNuevoHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxNuevoHorarioActionPerformed(evt);
            }
        });

        btnAgregarHorario.setText(">>");
        btnAgregarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHorarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnNuevoTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(txtCicloLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel10)
                .addGap(147, 147, 147)
                .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel7)
                .addGap(71, 71, 71)
                .addComponent(txtCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel4)
                .addGap(89, 89, 89)
                .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel15)
                .addGap(43, 43, 43)
                .addComponent(cbxLugarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addComponent(jLabel5)
                .addGap(45, 45, 45)
                .addComponent(fechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnNuevoTurno1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90)
                .addComponent(jLabel3)
                .addGap(82, 82, 82)
                .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(cboxNuevoHorario))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnAgregarHorario)
                .addGap(92, 92, 92)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(txtidCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(btnNuevoTurno))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtidCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(txtCicloLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel10))
                            .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(txtCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel4))
                            .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel15))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cbxLugarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNuevoTurno1)
                                    .addComponent(jLabel3))))
                        .addGap(11, 11, 11)
                        .addComponent(cboxNuevoHorario)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnAgregarHorario))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(btnGuardar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(btnCancelar)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        jPanel3.setBackground(new java.awt.Color(38, 86, 186));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(102, 102, 255));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Modificar Curso");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 12, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 925, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        Date fechaInicio1 = new Date();
        Date fechaFinalizacion1 = new Date();

        Curso curso = new Curso();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlCursoHora ctrlCursoHora = new CtrlCursoHora();
        LugarCurso lugarCurso = new LugarCurso();
        TipoCurso tipoCurso = new TipoCurso();
        String turno= (String) cbxTurno.getSelectedItem();
        int turnoInt=0;
        
        
        if (turno.equalsIgnoreCase("Mañana")) {
            turnoInt=1;
        }else{
            if (turno.equalsIgnoreCase("Tarde")) {
                turnoInt=2;
            }else{
                if (turno.equalsIgnoreCase("Noche")) {
                    turnoInt=3;
                }
            }
        }
        
        if (cbxNombreCurso.getSelectedIndex()==0 || txtCicloLectivo.getText().equalsIgnoreCase("") ||
            cbxTurno.getSelectedIndex()==0 || fechaInicio.getDate().toString().equalsIgnoreCase("") ||
            fechaFinalizacion.getDate().toString().equalsIgnoreCase("") || txtCupo.getText().equalsIgnoreCase("") ||
            txtcosto.getText().equalsIgnoreCase("") || cbxLugarCurso.getSelectedIndex()==0) {

            JOptionPane.showMessageDialog(null, "No se pueden cargar registros vacios");
        }else{
            lugarCurso = (LugarCurso) cbxLugarCurso.getSelectedItem();
            tipoCurso = (TipoCurso) cbxNombreCurso.getSelectedItem();
            curso = ctrlCurso.leer(tipoCurso.getIdTipoCurso());

            fechaInicio1 = fechaInicio.getDate();
            fechaFinalizacion1 = fechaFinalizacion.getDate();
            long i = fechaInicio1.getTime();
            long f = fechaFinalizacion1.getTime();
            java.sql.Date fecha1 = new java.sql.Date(i);
            java.sql.Date fecha2 = new java.sql.Date(f);

            ctrlCurso.editar(curso.getIdCurso(), Integer.parseInt(txtCicloLectivo.getText()), turnoInt, 
                    Float.parseFloat(txtcosto.getText()), Integer.parseInt(txtCupo.getText()), fecha1, fecha2,
                    Integer.parseInt(ctrlCurso.leer(tipoCurso.getIdTipoCurso()).toString()), 
                    lugarCurso.getIdLugarCurso(), false);
///////////////////////////////////////////////////////////////////////////////////////////////////////
            cbxNombreCurso.removeAllItems();
            cbxLugarCurso.removeAllItems();
            cargarComboLugarCurso(cbxLugarCurso);
            //cargarComboTipoCurso(cbxNombreCurso);
            cbxTurno.setSelectedIndex(0);
            fechaInicio.setDate(null);
            fechaFinalizacion.setDate(null);
            txtCicloLectivo.setText("");
            txtCupo.setText("");
            txtcosto.setText("");

            //Cargar tabla cursoHorarios
            ctrlCursoHora.eliminarCursoHora(curso.getIdCurso());
            //int idCurso = ctrlCurso.traerUltimoId();
            //JOptionPane.showMessageDialog(null, idCurso);
            cargarCursoHorario(curso.getIdCurso());
            //JOptionPane.showMessageDialog(null, "POR AQUI TAMBIEN");
            vaciarTablas(TablaHorario1);
            vaciarTablas(TablaHorario2);
            
        }
        
        
        
        
        
        this.setVisible(false);
        Principal.desactivarPanel();
        
        ModificarCurso curso1= new ModificarCurso();
        Principal.panelPrincipal.add(curso1);
        curso1.setVisible(true);
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    public void cargarCursoHorario(int idCurso){
        CtrlHorario ctrlHorario = new CtrlHorario();
        CtrlCursoHora ctrlCursoHora = new CtrlCursoHora();
        for (int i = 0; i < modelo2.getRowCount(); i++) {
            String dia = (String) TablaHorario2.getValueAt(i, 0);
            String desde = (String) TablaHorario2.getValueAt(i, 1);
            String hasta = (String) TablaHorario2.getValueAt(i, 2);
            
            
            
            Time desde1 = Time.valueOf(desde);
            Time hasta1 = Time.valueOf(hasta);
            //JOptionPane.showMessageDialog(null, desde1);
            
            //java.sql.Time desde1 = new java.sql.Time(d);
            //java.sql.Date hasta1 = new java.sql.Date(h);
            
            switch(dia){
                case "Lunes":
                    
                    modelo.Horario id1 = ctrlHorario.leer(1,desde1,hasta1);
                    
                    ctrlCursoHora.crear(id1.getIdHorario(), idCurso);
                    
                    break;
                case "Martes": 
                    modelo.Horario id2 = ctrlHorario.leer(2,desde1,hasta1);
                    
                    ctrlCursoHora.crear(id2.getIdHorario(), idCurso);
                    
                    break;
                case "Miercoles": 
                    modelo.Horario id3 = ctrlHorario.leer(3,desde1,hasta1);
                    
                    ctrlCursoHora.crear(id3.getIdHorario(), idCurso);
                    
                    break;
                case "Jueves": 
                    modelo.Horario id4 = ctrlHorario.leer(4,desde1,hasta1);
                    
                    ctrlCursoHora.crear(id4.getIdHorario(), idCurso);
                    
                    break;
                case "Viernes": 
                    modelo.Horario id5 = ctrlHorario.leer(5,desde1,hasta1);
                    
                    ctrlCursoHora.crear(id5.getIdHorario(), idCurso);
                    
                    break;
                case "Sabado": 
                    modelo.Horario id6 = ctrlHorario.leer(6,desde1,hasta1);
                    
                    ctrlCursoHora.crear(id6.getIdHorario(), idCurso);
                    
                    break;
                case "Domingo": 
                    modelo.Horario id7 = ctrlHorario.leer(7,desde1,hasta1);
                    
                    ctrlCursoHora.crear(id7.getIdHorario(), idCurso);
                    
                    break;
            }
            
        }
        
    }
    
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCupoActionPerformed

    private void btnNuevoTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTurnoActionPerformed
        // TODO add your handling code here:
        
        ModificarTipoCurso curso=new ModificarTipoCurso();
        Principal.panelPrincipal.add(curso);
        this.setComponentZOrder(curso, 0);
        curso.setVisible(true);
        
    }//GEN-LAST:event_btnNuevoTurnoActionPerformed

    private void txtcostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcostoActionPerformed

    private void btnNuevoTurno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTurno1ActionPerformed
        // TODO add your handling code here:
        
        Cursado_modificar configuracion=null;
        try {
            configuracion = new Cursado_modificar();
            Principal.panelPrincipal.add(configuracion);
            this.setComponentZOrder(configuracion, 0);
            configuracion.setVisible(true);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModificarCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnNuevoTurno1ActionPerformed
    
    @Override
    public boolean isOptimizedDrawingEnabled(){
        return false;
    }
    private void cbxLugarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLugarCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLugarCursoActionPerformed

    private void cbxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxTurnoActionPerformed

    private void cbxLugarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxLugarCursoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLugarCursoMouseClicked

    private void cbxLugarCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLugarCursoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLugarCursoItemStateChanged

    private void cbxNombreCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNombreCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNombreCursoActionPerformed

    private void cbxNombreCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxNombreCursoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNombreCursoMouseClicked

    private void cbxNombreCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNombreCursoItemStateChanged
        TipoCurso tipoCurso = new TipoCurso();
        CtrlCurso ctrlCurso = new CtrlCurso();
        tipoCurso = (TipoCurso) cbxNombreCurso.getSelectedItem();
        Curso curso = new Curso();
        
        if (bandera==0) {
            curso = ctrlCurso.leer(tipoCurso.getIdTipoCurso());
        
        txtCicloLectivo.setText(String.valueOf(curso.getCicloLectivo()));
        switch(curso.getTurno()){
            case 1:
                cbxTurno.setSelectedIndex(1);
                break;
            case 2:
                cbxTurno.setSelectedIndex(2);
                break;
            case 3:
                cbxTurno.setSelectedIndex(3);
                break;
            case 4:
                cbxTurno.setSelectedIndex(4);
                break;
        }
        txtcosto.setText(String.valueOf(curso.getCosto()));
        txtCupo.setText(String.valueOf(curso.getCupo()));
        fechaInicio.setDate(curso.getFechaInicio());
        fechaFinalizacion.setDate(curso.getFechaFinalizacion());
        elegirComboLugarCurso(curso.getIdLugarCurso().getDetalle());
        
        }
        
        
    }//GEN-LAST:event_cbxNombreCursoItemStateChanged

    public void elegirComboLugarCurso(String detalle){
        cbxLugarCurso.removeAllItems();
        cargarComboLugarCurso(cbxLugarCurso);
        for (int i = 0; i < cbxLugarCurso.getItemCount(); i++) {
                if (cbxLugarCurso.getItemAt(i).getDetalle().equalsIgnoreCase(detalle)) {
                    cbxLugarCurso.setSelectedIndex(i);
                }
            }
    }
    
    
    private void txtcosto2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcosto2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcosto2ActionPerformed

    private void txtCicloLectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCicloLectivoKeyTyped

    }//GEN-LAST:event_txtCicloLectivoKeyTyped

    private void txtCupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCupoKeyTyped

    }//GEN-LAST:event_txtCupoKeyTyped

    private void txtcostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcostoKeyTyped

    }//GEN-LAST:event_txtcostoKeyTyped

    private void TablaHorario2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaHorario2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaHorario2MouseClicked

    private void TablaHorario1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaHorario1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TablaHorario1MouseClicked

    private void cboxNuevoHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxNuevoHorarioActionPerformed

        if (cboxNuevoHorario.isSelected()) {
            llenarTablaHorario(TablaHorario1);
            btnAgregarHorario.setEnabled(true);
        } else {
            vaciarTablas(TablaHorario1);
            vaciarTablas(TablaHorario2);
        }
        
    }//GEN-LAST:event_cboxNuevoHorarioActionPerformed

    private void btnAgregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHorarioActionPerformed
        llenarTabladeHorario2(TablaHorario2);
    }//GEN-LAST:event_btnAgregarHorarioActionPerformed

    public void llenarTabladeHorario2(JTable tabla){
        int filaSeleccionada = TablaHorario1.getSelectedRow();
        
        if (filaSeleccionada>=0) {
            String datos[] = new String[3];
            datos[0]=TablaHorario1.getValueAt(filaSeleccionada, 0).toString();
            datos[1]=TablaHorario1.getValueAt(filaSeleccionada, 1).toString();
            datos[2]=TablaHorario1.getValueAt(filaSeleccionada, 2).toString();
            modelo2.addRow(datos);
        }
        banderaTabla=1;
    }
    
    public void vaciarTablas(JTable tabla){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Dia");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        tabla.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaHorario1;
    private javax.swing.JTable TablaHorario2;
    private javax.swing.JButton btnAgregarHorario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevoTurno;
    private javax.swing.JButton btnNuevoTurno1;
    private javax.swing.JCheckBox cboxNuevoHorario;
    private javax.swing.JComboBox<LugarCurso> cbxLugarCurso;
    private javax.swing.JComboBox<TipoCurso> cbxNombreCurso;
    private javax.swing.JComboBox<String> cbxTurno;
    private com.toedter.calendar.JDateChooser fechaFinalizacion;
    private com.toedter.calendar.JDateChooser fechaInicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtCicloLectivo;
    private javax.swing.JTextField txtCupo;
    private javax.swing.JTextField txtcosto;
    private javax.swing.JTextField txtcosto2;
    private javax.swing.JLabel txtidCurso;
    // End of variables declaration//GEN-END:variables
//Conectar x = new Conectar();
  //   Connection con = x.conexion();
}
