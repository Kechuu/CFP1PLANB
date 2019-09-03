/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Blob;
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
    
    public void crear(String nombreEscuela, String direccion, String telefono, String correo, String director, Blob logo, Blob fondo){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO escuela (nombreEscuela, direccion, telefono, correo, director, logo, fondo) VALUES (?,?,?,?,?,?,?)");
        
            ps.setString(1, nombreEscuela);
            ps.setString(2, direccion);
            ps.setString(3, telefono);
            ps.setString(4, correo);
            ps.setString(5, director);
            ps.setBlob(6, logo);
            ps.setBlob(7, fondo);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editarTelefonoCorreo(String telefono, String correo, int idEscuela){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE cargo SET telefono = ?, correo = ? WHERE idEscuela = ?");
            
            ps.setString(1, telefono);
            ps.setString(2, correo);
            ps.setInt(3, idEscuela);
            
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
    
    public void editarLogoFondo(Blob logo, Blob fondo, int idEscuela){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE cargo SET logo = ?, fondo = ? WHERE idEscuela = ?");
            
            ps.setBlob(1, logo);
            ps.setBlob(2, fondo);
            ps.setInt(3, idEscuela);
            
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
    
    public void editarDirector(String director, int idEscuela){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE cargo SET director = ? WHERE idEscuela = ?");
            
            ps.setString(1, director);
            ps.setInt(2, idEscuela);
            
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
