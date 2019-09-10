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
import modelo.TipoDocumento;
/**
 *
 * @author jesus
 */
public class CtrlTipoDocumento {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO tipoDocumento (detalle) VALUES (?)");
        
            ps.setString(1, detalle);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idTipoDocumento, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE tipoDocumento SET detalle = ? WHERE idTipoDocumento = ?");
            
            ps.setString(1, detalle);
            ps.setInt(2, idTipoDocumento);
            
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
    
    public TipoDocumento leer(){
        TipoDocumento tipoDocumento = new TipoDocumento();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM tipoDocumento");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                tipoDocumento.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return tipoDocumento;
    }
    
    public TipoDocumento leer(int idTipoDocumento){
        TipoDocumento tipoDocumento = new TipoDocumento();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM tipoDocumento");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                tipoDocumento.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                tipoDocumento.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return tipoDocumento;
    }
    
    public void cargarComboTipoDocumento(JComboBox<TipoDocumento> cbTipoDoc){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM tipoDocumento ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            TipoDocumento tipoDocumento = new TipoDocumento();
            tipoDocumento.setIdTipoDocumento(0);
            tipoDocumento.setDetalle("Seleccione una opcion...");
            cbTipoDoc.addItem(tipoDocumento);
            
            while (rs.next()) {                
                tipoDocumento = new TipoDocumento();
                
                tipoDocumento.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
                tipoDocumento.setDetalle(rs.getString("detalle"));
                cbTipoDoc.addItem(tipoDocumento);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento");       
        }
        
    }
}
