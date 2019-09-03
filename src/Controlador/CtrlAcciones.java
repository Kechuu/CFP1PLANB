/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Acciones;
/**
 *
 * @author jesus
 */
public class CtrlAcciones {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idEmpleado, Date desde){
     
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO acciones (idEmpleado,desde) VALUES (?,?)");
        
            ps.setInt(1, idEmpleado);
            ps.setDate(2, desde);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    
    public void cerrarSesion(int idEmpleado, Date hasta){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE acciones SET hasta = ? WHERE idEmpleado = ?");
            
            ps.setDate(1, hasta);
            ps.setInt(2, idEmpleado);
            
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
    /*
    public Acciones leer(int idEmpleado){
        Acciones acciones = new Acciones();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM acciones WHERE idEmpleado = ?");
            
            ps.setInt(1, idEmpleado);
            rs = ps.executeQuery();
            
            if(rs.next()){
                acciones.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                acciones.setDesde(rs.getDate("desde"));
                acciones.setHasta(rs.getDate("hasta"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return acciones;
    }
    
    public void leerTodasLasAcciones(JTable tabla){
        Acciones acciones = new Acciones();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Empleado");
        modelo.addColumn("Inició Sesion");
        modelo.addColumn("Cerró Sesion");
        tabla.setModel(modelo);
        //Terminar bien :v
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM acciones");
            
            rs = ps.executeQuery();
            
            if(rs.next()){
                acciones.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                acciones.setDesde(rs.getDate("desde"));
                acciones.setHasta(rs.getDate("hasta"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    //Falta el método de Leer id del empleado que se conectó
    */
}
