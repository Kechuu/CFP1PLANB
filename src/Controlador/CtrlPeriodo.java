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
import modelo.Periodo;
/**
 *
 * @author jesus
 */
public class CtrlPeriodo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO periodo (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idPeriodo, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE periodo SET detalle = ? WHERE idPeriodo = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idPeriodo);
            
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
    
    public Periodo leer(int idPeriodo){
        Periodo periodo = new Periodo();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM periodo WHERE idPeriodo = ?");
            
            ps.setInt(1, idPeriodo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                periodo.setIdPeriodo(rs.getInt("idPeriodo"));
                periodo.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "-Periodo No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return periodo;
    }
}
