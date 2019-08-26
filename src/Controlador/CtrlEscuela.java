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
import modelo.Escuela;
/**
 *
 * @author jesus
 */
public class CtrlEscuela {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO escuela (nombreEscuela, direccion, telefono, correo, director, logo, fondo) VALUES (?,?,?,?,?,?,?)");
        
            ps.setString(1, "");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setString(6, "");
            ps.setString(7, "");
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE cargo SET nombreEscuela = ?, direccion = ?, telefono = ?, correo = ?, director = ?, logo = ?, fondo = ? WHERE idCargo = ?");
            
            ps.setString(1, "");
            ps.setString(2, "");
            ps.setString(3, "");
            ps.setString(4, "");
            ps.setString(5, "");
            ps.setString(6, "");
            ps.setString(7, "");
            ps.setString(8, "");
            
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
    
    public Escuela leer(int id){
        Escuela escuela = new Escuela();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM escuela");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                escuela.setNombreEscuela(rs.getString("nombreEscuela"));
                escuela.setDireccion(rs.getString("direccion"));
                escuela.setTelefono(rs.getString("telefono"));
                escuela.setCorreo(rs.getString("correo"));
                escuela.setDirector(rs.getString("director"));
                escuela.setLogo(rs.getBlob("logo"));
                escuela.setFondo(rs.getBlob("fondo"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return escuela;
    }
}
