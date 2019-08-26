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
import modelo.Empleado;
import modelo.Persona;
import modelo.EstadoEmpleado;
import modelo.Gremio;
/**
 *
 * @author jesus
 */
public class CtrlEmpleado {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public Empleado leer(int id){
        Empleado empleado = new Empleado();
        CtrlPersona ctrlPersona = new CtrlPersona();
        CtrlEstadoEmpleado ctrlEstadoEmpleado = new CtrlEstadoEmpleado();
        CtrlGremio ctrlGremio = new CtrlGremio();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleado WHERE idEmpleado = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleado.setLegajo(rs.getString("legajo"));
                empleado.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                empleado.setIdEstadoEmpleado(ctrlEstadoEmpleado.leer(rs.getInt("idEstadoEmpleado")));
                empleado.setIdGremio(ctrlGremio.leer(rs.getInt("idGremio")));
                empleado.setBorrado(rs.getBoolean("borrado"));
                }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return empleado;
    }
}
