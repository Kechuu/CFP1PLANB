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
import modelo.Sexo;

/**
 *
 * @author araa
 */
public class CtrlSexo {
    
    Connection con=null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO sexo (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void editar(int idSexo, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE sexo SET detalle = ? WHERE idSexo = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idSexo);
            
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
    public Sexo leer(int idSexo){
        Sexo sx=new Sexo();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM sexo WHERE idSexo = ?");
            
            ps.setInt(1, idSexo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                sx.setIdSexo(rs.getInt("idSexo"));
                sx.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return sx;
    }
    
    public void cargarCombo(JComboBox <Sexo> cb){
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * from sexo ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            Sexo sx=new Sexo();
            sx.setIdSexo(0);
            sx.setDetalle("Seleccione una opción...");
            cb.addItem(sx);
            
            while(rs.next()){
                sx=new Sexo();
                
                sx.setIdSexo(rs.getInt("idSexo"));
                sx.setDetalle(rs.getString("detalle"));
                
                cb.addItem(sx);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    public List<Sexo> cargarListaSexo(){
        List<Sexo> listaSexo = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM sexo ORDER BY detalle ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Sexo sexo = new Sexo();
                sexo.setIdSexo(rst.getInt("idSexo"));
                sexo.setDetalle(rst.getString("detalle"));
                
                listaSexo.add(sexo);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaSexo;
    }
    
    public List<Sexo> leerTodos(){
        
        ResultSet rst;
        List<Sexo> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM sexo ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                Sexo sexo = new Sexo();
                sexo.setIdSexo(rst.getInt("idSexo"));
                sexo.setDetalle(rst.getString("detalle"));
                
                lista.add(sexo);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    
}
