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
import modelo.Alumno;
/**
 *
 * @author jesus
 */
public class CtrlAlumno {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idPersona){
     
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO alumno (idPersona,borrado) VALUES (?,?)");
        
            ps.setInt(1, idPersona);
            ps.setBoolean(2, false);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    
    public void borrar(int idPersona, int idAlumno){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE alumno borrado SET = TRUE WHERE idPersona = ? AND idAlumno = ?");
            
            ps.setInt(1, idPersona);
            ps.setInt(2, idAlumno);
            
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
    
    public Alumno leer(int idPersona){
        Alumno alumno = new Alumno();
        CtrlPersona ctrlPersona = new CtrlPersona();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM alumno WHERE idPersona = ? AND borrado = FALSE");
            
            ps.setInt(1, idPersona);
            rs = ps.executeQuery();
            
            if(rs.next()){
                alumno.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                alumno.setBorrado(rs.getBoolean("borrado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return alumno;
    }
    
    public Alumno leer(){
        Alumno alumno = new Alumno();
        CtrlPersona ctrlPersona = new CtrlPersona();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM alumno ORDER BY idAlumno DESC LIMIT 1");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                alumno.setBorrado(rs.getBoolean("borrado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return alumno;
    }
    
    public Alumno leerBorrado(int idPersona){
        Alumno alumno = new Alumno();
        CtrlPersona ctrlPersona = new CtrlPersona();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM alumno WHERE idPersona = ? AND borrado = TRUE");
            
            ps.setInt(1, idPersona);
            rs = ps.executeQuery();
            
            if(rs.next()){
                alumno.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return alumno;
    }
}
