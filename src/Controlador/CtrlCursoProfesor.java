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
    
    public void crear(int idCurso, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoProfesor (idCurso, idEmpleado) VALUES (?,?)");
            
            ps.setInt(1, idCurso);
            ps.setInt(2, idEmpleado);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void modificarHorario(int idHorario, int idCursoProfesor){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoProfesor SET idHorario = ? WHERE idCursoProfesor = ?");
            
            ps.setInt(1, idHorario);
            ps.setInt(2, idCursoProfesor);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void modificarEmpleado(int idEmpleado, int idCursoProfesor){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoProfesor SET idEmpleado = ? WHERE idCursoProfesor = ?");
            
            ps.setInt(1, idEmpleado);
            ps.setInt(2, idCursoProfesor);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void modificarEmpleadoHora(int idHorario, int idEmpleado, int idCursoProfesor){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoProfesor SET idHorario = ?, idEmpleado = ? WHERE idCursoProfesor = ?");
            
            ps.setInt(1, idHorario);
            ps.setInt(2, idEmpleado);
            ps.setInt(3, idCursoProfesor);
            
            int res = ps.executeUpdate();
            
            if (res > 0) {
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
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
