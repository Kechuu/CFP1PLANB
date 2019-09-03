/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Persona;
/**
 *
 * @author jesus
 */
public class CtrlPersona {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String nombrePersona, String apellidoPersona, Date fechaNacimiento, boolean sexo, String CUIL, int hijoPersona,
            String correo, int celular, int idDomicilio, int idTipoDocumento, int idNacionalidad, int idFoto, int lugarNacimiento,
            boolean borrado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO persona (nombrePersona,apellidoPersona,fechaNacimiento,sexo,"
                    + "CUIL,hijoPersona,correo,celular,idDomicilio,idTipoDocumento,idNacionalidad,idFoto,lugarNacimiento,borrado"
                    + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
            ps.setString(1, nombrePersona);
            ps.setString(2, apellidoPersona);
            ps.setDate(3, fechaNacimiento);
            ps.setBoolean(4, sexo);
            ps.setString(5, CUIL);
            ps.setInt(6, hijoPersona);
            ps.setString(7, correo);
            ps.setInt(8, celular);
            ps.setInt(9, idDomicilio);
            ps.setInt(10, idTipoDocumento);
            ps.setInt(11, idNacionalidad);
            ps.setInt(12, idFoto);
            ps.setInt(13, lugarNacimiento);
            ps.setBoolean(14, borrado);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idPersona, String nombrePersona, String apellidoPersona, Date fechaNacimiento, boolean sexo, String CUIL, int hijoPersona,
            String correo, int celular, int idDomicilio, int idTipoDocumento, int idNacionalidad, int idFoto, int lugarNacimiento,
            boolean borrado){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE edificio SET nombrePersona = ?, apellidoPersona = ?,"
                    + "fechaNacimiento = ?, sexo = ?, CUIL = ?, hijoPersona = ?, correo = ?, celular = ?, idDomicilio = ?,"
                    + "idTipoDocumento = ?, idNacionalidad = ?, idFoto = ?, lugarNacimiento = ?, borrado = ? WHERE idPersona = ?");
            
            ps.setString(1, nombrePersona);
            ps.setString(2, apellidoPersona);
            ps.setDate(3, fechaNacimiento);
            ps.setBoolean(4, sexo);
            ps.setString(5, CUIL);
            ps.setInt(6, hijoPersona);
            ps.setString(7, correo);
            ps.setInt(8, celular);
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
            ps =  (PreparedStatement) con.prepareStatement("UPDATE curso SET borrado = TRUE WHERE idPersona = ?");
            
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
    
    public Persona leer(int id){
     Persona persona = new Persona();
     CtrlDomicilio ctrlDomicilio = new CtrlDomicilio();
     CtrlTipoDocumento ctrlTipoDocumento = new CtrlTipoDocumento();
     CtrlNacionalidad ctrlNacionalidad = new CtrlNacionalidad();
     CtrlFoto ctrlFoto = new CtrlFoto();
     CtrlLugar ctrlLugarNacimiento = new CtrlLugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM persona WHERE idPersona = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setNombrePersona(rs.getString("nombrePersona"));
                persona.setApellidoPersona(rs.getString("apellidoPersona"));
                persona.setFechaNacimiento(rs.getDate("fechaNacimiento"));
                persona.setSexo(rs.getBoolean("sexo"));
                persona.setCUIL(rs.getString("CUIL"));
                persona.setHijoPersona(rs.getInt("hijoPersona"));
                persona.setCorreo(rs.getString("correo"));
                persona.setCelular(rs.getInt("celular"));
                persona.setIdDomicilio(ctrlDomicilio.leer(rs.getInt("idDomicilio")));
                persona.setIdTipoDocumento(ctrlTipoDocumento.leer(rs.getInt("idTipoDocumento")));
                persona.setIdNacionalidad(ctrlNacionalidad.leer(rs.getInt("idNacionalidad")));
                persona.setIdFoto(ctrlFoto.leer(rs.getInt("idFoto")));
                persona.setLugarNacimiento(ctrlLugarNacimiento.leer(rs.getInt("idLugarNacimiento")));
                persona.setBorrado(rs.getBoolean("borrado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
     return persona;
    }
}
