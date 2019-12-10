/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import Controlador.CtrlCurso;
import Controlador.CtrlCursoHora;
import Controlador.CtrlHorario;
import Controlador.CtrlLugarCurso;
import Controlador.CtrlTipoCurso;
import com.sun.glass.events.KeyEvent;
import principal.Principal;
import configuracion.Cursado_crear;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.TipoCurso;
import modelo.LugarCurso;


/**
 *
 * @author araa
 */
public final class CrearCurso extends javax.swing.JInternalFrame {
    public static int origenBandera=0;
   public DefaultTableModel  modelo2 = null, modelo3 = null;
   Connection con = clases.Conectar.conexion();
   public int bandera=0;
   CtrlTipoCurso ctrlTipoCurso=null;
   CtrlLugarCurso ctrlLugarCurso=null;
   Date fechaInicio1 = null;
   Date fechaFinalizacion1 = null;
   CtrlCurso ctrlCurso = null;
   CtrlHorario ctrlHorario = null;
   LugarCurso lugarCurso = null;
   TipoCurso tipoCurso=null;
   CtrlCursoHora ctrlCursoHora = null;

     /**
     * Creates new form NewJInternalFrame
     */
    public CrearCurso() {
        //modelo1 = new DefaultTableModel();
        modelo2 = new DefaultTableModel();
        modelo3 = new DefaultTableModel();
        ctrlTipoCurso = new CtrlTipoCurso();
        ctrlLugarCurso = new CtrlLugarCurso();
        fechaInicio1 = new Date();
        fechaFinalizacion1 = new Date();
        ctrlCurso = new CtrlCurso();
        ctrlHorario = new CtrlHorario();
        lugarCurso = new LugarCurso();
        tipoCurso = new TipoCurso();
        ctrlCursoHora = new CtrlCursoHora();
        
        initComponents();
        ctrlTipoCurso.cargarCombo(cbxNombreCurso);
        ctrlLugarCurso.cargarCombo(cbxLugarCurso);
        llenarTablaHorario(TablaHorario);
        llenarTablaHorario2(TablaHorario2);
    }
    
    public void vaciarTablas(JTable tabla){
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Dia");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        tabla.setModel(modelo);
    }
    
    public void vaciarTablas2(JTable tabla){
        DefaultTableModel modelo =new DefaultTableModel();
        modelo3.addColumn("Dia");
        modelo3.addColumn("Desde");
        modelo3.addColumn("Hasta");
        tabla.setModel(modelo3);
    }
    
