/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
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
    
    public void crear(float saldo, java.util.Date fechaIngreso, int idAlumno, int idEstadoAlumno, int idCurso,
            int idMotivoBaja){
        
        //java.util.Date dateT=new java.util.Date();
      
        java.sql.Date fecha1=new Date(fechaIngreso.getTime());
        //JOptionPane.showMessageDialog(null, fechaIngreso+" $$"+fecha1);
        /*
        java.util.Date date = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        */
        try {
          
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoAlumno (saldo,fechaIngreso,"
                    + "fechaBaja, idAlumno,idEstadoAlumno,idCurso,idMotivoBaja) VALUES (?,?,?,?,?,?,?)");
            
            ps.setFloat(1, saldo);
            ps.setDate(2, fecha1);
            ps.setDate(3, fecha1);
            ps.setInt(4, idAlumno);
            ps.setInt(5, idEstadoAlumno);
            ps.setInt(6, idCurso);
            ps.setInt(7, idMotivoBaja);
            
            int res = ps.executeUpdate();
            con.close();
            JOptionPane.showMessageDialog(null, "LLEGO HASTA EL FINAL. CURSO ALUMNO");
            
        } catch (HeadlessException | SQLException e ) {
            JOptionPane.showMessageDialog(null, "ES CURSO ALUMNO!!!");
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    public void alumnoBajaEgresado(int idAlumno,int idCurso, int idMotivoBaja,int idEstadoAlumno, Date fechaBajaEgreso){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoAlumno SET fechaBaja-Egreso = ?, idMotivoBaja = ?,"
                    + " idEstadoAlumno = ? WHERE idAlumno = ? AND idCurso = ?");
            
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
    
    public CursoAlumno leer(int idCursoAlumno){
        CursoAlumno cursoAlumno = new CursoAlumno();
        CtrlAlumno ctrlAlumno = new CtrlAlumno();
        CtrlEstadoAlumno ctrlEstadoAlumno = new CtrlEstadoAlumno();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlMotivoBaja ctrlMotivoBaja = new CtrlMotivoBaja();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoAlumno WHERE idCursoAlumno = ?");
            
            ps.setInt(1, idCursoAlumno);
            
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
