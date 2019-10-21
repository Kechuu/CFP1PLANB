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
import modelo.LugarCurso;
/**
 *
 * @author jesus
 */
public class CtrlLugarCurso {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO lugarCurso (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idLugarCurso, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE lugarCurso SET detalle = ? WHERE idLugarCurso = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idLugarCurso);
            
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
    
    public LugarCurso leer(int idLugarCurso){
        LugarCurso lugarCurso = new LugarCurso();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM lugarCurso WHERE idLugarCurso = ?");
            
            ps.setInt(1, idLugarCurso);
            rs = ps.executeQuery();
            
            if(rs.next()){
                lugarCurso.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return lugarCurso;
    }
    
    public List<LugarCurso> cargarListaCursado(){
        List<LugarCurso> listaCursado = new ArrayList();
        ResultSet rst;
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM lugarCurso ORDER BY detalle ASC");
            rst= ps.executeQuery();
            
            while (rst.next()) {
                LugarCurso lugarCurso = new LugarCurso();
                lugarCurso.setIdLugarCurso(rst.getInt("idLugarCurso"));
                lugarCurso.setDetalle(rst.getString("detalle"));
                
                listaCursado.add(lugarCurso);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
        return listaCursado;
    }
    
    public List<LugarCurso> leerTodos(){
        
        ResultSet rst;
        List<LugarCurso> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM lugarCurso ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                LugarCurso lugarCurso = new LugarCurso();
                lugarCurso.setIdLugarCurso(rst.getInt("idLugarCurso"));
                lugarCurso.setDetalle(rst.getString("detalle"));
                
                lista.add(lugarCurso);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    public void cargarCombo(JComboBox<LugarCurso> cbLugarCurso){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM lugarCurso ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            LugarCurso lugarCurso=new LugarCurso();
            lugarCurso.setIdLugarCurso(0);
            lugarCurso.setDetalle("Seleccione una opción...");
            cbLugarCurso.addItem(lugarCurso);
            
            while (rs.next()) {                
            
                lugarCurso=new LugarCurso();
                
                lugarCurso.setIdLugarCurso(rs.getInt("idLugarCurso"));
                lugarCurso.setDetalle(rs.getString("detalle"));
                cbLugarCurso.addItem(lugarCurso);
            }
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento: "+e.getMessage());       
        }
        
    }
    
}
