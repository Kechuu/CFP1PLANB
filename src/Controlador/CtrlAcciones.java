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
import modelo.Acciones;
/**
 *
 * @author jesus
 */
public class CtrlAcciones {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(Acciones acciones){
     
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO acciones (idEmpleado,desde,hasta) VALUES (?,?,?)");
        
            ps.setInt(1, acciones.getIdEmpleado().getIdEmpleado());
            ps.setDate(2, acciones.getDesde());
            ps.setDate(3, acciones.getHasta());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    
    public void actualizar(Acciones acciones){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE acciones SET hasta = ? WHERE idAcciones = ?");
            
            ps.setDate(1, acciones.getHasta());
            ps.setInt(2, acciones.getIdConexion());
            
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
    
    public void leer(Acciones acciones){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM acciones WHERE idAcciones = ?");
            
            ps.setInt (1, acciones.getIdConexion());
            rs = ps.executeQuery();
            
            if(rs.next()){
                //Cargar Caja de texto y combo box
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    //Falta el método de Leer id del empleado que se conectó
    
}
