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
import modelo.EmpleadoCargo;
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
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return empleadoCargo;
    }
}
