/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString()+"HAAASta");
        }
    }
    
    public void modificarHorario(int idHorario, int idCursoHora, int idCurso){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoHora SET idHorario = ? WHERE idCursoHora = ? AND idCurso = ?");
            
            ps.setInt(1, idHorario);
            ps.setInt(2, idCursoHora);
            ps.setInt(3, idCurso);
            
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
    
    public void modificarCurso(int idCurso, int idCursoHora, int idHorario){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoHora SET idCurso = ? WHERE idCursoHora = ? AND idHorario = ?");
            
            ps.setInt(1, idCurso);
            ps.setInt(2, idCursoHora);
            ps.setInt(3, idHorario);
            
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
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoHora SET idHorario = ?, idCurso = ? WHERE idCursoHora = ? AND "
                    + "idCurso = ? AND idHorario");
            
            ps.setInt(1, idHorario);
            ps.setInt(2, idCurso);
            ps.setInt(3, idCursoHora);
            ps.setInt(4, idCurso);
            ps.setInt(5, idHorario);
            
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
    
    public void eliminarCursoHora(int idCurso){
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("DELETE * FROM cursoHora WHERE idCurso = ?");
            
            ps.setInt(1, idCurso);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Se eliminaron los horarios viejos");
            }else{
                JOptionPane.showMessageDialog(null, "Holaaaaa");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    public CursoHora leer(int idCurso){//ANTES RECIBIA UN ID DE CURSO HORA
        CursoHora cursoHora = new CursoHora();
        CtrlHorario ctrlHorario = new CtrlHorario();
        CtrlCurso ctrlCurso = new CtrlCurso();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoHora WHERE idCurso = ?");
            
            ps.setInt(1, idCurso);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoHora.setIdCursoHora(rs.getInt("idCursoHora"));
                //cursoHora.setIdHorario(ctrlHorario.leer(rs.getInt("idHorario")));
                cursoHora.setIdCurso(ctrlCurso.leerCurso(rs.getInt("idCurso")));//VER BIEN
        //leer de CtrlCurso te regresa un obj donde coincidan datos del campo TipoCurso, idTipoCurso no es igual a idCurso
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return cursoHora;
    }
}
