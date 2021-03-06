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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Cargo;
/**
 *
 * @author jesus
 */
public class CtrlCargo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cargo (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idCargo, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE cargo SET detalle = ? WHERE idCargo = ?");
            
            ps.setString(1, detalle.toUpperCase());
            ps.setInt(2, idCargo);
            
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
    
    public Cargo leer(int idCargo){
        Cargo cargo = new Cargo();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cargo WHERE idCargo = ?");
            
            ps.setInt(1, idCargo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return cargo;
    }
    
    public void cargarCombo(JComboBox<Cargo> cbCargo){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM cargo ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            Cargo cargo=new Cargo();
            cargo.setIdCargo(0);
            cargo.setDetalle("Seleccione una opción...");
            cbCargo.addItem(cargo);
            
            while (rs.next()) {                
            
                cargo=new Cargo();
                
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setDetalle(rs.getString("detalle"));
                cbCargo.addItem(cargo);
            }
            
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento: "+e.getMessage());       
        }
        
    }
    
    public void cargoEmpleado(int idEmpleado, JComboBox<Cargo> cbCargo){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT cargo.idCargo, cargo.detalle FROM empleado"
                    + " INNER JOIN empleadoCargo ON empleado.idEmpleado = empleadoCargo.idEmpleado"
                    + " INNER JOIN cargo ON empleadoCargo.idCargo = cargo.idCargo"
                    + " WHERE empleado.idEmpleado=?");
            
            ps.setInt(1, idEmpleado);
            
            rs=ps.executeQuery();
            
            Cargo cargo=new Cargo();
            cargo.setIdCargo(0);
            cargo.setDetalle("Seleccione una opción");
            cbCargo.addItem(cargo);
            
            while (rs.next()) {                
            
                cargo=new Cargo();
                
                cargo.setIdCargo(rs.getInt("idCargo"));
                cargo.setDetalle(rs.getString("detalle"));
                cbCargo.addItem(cargo);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR cargos");       
        }
        
    }
    
    public List<Cargo> cargarListaCargo(){
        List<Cargo> listaCargo = new ArrayList();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM cargo ORDER BY detalle ASC");
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rst.getInt("idCargo"));
                cargo.setDetalle(rst.getString("detalle"));
                
                listaCargo.add(cargo);
            } 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaCargo;
    }
    
    public List<Cargo> leerTodos(){
        
        ResultSet rst;
        List<Cargo> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM cargo ORDER BY detalle ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                Cargo cargo = new Cargo();
                cargo.setIdCargo(rst.getInt("idCargo"));
                cargo.setDetalle(rst.getString("detalle"));
                
                lista.add(cargo);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
}