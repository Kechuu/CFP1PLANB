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
import modelo.EmpleadoLicencia;
/**
 *
 * @author jesus
 */
public class CtrlEmpleadoLicencia {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public EmpleadoLicencia leer(int id){
        EmpleadoLicencia empleadoLicencia = new EmpleadoLicencia();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        CtrlLicencia ctrlLicencia = new CtrlLicencia();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleadoLicencia WHERE idEmpleadoLicencia = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleadoLicencia.setInicio(rs.getDate("inicio"));
                empleadoLicencia.setFin(rs.getDate("fin"));
                empleadoLicencia.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                empleadoLicencia.setIdLicencia(ctrlLicencia.leer(rs.getInt("idLicencia")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return empleadoLicencia;
    }
}
