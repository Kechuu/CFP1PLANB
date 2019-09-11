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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.CursoHora;

/**
 *
 * @author jesus
 */
public class CtrlCurso {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int cicloLectivo, int turno, float costo, int cupo, Date fechaInicio, Date fechaFinalizacion,
    int idTipoCurso,int idLugarCurso, boolean borrado){
        
        java.sql.Date fecha=new Date(fechaInicio.getTime());
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO curso (cicloLectivo,turno,costo,cupo,fechaInicio,"
                    + "fechaFinalizacion,idTipoCurso,idLugarCurso,borrado) VALUES (?,?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, cicloLectivo);
            ps.setInt(2, turno);
            ps.setFloat(3, costo);
            ps.setInt(4, cupo);
            ps.setDate(5, fecha);
            ps.setDate(6, null);
            ps.setInt(7, idTipoCurso);
            ps.setInt(8, idLugarCurso);
            ps.setBoolean(9, borrado);
            
            int res = ps.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ES AQUI!!!");
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    public void editar(int idCurso, int cicloLectivo, int turno, float costo, int cupo, Date fechaInicio, Date fechaFinalizacion,
    int idTipoCurso,int idLugarCurso, boolean borrado){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE curso SET cicloLectivo = ?, turno = ?, costo = ?, cupo = ?,"
                    + "fechaInicio = ?, fechaFinalizacion = ?, idTipoCurso = ?, idLugarCurso = ?,  borrado = ? WHERE idCurso = ?");
            
            ps.setInt(1, cicloLectivo);
            ps.setInt(2, turno);
            ps.setFloat(3, costo);
            ps.setInt(4, cupo);
            ps.setDate(5, fechaInicio);
            ps.setDate(6, fechaFinalizacion);
            ps.setInt(7, idTipoCurso);
            ps.setInt(8, idLugarCurso);
            ps.setBoolean(9, borrado);
            ps.setInt(10, idCurso);
            
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
    
    public void borrar(int idCurso){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE curso SET borrado = TRUE WHERE idCurso = ?");
            
            ps.setInt(1, idCurso);
            
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
    
    public Curso leer(int idTipoCurso){
        Curso curso = new Curso();
        CtrlTipoCurso ctrlTipoCurso = new CtrlTipoCurso();
        CtrlLugarCurso ctrlLugarCurso = new CtrlLugarCurso();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM curso WHERE idTipoCurso = ?");
            
            ps.setInt(1, idTipoCurso);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCicloLectivo(rs.getInt("cicloLectivo"));
                curso.setTurno(rs.getInt("turno"));
                curso.setCosto(rs.getFloat("costo"));
                curso.setCupo(rs.getInt("cupo"));
                curso.setFechaInicio(rs.getDate("fechaInicio"));
                curso.setFechaFinalizacion(rs.getDate("fechaFinalizacion"));
                curso.setIdTipoCurso(ctrlTipoCurso.leer(rs.getInt("idTipoCurso")));
                curso.setIdLugarCurso(ctrlLugarCurso.leer(rs.getInt("idLugarCurso")));
                curso.setBorrado(rs.getBoolean("borrado"));
            }else{
                
                JOptionPane.showMessageDialog(null, "\nCURSO!! No existe lo que está buscando");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return curso;
    }
//<VER SI ESTO ES REALMENTE NECESARIO :v
    public Curso leerCurso(int idCurso){
        Curso curso = new Curso();
        CtrlTipoCurso ctrlTipoCurso = new CtrlTipoCurso();
        CtrlLugarCurso ctrlLugarCurso = new CtrlLugarCurso();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM curso WHERE idCurso = ?");
            
            ps.setInt(1, idCurso);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                curso.setIdCurso(rs.getInt("idCurso"));
                curso.setCicloLectivo(rs.getInt("cicloLectivo"));
                curso.setTurno(rs.getInt("turno"));
                curso.setCosto(rs.getFloat("costo"));
                curso.setCupo(rs.getInt("cupo"));
                curso.setFechaInicio(rs.getDate("fechaInicio"));
                curso.setFechaFinalizacion(rs.getDate("fechaFinalizacion"));
                curso.setIdTipoCurso(ctrlTipoCurso.leer(rs.getInt("idTipoCurso")));
                curso.setIdLugarCurso(ctrlLugarCurso.leer(rs.getInt("idLugarCurso")));
                curso.setBorrado(rs.getBoolean("borrado"));
            }else{
                
                JOptionPane.showMessageDialog(null, "CURSO!! No existe lo que está buscando");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return curso;
    }
    
     public void llenarTabla(int idCurso, JTable tabla) throws SQLException{
        String dia=null;
         
        CursoHora hora=new CursoHora();
        CtrlHorario ctrlHorario=new CtrlHorario();
        CtrlCurso ctrlCurso=new CtrlCurso();
        
        
        con=clases.Conectar.conexion();
        ps=(PreparedStatement)con.prepareStatement("SELECT * FROM cursoHora WHERE idCurso=?");
        ps.setInt(1, idCurso);
        
        rs=ps.executeQuery();
        
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Día");
        modelo.addColumn("Desde");
        modelo.addColumn("Hasta");
        
        tabla.setModel(modelo);
        
        String[] datos= new String[3];
        try{
            
            while(rs.next()){
                ctrlHorario=new CtrlHorario();
                
                hora.setIdCursoHora(rs.getInt("idCursoHora"));
                hora.setIdHorario(ctrlHorario.leer(rs.getInt("idHorario")));
                hora.setIdCurso(ctrlCurso.leerCurso(rs.getInt("idCurso")));
                
                switch(hora.getIdHorario().getDia()){
                    case 1:
                        dia="Lunes";
                        
                        break;
                        
                    case 2:
                        dia="Martes";
                        
                        break;
                    
                    case 3:
                        dia="Miercoles";
                        
                        break;
                        
                    case 4:
                        dia="Jueves";
                        
                        break;
                        
                    case 5:
                        dia="Viernes";
                        
                        break;
                        
                    case 6:
                        dia="Sábado";
                        
                        break;
                        
                    case 7:
                        dia="Domingo";
                        
                        break;
                }
                
                datos[0]=dia;
                datos[1]=String.valueOf(hora.getIdHorario().getDesde());
                datos[2]=String.valueOf(hora.getIdHorario().getHasta());
                
                modelo.addRow(datos);
            }
            
            tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS LOCALIDADES EN LA TABLA"); 
        }
        
    }
}
