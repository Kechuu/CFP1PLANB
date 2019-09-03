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
import modelo.Errores;
/**
 *
 * @author jesus
 */
public class CtrlErrorres {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idEmpleado, Date hora, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO errores (idEmpleado, hora, detalle) VALUES (?,?,?)");
        
            ps.setInt(1, idEmpleado);
            ps.setDate(2, hora);
            ps.setString(3, detalle);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public Errores leer(int idErrores){
        Errores errores = new Errores();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM errores WHERE idErrores = ?");
            
            ps.setInt(1, idErrores);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                errores.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                errores.setHora(rs.getDate("hora"));
                errores.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return errores;
    }
}
