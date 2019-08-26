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
import modelo.Errores;
/**
 *
 * @author jesus
 */
public class CtrlErrorres {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public Errores leer(int id){
        Errores errores = new Errores();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoAlumno WHERE idCursoAlumno = ?");
            
            ps.setInt(1, id);
            
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
