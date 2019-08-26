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
import modelo.CursoProfesor;
/**
 *
 * @author jesus
 */
public class CtrlCursoProfesor {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public CursoProfesor leer(int id){
        CursoProfesor cursoProfesor = new CursoProfesor();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoProfesor WHERE idCursoProfesor = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoProfesor.setIdCurso(ctrlCurso.leer(rs.getInt("idCurso")));
                cursoProfesor.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return cursoProfesor;
    }
}
