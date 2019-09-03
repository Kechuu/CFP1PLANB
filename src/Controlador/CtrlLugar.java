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
import modelo.Lugar;

/**
 *
 * @author jesus
 */
public class CtrlLugar {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String nombre, int nivel, int de){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO lugar (nombre, nivel, de) VALUES (?,?,?)");
        
            ps.setString(1, nombre);
            ps.setInt(2, nivel);
            ps.setInt(3, de);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idLugar, String nombre, int nivel, int de){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE lugar SET nombre = ?, nivel = ?, de = ? WHERE idLugar = ?");
            
            ps.setString(1, nombre);
            ps.setInt(2, nivel);
            ps.setInt(3, de);
            ps.setInt(4, idLugar);
            
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
    
    public Lugar leer(int id){
        Lugar lugar = new Lugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE idLugar = ?");
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                lugar.setNombre("nombre");
                lugar.setNivel(Integer.parseInt("nivel"));
                lugar.setDe(leer(rs.getInt("de")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            rs.close();
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return lugar;
    }
    
    public Lugar leer(String nombre, int nivel){
        Lugar lugar = new Lugar();
        
        try {
            con = clases.Conectar.conexion();
            
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE nombre = ? AND nivel = ?");
            
            ps.setString(1, nombre);
            ps.setInt(2, nivel);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                lugar.setNombre("nombre");
                lugar.setNivel(Integer.parseInt("nivel"));
                lugar.setDe(leer(rs.getInt("de")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return lugar;
    }
    
    //Leer todas las localidades, barrios, calles etc :v
}
