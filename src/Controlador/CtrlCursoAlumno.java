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
import modelo.CursoAlumno;
/**
 *
 * @author jesus
 */
public class CtrlCursoAlumno {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(float saldo, Date fechaIngreso, int idAlumno, int idEstadoAlumno, int idCurso,
            int idMotivoBaja){
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoAlumno (saldo,fechaIngreso,"
                    + "idAlumno,idEstadoAlumno,idCurso,idMotivoBaja) VALUES (?,?,?,?,?,?)");
            
            ps.setFloat(1, saldo);
            ps.setDate(2, fechaIngreso);
            ps.setInt(3, idAlumno);
            ps.setInt(4, idEstadoAlumno);
            ps.setInt(5, idCurso);
            ps.setInt(6, idMotivoBaja);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    public void alumnoBajaEgresado(int idAlumno,int idCurso, int idMotivoBaja,int idEstadoAlumno, Date fechaBajaEgreso){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoAlumno SET fechaBaja-Egreso = ?, idMotivoBaja = ?, idEstadoAlumno = ? WHERE idAlumno = ? AND idCurso = ?");
            
            ps.setDate(1, fechaBajaEgreso);
            ps.setInt(2, idMotivoBaja);
            ps.setInt(3, idEstadoAlumno);
            ps.setInt(4, idAlumno);
            ps.setInt(5, idCurso);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void pagarSaldo(int idAlumno,int idCurso, float saldo){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoAlumno SET saldo = ? WHERE idAlumno = ? AND idCurso = ?");
            
            ps.setFloat(1, saldo);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idCurso);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public CursoAlumno leer(int id){
        CursoAlumno cursoAlumno = new CursoAlumno();
        CtrlAlumno ctrlAlumno = new CtrlAlumno();
        CtrlEstadoAlumno ctrlEstadoAlumno = new CtrlEstadoAlumno();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlMotivoBaja ctrlMotivoBaja = new CtrlMotivoBaja();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoAlumno WHERE idCursoAlumno = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoAlumno.setSaldo(rs.getFloat("saldo"));
                cursoAlumno.setFechaIngreso(rs.getDate("fechaIngreso"));
                cursoAlumno.setFechaBajaEgreso(rs.getDate("fechaBaja-Egreso"));
                cursoAlumno.setIdAlumno(ctrlAlumno.leer(rs.getInt("idAlumno")));
                cursoAlumno.setIdEstadoAlumno(ctrlEstadoAlumno.leer(rs.getInt("idEstadoAlumno")));
                cursoAlumno.setIdCurso(ctrlCurso.leer(rs.getInt("idCurso")));
                cursoAlumno.setIdMotivoBaja(ctrlMotivoBaja.leer(rs.getInt("idMotivoBaja")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
        return cursoAlumno;
    }
}
