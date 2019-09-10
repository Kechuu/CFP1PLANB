/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JComboBox;
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
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
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
    
    public Lugar leer(int nivel){
        Lugar lugar = new Lugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE nivel = ?");
            
            ps.setInt(1, nivel);
            rs = ps.executeQuery();
            
            if(rs.next()){
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
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
    
    public Lugar leer(String nombre, int nivel, int de){
        Lugar lugar = new Lugar();
        
        try {
            con = clases.Conectar.conexion();
            
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE nombre = ? AND nivel = ? AND de = ?");
            
            ps.setString(1, nombre);
            ps.setInt(2, nivel);
            ps.setInt(3, de);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
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
    
    public Lugar leer(String nombre, int nivel){
        Lugar lugar = new Lugar();
        
        try {
            con = clases.Conectar.conexion();
            
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE nombre = ? AND nivel = ?");
            
            ps.setString(1, nombre);
            ps.setInt(2, nivel);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
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
    
    
    public Lugar leer(int idLugar, int nivel){
        Lugar lugar = new Lugar();
        
        try {
            con = clases.Conectar.conexion();
            
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE idLugar = ? AND nivel = ?");
            
            ps.setInt(1, idLugar);
            ps.setInt(2, nivel);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                lugar.setIdLugar(rs.getInt("idLugar"));
                lugar.setNombre(rs.getString("nombre"));
                lugar.setNivel(rs.getInt("nivel"));
                lugar.setDe(rs.getInt("de"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            rs.close();
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return lugar;
    }
    
    public void cargarComboLocalidad(JComboBox<Lugar> comboLocalidad){//Este metodo para llenar el combo con las localidades 
        
        try {
            con= clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM lugar WHERE nivel = 3 ORDER BY nombre ASC");
            rs=ps.executeQuery();
            
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
    
    public Vector<Lugar> cargarFiltrado(int de, int nivel) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Vector<Lugar> datos = new Vector<>();
        Lugar dat = null;
        try {
            String sql = "SELECT * FROM lugar WHERE nivel=? and de =" + de;
            
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
                    dat.setNivel(rs.getInt("nivel"));
                    dat.setDe(rs.getInt("de"));
                    
                    datos.add(dat);
                }
                rs.close();
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
    
}
