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
import modelo.PlanPersona;
/**
 *
 * @author jesus
 */
public class CtrlPlanPersona {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public PlanPersona leer(int id){
        PlanPersona planPersona = new PlanPersona();
        CtrlPersona ctrlPersona = new CtrlPersona();
        CtrlPlanes ctrlPlanes = new CtrlPlanes();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoAlumno WHERE idCursoAlumno = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                planPersona.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                planPersona.setIdPlanes(ctrlPlanes.leer(rs.getInt("idPlanes")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return planPersona;
    }
}
