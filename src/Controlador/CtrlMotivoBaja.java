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
import modelo.MotivoBaja;
/**
 *
 * @author jesus
 */
public class CtrlMotivoBaja {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO motivoBaja (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idMotivoBaja, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE motivoBaja SET detalle = ? WHERE idMotivoBaja = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idMotivoBaja);
            
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
    
    public MotivoBaja leer(int idMotivoBaja){
        MotivoBaja motivoBaja = new MotivoBaja();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM motivoBaja WHERE idMotivoBaja = ?");
            
            ps.setInt (1, idMotivoBaja);
            rs = ps.executeQuery();
            
            if(rs.next()){
                motivoBaja.setIdMotivoBaja(rs.getInt("idMotivoBaja"));
                motivoBaja.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "MotBaj No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return motivoBaja;
    }
    public MotivoBaja leer(){
        MotivoBaja motivoBaja = new MotivoBaja();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM motivoBaja ORDER BY idMotivoBaja DESC LIMIT 1");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                motivoBaja.setIdMotivoBaja(rs.getInt("idMotivoBaja"));
                motivoBaja.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "MB No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return motivoBaja;
    }
    public void cargarCombo(JComboBox<MotivoBaja> cbMotivo){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM motivoBaja ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            MotivoBaja motivo=new MotivoBaja();
            motivo.setIdMotivoBaja(0);
            motivo.setDetalle("Seleccione una opción...");
            cbMotivo.addItem(motivo);
            
            while (rs.next()) {                
            
                motivo=new MotivoBaja();
                
                motivo.setIdMotivoBaja(rs.getInt("idMotivoBaja"));
                motivo.setDetalle(rs.getString("detalle"));
                
                cbMotivo.addItem(motivo);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR motivos de baja");       
        }
        
    }
}
