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
import modelo.Pago;
/**
 *
 * @author jesus
 */
public class CtrlPago {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public Pago leer(int id){
        Pago pago = new Pago();
        CtrlEmpleado ctrlCobrador = new CtrlEmpleado();
        CtrlCursoAlumno ctrlCursoAlumno = new CtrlCursoAlumno();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM pago WHERE idPago = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pago.setFecha(rs.getDate("fecha"));
                pago.setImporte(rs.getFloat("importe"));
                pago.setIdCobrador(ctrlCobrador.leer(rs.getInt("idEmpleado")));
                pago.setIdCursoAlumno(ctrlCursoAlumno.leer(rs.getInt("idCursoAlumno")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return pago;
    }
}
