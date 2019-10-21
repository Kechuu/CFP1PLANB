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
        
            ps.setString(1, detalle.toUpperCase());
            
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
            
            ps.setString(1, detalle.toUpperCase());
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
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM tipoDocumento ORDER BY idTipoDocumento LIMIT 1");
            
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
    
    public List<TipoDocumento> cargarListatipoDoc(){
        List<TipoDocumento> listaTipoDoc = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM tipoDocumento ORDER BY detalle ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                TipoDocumento tipoDocumento = new TipoDocumento();
                tipoDocumento.setIdTipoDocumento(rst.getInt("idTipoDocumento"));
                tipoDocumento.setDetalle(rst.getString("detalle"));
                
                listaTipoDoc.add(tipoDocumento);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaTipoDoc;
    }
    
    public List<TipoDocumento> leerTodos(){
        
        ResultSet rst;
        List<TipoDocumento> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM tipoDocumento ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                TipoDocumento tipoDoc = new TipoDocumento();
                tipoDoc.setIdTipoDocumento(rst.getInt("idTipoDocumento"));
                tipoDoc.setDetalle(rst.getString("detalle"));
                
                lista.add(tipoDoc);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    
}
