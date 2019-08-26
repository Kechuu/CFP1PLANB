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
import modelo.TipoDocumento;
/**
 *
 * @author jesus
 */
public class CtrlTipoDocumento {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO tipoDocumento (detalle) VALUES (?)");
        
            ps.setString(1, "");
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE tipoDocumento SET detalle = ? WHERE idTipoDocumento = ?");
            
            ps.setString(1, "");
            ps.setString(2, "");
            
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
    
    public void borrar(){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE tipoDocumento SET borrado = TRUE WHERE idTipoDocumento = ?");
            
            ps.setString(1, "");
            
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
    
    public TipoDocumento leer(int id){
        TipoDocumento tipoDocumento = new TipoDocumento();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM tipoDocumento WHERE idTipoDocumento = ?");
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                tipoDocumento.setDetalle("detalle");
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return tipoDocumento;
    }
}
