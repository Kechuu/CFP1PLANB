/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
    //Este metodo llena lista de los cursos que esta cursando actualmente un determinado alumno
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
}
