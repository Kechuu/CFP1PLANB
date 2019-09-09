/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazAlumno;

import Controlador.CtrlAlumno;
import Controlador.CtrlCodigoPostal;
import Controlador.CtrlCurso;
import Controlador.CtrlCursoAlumno;
import Controlador.CtrlDomicilio;
import Controlador.CtrlEdificio;
import Controlador.CtrlEstadoAlumno;
import Controlador.CtrlPeriodo;
import Controlador.CtrlPersona;
import Controlador.CtrlPersonaTrabajo;
import Controlador.CtrlPlanPersona;
import Controlador.CtrlTipoDocumento;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import menu.Principal;
import modelo.Alumno;
import modelo.Curso;
import modelo.Domicilio;
import modelo.Edificio;
import modelo.Lugar;
import modelo.Nacionalidad;
import modelo.Persona;
import modelo.Planes;
import modelo.TipoCurso;
import modelo.TipoDocumento;
<<<<<<< HEAD
import modelo.Trabajo;
=======
import modelo.Lugar;
>>>>>>> 0fc1aca62c37cbff9225c6ec3675ae559b3b8fbb
/**
 *
 * @author
 */
public final class Inscripcion extends javax.swing.JInternalFrame {
    
    Connection con = clases.Conectar.conexion();
    CtrlTipoDocumento tipo = new CtrlTipoDocumento();
    /**
     * Creates new form InscripcionAlumno
     * @throws java.lang.ClassNotFoundException
     */
    public Inscripcion() throws ClassNotFoundException {
       initComponents();
       
       //cbTipo.addItem(tipo.leer());
       cargarComboTipoDocumento(cbTipo);
       cargarComboLocalidad(cbLocalidad);
       cargarComboPlan(cbPlan);
       cargarComboTrabajo(cbTrabajo);
       cargarComboLocalidad(cbNacimiento);
       cargarComboNacionalidad(cbNacionalidad);
       cargarListaCurso();
    }
    
    
    public void cargarComboTipoDocumento(JComboBox<TipoDocumento> cbTipoDoc){
        
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM tipoDocumento ORDER BY detalle ASC");
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setIdTipoDocumento(0);
            tipoDocumento.setDetalle("Seleccione una opcion...");
            cbTipoDoc.addItem(tipoDocumento);
            
            while (rs.next()) {                
                tipoDocumento = new TipoDocumento();
                
                tipoDocumento.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                tipoDocumento.setDetalle(rs.getString("detalle"));
                cbTipoDoc.addItem(tipoDocumento);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento");       
        }
        
    }
    
    public void cargarComboLocalidad(JComboBox<Lugar> comboLocalidad){//Este metodo para llenar el combo con las localidades 
        try {
            
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM lugar WHERE nivel = 3 ORDER BY nombre ASC");
            Lugar dat= new Lugar();
            dat.setIdLugar(0);
            dat.setNombre("Selecciona una opción...");
            dat.setNivel(0);
            dat.setDe(0);
            comboLocalidad.addItem(dat);

            while(rs.next()){
                dat= new Lugar();
                
                dat.setIdLugar(rs.getInt("idLugar"));
                dat.setNombre(rs.getString("nombre"));
                dat.setNivel(rs.getInt("nivel"));
                dat.setDe(rs.getInt("de"));
                
                comboLocalidad.addItem(dat); 
            }
                
        } catch (SQLException ex) {
         
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Las localidades");
        }
    }
    
    public Vector<Lugar> cargarFiltrado(int idLugar, int nivel) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Lugar> datos = new Vector<>();
        Lugar dat = null;
        try {
            String sql = "SELECT * FROM lugar WHERE nivel=? and de =" + idLugar;
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, nivel);
            
