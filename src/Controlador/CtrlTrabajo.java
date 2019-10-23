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
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import modelo.Trabajo;
/**
 *
 * @author jesus
 */
public class CtrlTrabajo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO trabajo (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idTrabajo, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE trabajo SET detalle = ? WHERE idTrabajo = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idTrabajo);
            
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
    
    public Trabajo leer(int idTrabajo){
        Trabajo trabajo = new Trabajo();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM trabajo WHERE idTrabajo = ?");
            
            ps.setInt(1, idTrabajo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                trabajo.setIdTrabajo(rs.getInt("idTrabajo"));
                trabajo.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return trabajo;
    }
    
    public void cargarComboTrabajo(JComboBox <Trabajo> cb){
        
        try{
            con = clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * from trabajo ORDER BY detalle ASC");
            rs=ps.executeQuery();
         
            Trabajo trabajo = new Trabajo();
            trabajo.setIdTrabajo(0);
            trabajo.setDetalle("Selecciones una opción...");
            
            cb.addItem(trabajo);
            
            while(rs.next()){
                trabajo= new Trabajo();
                
                trabajo.setIdTrabajo(rs.getInt("idTrabajo"));
                trabajo.setDetalle(rs.getString("detalle"));
                cb.addItem(trabajo);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    public List<Trabajo> cargarListaTrabajo(){
        List<Trabajo> listaTrabajo = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM trabajo ORDER BY detalle ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Trabajo trabajo = new Trabajo();
                trabajo.setIdTrabajo(rst.getInt("idTrabajo"));
                trabajo.setDetalle(rst.getString("detalle"));
                
                listaTrabajo.add(trabajo);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaTrabajo;
    }
    
    public List<Trabajo> leerTodos(){
        
        ResultSet rst;
        List<Trabajo> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM trabajo ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                Trabajo trabajo = new Trabajo();
                trabajo.setIdTrabajo(rst.getInt("idTrabajo"));
                trabajo.setDetalle(rst.getString("detalle"));
                
                lista.add(trabajo);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    
}
