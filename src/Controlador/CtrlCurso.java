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
import java.sql.Statement;
import java.sql.Time;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Curso;
import modelo.CursoHora;
import modelo.LugarCurso;
import modelo.TipoCurso;

/**
 *
 * @author jesus
 */
public class CtrlCurso {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int cicloLectivo, int turno, float costo, int cupo, java.sql.Date fechaInicio, java.sql.Date fechaFinalizacion,
    int idTipoCurso,int idLugarCurso, boolean borrado){
        
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO curso (cicloLectivo,turno,costo,cupo,fechaInicio,"
                    + "fechaFinalizacion,idTipoCurso,idLugarCurso,borrado) VALUES (?,?,?,?,?,?,?,?,?)");
            
            ps.setInt(1, cicloLectivo);
            ps.setInt(2, turno);
            ps.setFloat(3, costo);
            ps.setInt(4, cupo);
            ps.setDate(5, fechaInicio);
            ps.setDate(6, fechaFinalizacion);
            ps.setInt(7, idTipoCurso);
            ps.setInt(8, idLugarCurso);
            ps.setBoolean(9, borrado);
            
            int res = ps.executeUpdate();
            
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ctrlCurso");
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    public void editar(int idCurso, int cicloLectivo, int turno, float costo, int cupo, java.sql.Date fechaInicio, java.sql.Date fechaFinalizacion,
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
    
    public void borrar(int idTipoCurso, int turno, int cicloLectivo){
        //por idtipocurso, turno y ciclo lectivo
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE curso SET borrado = TRUE WHERE idTipoCurso = ? AND turno = ?"
                    + " AND cicloLectivo = ?");
            
            ps.setInt(1, idTipoCurso);
            ps.setInt(2, turno);
            ps.setInt(3, cicloLectivo);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
            con.close();
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
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
                
                JOptionPane.showMessageDialog(null, "\nCURSO!! No existe lo que está buscando :v");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return curso;
    }
//<VER SI ESTO ES REALMENTE NECESARIO :v -SI ES NECESARIO :vv
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
    
    
    public void llenarTablaCurso(JTable tabla){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Ciclo Lectivo");
        modelo.addColumn("Turno");
        modelo.addColumn("Costo");
        modelo.addColumn("Cupo");
        modelo.addColumn("Fecha Inicio");
        modelo.addColumn("FechaFinalizacion");
        modelo.addColumn("Lugar");
        tabla.setModel(modelo);
                
        String[] dato = new String[8];
        String turno="";
        try {
            Statement st = (Statement) con.createStatement();
            ResultSet rs= st.executeQuery("SELECT idTipoCurso,cicloLectivo,turno,"
                    + "costo,cupo,fechaInicio,fechaFinalizacion,idLugarCurso FROM curso");
            
            while (rs.next()) {                
                CtrlTipoCurso ctrlTipoCurso = new CtrlTipoCurso();
                TipoCurso tipoCurso = new TipoCurso();
                
                int idTipoCurso = rs.getInt(1);
                //JOptionPane.showMessageDialog(null, idTipoCurso);
                tipoCurso = ctrlTipoCurso.leer(idTipoCurso);
                //JOptionPane.showMessageDialog(null, tipoCurso.getDetalle());
                dato[0]=tipoCurso.getDetalle();
                
                dato[1]=rs.getString(2);
    
                 switch(rs.getInt(3)){
                    case 1:
                        turno="Mañana";
                        
                        break;
                        
                    case 2:
                        turno="Tarde";
                        
                        break;
                    
                    case 3:
                        turno="Noche";
                        
                        break;
                        
                }
                
                dato[2]=turno;
                
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[5]=rs.getString(6);
                dato[6]=rs.getString(7);
                
                CtrlLugarCurso ctrlLugarCurso = new CtrlLugarCurso();
                LugarCurso lugarCurso = new LugarCurso();
                int idLugarCurso = rs.getInt(8);
                
                lugarCurso = ctrlLugarCurso.leer(idLugarCurso);
                dato[7]= lugarCurso.getDetalle();
                modelo.addRow(dato);
            }
            
            tabla.setModel(modelo);
            
        } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, e.getLocalizedMessage()); 
        }
    }
    
    public int traerUltimoId(){
        int idCurso=0;
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM curso ORDER BY idCurso DESC LIMIT 1");
            
            ResultSet rs1 = null;
            
            rs1 = ps.executeQuery();
            
            if (rs1.next()) {
                
            idCurso = rs1.getInt("idCurso");
            
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return idCurso;
    }
    
    public void llenarTabla(int idCurso, JTable tabla) throws SQLException{
    //Este metodo llena los horarios que tiene un determinado curso..
        
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
                datos[1]=String.valueOf(hora.getIdHorario().getDesde().toLocalTime());
                datos[2]=String.valueOf(hora.getIdHorario().getHasta().toLocalTime());
                
                modelo.addRow(datos);
            }
            
            tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LA TABLA"); 
        }
        
    }
     
    public void llenarLista(JList<TipoCurso>lista){
    //Este metodo llena lista de los cursos que esta cursando actualmente un determinado alumno
        DefaultListModel <TipoCurso> modelo=new DefaultListModel<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT tipoCurso.idTipoCurso, tipoCurso.detalle, curso.costo FROM curso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE curso.cicloLectivo= 2019 AND curso.borrado=false");
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoCurso tipoCurso=new TipoCurso();
                
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setCosto(rs.getFloat("curso.costo"));
                
                modelo.addElement(tipoCurso);
            }
            
            lista.setModel(modelo);
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
    }
    
    
}
