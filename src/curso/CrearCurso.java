/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso;

import Controlador.CtrlCurso;
import Controlador.CtrlCursoHora;
import Controlador.CtrlHorario;
import com.sun.glass.events.KeyEvent;
import menu.Principal;
import configuracion.Cursado_crear;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.TipoCurso;
import modelo.LugarCurso;


/**
 *
 * @author araa
 */
public class CrearCurso extends javax.swing.JInternalFrame {
    public static int origenBandera=0;
   public DefaultTableModel modelo2 = new DefaultTableModel();
   Connection con = clases.Conectar.conexion();
   public int bandera=0;
     /**
     * Creates new form NewJInternalFrame
     */
    public CrearCurso() {
        initComponents();
        cargarComboTipoCurso(cbxNombreCurso);
        cargarComboLugarCurso(cbxLugarCurso);
        llenarTablaHorario2(TablaHorario2);
    }
    
    public void vaciarTablas(JTable tabla){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Dia");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        tabla.setModel(modelo);
    }
    
    public void llenarTablaHorario2(JTable tabla){
        modelo2.addColumn("Dia");
        modelo2.addColumn("Desde");
        modelo2.addColumn("Hasta");
        tabla.setModel(modelo2);
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
    
    public void llenarTabladeHorario2(JTable tabla){
        int filaSeleccionada = TablaHorario.getSelectedRow();
        
        if (filaSeleccionada>=0) {
            String datos[] = new String[3];
            datos[0]=TablaHorario.getValueAt(filaSeleccionada, 0).toString();
            datos[1]=TablaHorario.getValueAt(filaSeleccionada, 1).toString();
            datos[2]=TablaHorario.getValueAt(filaSeleccionada, 2).toString();
            modelo2.addRow(datos);
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
        btnCrearTipoCurso = new javax.swing.JButton();
        btnAsigHora = new javax.swing.JButton();
        cbxTurno = new javax.swing.JComboBox<>();
        cbxLugarCurso = new javax.swing.JComboBox<>();
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

        fechaFinalizacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaFinalizacionKeyTyped(evt);
            }
        });

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
        btnCrearTipoCurso.setText("Nuevo Curso");
        btnCrearTipoCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTipoCursoActionPerformed(evt);
            }
        });

        btnAsigHora.setBackground(new java.awt.Color(38, 86, 186));
        btnAsigHora.setForeground(new java.awt.Color(255, 255, 255));
        btnAsigHora.setText("Asignar Horario");
        btnAsigHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsigHoraActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonAgregar)
                .addGap(118, 118, 118)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(23, 23, 23))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnCursado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCupo, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxLugarCurso, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCicloLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(185, 185, 185)
                .addComponent(btnAsigHora, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnAgregarHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearTipoCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addGap(75, 75, 75))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxNombreCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearTipoCurso))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbxTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCicloLectivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(fechaFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtcosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxLugarCurso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCursado))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregarHorario)
                            .addComponent(btnAsigHora))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCancelar)
                            .addComponent(btnGuardar))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(BotonAgregar)
                        .addGap(113, 113, 113))))
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
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Date fechaInicio1 = new Date();
        Date fechaFinalizacion1 = new Date();

        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlHorario ctrlHorario = new CtrlHorario();
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
            txtcosto.getText().equalsIgnoreCase("") || cbxLugarCurso.getSelectedIndex()==0 || bandera==0) {

            JOptionPane.showMessageDialog(null, "No se pueden cargar registros vacios");
        }else{
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
            cargarComboLugarCurso(cbxLugarCurso);
            cargarComboTipoCurso(cbxNombreCurso);
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

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void BotonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonAgregarActionPerformed
        llenarTabladeHorario2(TablaHorario2);
        bandera=1;
    }//GEN-LAST:event_BotonAgregarActionPerformed

    private void btnAgregarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarHorarioActionPerformed
        // TODO add your handling code here:
        vaciarTablas(TablaHorario);
        vaciarTablas(TablaHorario2);

        origenBandera=1;
        
        Horario curso=new Horario();
        Principal.panelPrincipal.add(curso);
        this.setComponentZOrder(curso, 0);
        curso.setVisible(true);
    }//GEN-LAST:event_btnAgregarHorarioActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
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
            Principal.panelPrincipal.add(configuracion);
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

    private void btnAsigHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsigHoraActionPerformed

        llenarTablaHorario(TablaHorario);

    }//GEN-LAST:event_btnAsigHoraActionPerformed

    private void btnCrearTipoCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTipoCursoActionPerformed
        // TODO add your handling code here:
        vaciarTablas(TablaHorario);
        vaciarTablas(TablaHorario2);

        CrearTipoCurso curso=new CrearTipoCurso();
        Principal.panelPrincipal.add(curso);
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

    private void fechaFinalizacionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaFinalizacionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaFinalizacionKeyTyped

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
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonAgregar;
    public static javax.swing.JTable TablaHorario;
    public static javax.swing.JTable TablaHorario2;
    private javax.swing.JButton btnAgregarHorario;
    private javax.swing.JButton btnAsigHora;
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
