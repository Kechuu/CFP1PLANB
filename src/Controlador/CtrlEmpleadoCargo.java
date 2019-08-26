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
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public EmpleadoCargo leer(int id){
        EmpleadoCargo empleadoCargo = new EmpleadoCargo();
        CtrlCargo ctrlCargo = new CtrlCargo();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleadoCargo WHERE idEmpleadoCargo = ?");
            
            ps.setInt(1, id);
            
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
