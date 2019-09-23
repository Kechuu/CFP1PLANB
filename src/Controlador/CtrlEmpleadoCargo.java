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
import modelo.Cargo;
import modelo.EmpleadoCargo;
import modelo.EmpleadoTitulo;
import modelo.Titulo;
/**
 *
 * @author jesus
 */
public class CtrlEmpleadoCargo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idCargo, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO empleadoCargo (idCargo,idEmpleado) VALUES (?,?)");
        
            ps.setInt(1, idCargo);
            ps.setInt(2, idEmpleado);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void modificarCargo(int idEmpleadoCargo, int idCargo, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE empleadoCargo SET idCargo = ? WHERE idEmpleadoCargo = ? AND idEmpleado = ? ");
        
            ps.setInt(1, idCargo);
            ps.setInt(2, idEmpleadoCargo);
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
    
    public void borrar(int idEmpleadoCargo, int idCargo, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("DELETE FROM empleadoCargo WHERE idEmpleadoCargo=? AND idEmpleado=? AND idCargo=?");
            
            ps.setInt(1, idEmpleadoCargo);
            ps.setInt(2, idEmpleado);
            ps.setInt(3, idCargo);
            
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
    
    public EmpleadoCargo leer(int idEmpleadoCargo){
        EmpleadoCargo empleadoCargo = new EmpleadoCargo();
        CtrlCargo ctrlCargo = new CtrlCargo();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleadoCargo WHERE idEmpleadoCargo = ?");
            
            ps.setInt(1, idEmpleadoCargo);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleadoCargo.setIdCargo(ctrlCargo.leer(rs.getInt("idCargo")));
                empleadoCargo.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return empleadoCargo;
    }
    
    public EmpleadoCargo leer(int idEmpleado, int idCargo){
        
        EmpleadoCargo empleadoCargo=new EmpleadoCargo();
        CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
        CtrlCargo ctrlCargo=new CtrlCargo();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleadoCargo WHERE idEmpleado = ? AND idCargo=?");
            
            ps.setInt(1, idEmpleado);
            ps.setInt(2, idCargo);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleadoCargo=new EmpleadoCargo();
                
                empleadoCargo.setEmpleadoCargo(rs.getInt("idEmpleadoCargo"));
                empleadoCargo.setIdEmpleado(ctrlEmpleado.leerIdEmpleado(rs.getInt("idEmpleado")));
                empleadoCargo.setIdCargo(ctrlCargo.leer(rs.getInt("idCargo")));
                
            }    
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return empleadoCargo;
    }
    
        public void llenarLista(int idEmpleado, JList <Cargo> lista){
        CtrlCargo ctrlCargo=new CtrlCargo();
        EmpleadoCargo empleadoCargo;
        
        DefaultListModel<Cargo> modelo=new DefaultListModel<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM empleadoCargo WHERE idEmpleado=?");
            ps.setInt(1, idEmpleado);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                empleadoCargo=new EmpleadoCargo();
                
                empleadoCargo.setIdCargo(ctrlCargo.leer(rs.getInt("idCargo")));
                modelo.addElement(empleadoCargo.getIdCargo());
            }
            
            lista.setModel(modelo);
            con.close();
        }catch(SQLException e){
            
        }
        
    }
}
