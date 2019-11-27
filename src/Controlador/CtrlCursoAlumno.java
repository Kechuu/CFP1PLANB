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
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CursoAlumno;
import modelo.Lugar;
import modelo.TipoCurso;
/**
 *
 * @author jesus
 */
public class CtrlCursoAlumno {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(float saldo, java.util.Date fechaIngreso, int idAlumno, int idEstadoAlumno, int idCurso){
        
        java.sql.Date fecha1=new Date(fechaIngreso.getTime());
        
        try {
          
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoAlumno (costo,saldo,fechaIngreso,"
                    + "fechaBaja, idAlumno,idEstadoAlumno,idCurso) VALUES (?,?,?,?,?,?,?)");
            
            ps.setFloat(1, 0);
            ps.setFloat(2, saldo);
            ps.setDate(3, fecha1);
            ps.setDate(4, null);
            ps.setInt(5, idAlumno);
            ps.setInt(6, idEstadoAlumno);
            ps.setInt(7, idCurso);
            //ps.setInt(8, idMotivoBaja);
            
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
            
            if(res>0) JOptionPane.showMessageDialog(null, "Se realizo el cambio");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    
    public void costo(int idAlumno,int idCurso, float costo, int cursoAlumno){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoAlumno SET costo=? WHERE idAlumno = ? AND idCurso = ? "
                    + " AND idCursoAlumno=? AND idEstadoAlumno = 1");
            
            ps.setFloat(1, costo);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idCurso);
            ps.setInt(4, cursoAlumno);
            int res = ps.executeUpdate();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public void pagarSaldo(int idAlumno, int idCurso, float saldo, int cursoAlumno){
    
            try{
                con=clases.Conectar.conexion();
                ps=(PreparedStatement)con.prepareStatement("UPDATE cursoAlumno SET saldo=?"
                        + " WHERE idAlumno=? AND idCurso=? AND idCursoAlumno=?");
                
                ps.setFloat(1, saldo);
                ps.setInt(2, idAlumno);
                ps.setInt(3, idCurso);
                ps.setInt(4, cursoAlumno);
                
                ps.execute();
                
                con.close();
            }catch(Exception e){
                
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
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoAlumno WHERE idAlumno=? AND idCurso=? AND idEstadoAlumno=1");
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idCurso);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoAlumno.setIdCursoAlumno(rs.getInt("idCursoAlumno"));
                cursoAlumno.setCosto(rs.getFloat("costo"));
                cursoAlumno.setSaldo(rs.getFloat("saldo"));
                cursoAlumno.setFechaIngreso(rs.getDate("fechaIngreso"));
                cursoAlumno.setFechaBajaEgreso(rs.getDate("fechaBaja"));
                cursoAlumno.setIdAlumno(ctrlAlumno.leerId(rs.getInt("idAlumno")));
                cursoAlumno.setIdEstadoAlumno(ctrlEstadoAlumno.leer(rs.getInt("idEstadoAlumno")));
                cursoAlumno.setIdCurso(ctrlCurso.leerCurso(rs.getInt("idCurso")));
                //cursoAlumno.setIdMotivoBaja(ctrlMotivoBaja.leer(rs.getInt("idMotivoBaja")));
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
            ps=(PreparedStatement)con.prepareStatement("SELECT curso.idCurso, tipoCurso.detalle FROM cursoAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoAlumno.idAlumno = ? AND cursoAlumno.idEstadoAlumno = 1");
            ps.setInt(1, idAlumno);
            
            //ps=(PreparedStatement)con.prepareStatement("SELECT c");
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoCurso tipoCurso=new TipoCurso();
                
                tipoCurso.setIdTipoCurso(rs.getInt("idCurso"));
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
            /*ps=(PreparedStatement)con.prepareStatement("SELECT tipoCurso.idTipoCurso, tipoCurso.detalle FROM cursoAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoAlumno.idAlumno = ? AND cursoAlumno.idEstadoAlumno=1");
            */
            ps=(PreparedStatement)con.prepareStatement("SELECT curso.idCurso, tipoCurso.detalle FROM cursoAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoAlumno.idAlumno = ? AND cursoAlumno.idEstadoAlumno = 1");
            
            ps.setInt(1, idAlumno);
            rs=ps.executeQuery();
            
            TipoCurso tipoCurso=new TipoCurso();
            tipoCurso.setIdTipoCurso(0);
            tipoCurso.setDetalle("Seleccione una opción...");
            cbCurso.addItem(tipoCurso);
            
            while (rs.next()) {      
                
                tipoCurso=new TipoCurso();
                
                tipoCurso.setIdTipoCurso(rs.getInt("idCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                
                cbCurso.addItem(tipoCurso);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL CARGAR COMBO ");       
        }
        
    }
    
    public void llenarTabla(int idAlumno, JTable tabla) throws SQLException{
        
        con=clases.Conectar.conexion();
    
        ps=(PreparedStatement)con.prepareStatement("SELECT tipoCurso.detalle, estadoAlumno.detalle FROM tipoCurso "
                + " INNER JOIN curso ON tipoCurso.idTipoCurso = curso.idTipoCurso "
                + " INNER JOIN cursoAlumno ON curso.idCurso= cursoAlumno.idCurso "
                + " INNER JOIN estadoAlumno ON cursoAlumno.idEstadoAlumno=estadoAlumno.idEstadoAlumno "
                + " WHERE cursoAlumno.idAlumno=?");
        
        ps.setInt(1, idAlumno);
        
        rs=ps.executeQuery();
        
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado Alumno");
        
        tabla.setModel(modelo);
        
        String[] datos= new String[2];
        try{
            
            while(rs.next()){

	            datos[0]=rs.getString(1);
	            datos[1]=rs.getString(2);
	            
            	    modelo.addRow(datos);
            }

            con.close();
            tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR"); 
        }
        
    }
    
    public void borradoLogico(int idAlumno, int idMotivo, java.util.Date fecha){
        CtrlCurso ctrlCurso=new CtrlCurso();
        CtrlAlumno ctrlAlumno=new CtrlAlumno();
        CtrlPersona ctrlPersona=new CtrlPersona();
        
        CursoAlumno cursoAlumno;
        Vector<CursoAlumno> vector = new Vector<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM cursoAlumno"
                    + " WHERE idAlumno = ? AND idEstadoAlumno = 1");
            ps.setInt(1, idAlumno);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                cursoAlumno=new CursoAlumno();
                
                cursoAlumno.setIdCursoAlumno(rs.getInt("idCursoAlumno"));
                cursoAlumno.setIdCurso(ctrlCurso.leerCurso(rs.getInt("idCurso")));
                
                vector.add(cursoAlumno);
            }
         
    //public void alumnoBajaEgresado(int idAlumno,int idCurso, int idMotivoBaja,int idEstadoAlumno, java.util.Date fechaBajaEgreso){
            java.sql.Date fechaS=new Date(fecha.getTime());
        
            for(int i=0; i<vector.size(); i++){
                alumnoBajaEgresado(idAlumno, vector.get(i).getIdCurso().getIdCurso(), idMotivo, 2, fechaS);
            }
    //HAY QUE VERIFICAR SI ESTA DADO DE BAJA SI LOS CURSOS EN QUE ESTÁ SIGUE ACTIVO        
            ctrlPersona.borrar(ctrlAlumno.leerId(idAlumno).getIdPersona().getIdPersona());
            ctrlAlumno.borrar(ctrlAlumno.leerId(idAlumno).getIdPersona().getIdPersona(), idAlumno);
            
        }catch(SQLException e){
            
        }
    }
}