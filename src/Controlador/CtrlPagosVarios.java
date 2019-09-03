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
import modelo.PagoVarios;
/**
 *
 * @author jesus
 */
public class CtrlPagosVarios {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(Date fecha, String detalle, float importe, int idEmpleado, int idAlumno){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO pagosVarios (fecha,detalle,importe,idEmpleado,idAlumno) "
                    + "VALUES (?,?,?,?,?)");
        
            ps.setDate(1, fecha);
            ps.setString(2, detalle);
            ps.setFloat(3, importe);
            ps.setInt(4, idEmpleado);
            ps.setInt(5, idAlumno);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public PagoVarios leer(int idPagosVarios){
        PagoVarios pagoVarios = new PagoVarios();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        CtrlAlumno ctrlAlumno = new CtrlAlumno();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM pagosVarios WHERE idPagosVarios = ?");
            
            ps.setInt(1, idPagosVarios);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pagoVarios.setFecha(rs.getDate("fecha"));
                pagoVarios.setDetalle(rs.getString("detalle"));
                pagoVarios.setImporte(rs.getInt("importe"));
                pagoVarios.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                pagoVarios.setIdAlumno(ctrlAlumno.leer(rs.getInt("idAlumno")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return pagoVarios;
    }
}
