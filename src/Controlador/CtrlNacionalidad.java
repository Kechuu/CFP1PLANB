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
import javax.swing.JOptionPane;
import modelo.Nacionalidad;
/**
 *
 * @author jesus
 */
public class CtrlNacionalidad {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO nacionalidad (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idNacionalidad, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE nacionalidad SET detalle = ? WHERE idNacionalidad = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idNacionalidad);
            
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
    
    public Nacionalidad leer(int idNacionalidad){
        Nacionalidad nacionalidad = new Nacionalidad();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM nacionalidad WHERE idNacionalidad = ?");
            
            ps.setInt(1, idNacionalidad);
            rs = ps.executeQuery();
            
            if(rs.next()){
                nacionalidad.setIdNacionalidad(rs.getInt("idNacionalidad"));
                nacionalidad.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return nacionalidad;
    }
    
    public void cargarComboNacionalidad(JComboBox <Nacionalidad> cb){
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM nacionalidad ORDER BY detalle ASC");
            
            rs=ps.executeQuery();
            Nacionalidad nacion= new Nacionalidad();
            nacion.setIdNacionalidad(0);
            nacion.setDetalle("Seleccione una opción...");
           
            cb.addItem(nacion);
            
            while(rs.next()){
                
                nacion= new Nacionalidad();
                
                nacion.setIdNacionalidad(rs.getInt("idNacionalidad"));
                nacion.setDetalle(rs.getString("detalle"));
                cb.addItem(nacion);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    public List<Nacionalidad> cargarListaNacionalidad(){
        List<Nacionalidad> listaNacionalidad = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM nacionalidad ORDER BY detalle ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Nacionalidad nacionalidad = new Nacionalidad();
                nacionalidad.setIdNacionalidad(rst.getInt("idNacionalidad"));
                nacionalidad.setDetalle(rst.getString("detalle"));
                
                listaNacionalidad.add(nacionalidad);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaNacionalidad;
    }
    
    public List<Nacionalidad> leerTodos(){
        
        ResultSet rst;
        List<Nacionalidad> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM nacionalidad ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                Nacionalidad nacionalidad = new Nacionalidad();
                nacionalidad.setIdNacionalidad(rst.getInt("idNacionalidad"));
                nacionalidad.setDetalle(rst.getString("detalle"));
                
                lista.add(nacionalidad);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    
}
