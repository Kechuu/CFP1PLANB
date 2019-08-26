/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.sql.Connection;
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
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
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
