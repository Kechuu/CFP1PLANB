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
import modelo.Empleado;
/**
 *
 * @author jesus
 */
public class CtrlEmpleado {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(java.util.Date fechaIngreso, int idPersona, int idEstadoEmpleado, int idGremio){
        
        java.sql.Date fecha=new Date(fechaIngreso.getTime());
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO empleado (fechaIngreso,idPersona,idEstadoEmpleado,"
                    + "idGremio,borrado) VALUES (?,?,?,?,?)");
        
            ps.setDate(1, fecha);
            ps.setInt(2, idPersona);
            ps.setInt(3, idEstadoEmpleado);
            ps.setInt(4, idGremio);
            ps.setBoolean(5, false);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void darDeBaja(Date fechaBaja, int idPersona, int idEstadoEmpleado, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE empleado SET fechaBaja = ?, borrado = ?, idEstadoEmpleado = ?"
                    + " WHERE idEmpleado = ? AND idPersona = ?");
            
            ps.setDate(1, fechaBaja);
            ps.setBoolean(2, true);
            ps.setInt(3, idEstadoEmpleado);
            ps.setInt(4, idEmpleado);
            ps.setInt(5, idPersona);
            
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
    
    public void modificar(int idEmpleado, int idPersona, int idEstadoEmpleado, int idGremio){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE empleado SET idEstadoEmpleado = ?, idGremio = ? "
                    + " WHERE idEmpleado = ? AND idPersona = ?");
            
            ps.setInt(1, idEstadoEmpleado);
            ps.setInt(2, idGremio);
            ps.setInt(3, idEmpleado);
            ps.setInt(4, idPersona);
            
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
    
    public Empleado leer(int idPersona){
        Empleado empleado = new Empleado();
        CtrlPersona ctrlPersona = new CtrlPersona();
        CtrlEstadoEmpleado ctrlEstadoEmpleado = new CtrlEstadoEmpleado();
        CtrlGremio ctrlGremio = new CtrlGremio();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleado WHERE idPersona = ? AND borrado = FALSE");
            
            ps.setInt(1, idPersona);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                empleado.setIdEstadoEmpleado(ctrlEstadoEmpleado.leer(rs.getInt("idEstadoEmpleado")));
                empleado.setIdGremio(ctrlGremio.leer(rs.getInt("idGremio")));
                }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return empleado;
    }
    
    public Empleado leerIdEmpleado(int idEmpleado){
        Empleado empleado = new Empleado();
        CtrlPersona ctrlPersona = new CtrlPersona();
        CtrlEstadoEmpleado ctrlEstadoEmpleado = new CtrlEstadoEmpleado();
        CtrlGremio ctrlGremio = new CtrlGremio();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleado WHERE idEmpleado = ? AND borrado = FALSE");
            
            ps.setInt(1, idEmpleado);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                empleado.setIdEstadoEmpleado(ctrlEstadoEmpleado.leer(rs.getInt("idEstadoEmpleado")));
                empleado.setIdGremio(ctrlGremio.leer(rs.getInt("idGremio")));
                }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return empleado;
    }
    public Empleado leer(){
        Empleado empleado = new Empleado();
        CtrlPersona ctrlPersona = new CtrlPersona();
        CtrlEstadoEmpleado ctrlEstadoEmpleado = new CtrlEstadoEmpleado();
        CtrlGremio ctrlGremio = new CtrlGremio();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleado ORDER BY idEmpleado DESC LIMIT 1");
           
            rs = ps.executeQuery();
            
            if (rs.next()) {
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                empleado.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                empleado.setIdEstadoEmpleado(ctrlEstadoEmpleado.leer(rs.getInt("idEstadoEmpleado")));
                empleado.setIdGremio(ctrlGremio.leer(rs.getInt("idGremio")));
                }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return empleado;
    }
}
