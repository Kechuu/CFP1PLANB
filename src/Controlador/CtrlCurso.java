/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.Date;
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
    
    public void crear(int cicloLectivo, int turno, float costo, int cupo, Date fechaInicio, Date fechaFinalizacion,
    int idTipoCurso,int idLugarCurso, int idPeriodicidad, boolean borrado){
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO curso (cicloLectivo,turno,costo,cupo,fechaInicio,fechaFinalizacion,idTipoCurso,idLugarCurso,idPeriodicidad,borrado) VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, cicloLectivo);
            ps.setInt(2, turno);
            ps.setFloat(3, costo);
            ps.setInt(4, cupo);
            ps.setDate(5, fechaInicio);
            ps.setDate(6, fechaFinalizacion);
            ps.setInt(7, idTipoCurso);
            ps.setInt(8, idLugarCurso);
            ps.setInt(9, idPeriodicidad);
            ps.setBoolean(10, borrado);
            
            int res = ps.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    public void editar(int id, int cicloLectivo, int turno, float costo, int cupo, Date fechaInicio, Date fechaFinalizacion,
    int idTipoCurso,int idLugarCurso, int idPeriodicidad, boolean borrado){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE curso SET cicloLectivo = ?, turno = ?, costo = ?, cupo = ?,"
                    + "fechaInicio = ?, fechaFinalizacion = ?, idTipoCurso = ?, idLugarCurso = ?, idPeriodicidad = ?,  borrado = ? WHERE idCurso = ?");
            
            ps.setInt(1, cicloLectivo);
            ps.setInt(2, turno);
            ps.setFloat(3, costo);
            ps.setInt(4, cupo);
            ps.setDate(5, fechaInicio);
            ps.setDate(6, fechaFinalizacion);
            ps.setInt(7, idTipoCurso);
            ps.setInt(8, idLugarCurso);
            ps.setInt(9, idPeriodicidad);
            ps.setBoolean(10, borrado);
            ps.setInt(11, id);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void borrar(int id){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE curso SET borrado = TRUE WHERE idCurso = ?");
            
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
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
