/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import clases.CambiaPanel;
import interfazAlumno.Inscripcion;
import interfazAlumno.PanelDni;
import interfazEmpleado.Registro;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import menu.AlumnoMenu;
import menu.EmpleadoMenu;
import menu.*;
import modelo.Persona;
import usuario.CrearUsuario;
/**
 *
 * @author jesus
 */
public class CtrlPersona {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    //public int CUIL = 0;
    
    public void crear(String nombrePersona, String apellidoPersona, java.util.Date fechaNacimiento, int sexo, String CUIL, int hijoPersona,
            String correo, String celular, int idDomicilio, int idTipoDocumento, int idNacionalidad, int idFoto, int lugarNacimiento,
            boolean borrado){
        
        java.sql.Date fecha=new Date(fechaNacimiento.getTime());
        //int hijo=Integer.parseInt(hijoPersona);
        //int celu=Integer.parseInt(celular);
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO persona (nombrePersona,apellidoPersona,fechaNacimiento,sexo,"
                    + "CUIL,hijoPersona,correo,celular,idDomicilio,idTipoDocumento,idNacionalidad,idFoto, lugarNacimiento,borrado"
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
            ps.setString(1, nombrePersona.toUpperCase());
            ps.setString(2, apellidoPersona.toUpperCase());
            ps.setDate(3, (java.sql.Date) fecha);
            ps.setInt(4, sexo);
            ps.setString(5, CUIL);
            ps.setInt(6, hijoPersona);
            ps.setString(7, correo);
            ps.setString(8, celular);
            ps.setInt(9, idDomicilio);
            ps.setInt(10, idTipoDocumento);
            ps.setInt(11, idNacionalidad);
            ps.setInt(12, idFoto);
            ps.setInt(13, lugarNacimiento);
            ps.setBoolean(14, borrado);
            
            int res = ps.executeUpdate();
            con.close();
          
        } catch (NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(null, "es el control de persona");
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public void editar(int idPersona, String nombrePersona, String apellidoPersona, java.util.Date fechaNacimiento, boolean sexo, String CUIL, String hijoPersona,
            String correo, String celular, int idDomicilio, int idTipoDocumento, int idNacionalidad, int idFoto, int lugarNacimiento,
            boolean borrado){
        java.sql.Date fecha =new Date(fechaNacimiento.getTime());
        int hijo=Integer.parseInt(hijoPersona);
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE persona SET nombrePersona = ?, apellidoPersona = ?,"
                    + "fechaNacimiento = ?, sexo = ?, CUIL = ?, hijoPersona = ?, correo = ?, celular = ?, idDomicilio = ?,"
                    + "idTipoDocumento = ?, idNacionalidad = ?, idFoto = ?, lugarNacimiento = ?, borrado = ? WHERE idPersona = ?");
            
            ps.setString(1, nombrePersona.toUpperCase());
            ps.setString(2, apellidoPersona.toUpperCase());
            ps.setDate(3, fecha);
            ps.setBoolean(4, sexo);
            ps.setString(5, CUIL);
            ps.setInt(6, hijo);
            ps.setString(7, correo);
            ps.setString(8, celular);
            ps.setInt(9, idDomicilio);
            ps.setInt(10, idTipoDocumento);
            ps.setInt(11, idNacionalidad);
            ps.setInt(12, idFoto);
            ps.setInt(13, lugarNacimiento);
            ps.setBoolean(14, borrado);
            ps.setInt(15, idPersona);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void borrar(int idPersona){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE persona SET borrado = TRUE WHERE idPersona = ?");
            
            ps.setInt(1, idPersona);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public Persona leer(int idPersona){
     Persona persona = new Persona();
     CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
     CtrlTipoDocumento ctrlTipoDocumento = new CtrlTipoDocumento();
     CtrlNacionalidad ctrlNacionalidad = new CtrlNacionalidad();
     CtrlFoto ctrlFoto = new CtrlFoto();
     CtrlLugar ctrlLugarNacimiento = new CtrlLugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM persona WHERE idPersona = ?");
            
            ps.setInt(1, idPersona);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombrePersona(rs.getString("nombrePersona"));
                persona.setApellidoPersona(rs.getString("apellidoPersona"));
                persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                persona.setSexo(rs.getInt("sexo"));
                persona.setCUIL(rs.getString("CUIL"));
                persona.setHijoPersona(rs.getInt("hijoPersona"));
                persona.setCorreo(rs.getString("correo"));
                persona.setCelular(rs.getString("celular"));
                persona.setIdDomicilio(ctrlDomicilio.leer(rs.getInt("idDomicilio")));
                persona.setIdTipoDocumento(ctrlTipoDocumento.leer(rs.getInt("idTipoDocumento")));
                persona.setIdNacionalidad(ctrlNacionalidad.leer(rs.getInt("idNacionalidad")));
                persona.setIdFoto(ctrlFoto.leer(rs.getInt("idFoto")));
                persona.setLugarNacimiento(ctrlLugarNacimiento.leer(rs.getInt("lugarNacimiento")));
            }else{
                JOptionPane.showMessageDialog(null, "-P No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
     return persona;
    }
    
    public Persona leer(){
     Persona persona = new Persona();
     CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
     CtrlTipoDocumento ctrlTipoDocumento = new CtrlTipoDocumento();
     CtrlNacionalidad ctrlNacionalidad = new CtrlNacionalidad();
     CtrlFoto ctrlFoto = new CtrlFoto();
     CtrlLugar ctrlLugarNacimiento = new CtrlLugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM persona ORDER BY idPersona DESC LIMIT 1");
        
            rs = ps.executeQuery();
            
            if (rs.next()) {
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombrePersona(rs.getString("nombrePersona"));
                persona.setApellidoPersona(rs.getString("apellidoPersona"));
                persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                persona.setSexo(rs.getInt("sexo"));
                persona.setCUIL(rs.getString("CUIL"));
                persona.setHijoPersona(rs.getInt("hijoPersona"));
                persona.setCorreo(rs.getString("correo"));
                persona.setCelular(rs.getString("celular"));
                persona.setIdDomicilio(ctrlDomicilio.leer(rs.getInt("idDomicilio")));
                persona.setIdTipoDocumento(ctrlTipoDocumento.leer(rs.getInt("idTipoDocumento")));
                persona.setIdNacionalidad(ctrlNacionalidad.leer(rs.getInt("idNacionalidad")));
                persona.setIdFoto(ctrlFoto.leer(rs.getInt("idFoto")));
                persona.setLugarNacimiento(ctrlLugarNacimiento.leer(rs.getInt("lugarNacimiento")));
            }else{
                JOptionPane.showMessageDialog(null, "-Persona No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
     return persona;
    }
    
    public Persona leer(String dni){
     Persona persona = new Persona();
     CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
     CtrlTipoDocumento ctrlTipoDocumento = new CtrlTipoDocumento();
     CtrlNacionalidad ctrlNacionalidad = new CtrlNacionalidad();
     CtrlFoto ctrlFoto = new CtrlFoto();
     CtrlLugar ctrlLugarNacimiento = new CtrlLugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM persona WHERE CUIL like '%"+dni+"%'");
        
            rs = ps.executeQuery();
            
            if (rs.next()) {
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombrePersona(rs.getString("nombrePersona"));
                persona.setApellidoPersona(rs.getString("apellidoPersona"));
                persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                persona.setSexo(rs.getInt("sexo"));
                persona.setCUIL(rs.getString("CUIL"));
                persona.setHijoPersona(rs.getInt("hijoPersona"));
                persona.setCorreo(rs.getString("correo"));
                persona.setCelular(rs.getString("celular"));
                persona.setIdDomicilio(ctrlDomicilio.leer(rs.getInt("idDomicilio")));
                persona.setIdTipoDocumento(ctrlTipoDocumento.leer(rs.getInt("idTipoDocumento")));
                persona.setIdNacionalidad(ctrlNacionalidad.leer(rs.getInt("idNacionalidad")));
                persona.setIdFoto(ctrlFoto.leer(rs.getInt("idFoto")));
                persona.setLugarNacimiento(ctrlLugarNacimiento.leer(rs.getInt("lugarNacimiento")));
            }else{
                JOptionPane.showMessageDialog(null, "-Persona No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
     return persona;
    }
    public void generarCUIL(int DNI, char sx) throws ClassNotFoundException{
        //PanelDni dni = new PanelDni();
        int validarPersona = PanelDni.validarPersona;
    //HACER LA VARIABLE validarPersona STATIC!!!
        /*
        Codigo de CUIL :v
        */
        //CUIL = DNI;
       // String CUIL = clases.Cuil.generar(DNI, sx);
        //buscarAlumno(CUIL, validarPersona);
        
    }
    
    public Persona buscarAlumno(String CUIL, int validarPersona) throws ClassNotFoundException{
        PanelDni dni = new PanelDni();
        Persona persona = new Persona();
        CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
        CtrlTipoDocumento ctrlTipoDocumento = new CtrlTipoDocumento();
        CtrlNacionalidad ctrlNacionalidad = new CtrlNacionalidad();
        CtrlFoto ctrlFoto = new CtrlFoto();
        CtrlLugar ctrlLugarNacimiento = new CtrlLugar();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM persona WHERE CUIL = ?");
            
            ps.setString(1, CUIL);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, validarPersona);
                
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombrePersona(rs.getString("nombrePersona"));
                persona.setApellidoPersona(rs.getString("apellidoPersona"));
                persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                persona.setSexo(rs.getInt("sexo"));
                persona.setCUIL(rs.getString("CUIL"));
                persona.setHijoPersona(rs.getInt("hijoPersona"));
                persona.setCorreo(rs.getString("correo"));
                persona.setCelular(rs.getString("celular"));
                persona.setIdDomicilio(ctrlDomicilio.leer(rs.getInt("idDomicilio")));
                persona.setIdTipoDocumento(ctrlTipoDocumento.leer(rs.getInt("idTipoDocumento")));
                persona.setIdNacionalidad(ctrlNacionalidad.leer(rs.getInt("idNacionalidad")));
                persona.setIdFoto(ctrlFoto.leer(rs.getInt("idFoto")));
                persona.setLugarNacimiento(ctrlLugarNacimiento.leer(rs.getInt("lugarNacimiento")));
                
                if (validarPersona == 1) {
                    JOptionPane.showMessageDialog(null, "La persona ya está cargada. Elija una de las opciones para continuar.");
                    validarPersona=2;
                    PanelDni.validarPersona = validarPersona;
                    
                    switch (PanelDni.alumnoEmpleado) {
                        case 1://ESTE SERA EN CASO DE QUE SE TRATE DE UN ALUMNO
                            {
                                CambiaPanel cambiaPanel = new CambiaPanel(menu.Principal.panelSubMenu, new AlumnoMenu(persona));
                                break;
                            }
                        case 2://EN CASO DE QUE SE TRATE DE UN EMPLEADO
                            {
                                CambiaPanel cambiaPanel=new CambiaPanel(menu.Principal.panelSubMenu, new EmpleadoMenu(persona));
                                break;
                            }
                            
                        case 3://ESTE ES EN CASO DE QUE SE QUIERA CREAR UN USUARIO..
                        {
                            Principal.desactivarPanel();
                            CrearUsuario crearUs=new CrearUsuario();
                            Principal.panelPrincipal.add(crearUs);
                            crearUs.setVisible(true);
                        }
                    }
                }else{
                    //SALDRA POR AQUI EN CASO DE QUE SE BUSQUE POR EL BUSCADOR :v 
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
                
                switch(PanelDni.alumnoEmpleado){
                    case 1://EN CASO DE QUE EL ALUMNO NO EXISTA
                        Principal.desactivarPanel();
                        Inscripcion inscripcion =new Inscripcion(CUIL);
                        Principal.panelPrincipal.add(inscripcion);
                        inscripcion.setVisible(true);      
                    break;
                    
                    case 2://EN CASO DE QUE EL EMPLEADO NO EXISTA
                        Principal.desactivarPanel();
                        Registro registro=new Registro(CUIL);
                        Principal.panelPrincipal.add(registro);
                        registro.setVisible(true);
                    break;
                    
                    case 3://ESTE SERA EN CASO DE QUE EL EMPLEADO AL QUE SE QUIERA CREAR, NO ESTE DADO DE ALTA
                        Registro registroE=new Registro(CUIL);
                        Principal.panelPrincipal.add(registroE);
                        registroE.setVisible(true);
                    break;
                }
                        
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
     return persona;
    }
}
