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
import modelo.Curso;

/**
 *
 * @author jesus
 */
public class CtrlCurso {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public Curso leer(int id){
        Curso curso = new Curso();
        CtrlTipoCurso ctrlTipoCurso = new CtrlTipoCurso();
        CtrlLugarCurso ctrlLugarCurso = new CtrlLugarCurso();
        CtrlPeriodicidad ctrlPeriodicidad = new CtrlPeriodicidad();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM curso WHERE idCurso = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
            curso.setCicloLectivo(rs.getInt("cicloLectivo"));
            curso.setTurno(rs.getInt("turno"));
            curso.setCosto(rs.getFloat("costo"));
            curso.setCupo(rs.getInt("cupo"));
            curso.setFechaInicio(rs.getDate("fechaInicio"));
            curso.setFechaFinalizacion(rs.getDate("fechaFinalizacion"));
            curso.setIdTipoCurso(ctrlTipoCurso.leer(rs.getInt("idTipoCurso")));
            curso.setIdLugarCurso(ctrlLugarCurso.leer(rs.getInt("idLugarCurso")));
            curso.setIdPeriodicidad(ctrlPeriodicidad.leer(rs.getInt("idPeriodicidad")));
            curso.setBorrado(rs.getBoolean("borrado"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return curso;
    }
}
