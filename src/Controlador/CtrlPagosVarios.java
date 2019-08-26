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
import modelo.PagoVarios;
/**
 *
 * @author jesus
 */
public class CtrlPagosVarios {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public PagoVarios leer(int id){
        PagoVarios pagoVarios = new PagoVarios();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        CtrlAlumno ctrlAlumno = new CtrlAlumno();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoAlumno WHERE idCursoAlumno = ?");
            
            ps.setInt(1, id);
            
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
