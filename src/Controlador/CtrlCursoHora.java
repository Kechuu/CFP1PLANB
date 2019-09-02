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
    
    public void crear(int idHorario, int idCurso){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoHora (idHorario,idCurso) VALUES (?,?)");
            
            ps.setInt(1, idHorario);
            ps.setInt(2, idCurso);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void modificarHorario(int idHorario, int idCursoHora){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoHora SET idHorario = ? WHERE idCursoHora = ?");
            
            ps.setInt(1, idHorario);
            ps.setInt(2, idCursoHora);
            
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
    
    public void modificarCurso(int idCurso, int idCursoHora){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoHora SET idCurso = ? WHERE idCursoHora = ?");
            
            ps.setInt(1, idCurso);
            ps.setInt(2, idCursoHora);
            
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
    
    public void modificarCursoHora(int idHorario, int idCurso, int idCursoHora){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoHora SET idHorario = ?, idCurso = ? WHERE idCursoHora = ?");
            
            ps.setInt(1, idHorario);
            ps.setInt(2, idCurso);
            ps.setInt(3, idCursoHora);
            
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
