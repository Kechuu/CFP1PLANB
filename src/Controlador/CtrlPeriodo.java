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
    
    public List<Periodo> cargarListaPeriodo(){
        List<Periodo> listaPeriodo = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM periodo ORDER BY detalle ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Periodo periodo = new Periodo();
                periodo.setIdPeriodo(rst.getInt("idPeriodo"));
                periodo.setDetalle(rst.getString("detalle"));
                
                listaPeriodo.add(periodo);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaPeriodo;
    }
    
    public List<Periodo> leerTodos(){
        
        ResultSet rst;
        List<Periodo> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM periodo ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                Periodo periodo = new Periodo();
                periodo.setIdPeriodo(rst.getInt("idPeriodo"));
                periodo.setDetalle(rst.getString("detalle"));
                
                lista.add(periodo);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
    public void cargarCombo(JComboBox<Periodo> cbPeriodo){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM periodo ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            Periodo periodo=new Periodo();
            periodo.setIdPeriodo(0);
            periodo.setDetalle("Seleccione una opción...");
            cbPeriodo.addItem(periodo);
            
            while (rs.next()) {                
            
                periodo=new Periodo();
                
                periodo.setIdPeriodo(rs.getInt("idPeriodo"));
                periodo.setDetalle(rs.getString("detalle"));
                cbPeriodo.addItem(periodo);
            }
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento: "+e.getMessage());       
        }
        
    }
    
}
