/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import modelo.TipoCurso;

/**
 *
 * @author araa
 */
public class Listado {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    
    public void listaPorCurso(JList<TipoCurso>lista){
        DefaultListModel <TipoCurso> modelo=new DefaultListModel<>();
        Calendar cal= Calendar.getInstance();
        //int year= cal.get(Calendar.YEAR);
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT curso.idCurso, tipoCurso.detalle, curso.costo, curso.cicloLectivo FROM curso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE curso.borrado=false");
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoCurso tipoCurso=new TipoCurso();
                
                tipoCurso.setIdTipoCurso(rs.getInt("idCurso"));
                String detalleLectivo=rs.getString("detalle")+" | Ciclo Lectivo: "+rs.getString("cicloLectivo");
                //tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setDetalle(detalleLectivo);
                tipoCurso.setCosto(rs.getFloat("curso.costo"));
                
                modelo.addElement(tipoCurso);
            }
            
            lista.setModel(modelo);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }        
    }
    
    public void filtradoPorCurso(JTable tabla, int idCurso){
        
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Estado Alumno");
        
        tabla.setModel(modelo);
        
         
        String[] datos= new String[2];
        
	try{
        
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("SELECT persona.apellidoPersona, persona.nombrePersona, estadoAlumno.detalle FROM persona"
                    + " INNER JOIN alumno ON persona.idPersona = alumno.idPersona"
                    + " INNER JOIN cursoAlumno ON alumno.idAlumno = cursoAlumno.idAlumno"
                    + " INNER JOIN estadoAlumno ON cursoAlumno.idEstadoAlumno = estadoAlumno.idEstadoAlumno"
                    + " WHERE cursoAlumno.idCurso = ?");
            
            ps.setInt(1, idCurso);

            rs = ps.executeQuery();

            while(rs.next()){
            /*
                dato[3]=rs.getString(4);
                dato[4]=rs.getString(5);
                dato[5]=rs.getString(6);
                dato[6]=rs.getString(7);
                */
	            datos[0]=rs.getString(1)+" "+rs.getString(2);
	            datos[1]=rs.getString(3);
	            
            	    modelo.addRow(datos);
            }

             tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR"); 
        }
    }
    
    public float listaDeudores(JTable tabla){
        float saldo=0;
        
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Apellido - Nombre");
        modelo.addColumn("Saldo");
        modelo.addColumn("Curso");
        
        tabla.setModel(modelo);
        
         
        String[] datos= new String[3];
        
	try{
        
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("SELECT persona.apellidoPersona, persona.nombrePersona, cursoAlumno.saldo, tipoCurso.detalle, curso.cicloLectivo FROM persona"
                    + " INNER JOIN alumno ON persona.idPersona = alumno.idPersona"
                    + " INNER JOIN cursoAlumno ON alumno.idAlumno = cursoAlumno.idAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoAlumno.saldo > 0");
            
            
            rs = ps.executeQuery();

            while(rs.next()){
                    datos[0]=rs.getString(1)+" "+rs.getString(2);
	            datos[1]=rs.getString(3);
	            datos[2]=rs.getString(4)+" | Ciclo Lectivo: "+rs.getString(5);
                
                    saldo=saldo+rs.getFloat(3);
                
            	    modelo.addRow(datos);
            }

             tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR"); 
        }
        
        return saldo;
    }
    
    public float filtradoDeudores(JTable tabla, String filtro){
        
        float saldo=0;
        
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Apellido - Nombre");
        modelo.addColumn("Saldo");
        modelo.addColumn("Curso");
        
        tabla.setModel(modelo);
        
         
        String[] datos= new String[3];
        
        try{
            con=clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("SELECT persona.apellidoPersona, persona.nombrePersona, cursoAlumno.saldo, tipoCurso.detalle FROM persona"
                    + " INNER JOIN alumno ON persona.idPersona = alumno.idPersona"
                    + " INNER JOIN cursoAlumno ON alumno.idAlumno = cursoAlumno.idAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoAlumno.saldo > 0 AND persona.apellidoPersona LIKE '%"+filtro+"%'");
            
            //      + " WHERE persona.apellidoPersona LIKE '%"+filtro+"%'");
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                datos[0]=rs.getString(1)+" "+rs.getString(2);
                datos[1]=rs.getString(3);
                datos[2]=rs.getString(4);
                
                saldo=saldo+rs.getFloat(3);
                modelo.addRow(datos);
            }
            
            tabla.setModel(modelo);
            
            con.close();
            
        }catch(SQLException e){
            
        }
        return saldo;
    }
    
    public void cargarCicloLectivo(JComboBox cb){
        
        try{
            con=clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("SELECT cicloLectivo FROM curso ORDER BY cicloLectivo ASC");
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                cb.addItem("Seleccione un ciclo lectivo");
                cb.addItem(rs.getObject("cicloLectivo"));
                
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public void listaPorCicloLectivo(JList<TipoCurso>lista, int ciclo){
        DefaultListModel <TipoCurso> modelo=new DefaultListModel<>();
        Calendar cal= Calendar.getInstance();
        //int year= cal.get(Calendar.YEAR);
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT curso.idCurso, tipoCurso.detalle FROM curso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE curso.borrado=false AND curso.cicloLectivo = ?");
            
            ps.setInt(1, ciclo);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                TipoCurso tipoCurso=new TipoCurso();
                
                tipoCurso.setIdTipoCurso(rs.getInt("idCurso"));
                String detalleLectivo=rs.getString("detalle");

                tipoCurso.setDetalle(detalleLectivo);
                
                modelo.addElement(tipoCurso);
            }
            
            lista.setModel(modelo);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }        
    }
    
}
