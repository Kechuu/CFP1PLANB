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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.EmpleadoTitulo;
import modelo.PlanPersona;
import modelo.Planes;
import modelo.Titulo;
/**
 *
 * @author jesus
 */
public class CtrlEmpleadoTitulo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idTitulo, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO empleadoTitulo (idTitulo, idEmpleado) VALUES (?,?)");
        
            ps.setInt(1, idTitulo);
            ps.setInt(2, idEmpleado);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public void editar(int idEmpleadoTitulo, int idTitulo, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE empleadoTitulo SET idTitulo = ? WHERE idEmpleadoTitulo = ? AND idEmpleado = ? ");
        
            ps.setInt(1, idTitulo);
            ps.setInt(2, idEmpleadoTitulo);
            ps.setInt(3, idEmpleado);
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
    
    public void borrar(int idEmpleadoTitulo, int idTitulo, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("DELETE FROM empleadoTitulo WHERE idEmpleadoTitulo=? AND idEmpleado=? AND idTitulo=?");
            
            ps.setInt(1, idEmpleadoTitulo);
            ps.setInt(2, idEmpleado);
            ps.setInt(3, idTitulo);
            
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
    
    public EmpleadoTitulo leer(int idEmpleadoTitulo){
        EmpleadoTitulo empleadoTitulo = new EmpleadoTitulo();
        CtrlTitulo ctrlTitulo = new CtrlTitulo();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleadoTitulo WHERE idEmpleadoTitulo = ?");
            
            ps.setInt(1, idEmpleadoTitulo);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleadoTitulo.setIdTitulo(ctrlTitulo.leer(rs.getInt("idTitulo")));
                empleadoTitulo.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return empleadoTitulo;
    }
    
    public EmpleadoTitulo leer(int idEmpleado, int idTitulo){
        
        EmpleadoTitulo empleadoTitulo=null;
        CtrlTitulo ctrlTitulo=new CtrlTitulo();
        CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleadoTitulo WHERE idEmpleado = ? AND idTitulo=?");
            
            ps.setInt(1, idEmpleado);
            ps.setInt(2, idTitulo);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleadoTitulo=new EmpleadoTitulo();
                
                empleadoTitulo.setIdEmpleadoTitulo(rs.getInt("idEmpleadoTitulo"));
                empleadoTitulo.setIdEmpleado(ctrlEmpleado.leerIdEmpleado(rs.getInt("idEmpleado")));
                empleadoTitulo.setIdTitulo(ctrlTitulo.leer(rs.getInt("idTitulo")));
                
            }    
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return empleadoTitulo;
    }
    
    
    public void llenarLista(int idEmpleado, JList <Titulo> lista){
        CtrlTitulo ctrlTitulo=new CtrlTitulo();
        EmpleadoTitulo empleadoTitulo;
        
        DefaultListModel<Titulo> modelo=new DefaultListModel<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM empleadoTitulo WHERE idEmpleado=?");
            ps.setInt(1, idEmpleado);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                empleadoTitulo=new EmpleadoTitulo();
                
                empleadoTitulo.setIdTitulo(ctrlTitulo.leer(rs.getInt("idTitulo")));                
                modelo.addElement(empleadoTitulo.getIdTitulo());
                
            }
            
            lista.setModel(modelo);
            con.close();
        }catch(SQLException e){
            
        }
        
    }
}
