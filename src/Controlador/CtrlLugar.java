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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.CodigoPostal;
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
        
            ps.setString(1, nombre.toUpperCase());
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
            
            ps.setString(1, nombre.toUpperCase());
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
    
    public Lugar leer(int idLugar){//cambie esto, estaba con nivel...<--
        Lugar lugar = new Lugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE idLugar = ?");
            
            ps.setInt(1, idLugar);
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
            
            ps.setString(1, nombre.toUpperCase());
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
            
            ps.setString(1, nombre.toUpperCase());
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
        ResultSet rst;
        try {
            con= clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM lugar WHERE nivel = 3 ORDER BY nombre ASC");
            rst=ps.executeQuery();
            
            Lugar dat= new Lugar();
            dat.setIdLugar(0);
            dat.setNombre("Selecciona una opción...");
            dat.setNivel(0);
            dat.setDe(0);
            comboLocalidad.addItem(dat);

            while(rst.next()){
                dat= new Lugar();
                
                dat.setIdLugar(rst.getInt("idLugar"));
                dat.setNombre(rst.getString("nombre"));
                dat.setNivel(rst.getInt("nivel"));
                dat.setDe(rst.getInt("de"));
                
                comboLocalidad.addItem(dat); 
            }
                
        } catch (SQLException ex) {
         
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Las localidades"+ex.getMessage());
        }
    }
    
    public Vector<Lugar> cargarFiltrado(int de, int nivel) {
        //PreparedStatement ps = null;
        ResultSet rst;
        Vector<Lugar> datos = new Vector<>();
        Lugar dat = null;
        try {
            con = clases.Conectar.conexion();
            String sql = "SELECT * FROM lugar WHERE nivel=? and de =" + de;
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, nivel);
            
            rst = ps.executeQuery();
            dat = new Lugar();
            dat.setIdLugar(0);
            dat.setNombre("Seleccionae una opción...");
            dat.setNivel(0);
            dat.setDe(0);
            datos.add(dat);
                while (rst.next()) {
                    dat = new Lugar();
                    dat.setIdLugar(rst.getInt("idLugar"));
                    dat.setNombre(rst.getString("nombre"));
                    dat.setNivel(rst.getInt("nivel"));
                    dat.setDe(rst.getInt("de"));
                    
                    datos.add(dat);
                }
        } catch (SQLException ex) {
            System.err.println("Error consulta :" + ex.getMessage());
        }
        return datos;
    }
    
    public List<Lugar> cargarListaBarrios(int idLugar){
        List<Lugar> listaBarrio = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM lugar WHERE nivel = 2 AND de = '"+ idLugar +"'ORDER BY nombre ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(rst.getInt("idLugar"));
                lugar.setNombre(rst.getString("nombre"));
                lugar.setNivel(rst.getInt("nivel"));
                lugar.setDe(rst.getInt("de"));
                
                listaBarrio.add(lugar);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaBarrio;
    }
    
    
    
    public List<Lugar> llenarTablaBarrio(int idLugar){
        ResultSet rst;
        List<Lugar> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps= (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE nivel = 2 AND de = '"+ idLugar +"'ORDER BY nombre ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(rst.getInt("idLugar"));
                lugar.setNivel(rst.getInt("nivel"));
                lugar.setNombre(rst.getString("nombre"));
                lugar.setDe(rst.getInt("de"));
                
                lista.add(lugar);
            }
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LOS BARRIOS EN LA TABLA"+e.getMessage()); 
        }
        return lista;
    }
    
    
    public List<Lugar> llenarTablaCalle(int idLugar){
        ResultSet rst;
        List<Lugar> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps= (PreparedStatement) con.prepareStatement("SELECT * FROM lugar WHERE nivel = 1 AND de = '"+ idLugar +"'ORDER BY nombre ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(rst.getInt("idLugar"));
                lugar.setNivel(rst.getInt("nivel"));
                lugar.setNombre(rst.getString("nombre"));
                lugar.setDe(rst.getInt("de"));
                
                lista.add(lugar);
            }
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS CALLES EN LA TABLA"+e.getMessage()); 
        }
        return lista;
    }
    
    public List<Lugar> cargarListaCalles(int idLugar){
        List<Lugar> listaCalle = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM lugar WHERE nivel = 1 AND de = '"+ idLugar +"'ORDER BY nombre ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(rst.getInt("idLugar"));
                lugar.setNombre(rst.getString("nombre"));
                lugar.setNivel(rst.getInt("nivel"));
                lugar.setDe(rst.getInt("de"));
                
                listaCalle.add(lugar);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaCalle;
    }
    
    public List<Lugar> cargarListaLocalidades(){
        List<Lugar> listaCalle = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT idLugar, nombre, nivel, de, codigoPostal FROM lugar INNER JOIN codigoPostal"
                    + " WHERE idLugar = localidad AND nivel = 3 ORDER BY nombre ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Lugar lugar = new Lugar();
                lugar.setIdLugar(rst.getInt("idLugar"));
                lugar.setNombre(rst.getString("nombre"));
                lugar.setDe(rst.getInt("de"));
                
                listaCalle.add(lugar);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaCalle;
    }
    
    public List<String> llenarTablaLocalidades(int idLugar){
        ResultSet rst;
        List<String> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps= (PreparedStatement) con.prepareStatement("SELECT nombre, codigoPostal FROM lugar INNER JOIN codigoPostal"
                    + " WHERE idLugar = localidad AND nivel = '"+idLugar+"' ORDER BY nombre ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {
                Lugar lugar = new Lugar();
                CodigoPostal codigoPostal = new CodigoPostal();
                lugar.setNombre(rst.getString("nombre"));
                codigoPostal.setCodigoPostal(rst.getString("codigoPostal"));
                
                lista.add(lugar.toString());
                lista.add(codigoPostal.toString());
            }
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS LOCALIDADES EN LA TABLA"+e.getMessage()); 
        }
        return lista;
    }
    
}
