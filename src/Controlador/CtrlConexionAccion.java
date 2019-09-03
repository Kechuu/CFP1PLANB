/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import javax.swing.JOptionPane;
import modelo.ConexionAcciones;
/**
 *
 * @author jesus
 */
public class CtrlConexionAccion {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idEmpleado, String detalle, Date fecha){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO conexionAccion (idEmpleado,detalle,fecha) VALUES (?,?,?)");
            
            ps.setInt(1, idEmpleado);
            ps.setString(2, detalle);
            ps.setDate(3, fecha);
            
            int res = ps.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    /*
    public ConexionAcciones leerTodoHistorialPersonal(int idEmpleado){
        ConexionAcciones accion = new ConexionAcciones();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM conexionAccion WHERE idEmpleado = ?");
            
            ps.setInt(1, idEmpleado);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                accion.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                accion.setDetalle(rs.getString("detalle"));
                accion.setFecha(rs.getDate("fecha"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return accion;
    }
    
    public ConexionAcciones leerHistorialPorFechayEmpleado(Date fecha,int idEmpleado){
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        ConexionAcciones accion = new ConexionAcciones();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM conexionAccion WHERE idEmpleado = ? AND fecha = ?");
            
            ps.setInt(1, idEmpleado);
            ps.setDate(2, fecha);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                accion.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                accion.setDetalle(rs.getString("detalle"));
                accion.setFecha(rs.getDate("fecha"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return accion;
    }
    
    public ConexionAcciones leerHistorialPorFecha(Date fecha){
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        ConexionAcciones accion = new ConexionAcciones();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM conexionAccion WHERE fecha = ?");
            
            ps.setDate(1, fecha);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                accion.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                accion.setDetalle(rs.getString("detalle"));
                accion.setFecha(rs.getDate("fecha"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return accion;
    }
    
    public ConexionAcciones leerTodoHistorialCompleto(){
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        ConexionAcciones accion = new ConexionAcciones();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM conexionAccion");
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                accion.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                accion.setDetalle(rs.getString("detalle"));
                accion.setFecha(rs.getDate("fecha"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return accion;
    }
    */
}
