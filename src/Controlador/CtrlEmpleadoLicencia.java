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
import modelo.EmpleadoLicencia;
/**
 *
 * @author jesus
 */
public class CtrlEmpleadoLicencia {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(Date inicio, Date fin, int idEmpleado, int idLicencia){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO empleadoLicencia (inicio,fin, idEmpleado, idLicencia) VALUES (?,?,?,?)");
        
            ps.setDate(1, inicio);
            ps.setDate(2, fin);
            ps.setInt(3, idEmpleado);
            ps.setInt(4, idLicencia);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void finDeLicencia(int idLicenciaEmpleado ,int idEmpleado ,Date fin){
        
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
