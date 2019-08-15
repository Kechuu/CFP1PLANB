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

/**
 *
 * @author jesus
 */
public class CtrlEstadoAlumno {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO estadoAlumno (detalle) VALUES (?)");
        
            ps.setString(1, "");
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE estadoAlumno SET detalle = ? WHERE idEstadoAlumno = ?");
            
            ps.setString(1, "");
            ps.setString(2, "");
            
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
    
    public void borrar(){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE estadoAlumno SET borrado = TRUE WHERE idEstadoAlumno = ?");
            
            ps.setString(1, "");
            
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
    
    public void leer(){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM estadoAlumno WHERE idEstadoAlumno = ?");
            
            ps.setString(1,"");
            rs = ps.executeQuery();
            
            if(rs.next()){
                //Cargar Caja de texto y combo box
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
}
