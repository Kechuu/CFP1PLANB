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
import modelo.EstadoEmpleado;
/**
 *
 * @author jesus
 */
public class CtrlEstadoEmpleado {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO estadoEmpleado (detalle) VALUES (?)");
        
            ps.setString(1, detalle);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idEstadoEmpleado, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE estadoEmpleado SET detalle = ? WHERE idEstadoEmpleado = ?");
            
            ps.setString(1, detalle);
            ps.setInt(2, idEstadoEmpleado);
            
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
    
    public EstadoEmpleado leer(int idEstadoEmpleado){
        EstadoEmpleado estadoEmpleado = new EstadoEmpleado();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM estadoEmpleado WHERE idEstadoEmpleado = ?");
            
            ps.setInt(1, idEstadoEmpleado);
            rs = ps.executeQuery();
            
            if(rs.next()){
                estadoEmpleado.setIdEstadoEmpleado(rs.getInt("idEstadoEmpleado"));
                estadoEmpleado.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return estadoEmpleado;
    }
}
