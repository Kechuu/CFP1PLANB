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
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CursoProfesor;
import modelo.TipoCurso;
/**
 *
 * @author jesus
 */
public class CtrlCursoProfesor {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idCurso, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoProfesor (idCurso, idEmpleado) VALUES (?,?)");
            
            ps.setInt(1, idCurso);
            ps.setInt(2, idEmpleado);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void cambiarProfesorCurso(int idCurso, int idCursoProfesor, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE cursoProfesor SET idCurso = ? WHERE idCursoProfesor = ? "
                    + "AND idEmpleado = ?");
            
            ps.setInt(1, idCurso);
            ps.setInt(2, idCursoProfesor);
            ps.setInt(3, idEmpleado);
            
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
    
    public void borrar(int idEmpleado, int idCurso){
    
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("DELETE FROM cursoProfesor WHERE idEmpleado=? AND idCurso=?");
            
            ps.setInt(1, idEmpleado);
            ps.setInt(2, idCurso);
            
            int res=ps.executeUpdate();
            
            if(res>0)JOptionPane.showMessageDialog(null, "Se dio de baja");
            else JOptionPane.showMessageDialog(null, "No se pudo dar de baja");
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public CursoProfesor leer(int idCursoProfesor){
        CursoProfesor cursoProfesor = new CursoProfesor();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoProfesor WHERE idCursoProfesor = ?");
            
            ps.setInt(1, idCursoProfesor);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoProfesor.setIdCurso(ctrlCurso.leer(rs.getInt("idCurso")));
                cursoProfesor.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return cursoProfesor;
    }
    
    public void llenarLista(int idEmpleado, JList<TipoCurso>lista){
    //Este metodo llena lista de los cursos que esta cursando actualmente un determinado empleado
        DefaultListModel <TipoCurso> modelo=new DefaultListModel<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT tipoCurso.idTipoCurso, tipoCurso.detalle FROM cursoProfesor"
                    + " INNER JOIN curso ON cursoProfesor.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " WHERE cursoProfesor.idEmpleado = ?");
           
            ps.setInt(1, idEmpleado);
            
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
    
    public void llenarTabla(int idEmpleado, JTable tabla) throws SQLException{
    //CAMBIAR PARA QUE LLENE SEGUN EL EMPLEADO Y NO SEGUN EL ALUMNO..    
        con=clases.Conectar.conexion();
    
        ps=(PreparedStatement)con.prepareStatement("SELECT tipoCurso.detalle, cargo.detalle, estadoEmpleado.detalle FROM tipoCurso "
                + " INNER JOIN curso ON tipoCurso.idTipoCurso = curso.idTipoCurso"
                + " INNER JOIN cursoProfesor ON curso.idCurso= cursoProfesor.idCurso"
                + " INNER JOIN empleado ON cursoProfesor.idEmpleado = empleado.idEmpleado"
                + " INNER JOIN empleadoCargo ON empleado.idEmpleado = empleadoCargo.idEmpleado"
                + " INNER JOIN cargo ON empleadoCargo.idCargo = cargo.idCargo"
                + " INNER JOIN estadoEmpleado ON empleado.idEstadoEmpleado = estadoEmpleado.idEstadoEmpleado"
                + " WHERE empleado.idEmpleado=?");
        
        ps.setInt(1, idEmpleado);
        
        rs=ps.executeQuery();
        
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Nombre");
        modelo.addColumn("Cargo");
        modelo.addColumn("Estado empleado");
        
        tabla.setModel(modelo);
        
        String[] datos= new String[3];
        try{
            
            while(rs.next()){

	            datos[0]=rs.getString(1);
	            datos[1]=rs.getString(2);
	            datos[2]=rs.getString(3);
                    
            	    modelo.addRow(datos);
            }

             tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS LOCALIDADES EN LA TABLA"); 
        }
        
    }
}
