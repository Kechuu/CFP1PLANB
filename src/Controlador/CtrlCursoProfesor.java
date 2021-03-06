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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Caracter;
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
    
    public void crear(int idCurso, int idEmpleado, int idCaracter){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO cursoProfesor (idCurso, idEmpleado, idCaracter) VALUES (?,?,?)");
            
            ps.setInt(1, idCurso);
            ps.setInt(2, idEmpleado);
            ps.setInt(3, idCaracter);
            
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
        CtrlCaracter ctrlCaracter = new CtrlCaracter();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoProfesor WHERE idCursoProfesor = ?");
            
            ps.setInt(1, idCursoProfesor);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoProfesor.setIdCurso(ctrlCurso.leer(rs.getInt("idCurso")));
                cursoProfesor.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                cursoProfesor.setIdCaracter(ctrlCaracter.leer(rs.getInt("idCaracter")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return cursoProfesor;
    }
    
    public CursoProfesor leerCurso(int idCurso, int idEmpleado){
        CursoProfesor cursoProfesor = new CursoProfesor();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        CtrlCaracter ctrlCaracter = new CtrlCaracter();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM cursoProfesor WHERE idCurso = ? AND idEmpleado = ?");
            
            ps.setInt(1, idCurso);
            ps.setInt(2, idEmpleado);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                cursoProfesor.setIdCursoProfesor(rs.getInt("idCursoProfesor"));
                cursoProfesor.setIdCurso(ctrlCurso.leer(rs.getInt("idCurso")));
                cursoProfesor.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                cursoProfesor.setIdCaracter(ctrlCaracter.leer(rs.getInt("idCaracter")));
            }else{
                JOptionPane.showMessageDialog(null, "cursoProfesor No existe lo que está buscando");
            }
            con.close();
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

            con.close();
             tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS LOCALIDADES EN LA TABLA"); 
        }
        
    }
    
    public List<CursoProfesor> cargarListaCursoProfesor(int idEmpleado, int idCaracter){
        List<CursoProfesor> listaCursoProfesor = new ArrayList();
        CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlCaracter ctrlCaracter =new CtrlCaracter();
        ResultSet rst;
        con =clases.Conectar.conexion();
        try {
            ps = (PreparedStatement)con.prepareStatement("SELECT * FROM cursoProfesor WHERE idEmpleado = ? AND idCaracter = ?");
            ps.setInt(1, idEmpleado);
            ps.setInt(2, idCaracter);
            
            rst= ps.executeQuery();
            
            while (rst.next()) {
                CursoProfesor cursoProfesor = new CursoProfesor();
                cursoProfesor.setIdCursoProfesor(rst.getInt("idCursoProfesor"));
                cursoProfesor.setIdEmpleado(ctrlEmpleado.leerIdEmpleado(rst.getInt("idEmpleado")));
                cursoProfesor.setIdCurso(ctrlCurso.leerCurso(rst.getInt("idCurso")));
                cursoProfesor.setIdCaracter(ctrlCaracter.leer(rst.getInt("idCaracter")));
                
                listaCursoProfesor.add(cursoProfesor);
            } 
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error, "+e);
        }
    return listaCursoProfesor;
    }
    
    public void cargarCombo(JComboBox<Caracter> cbCursoProfesor, int idEmpleado){
        cbCursoProfesor.removeAllItems();
        CtrlCurso ctrlCurso = new CtrlCurso();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        CtrlCaracter ctrlCaracter = new CtrlCaracter();
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT DatosCFP.cursoProfesor.idCaracter FROM DatosCFP.cursoProfesor "
                    + "WHERE DatosCFP.cursoProfesor.idEmpleado = ?");
            ps.setInt(1, idEmpleado);
            
            rs=ps.executeQuery();
            
            Caracter caracter2=new Caracter();
            Caracter caracter = new Caracter();
            caracter2.setIdCaracter(0);
            caracter2.setDetalle("Seleciione un caracter...");
            cbCursoProfesor.addItem(caracter2);
            
            while (rs.next()) {                
            
                caracter=new Caracter();
                caracter2=new Caracter();
                
                caracter = ctrlCaracter.leer(rs.getInt("idCaracter"));
                
                
                caracter2.setIdCaracter(caracter.getIdCaracter());
                caracter2.setDetalle(caracter.getDetalle());
                
                cbCursoProfesor.addItem(caracter2);
            }
            con.close();
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento: "+e.getMessage());       
        }
        
    }
    
    public void borradoLogicoGeneral(int idEmpleado){
        CursoProfesor cursoProfesor;
        CtrlCurso ctrlCurso=new CtrlCurso();
        CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
        CtrlPersona ctrlPersona=new CtrlPersona();
        
        Vector<CursoProfesor> vector=new Vector<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM cursoProfesor "
                    + " WHERE idEmpleado = ?");
            ps.setInt(1, idEmpleado);
            rs=ps.executeQuery();
            
            while(rs.next()){
                cursoProfesor=new CursoProfesor();
                
                cursoProfesor.setIdCursoProfesor(rs.getInt("idCursoProfesor"));
                cursoProfesor.setIdCurso(ctrlCurso.leerCurso(rs.getInt("idCurso")));
                
                vector.add(cursoProfesor);
            }
        
            for(int i=0; i<vector.size();i++){
                borrar(idEmpleado, vector.get(i).getIdCurso().getIdCurso());
            }
            
            java.util.Date fecha=new Date();
            int idPersona=ctrlEmpleado.leerIdEmpleado(idEmpleado).getIdPersona().getIdPersona();
            ctrlEmpleado.darDeBaja(fecha, idPersona, 2);
            ctrlPersona.borrar(idPersona);
            
            con.close();
        }catch(SQLException e){
            
        }
    }
    
}