            rs = ps.executeQuery();
            dat = new Lugar();
            dat.setIdLugar(0);
            dat.setNombre("Seleccionae una opción...");
            datos.add(dat);
                while (rs.next()) {
                    dat = new Lugar();
                    dat.setIdLugar(rs.getInt("idLugar"));
                    dat.setNombre(rs.getString("nombre"));
                    datos.add(dat);
                }
                rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
       
    public void cargarComboPlan(JComboBox <Planes> cb){
        
        try{
            Statement st= (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from planes ORDER BY detalle ASC");
            
            Planes plan= new Planes();
            plan.setIdPlanes(0);
            plan.setDetalle("Seleccione un plan...");
            cb.addItem(plan);
            
            while(rs.next()){
                plan= new Planes();
                
                plan.setIdPlanes(rs.getInt("idPlanes"));
                plan.setDetalle(rs.getString("detalle"));
                
                cb.addItem(plan);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    public void cargarComboTrabajo(JComboBox <Trabajo> cb){
        
        try{
            Statement st= (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from trabajo ORDER BY detalle ASC");
            
         
            Trabajo trabajo = new Trabajo();
            trabajo.setIdTrabajo(0);
            trabajo.setDetalle("Selecciones una opción...");
            
            cb.addItem(trabajo);
            
            while(rs.next()){
                trabajo= new Trabajo();
                
                trabajo.setIdTrabajo(rs.getInt("idTrabajo"));
                trabajo.setDetalle(rs.getString("detalle"));
                cb.addItem(trabajo);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    public void cargarComboNacionalidad(JComboBox <Nacionalidad> cb){
        
        try{
            Statement st= (Statement) con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from nacionalidad ORDER BY detalle ASC");
            
           
            Nacionalidad nacion= new Nacionalidad();
            nacion.setIdNacionalidad(0);
            nacion.setDetalle("Seleccione una opción...");
           
            cb.addItem(nacion);
            
            while(rs.next()){
                
                nacion= new Nacionalidad();
                
                nacion.setIdNacionalidad(rs.getInt("idNacionalidad"));
                nacion.setDetalle(rs.getString("detalle"));
                cb.addItem(nacion);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    public void cargarListaCurso(){
        CtrlPeriodo ctrlPeriodo = new CtrlPeriodo();
        
        DefaultListModel<TipoCurso> modelo=new DefaultListModel<>();
        
        try {
            Statement st=(Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT * from tipoCurso");
            
            while (rs.next()) {
                TipoCurso tipoCurso = new TipoCurso();
        
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setCosto(rs.getFloat("costo"));
                tipoCurso.setIdPeriodo(ctrlPeriodo.leer(rs.getInt("idPeriodo")));
                
                modelo.addElement(tipoCurso);
            }
            
            listDisponible.setModel(modelo);
            
        } catch (SQLException e) {
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

        jPanel1 = new javax.swing.JPanel();
        panelContenedor = new javax.swing.JTabbedPane();
        panelInscripcion = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        femenino = new javax.swing.JRadioButton();
        masculino = new javax.swing.JRadioButton();
        txtCuil = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cbNacionalidad = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        cbNacimiento = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        cbTipo = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbLocalidad = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        cbBarrio = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtDepto = new javax.swing.JTextField();
        panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtFijo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        cbCalle = new javax.swing.JComboBox<>();
        txtCasa = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtBloque = new javax.swing.JTextField();
        txtPiso = new javax.swing.JTextField();
        panelOtros = new javax.swing.JPanel();
        cbPlan = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        cbTrabajo = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        txtHijos = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        listPlan = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        listTrabajo = new javax.swing.JList<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnAsignar1 = new javax.swing.JButton();
        btnAsignar = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        btnCurso = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnCurso1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        listDetalle = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        listCurso = new javax.swing.JList<>();
        jScrollPane7 = new javax.swing.JScrollPane();
        listDisponible = new javax.swing.JList<>();
        btnGuardar = new javax.swing.JButton();
        btnPago = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanelWebCam1 = new JPanelWebCam.JPanelWebCam();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(220, 203, 203));

        panelInscripcion.setBackground(new java.awt.Color(255, 255, 255));
        panelInscripcion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Nombre");

        txtNombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Apellido");

        txtApellido.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        femenino.setBackground(new java.awt.Color(255, 255, 255));
        femenino.setText("Femenino");
        jPanel3.add(femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        masculino.setBackground(new java.awt.Color(255, 255, 255));
        masculino.setText("Masculino");
        masculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masculinoActionPerformed(evt);
            }
        });
        jPanel3.add(masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        txtCuil.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setText("CUIL");

        txtDni.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel17.setText("N° de documento");

        jLabel13.setText("Tipo Documento");

        cbNacionalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbNacionalidad.setToolTipText("");

        jLabel14.setText("Nacionalidad");

        cbNacimiento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbNacimiento.setToolTipText("");

        jLabel15.setText("Lugar De Nacimiento");

        jLabel5.setText("Fecha de nacimiento");

        cbTipo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTipo.setToolTipText("");

        javax.swing.GroupLayout panelInscripcionLayout = new javax.swing.GroupLayout(panelInscripcion);
        panelInscripcion.setLayout(panelInscripcionLayout);
        panelInscripcionLayout.setHorizontalGroup(
            panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInscripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInscripcionLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(cbTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(panelInscripcionLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelInscripcionLayout.createSequentialGroup()
                        .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addGroup(panelInscripcionLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelInscripcionLayout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel14)
                                    .addGroup(panelInscripcionLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInscripcionLayout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(99, 99, Short.MAX_VALUE))))
        );
        panelInscripcionLayout.setVerticalGroup(
            panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInscripcionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCuil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel8)
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelInscripcionLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelInscripcionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbNacionalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelInscripcionLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(63, 63, 63))
        );

        panelContenedor.addTab("Inscripcion", panelInscripcion);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setText("Localidad");

        cbLocalidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbLocalidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLocalidadItemStateChanged(evt);
            }
        });

        jLabel16.setText("Código postal");

        txtCodigo.setEditable(false);
        txtCodigo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        cbBarrio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbBarrio.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbBarrioItemStateChanged(evt);
            }
        });

        jLabel19.setText("Barrio");

        jLabel22.setText("Bloque");

        jLabel23.setText("Piso");

        jLabel24.setText("N° de departamento");

        txtDepto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "contactos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        jLabel11.setText("Celular");

        txtCelular.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel18.setText("Telefono Fijo");

        txtFijo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel10.setText("Correo");

        txtCorreo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(txtFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel21.setText("Calle");

        cbCalle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtCasa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel20.setText("N° de casa");

        txtBloque.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        txtPiso.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbBarrio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(18, 18, 18)
                            .addComponent(cbCalle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBloque, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61))))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel22)
                                .addComponent(txtBloque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(txtPiso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)
                            .addComponent(txtDepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(77, 77, 77)))
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelContenedor.addTab("Domicilio", jPanel7);

        panelOtros.setBackground(new java.awt.Color(255, 255, 255));

        cbPlan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlanActionPerformed(evt);
            }
        });

        jLabel7.setText("Planes");

        jLabel26.setText("Trabajo");

        cbTrabajo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbTrabajo.setToolTipText("");

        jLabel25.setText("Cantidad de hijos");

        txtHijos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jScrollPane3.setViewportView(listPlan);

        jScrollPane4.setViewportView(listTrabajo);

        jLabel27.setText("Planes que posee");

        jLabel28.setText("Trabajos actuales");

        btnAsignar1.setText("Asignar");
        btnAsignar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignar1ActionPerformed(evt);
            }
        });

        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelOtrosLayout = new javax.swing.GroupLayout(panelOtros);
        panelOtros.setLayout(panelOtrosLayout);
        panelOtrosLayout.setHorizontalGroup(
            panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOtrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOtrosLayout.createSequentialGroup()
                        .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelOtrosLayout.createSequentialGroup()
                                .addGap(0, 64, Short.MAX_VALUE)
                                .addComponent(cbTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelOtrosLayout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAsignar)))
                        .addGap(119, 119, 119)
                        .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelOtrosLayout.createSequentialGroup()
                        .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelOtrosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelOtrosLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAsignar1)))
                        .addGap(119, 119, 119)
                        .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelOtrosLayout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtHijos, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelOtrosLayout.setVerticalGroup(
            panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelOtrosLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtHijos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel7)
                    .addComponent(btnAsignar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelOtrosLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(panelOtrosLayout.createSequentialGroup()
                        .addComponent(cbPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelOtrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAsignar)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))))
        );

        panelContenedor.addTab("Otros datos", panelOtros);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Curso disponibles");

        btnCurso.setBackground(new java.awt.Color(38, 86, 186));
        btnCurso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnCurso.setText("Asignar");
        btnCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Cursos inscriptos");

        btnCurso1.setBackground(new java.awt.Color(38, 86, 186));
        btnCurso1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCurso1.setForeground(new java.awt.Color(255, 255, 255));
        btnCurso1.setText("Asignar");
        btnCurso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurso1ActionPerformed(evt);
            }
        });

        jScrollPane5.setViewportView(listDetalle);

        jScrollPane6.setViewportView(listCurso);

        listDisponible.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listDisponibleValueChanged(evt);
            }
        });
        jScrollPane7.setViewportView(listDisponible);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(btnCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addComponent(btnCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(btnCurso)
                    .addComponent(btnCurso1)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelContenedor.addTab("Asignación a cursos", jPanel10);

        btnGuardar.setBackground(new java.awt.Color(38, 86, 186));
        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar e inscribir");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnPago.setBackground(new java.awt.Color(38, 86, 186));
        btnPago.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPago.setForeground(new java.awt.Color(255, 255, 255));
        btnPago.setText("Pago");
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(38, 86, 186));
        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelWebCam1Layout = new javax.swing.GroupLayout(jPanelWebCam1);
        jPanelWebCam1.setLayout(jPanelWebCam1Layout);
        jPanelWebCam1Layout.setHorizontalGroup(
            jPanelWebCam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelWebCam1Layout.setVerticalGroup(
            jPanelWebCam1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 201, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanelWebCam1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanelWebCam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(38, 86, 186));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Carga De Datos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(742, 742, 742)
                .addComponent(jLabel1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        
    }//GEN-LAST:event_btnPagoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        Principal.activarPanel();
        dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void masculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masculinoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_masculinoActionPerformed

    private void cbPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPlanActionPerformed

    private void cbLocalidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLocalidadItemStateChanged

        if(evt.getStateChange()==ItemEvent.SELECTED){
            if(cbLocalidad.getSelectedIndex()!=0){
                Lugar lugar;
                lugar=(Lugar)cbLocalidad.getSelectedItem();           
                DefaultComboBoxModel modelo=new DefaultComboBoxModel(cargarFiltrado(lugar.getIdLugar(), 2));
            
                cbBarrio.setModel(modelo);
                
                CtrlCodigoPostal cod=new CtrlCodigoPostal();
                
                txtCodigo.setText(String.valueOf(cod.leer(lugar.getIdLugar())));
            }
        }
        
    }//GEN-LAST:event_cbLocalidadItemStateChanged

    private void cbBarrioItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbBarrioItemStateChanged

        if(evt.getStateChange()== ItemEvent.SELECTED){
            if(cbBarrio.getSelectedIndex()!=0){
                Lugar lugar=new Lugar();
                lugar=(Lugar)cbBarrio.getSelectedItem();
                DefaultComboBoxModel modelo=new DefaultComboBoxModel(cargarFiltrado(lugar.getIdLugar(),1));
            
                cbCalle.setModel(modelo);
                
            }
        }
    }//GEN-LAST:event_cbBarrioItemStateChanged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Lugar lugar=(Lugar) cbCalle.getSelectedItem();
        TipoDocumento doc=(TipoDocumento) cbTipo.getSelectedItem();
        Nacionalidad nacion=(Nacionalidad) cbNacionalidad.getSelectedItem();
        Lugar nacimiento=(Lugar)cbNacimiento.getSelectedItem();
        
        CtrlEdificio edificio=new CtrlEdificio();
        CtrlDomicilio domicilio=new CtrlDomicilio();
        CtrlPersona persona=new CtrlPersona();
        CtrlPlanPersona planes=new CtrlPlanPersona();
        CtrlPersonaTrabajo trabajo=new CtrlPersonaTrabajo();
        CtrlAlumno alumno=new CtrlAlumno();
        CtrlCursoAlumno cursoAlumno= new CtrlCursoAlumno();
        CtrlEstadoAlumno estadoAlumno=new CtrlEstadoAlumno();
        CtrlCurso curso=new CtrlCurso();
        
        Edificio leer=new Edificio();
        Domicilio leerDomicilio=new Domicilio();
        Persona leerPersona=new Persona();
        Alumno leerAlumno=new Alumno();
        
        int idEdificio=0;
       
        if(txtBloque.equals("") && txtPiso.equals("") && txtDepto.equals("")){  
            
            edificio.crear(Integer.parseInt(txtBloque.getText().trim()), Integer.parseInt(txtPiso.getText().trim()), Integer.parseInt(txtDepto.getText().trim()));          
            //edificio.crear(1, 1, 1);
            leer=edificio.leer();
            idEdificio=leer.getIdEdificio();
        }
        
        domicilio.crear(Integer.parseInt(txtCasa.getText()), txtFijo.getText(), lugar.getIdLugar(), idEdificio);
        leerDomicilio=domicilio.leer();
        
        persona.crear(txtNombre.getText(), txtApellido.getText(), (Date) fecha.getDate(), false, txtCuil.getText(), Integer.parseInt(txtHijos.getText()), txtCorreo.getText(), Integer.parseInt(txtCelular.getText()), leerDomicilio.getIdDomicilio(), doc.getIdTipoDocumento(), nacion.getIdNacionalidad(), 1, nacimiento.getIdLugar(), false);
        
        leerPersona=persona.leer();
        
        ListModel<Planes> listaPlan=listPlan.getModel();
        ListModel<Trabajo>listaTrabajo=listTrabajo.getModel();
        ListModel<TipoCurso>listaInscripto=listCurso.getModel();
        
        for(int i=0; i<listaPlan.getSize(); i++){
            planes.crear(leerPersona.getIdPersona(), listaPlan.getElementAt(i).getIdPlanes());           
        }       
        for(int i=0; i<listaTrabajo.getSize();i++){
            trabajo.crear(listaTrabajo.getElementAt(i).getIdTrabajo(), leerPersona.getIdPersona());
        }
        
        alumno.crear(leerPersona.getIdPersona());
        leerAlumno=alumno.leer();
        
        java.util.Date date= new java.util.Date();
        java.text.SimpleDateFormat sdf= new java.text.SimpleDateFormat("yyyy-mm-dd");
        String fechaHoy = sdf.format(date);
        
        /*VER LUEGO!!!!
        for(int i=0; i<listaInscripto.getSize(); i++){
            cursoAlumno.crear(1, (java.util.Date) date, leerAlumno.getIdAlumno(), estadoAlumno.leer(1).getIdEstadoAlumno(), curso.leer(listaInscripto.getElementAt(i).getIdTipoCurso()).getIdCurso(),1);
        }*/
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursoActionPerformed
        // TODO add your handling code here:
        DefaultListModel<TipoCurso> modelo=new DefaultListModel<>();
        
        modelo.addElement((TipoCurso)listDisponible.getSelectedValue());
        
        //listDisponible.remove(listDisponible.getSelectedIndex());
        
        listCurso.setModel(modelo);

    }//GEN-LAST:event_btnCursoActionPerformed

    
    private void btnCurso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCurso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCurso1ActionPerformed

    private void listDisponibleValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listDisponibleValueChanged

        CtrlCurso curso= new CtrlCurso();
        Curso obj=new Curso();
        DefaultListModel model=new DefaultListModel();
       
        obj=curso.leer(listDisponible.getSelectedValue().getIdTipoCurso());
        
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
        
        
        listDetalle.setModel(model);
    }//GEN-LAST:event_listDisponibleValueChanged

    private void btnAsignar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignar1ActionPerformed
        // TODO add your handling code here:
        if(cbPlan.getSelectedIndex()!=0){
            
            DefaultListModel <Planes> model= new DefaultListModel<>();
            
            model.addElement((Planes) cbPlan.getSelectedItem());
            cbPlan.removeItem(cbPlan.getSelectedItem());
            listPlan.setModel(model);
            
        }
        
    }//GEN-LAST:event_btnAsignar1ActionPerformed

    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        // TODO add your handling code here:
        
        if(cbTrabajo.getSelectedIndex()!=0){
            DefaultListModel <Trabajo> model=new DefaultListModel<>();
            
            model.addElement((Trabajo)cbTrabajo.getSelectedItem());
            cbTrabajo.removeItem(cbTrabajo.getSelectedItem());
            listTrabajo.setModel(model);
        }
    }//GEN-LAST:event_btnAsignarActionPerformed
    
    /*void validar(){
        if(txtNombre.getText().equals("") || txtApellido.getText().equals("") || txtCuil.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Faltan datos qué ingresar");
            return;
        }
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JButton btnAsignar1;
    private javax.swing.JButton btnCurso;
    private javax.swing.JButton btnCurso1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPago;
    private javax.swing.JButton btncancelar;
    private javax.swing.JComboBox<String> cbBarrio;
    private javax.swing.JComboBox<String> cbCalle;
    private javax.swing.JComboBox<Lugar> cbLocalidad;
<<<<<<< HEAD
    private javax.swing.JComboBox<Lugar> cbNacimiento;
    private javax.swing.JComboBox<Nacionalidad> cbNacionalidad;
    private javax.swing.JComboBox<Planes> cbPlan;
    private javax.swing.JComboBox<TipoDocumento> cbTipo;
    private javax.swing.JComboBox<Trabajo> cbTrabajo;
=======
    private javax.swing.JComboBox<String> cbNacimiento;
    private javax.swing.JComboBox<String> cbNacionalidad;
    private javax.swing.JComboBox<String> cbPlan;
    private javax.swing.JComboBox<TipoDocumento> cbTipoDoc;
    private javax.swing.JComboBox<String> cbTrabajo;
    private javax.swing.JComboBox<String> combopiso;
    private javax.swing.JComboBox<String> combotorre;
>>>>>>> 0fc1aca62c37cbff9225c6ec3675ae559b3b8fbb
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JRadioButton femenino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private JPanelWebCam.JPanelWebCam jPanelWebCam1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JList<TipoCurso> listCurso;
    private javax.swing.JList<String> listDetalle;
    private javax.swing.JList<TipoCurso> listDisponible;
    private javax.swing.JList<Planes> listPlan;
    private javax.swing.JList<Trabajo> listTrabajo;
    private javax.swing.JRadioButton masculino;
    private javax.swing.JPanel panel;
    private javax.swing.JTabbedPane panelContenedor;
    private javax.swing.JPanel panelInscripcion;
    private javax.swing.JPanel panelOtros;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtBloque;
    private javax.swing.JTextField txtCasa;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCuil;
    private javax.swing.JTextField txtDepto;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtFijo;
    private javax.swing.JTextField txtHijos;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPiso;
    // End of variables declaration//GEN-END:variables
}
