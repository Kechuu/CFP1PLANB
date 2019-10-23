/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import configuracion.*;
import usuario.*;
import java.awt.Dimension;

import clases.CambiaPanel;
import com.sun.glass.events.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jesus
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    
    public static int menuAlumno=0;
    
    String respuesta=null;
    public static Dimension pantalla;
        
    
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        pantalla=panelPrincipal.getSize();
        
        desactivarPanel();
        Login log=new Login();
        panelPrincipal.add(log);
        log.setVisible(true);
        
        menuAlumno=0;
        this.setResizable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        labelInstitucion = new javax.swing.JLabel();
        panelPrincipal = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnAlumnos = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnListados = new javax.swing.JButton();
        btnLicencias = new javax.swing.JButton();
        btnCursos = new javax.swing.JButton();
        panelUsuarios = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        panelSubMenu = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menuConfiguracion = new javax.swing.JMenu();
        menuCalle = new javax.swing.JMenuItem();
        menuBarrio = new javax.swing.JMenuItem();
        menuLocalidad = new javax.swing.JMenuItem();
        menuNacionalidad = new javax.swing.JMenuItem();
        menuTipoDoc = new javax.swing.JMenuItem();
        meunCargo = new javax.swing.JMenuItem();
        menuTitulo = new javax.swing.JMenuItem();
        menuCaracterLicencia = new javax.swing.JMenuItem();
        menuPlan = new javax.swing.JMenuItem();
        menuGremio = new javax.swing.JMenuItem();
        menuSexo = new javax.swing.JMenuItem();
        menuLugarCursado = new javax.swing.JMenuItem();
        menuPeriodo = new javax.swing.JMenuItem();
        menuTrabajo = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();
        menuOpcionSalir = new javax.swing.JMenuItem();

        jMenuItem8.setText("jMenuItem8");

        jMenuItem9.setText("jMenuItem9");

        jMenuItem13.setText("jMenuItem13");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setMaximumSize(new java.awt.Dimension(1000, 600));
        escritorio.setMinimumSize(new java.awt.Dimension(1000, 600));
        escritorio.setRequestFocusEnabled(false);

        jPanel1.setBackground(new java.awt.Color(38, 86, 186));
        jPanel1.setMaximumSize(new java.awt.Dimension(1000, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 100));

        labelInstitucion.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        labelInstitucion.setForeground(new java.awt.Color(254, 238, 238));
        labelInstitucion.setText("Centro de Formacion Profesional 1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelInstitucion)
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(labelInstitucion)
                .addGap(24, 24, 24))
        );

        escritorio.add(jPanel1);
        jPanel1.setBounds(0, 0, 1000, 100);

        panelPrincipal.setBackground(new java.awt.Color(239, 238, 240));
        panelPrincipal.setMaximumSize(new java.awt.Dimension(1000, 500));

        panelMenu.setBackground(new java.awt.Color(239, 238, 240));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Menu");

        btnAlumnos.setBackground(new java.awt.Color(239, 238, 240));
        btnAlumnos.setText("Alumnos");
        btnAlumnos.setBorderPainted(false);
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btnEmpleados.setBackground(new java.awt.Color(239, 238, 240));
        btnEmpleados.setText("Empleados");
        btnEmpleados.setBorderPainted(false);
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnListados.setBackground(new java.awt.Color(239, 238, 240));
        btnListados.setText("Listados");
        btnListados.setBorderPainted(false);
        btnListados.setMaximumSize(new java.awt.Dimension(240, 40));
        btnListados.setMinimumSize(new java.awt.Dimension(240, 40));
        btnListados.setPreferredSize(new java.awt.Dimension(240, 40));
        btnListados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadosActionPerformed(evt);
            }
        });

        btnLicencias.setBackground(new java.awt.Color(239, 238, 240));
        btnLicencias.setText("Licencias");
        btnLicencias.setBorderPainted(false);
        btnLicencias.setMaximumSize(new java.awt.Dimension(240, 40));
        btnLicencias.setMinimumSize(new java.awt.Dimension(240, 40));
        btnLicencias.setPreferredSize(new java.awt.Dimension(240, 40));
        btnLicencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLicenciasActionPerformed(evt);
            }
        });

        btnCursos.setBackground(new java.awt.Color(239, 238, 240));
        btnCursos.setText("Cursos");
        btnCursos.setBorderPainted(false);
        btnCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCursosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel2))
            .addComponent(btnAlumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnEmpleados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnListados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnLicencias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCursos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(btnAlumnos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnListados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLicencias, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        panelUsuarios.setBackground(new java.awt.Color(239, 238, 240));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel3.setText("Usuarios");

        jButton5.setBackground(new java.awt.Color(239, 238, 240));
        jButton5.setText("Ver usuarios conectados");
        jButton5.setBorderPainted(false);

        jButton6.setBackground(new java.awt.Color(239, 238, 240));
        jButton6.setText("Crear Usuarios");
        jButton6.setBorderPainted(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(239, 238, 240));
        jButton7.setText("Modificar Usuario");
        jButton7.setBorderPainted(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(239, 238, 240));
        jButton8.setText("Eliminar Usuario");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUsuariosLayout = new javax.swing.GroupLayout(panelUsuarios);
        panelUsuarios.setLayout(panelUsuariosLayout);
        panelUsuariosLayout.setHorizontalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel3)
                .addGap(75, 75, 75))
            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        panelUsuariosLayout.setVerticalGroup(
            panelUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        panelSubMenu.setBackground(new java.awt.Color(239, 238, 240));

        javax.swing.GroupLayout panelSubMenuLayout = new javax.swing.GroupLayout(panelSubMenu);
        panelSubMenu.setLayout(panelSubMenuLayout);
        panelSubMenuLayout.setHorizontalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 754, Short.MAX_VALUE)
        );
        panelSubMenuLayout.setVerticalGroup(
            panelSubMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addGroup(panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelSubMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        escritorio.add(panelPrincipal);
        panelPrincipal.setBounds(0, 100, 1000, 500);

        menuConfiguracion.setText("Configuración");

        menuCalle.setText("Calle");
        menuCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCalleActionPerformed(evt);
            }
        });
        menuCalle.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuCalleKeyPressed(evt);
            }
        });
        menuConfiguracion.add(menuCalle);

        menuBarrio.setText("Barrio");
        menuBarrio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarrioActionPerformed(evt);
            }
        });
        menuBarrio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuBarrioKeyPressed(evt);
            }
        });
        menuConfiguracion.add(menuBarrio);

        menuLocalidad.setText("Localidad");
        menuLocalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLocalidadActionPerformed(evt);
            }
        });
        menuLocalidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                menuLocalidadKeyPressed(evt);
            }
        });
        menuConfiguracion.add(menuLocalidad);

        menuNacionalidad.setText("Nacionalidad");
        menuNacionalidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNacionalidadActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuNacionalidad);

        menuTipoDoc.setText("Tipo Documento");
        menuTipoDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTipoDocActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuTipoDoc);

        meunCargo.setText("Cargo");
        meunCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meunCargoActionPerformed(evt);
            }
        });
        menuConfiguracion.add(meunCargo);

        menuTitulo.setText("Titulo");
        menuTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTituloActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuTitulo);

        menuCaracterLicencia.setText("Caracter Licencia");
        menuCaracterLicencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCaracterLicenciaActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuCaracterLicencia);

        menuPlan.setText("Plan");
        menuPlan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPlanActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuPlan);

        menuGremio.setText("Gremio");
        menuGremio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGremioActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuGremio);

        menuSexo.setText("Sexo");
        menuSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSexoActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuSexo);

        menuLugarCursado.setText("Lugar de Cursado");
        menuLugarCursado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLugarCursadoActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuLugarCursado);

        menuPeriodo.setText("Periodo");
        menuPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPeriodoActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuPeriodo);

        menuTrabajo.setText("Trabajo");
        menuTrabajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTrabajoActionPerformed(evt);
            }
        });
        menuConfiguracion.add(menuTrabajo);

        menuBar.add(menuConfiguracion);

        menuSalir.setText("Salir");

        menuOpcionSalir.setText("Salir");
        menuOpcionSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpcionSalirActionPerformed(evt);
            }
        });
        menuSalir.add(menuOpcionSalir);

        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void centrarPantalla(int medidaHeight,int medidaWidth,int location){
        
        
        panelPrincipal.setLocation((pantalla.width - medidaWidth)/2,(pantalla.height - medidaHeight)/2);
    
        
    }
    
    public static void desactivarPanel(){
        panelMenu.setVisible(false);
        panelUsuarios.setVisible(false);
        panelSubMenu.setVisible(false);
    }
    
    public static void activarPanel(){
        panelMenu.setVisible(true);
        panelUsuarios.setVisible(true);
        panelSubMenu.setVisible(true);
        
        menuAlumno=0;
    }
    
    public static void crearBarrio() throws ClassNotFoundException, SQLException{
        Barrio_crear barrio=new Barrio_crear();
        panelPrincipal.add(barrio);
        barrio.setVisible(true);
        
    }
    public static void modificarBarrio() throws ClassNotFoundException, SQLException{
        Barrio_modificar barrio=new Barrio_modificar();
        panelPrincipal.add(barrio);
        barrio.setVisible(true);
        
    }
    public static void consultaBarrio() throws SQLException, ClassNotFoundException{
        Barrio_consulta barrio=new Barrio_consulta();
        panelPrincipal.add(barrio);
        barrio.setVisible(true);
        
    }
    
    public static void crearCalle() throws ClassNotFoundException{
        
        Calles_crear nuevo=new Calles_crear();
        panelPrincipal.add(nuevo);
        nuevo.setVisible(true);
        
    }
    public static void modificarCalle() throws ClassNotFoundException{
        
        Calles_modificar calle=new Calles_modificar();
        panelPrincipal.add(calle);
        calle.setVisible(true);
        
    }
    public static void consultaCalle() throws ClassNotFoundException{
        Calles_consulta calle=new Calles_consulta();
        panelPrincipal.add(calle);
        calle.setVisible(true);
    }
    
    public static void crearCaracter() throws ClassNotFoundException{
        Caracter_crear caracter = new Caracter_crear();
        panelPrincipal.add(caracter);
        caracter.setVisible(true);
    }
    
    public static void modificarCaracter() throws ClassNotFoundException{
        Caracter_modificar caracter = new Caracter_modificar();
        panelPrincipal.add(caracter);
        caracter.setVisible(true);
    }
    
    public static void consultaCaracter() throws ClassNotFoundException{
        Caracter_Consulta caracter = new Caracter_Consulta();
        panelPrincipal.add(caracter);
        caracter.setVisible(true);
    }
    public static void crearCargo() throws ClassNotFoundException{
        Cargo_crear cargo=new Cargo_crear();
                
        panelPrincipal.add(cargo);
        cargo.setVisible(true);
        
    }
    public static void modificarCargo() throws ClassNotFoundException{
        Cargo_modificar cargo=new Cargo_modificar();
                
        panelPrincipal.add(cargo);
        cargo.setVisible(true);
        
    }
    public static void consultaCargo() throws ClassNotFoundException{
        Cargo_consulta cargo=new Cargo_consulta();
        
        panelPrincipal.add(cargo);
        cargo.setVisible(true);
        
    }
    
    public static void crearCursado() throws ClassNotFoundException{
         Cursado_crear curso=new Cursado_crear();
        
        panelPrincipal.add(curso);
        curso.setVisible(true);
        
    }
    public static void modificarCursado() throws ClassNotFoundException{
         Cursado_modificar curso=new Cursado_modificar();
        
        panelPrincipal.add(curso);
        curso.setVisible(true);
        
    }
    public static void consultaCursado() throws ClassNotFoundException{
        Cursado_consulta curso=new Cursado_consulta();
        
        panelPrincipal.add(curso);
        curso.setVisible(true);
        
    }
    
    public static void crearGremio() throws ClassNotFoundException{
        Gremio_crear gremio=new Gremio_crear();
        
        panelPrincipal.add(gremio);
        gremio.setVisible(true);
        
    }
    public static void modificarGremio() throws ClassNotFoundException{
        Gremio_modificar gremio=new Gremio_modificar();
        
        panelPrincipal.add(gremio);
        gremio.setVisible(true);
        
    }
    public static void consultaGremio() throws ClassNotFoundException{
        Gremio_consulta gremio=new Gremio_consulta();
        
        panelPrincipal.add(gremio);
        gremio.setVisible(true);
        
    }
    
    public static void crearLocalidad() throws ClassNotFoundException{
        Localidad_crear localidad= new Localidad_crear();
        
        panelPrincipal.add(localidad);
        localidad.setVisible(true);
        
    }
    public static void modificarLocalidad() throws ClassNotFoundException{
        Localidad_modificar localidad=new Localidad_modificar();
        
        
        panelPrincipal.add(localidad);
        localidad.setVisible(true);
        
    }
    public static void consultaLocalidad() throws ClassNotFoundException{
        Localidad_consulta localidad=new Localidad_consulta();
        
        panelPrincipal.add(localidad);
        localidad.setVisible(true);
    }
    
    public static void crearNacionalidad() throws ClassNotFoundException{
        Nacionalidad_crear nacion= new Nacionalidad_crear();
        
        panelPrincipal.add(nacion);
        nacion.setVisible(true);
        
    }
    public static void modificarNacionalidad() throws ClassNotFoundException{
        Nacionalidad_modificar nacion= new Nacionalidad_modificar();
        
        panelPrincipal.add(nacion);
        nacion.setVisible(true);
        
    }
    public static void consultaNacionalidad() throws ClassNotFoundException{
        Nacionalidad_consulta nacion= new Nacionalidad_consulta();
        
        panelPrincipal.add(nacion);
        nacion.setVisible(true);
    }
    public static void crearPeriodo() throws ClassNotFoundException{
        Periodo_crear periodo = new Periodo_crear();
        
        panelPrincipal.add(periodo);
        periodo.setVisible(true);
    }
    public static void modificarPeriodo() throws ClassNotFoundException{
        Periodo_modificar periodo = new Periodo_modificar();
        
        panelPrincipal.add(periodo);
        periodo.setVisible(true);
    }
    public static void consultaPeriodo() throws ClassNotFoundException{
        Periodo_consulta periodo = new Periodo_consulta();
        
        panelPrincipal.add(periodo);
        periodo.setVisible(true);
    }
    public static void crearPlan() throws ClassNotFoundException{
        Plan_crear plan=new Plan_crear();
        
        panelPrincipal.add(plan);
        plan.setVisible(true);
        
    }
    public static void modificarPlan() throws ClassNotFoundException{
        
        Plan_modificar plan=new Plan_modificar();
        
        panelPrincipal.add(plan);
        plan.setVisible(true);
        
    }
    public static void consultaPlan() throws ClassNotFoundException{
        Plan_consulta plan=new Plan_consulta();
        
        panelPrincipal.add(plan);
        plan.setVisible(true);
        
    }
    public static void crearSexo() throws ClassNotFoundException{
        Sexo_crear sexo = new Sexo_crear();
        
        panelPrincipal.add(sexo);
        sexo.setVisible(true);
    }
    public static void modificarSexo() throws ClassNotFoundException{
        Sexo_modificar sexo = new Sexo_modificar();
        
        panelPrincipal.add(sexo);
        sexo.setVisible(true);
    }
    public static void sexoConsulta() throws ClassNotFoundException{
        Sexo_consulta sexo = new Sexo_consulta();
        
        panelPrincipal.add(sexo);
        sexo.setVisible(true);
    }
    public static void crearTipoDoc() throws ClassNotFoundException{
        TipoDoc_crear tipo = new TipoDoc_crear();
        
        panelPrincipal.add(tipo);
        tipo.setVisible(true);
    }
    public static void modificarTipoDoc() throws ClassNotFoundException{
        TipoDoc_modificar tipo = new TipoDoc_modificar();
        
        panelPrincipal.add(tipo);
        tipo.setVisible(true);
    }
    public static void consultaTipoDoc() throws ClassNotFoundException{
        TipoDoc_consulta tipo = new TipoDoc_consulta();
        
        panelPrincipal.add(tipo);
        tipo.setVisible(true);
    }
    public static void crearTitulo() throws ClassNotFoundException{
        Titulo_crear titulo=new Titulo_crear();
             
        panelPrincipal.add(titulo);
        titulo.setVisible(true);
        
    }
    public static void modificarTitulo() throws ClassNotFoundException{
        Titulo_modificar titulo= new Titulo_modificar();
        
        panelPrincipal.add(titulo);
        titulo.setVisible(true);
        
    }
    public static void consultaTitulo() throws ClassNotFoundException{
        Titulo_consulta titulo=new Titulo_consulta();
        
        panelPrincipal.add(titulo);
        titulo.setVisible(true);
        
    }
    
    public static void crearTrabajo() throws ClassNotFoundException{
        Trabajo_crear trabajo=new Trabajo_crear();
        panelPrincipal.add(trabajo);
        trabajo.setVisible(true);
        
    }
    public static void modificarTrabajo() throws ClassNotFoundException{
        Trabajo_modificar trabajo=new Trabajo_modificar();
        panelPrincipal.add(trabajo);
        trabajo.setVisible(true);
        
    }
    public static void consultaTrabajo() throws ClassNotFoundException{
        Trabajo_consulta trabajo=new Trabajo_consulta();
        panelPrincipal.add(trabajo);
        trabajo.setVisible(true);
    }
    
    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed

        try{
            FormDni.alumnoEmpleadoUser=1;
            new CambiaPanel(panelSubMenu, new AlumnoMenu());
            
        }catch(Exception e){
            
        }
        
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btnListadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadosActionPerformed

        new CambiaPanel(panelSubMenu, new ListadoMenu());
    }//GEN-LAST:event_btnListadosActionPerformed

    private void btnLicenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLicenciasActionPerformed

        new CambiaPanel(panelSubMenu, new LicenciaMenu());
    }//GEN-LAST:event_btnLicenciasActionPerformed

    private void btnCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCursosActionPerformed
        // TODO add your handling code here:
        /*desactivarPanel();
        MenuCursos curso=new MenuCursos();
        panelPrincipal.add(curso);
        curso.setVisible(true);*/
        
        new CambiaPanel(panelSubMenu, new CursosMenu());
    }//GEN-LAST:event_btnCursosActionPerformed

    
    private void menuOpcionSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOpcionSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuOpcionSalirActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        desactivarPanel();
        CrearUsuario user = null;
        try {
            user = new CrearUsuario();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        panelPrincipal.add(user);
        user.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        new CambiaPanel(panelSubMenu, new UsuarioMenu());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        desactivarPanel();
        
        EliminarUsuario user= new EliminarUsuario();
        panelPrincipal.add(user);
        user.setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        // TODO add your handling code here:

        try{
            FormDni.alumnoEmpleadoUser=2;
            CambiaPanel cambiaPanel = new CambiaPanel(panelSubMenu, new EmpleadoMenu());
            
        }catch(Exception e){
            
        }
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void menuBarrioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarrioActionPerformed
        desactivarPanel();
        
        try {
            consultaBarrio();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuBarrioActionPerformed

    private void menuCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCalleActionPerformed
        
        desactivarPanel();
        
        try {
            consultaCalle();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuCalleActionPerformed

    private void menuLocalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLocalidadActionPerformed
        desactivarPanel();
        try {
            consultaLocalidad();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuLocalidadActionPerformed

    private void meunCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meunCargoActionPerformed
        desactivarPanel();
        
        try {
            consultaCargo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_meunCargoActionPerformed

    private void menuTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTituloActionPerformed
        desactivarPanel();
        
        try {
            consultaTitulo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuTituloActionPerformed

    private void menuPlanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPlanActionPerformed
        desactivarPanel();
        
        try {
            consultaPlan();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuPlanActionPerformed

    private void menuGremioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGremioActionPerformed
        desactivarPanel();
        
        try {
            consultaGremio();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuGremioActionPerformed

    private void menuLugarCursadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLugarCursadoActionPerformed
        desactivarPanel();
        
        try {
            consultaCursado();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuLugarCursadoActionPerformed

    private void menuTrabajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTrabajoActionPerformed
        desactivarPanel();
        try {
            consultaTrabajo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuTrabajoActionPerformed

    private void menuNacionalidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNacionalidadActionPerformed
        desactivarPanel();
        try {
            consultaNacionalidad();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuNacionalidadActionPerformed

    private void menuPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPeriodoActionPerformed
        desactivarPanel();
        try {
            consultaPeriodo();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuPeriodoActionPerformed


    private void menuTipoDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTipoDocActionPerformed
        desactivarPanel();
        try {
            consultaTipoDoc();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuTipoDocActionPerformed

    private void menuSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSexoActionPerformed
        desactivarPanel();
        try {
            sexoConsulta();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuSexoActionPerformed

    private void menuCalleKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuCalleKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.menuCalleActionPerformed(e);
        }
    }//GEN-LAST:event_menuCalleKeyPressed

    private void menuBarrioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuBarrioKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.menuBarrioActionPerformed(e);
        }
    }//GEN-LAST:event_menuBarrioKeyPressed

    private void menuLocalidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_menuLocalidadKeyPressed
        if(evt.getKeyCode()==java.awt.event.KeyEvent.VK_ENTER) {
            ActionEvent e = null;
            this.menuLocalidadActionPerformed(e);
        }
    }//GEN-LAST:event_menuLocalidadKeyPressed

    private void menuCaracterLicenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCaracterLicenciaActionPerformed
        desactivarPanel();
        
        try {
            consultaCaracter();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuCaracterLicenciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnCursos;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnLicencias;
    private javax.swing.JButton btnListados;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel labelInstitucion;
    public static javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuBarrio;
    private javax.swing.JMenuItem menuCalle;
    private javax.swing.JMenuItem menuCaracterLicencia;
    private javax.swing.JMenu menuConfiguracion;
    private javax.swing.JMenuItem menuGremio;
    private javax.swing.JMenuItem menuLocalidad;
    private javax.swing.JMenuItem menuLugarCursado;
    private javax.swing.JMenuItem menuNacionalidad;
    private javax.swing.JMenuItem menuOpcionSalir;
    private javax.swing.JMenuItem menuPeriodo;
    private javax.swing.JMenuItem menuPlan;
    private javax.swing.JMenu menuSalir;
    private javax.swing.JMenuItem menuSexo;
    private javax.swing.JMenuItem menuTipoDoc;
    private javax.swing.JMenuItem menuTitulo;
    private javax.swing.JMenuItem menuTrabajo;
    private javax.swing.JMenuItem meunCargo;
    public static javax.swing.JPanel panelMenu;
    public static javax.swing.JPanel panelPrincipal;
    public static javax.swing.JPanel panelSubMenu;
    public static javax.swing.JPanel panelUsuarios;
    // End of variables declaration//GEN-END:variables

}
