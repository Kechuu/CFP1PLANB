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
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.CursoAlumno;
import modelo.TipoCurso;
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
        
        java.sql.Date fecha1=new Date(fechaIngreso.getTime());
        
        try {
          
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoAlumno (saldo,fechaIngreso,"
                    + "fechaBaja, idAlumno,idEstadoAlumno,idCurso,idMotivoBaja) VALUES (?,?,?,?,?,?,?)");
            
            ps.setFloat(1, saldo);
            ps.setDate(2, fecha1);
            ps.setDate(3, null);
            ps.setInt(4, idAlumno);
            ps.setInt(5, idEstadoAlumno);
            ps.setInt(6, idCurso);
            ps.setInt(7, idMotivoBaja);
            
            int res = ps.executeUpdate();
            con.close();
           
        } catch (HeadlessException | SQLException e ) {
            JOptionPane.showMessageDialog(null, "ES CURSO ALUMNO!!!");
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }        
    }
    
    public void editar(int idCursoAlumno, int idCurso){
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("UPDATE cursoAlumno SET idCurso =? WHERE idCursoAlumno = ?");
            ps.setInt(1, idCurso);
            ps.setInt(2, idCursoAlumno);
            
            ps.execute();
            
            con.close();
        }catch(SQLException e){
            
        }
    }
    
    public void alumnoBajaEgresado(int idAlumno,int idCurso, int idMotivoBaja,int idEstadoAlumno, java.util.Date fechaBajaEgreso){
        
        java.sql.Date fecha=new Date(fechaBajaEgreso.getTime());
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoAlumno SET fechaBaja = ?, idMotivoBaja = ?,"
                    + " idEstadoAlumno = ? WHERE idAlumno = ? AND idCurso = ?");
            
            ps.setDate(1, fecha);
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
    
    public CursoAlumno leer(int idAlumno, int idCurso){
        CursoAlumno cursoAlumno = new CursoAlumno();
        CtrlAlumno ctrlAlumno = new CtrlAlumno();
        CtrlEstadoAlumno ctrlEstadoAlumno = new CtrlEstadoAlumno();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlMotivoBaja ctrlMotivoBaja = new CtrlMotivoBaja();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoAlumno WHERE idAlumno=? AND idCurso=?");
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idCurso);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoAlumno.setIdCursoAlumno(rs.getInt("idCursoAlumno"));
                cursoAlumno.setSaldo(rs.getFloat("saldo"));
                cursoAlumno.setFechaIngreso(rs.getDate("fechaIngreso"));
                cursoAlumno.setFechaBajaEgreso(rs.getDate("fechaBaja"));
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
    
    public void llenarLista(int idAlumno, JList<TipoCurso>lista){
    //Este metodo llena lista de los cursos que esta cursando actualmente un determinado alumno
        DefaultListModel <TipoCurso> modelo=new DefaultListModel<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT tipoCurso.idTipoCurso, tipoCurso.detalle FROM cursoAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoAlumno.idAlumno = ? AND cursoAlumno.idEstadoAlumno = 1");
            ps.setInt(1, idAlumno);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoCurso tipoCurso=new TipoCurso();
                
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                
                modelo.addElement(tipoCurso);
            }
            lista.setModel(modelo);
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    public void cargarCombo(int idAlumno, JComboBox<TipoCurso> cbCurso){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT tipoCurso.idTipoCurso, tipoCurso.detalle, cursoAlumno.costo FROM cursoAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoAlumno.idAlumno = ?");
            
            ps.setInt(1, idAlumno);
            rs=ps.executeQuery();
            
            TipoCurso tipoCurso=new TipoCurso();
            tipoCurso.setIdTipoCurso(0);
            tipoCurso.setDetalle("Seleccione una opción...");
            cbCurso.addItem(tipoCurso);
            
            while (rs.next()) {      
                
                tipoCurso=new TipoCurso();
                
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setCosto(rs.getFloat("cursoAlumno.costo"));
                
                cbCurso.addItem(tipoCurso);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento");       
        }
        
    }
}
