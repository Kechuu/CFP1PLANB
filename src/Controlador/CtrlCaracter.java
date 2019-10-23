/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Caracter;

/**
 *
 * @author jesus
 */
public class CtrlCaracter {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO caracter (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void editar(int idCaracter, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE caracter SET detalle = ? WHERE idCaracter = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idCaracter);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public Caracter leer(int idCaracter){
        Caracter caracter = new Caracter();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM caracter WHERE idCaracter = ?");
            
            ps.setInt(1, idCaracter);
            rs = ps.executeQuery();
            
            if(rs.next()){
                caracter.setIdCaracter(rs.getInt("idCaracter"));
                caracter.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return caracter;
    }
    public Caracter leer(String nombreCaracter){
        Caracter caracter = new Caracter();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM caracter WHERE detalle = ?");
            
            ps.setString(1, nombreCaracter);
            rs = ps.executeQuery();
            
            if(rs.next()){
                caracter.setIdCaracter(rs.getInt("idCaracter"));
                caracter.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return caracter;
    }
    
    public void cargarCombo(JComboBox<Caracter> cbCaracter){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM caracter ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            Caracter caracter=new Caracter();
            caracter.setIdCaracter(0);
            caracter.setDetalle("Seleccione una opción...");
            cbCaracter.addItem(caracter);
            
            while (rs.next()) {                
            
                caracter=new Caracter();
                
                caracter.setIdCaracter(rs.getInt("idCaracter"));
                caracter.setDetalle(rs.getString("detalle"));
                cbCaracter.addItem(caracter);
            }
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR CARACTERES: "+e.getMessage());       
        }
        
    }
    
    public List<Caracter> cargarListaCargo(){
        List<Caracter> listaCaracter = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM caracter ORDER BY detalle ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Caracter caracter = new Caracter();
                caracter.setIdCaracter(rst.getInt("idCaracter"));
                caracter.setDetalle(rst.getString("detalle"));
                
                listaCaracter.add(caracter);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaCaracter;
    }
    
    public List<Caracter> leerTodos(){
        
        ResultSet rst;
        List<Caracter> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM caracter ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                Caracter caracter = new Caracter();
                caracter.setIdCaracter(rst.getInt("idCaracter"));
                caracter.setDetalle(rst.getString("detalle"));
                
                lista.add(caracter);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
}
