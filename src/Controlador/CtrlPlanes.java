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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Planes;
/**
 *
 * @author jesus
 */
public class CtrlPlanes {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO planes (detalle,borrado) VALUES (?,?)");
        
            ps.setString(1, detalle);
            ps.setBoolean(2, false);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idPlanes, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE planes SET detalle = ? WHERE idPlanes = ?");
            
            ps.setString(1, detalle);
            ps.setInt(2, idPlanes);
            
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
    
    public void borrar(int idPlanes){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE planes SET borrado = TRUE WHERE idPlanes = ?");
            
            ps.setInt(1, idPlanes);
            
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
    
    public Planes leer(int idPlanes){
        Planes planes = new Planes();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM planes WHERE idPlanes = ?");
            
            ps.setInt(1, idPlanes);
            rs = ps.executeQuery();
            
            if(rs.next()){
                planes.setIdPlanes(rs.getInt("idPlanes"));
                planes.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "-Planes No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return planes;
    }
    
    public void cargarComboPlan(JComboBox <Planes> cb){
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * from planes ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            Planes plan= new Planes();
            plan.setIdPlanes(0);
            plan.setDetalle("Seleccione un plan...");
            cb.addItem(plan);
            
            while(rs.next()){
                plan= new Planes();
                
                plan.setIdPlanes(rs.getInt("idPlanes"));
                plan.setDetalle(rs.getString("detalle"));
                
                cb.addItem(plan);
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
}