    public void llenarTablaHorario2(JTable tabla){
        modelo3.addColumn("Dia");
        modelo3.addColumn("Desde");
        modelo3.addColumn("Hasta");
        tabla.setModel(modelo3);
    }
    
    
    public void llenarTabladeHorario2(JTable tabla){
        int filaSeleccionada = TablaHorario.getSelectedRow();
        //JOptionPane.showMessageDialog(null, TablaHorario.getSelectionModel());
        if (filaSeleccionada>=0) {
            
            //modelo3.addRow(TablaHorario.getSelectedRow());
            
            
            String datos[] = new String[3];
            datos[0]=TablaHorario.getValueAt(filaSeleccionada, 0).toString();
            datos[1]=TablaHorario.getValueAt(filaSeleccionada, 1).toString();
            datos[2]=TablaHorario.getValueAt(filaSeleccionada, 2).toString();
            modelo3.addRow(datos);
            
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
            
        } catch (SQLException e) {
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtcosto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtCicloLectivo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCupo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbxNombreCurso = new javax.swing.JComboBox<TipoCurso>();
        btnCrearTipoCurso = new javax.swing.JButton();
        cbxTurno = new javax.swing.JComboBox<String>();
        cbxLugarCurso = new javax.swing.JComboBox<LugarCurso>();
        jLabel15 = new javax.swing.JLabel();
        btnCursado = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TablaHorario = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        btnAgregarHorario = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaHorario2 = new javax.swing.JTable();
        BotonAgregar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        fechaFinalizacion = new com.toedter.calendar.JDateChooser();
        btnActualizarPlanes1 = new javax.swing.JButton();
        btnActualizarPlanes2 = new javax.swing.JButton();
        btnActualizarPlanes3 = new javax.swing.JButton();
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

        txtCicloLectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCicloLectivoActionPerformed(evt);
            }
        });
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

        btnCrearTipoCurso.setBackground(new java.awt.Color(38, 86, 186));
        btnCrearTipoCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnCrearTipoCurso.setText("Crear Nuevo Curso");
        btnCrearTipoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTipoCursoActionPerformed(evt);
            }
        });

        cbxTurno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Mañana", "Tarde", "Vespertino", "Noche" }));
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

        btnCursado.setBackground(new java.awt.Color(38, 86, 186));
        btnCursado.setForeground(new java.awt.Color(255, 255, 255));
        btnCursado.setText("Agregar Lugar");
        btnCursado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursadoActionPerformed(evt);
            }
        });

        TablaHorario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DIA", "DESDE", "HASTA"
            }
        ));
        TablaHorario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaHorarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TablaHorario);

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

        btnAgregarHorario.setBackground(new java.awt.Color(38, 86, 186));
        btnAgregarHorario.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarHorario.setText("Crear Horario");
        btnAgregarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarHorarioActionPerformed(evt);
            }
        });

        TablaHorario2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "DIA", "DESDE", "HASTA"
            }
        ));
        jScrollPane4.setViewportView(TablaHorario2);

        BotonAgregar.setText(">>");
        BotonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonAgregarActionPerformed(evt);
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

        btnActualizarPlanes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar(2).png"))); // NOI18N
        btnActualizarPlanes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPlanes1ActionPerformed(evt);
            }
        });

        btnActualizarPlanes2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar(2).png"))); // NOI18N
        btnActualizarPlanes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPlanes2ActionPerformed(evt);
            }
        });

        btnActualizarPlanes3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar(2).png"))); // NOI18N
        btnActualizarPlanes3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarPlanes3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addGap(12, 12, 12)
                        .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btnActualizarPlanes1)
                        .addGap(8, 8, 8)
                        .addComponent(btnCrearTipoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34)
                        .addComponent(txtCicloLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel10)
                        .addGap(106, 106, 106)
                        .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addGap(23, 23, 23)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel5)
                        .addGap(3, 3, 3)
                        .addComponent(fechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addGap(84, 84, 84)
                        .addComponent(txtCupo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel3)
                        .addGap(40, 40, 40)
                        .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(BotonAgregar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnActualizarPlanes3)))
                        .addGap(118, 118, 118)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(btnCursado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(353, 353, 353)
                        .addComponent(btnAgregarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(cbxLugarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizarPlanes2)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnActualizarPlanes1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnCrearTipoCurso)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel2))
                    .addComponent(txtCicloLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(fechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel15))
                    .addComponent(cbxLugarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizarPlanes2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCursado)
                    .addComponent(btnAgregarHorario))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(BotonAgregar))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarPlanes3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelar))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(38, 86, 186));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(102, 102, 255));
        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Crear Curso");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 12, 187, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 858, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (!txtCicloLectivo.getText().equalsIgnoreCase("")) {
            String yearInicio1 = fechaInicio.getDate().toString();
            
            int cicloLectivo = Integer.parseInt(txtCicloLectivo.getText());
            String yearFinalizacion1 = fechaFinalizacion.getDate().toString();

            int yearInicio = Integer.parseInt(yearInicio1.substring(24, yearInicio1.length()));
            int yearFinalizacion = Integer.parseInt(yearFinalizacion1.substring(24, yearFinalizacion1.length()));
            
            if (cicloLectivo > yearInicio) {
                JOptionPane.showMessageDialog(null, "El año lectivo es mayor al año de inicio de curso\n "
                        + "Por favor revice bien las fechas");
            } else {
                if (cicloLectivo > yearFinalizacion) {
                    JOptionPane.showMessageDialog(null, "El año lectivo es mayor al año de finalizacion de curso\n"
                            + "Por favor revice bien las fechas");
                } else {
                    if (yearFinalizacion > yearInicio) {
                        JOptionPane.showMessageDialog(null, "El año de finalizacion de curso es mayor al de inicio\n"
                                + "Por favor revice bien las fechas");
                    } else {

                        String turno = (String) cbxTurno.getSelectedItem();

                        int turnoInt = 0;
                        if (turno.equalsIgnoreCase("Mañana")) {
                            turnoInt = 1;
                        } else {
                            if (turno.equalsIgnoreCase("Tarde")) {
                                turnoInt = 2;
                            } else {
                                if (turno.equalsIgnoreCase("Vespertino")) {
                                    turnoInt = 3;
                                } else {
                                    if (turno.equalsIgnoreCase("Noche")) {
                                        turnoInt = 4;
                                    }
                                }
                            }
                        }

                        if (cbxNombreCurso.getSelectedIndex() == 0 || txtCicloLectivo.getText().equalsIgnoreCase("")
                                || cbxTurno.getSelectedIndex() == 0 || fechaInicio.getDate().toString().equalsIgnoreCase("")
                                || fechaFinalizacion.getDate().toString().equalsIgnoreCase("") || txtCupo.getText().equalsIgnoreCase("")
                                || txtcosto.getText().equalsIgnoreCase("") || cbxLugarCurso.getSelectedIndex() == 0 || bandera == 0) {

                            JOptionPane.showMessageDialog(null, "No se pueden cargar registros vacios");
                        } else {
                            lugarCurso = (LugarCurso) cbxLugarCurso.getSelectedItem();
                            tipoCurso = (TipoCurso) cbxNombreCurso.getSelectedItem();

                            fechaInicio1 = fechaInicio.getDate();
                            fechaFinalizacion1 = fechaFinalizacion.getDate();
                            long i = fechaInicio1.getTime();
                            long f = fechaFinalizacion1.getTime();
                            java.sql.Date fecha1 = new java.sql.Date(i);
                            java.sql.Date fecha2 = new java.sql.Date(f);

                            ctrlCurso.crear(Integer.parseInt(txtCicloLectivo.getText()), turnoInt,
                                    Float.parseFloat(txtcosto.getText()), Integer.parseInt(txtCupo.getText()),
                                    fecha1, fecha2,
                                    tipoCurso.getIdTipoCurso(), lugarCurso.getIdLugarCurso(), false);

                            cbxNombreCurso.removeAllItems();
                            cbxLugarCurso.removeAllItems();
                            ctrlLugarCurso.cargarCombo(cbxLugarCurso);
                            ctrlTipoCurso.cargarCombo(cbxNombreCurso);
                            cbxTurno.setSelectedIndex(0);
                            fechaInicio.setDate(null);
                            fechaFinalizacion.setDate(null);
                            txtCicloLectivo.setText("");
                            txtCupo.setText("");
                            txtcosto.setText("");

            //Cargar tabla cursoHorarios
                            int idCurso = ctrlCurso.traerUltimoId();
                            //JOptionPane.showMessageDialog(null, idCurso);
                            cargarCursoHorario(idCurso);
                            //JOptionPane.showMessageDialog(null, "POR AQUI TAMBIEN");
                            vaciarTablas(TablaHorario);
                            vaciarTablas(TablaHorario2);
                        }
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cargue un ciclo lectivo");
        }

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        //llenarTablaHorario(TablaHorario2);
            //llenarTablaHorario2(TablaHorario2);
            //vaciarTablas2(TablaHorario2);
            llenarTabladeHorario2(TablaHorario2);
            bandera = 1;
        
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void btnAgregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHorarioActionPerformed
        // TODO add your handling code here:
        //vaciarTablas(TablaHorario);
        //vaciarTablas(TablaHorario2);

        origenBandera=1;
        
        Horario curso=new Horario();
        Principal.principal.add(curso);
        this.setComponentZOrder(curso, 0);
        curso.setVisible(true);
    }//GEN-LAST:event_btnAgregarHorarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void TablaHorarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaHorarioMouseClicked

    }//GEN-LAST:event_TablaHorarioMouseClicked

    private void btnCursadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursadoActionPerformed
        // TODO add your handling code here:
        vaciarTablas(TablaHorario);
        vaciarTablas(TablaHorario2);
        
        Cursado_crear configuracion=null;
        try {
            configuracion = new Cursado_crear();
            Principal.principal.add(configuracion);
            this.setComponentZOrder(configuracion, 0);
            configuracion.setVisible(true);
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearCurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnCursadoActionPerformed

    private void cbxLugarCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLugarCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLugarCursoActionPerformed

    private void cbxLugarCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxLugarCursoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLugarCursoMouseClicked

    private void cbxLugarCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxLugarCursoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLugarCursoItemStateChanged

    private void cbxTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTurnoActionPerformed

    }//GEN-LAST:event_cbxTurnoActionPerformed

    private void btnCrearTipoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTipoCursoActionPerformed
        // TODO add your handling code here:
        //vaciarTablas(TablaHorario);
        //vaciarTablas(TablaHorario2);

        CrearTipoCurso curso=new CrearTipoCurso();
        Principal.principal.add(curso);
        this.setComponentZOrder(curso, 0);
        curso.setVisible(true);

    }//GEN-LAST:event_btnCrearTipoCursoActionPerformed

   @Override
    public boolean isOptimizedDrawingEnabled(){
        return false;
    }
    private void cbxNombreCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNombreCursoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNombreCursoActionPerformed

    private void cbxNombreCursoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxNombreCursoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNombreCursoMouseClicked

    private void cbxNombreCursoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxNombreCursoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNombreCursoItemStateChanged

    private void txtCupoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCupoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCupoKeyTyped

    private void txtCupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCupoActionPerformed

    private void txtCicloLectivoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCicloLectivoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCicloLectivoKeyTyped

    private void txtCicloLectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCicloLectivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCicloLectivoActionPerformed

    private void txtcostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcostoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcostoKeyTyped

    private void txtcostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcostoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtcostoActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnGuardarActionPerformed(e);
        }
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnCancelarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnCancelarKeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.btnCancelarActionPerformed(e);
        }
    }//GEN-LAST:event_btnCancelarKeyPressed

    private void btnActualizarPlanes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPlanes1ActionPerformed
        cbxNombreCurso.removeAllItems();
        ctrlTipoCurso.cargarCombo(cbxNombreCurso);
    }//GEN-LAST:event_btnActualizarPlanes1ActionPerformed

    private void btnActualizarPlanes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPlanes2ActionPerformed
        cbxLugarCurso.removeAllItems();
        ctrlLugarCurso.cargarCombo(cbxLugarCurso);
    }//GEN-LAST:event_btnActualizarPlanes2ActionPerformed

    private void btnActualizarPlanes3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarPlanes3ActionPerformed
        vaciarTablas(TablaHorario);
        llenarTablaHorario(TablaHorario);
        //vaciarTablas(TablaHorario2);
        bandera=0;
        //llenarTablaHorario2(TablaHorario2);
    }//GEN-LAST:event_btnActualizarPlanes3ActionPerformed

    public void cargarCursoHorario(int idCurso){
        for (int i = 0; i < modelo2.getRowCount(); i++) {
            
            String dia = (String) TablaHorario2.getValueAt(i, 0);
            String desde = (String) TablaHorario2.getValueAt(i, 1);
            String hasta = (String) TablaHorario2.getValueAt(i, 2);
            
            Time desde1 = Time.valueOf(desde);
            Time hasta1 = Time.valueOf(hasta);
            
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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    public static javax.swing.JTable TablaHorario;
    public static javax.swing.JTable TablaHorario2;
    private javax.swing.JButton btnActualizarPlanes1;
    private javax.swing.JButton btnActualizarPlanes2;
    private javax.swing.JButton btnActualizarPlanes3;
    private javax.swing.JButton btnAgregarHorario;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearTipoCurso;
    private javax.swing.JButton btnCursado;
    private javax.swing.JButton btnGuardar;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtCicloLectivo;
    private javax.swing.JTextField txtCupo;
    private javax.swing.JTextField txtcosto;
    // End of variables declaration//GEN-END:variables
//Conectar x = new Conectar();
  //   Connection con = x.conexion();
}
