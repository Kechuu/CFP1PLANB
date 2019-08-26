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
import modelo.CursoHora;
/**
 *
 * @author jesus
 */
public class CtrlCursoHora {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public CursoHora leer(int id){
        CursoHora cursoHora = new CursoHora();
        CtrlHorario ctrlHorario = new CtrlHorario();
        CtrlCurso ctrlCurso = new CtrlCurso();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoHora WHERE idCursoHora = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoHora.setIdHorario(ctrlHorario.leer(rs.getInt("idHorario")));
                cursoHora.setIdCurso(ctrlCurso.leer(rs.getInt("idCurso")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return cursoHora;
    }
}
