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
import modelo.PersonaTrabajo;
import modelo.Trabajo;
/**
 *
 * @author jesus
 */
public class CtrlPersonaTrabajo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idPersona, int idTrabajo){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO personaTrabajo (idTrabajo, idPersona) VALUES (?,?)");
        
            ps.setInt(1, idTrabajo);
            ps.setInt(2, idPersona);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idPersonaTrabajo, int idPersona, int idTrabajo){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE personaTrabajo SET idTrabajo = ? WHERE idPersonaTrabajo = ? AND "
                    + "idPersona = ?");
            
            ps.setInt(1, idTrabajo);
            ps.setInt(2, idPersonaTrabajo);
            ps.setInt(3, idPersona);

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
    
    
    public void borrar(int idPersonaTrabajo, int idTrabajo, int idPersona){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("DELETE FROM personaTrabajo WHERE idPersonaTrabajo=? AND idPersona=? AND idTrabajo=?");
            
            ps.setInt(1, idPersonaTrabajo);
            ps.setInt(2, idPersona);
            ps.setInt(3, idTrabajo);
            
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
    
    
    public PersonaTrabajo leer(int idPersona, int idTrabajo){
        PersonaTrabajo personaTrabajo = new PersonaTrabajo();
        CtrlTrabajo ctrlTrabajo = new CtrlTrabajo();
        CtrlPersona ctrlPersona = new CtrlPersona();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM personaTrabajo WHERE idPersona = ? AND idTrabajo=?");
           
            ps.setInt(1, idPersona);
            ps.setInt(2, idTrabajo);
            rs = ps.executeQuery();
            
            
            if (rs.next()) {
                personaTrabajo.setIdPersonaTrabajo(rs.getInt("idPersonaTrabajo"));
                personaTrabajo.setIdTrabajo(ctrlTrabajo.leer(rs.getInt("idTrabajo")));
                personaTrabajo.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return personaTrabajo;
    }
    
    public PersonaTrabajo leerIdTrabajo(int idPersona, int idPersonaTrabajo){
        PersonaTrabajo personaTrabajo = new PersonaTrabajo();
        CtrlTrabajo ctrlTrabajo = new CtrlTrabajo();
        CtrlPersona ctrlPersona = new CtrlPersona();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM personaTrabajo WHERE idPersona = ? AND idPersonaTrabajo=?");
           
            ps.setInt(1, idPersona);
            ps.setInt(2, idPersonaTrabajo);
            rs = ps.executeQuery();
            
            
            if (rs.next()) {
                personaTrabajo.setIdPersonaTrabajo(rs.getInt("idPersonaTrabajo"));
                personaTrabajo.setIdTrabajo(ctrlTrabajo.leer(rs.getInt("idTrabajo")));
                personaTrabajo.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return personaTrabajo;
    }
    
    public void llenarLista(int idPersona, JList<Trabajo> lista){
        CtrlTrabajo ctrlTrabajo=new CtrlTrabajo();
        PersonaTrabajo personaTrabajo;
        
        DefaultListModel<Trabajo> modelo=new DefaultListModel<>();
        
        try{
            
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM personaTrabajo WHERE idPersona=?");
            ps.setInt(1, idPersona);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                personaTrabajo=new PersonaTrabajo();
                
                personaTrabajo.setIdTrabajo(ctrlTrabajo.leer(rs.getInt("idTrabajo")));
                
                modelo.addElement(personaTrabajo.getIdTrabajo());
            }
            
            lista.setModel(modelo);
            
            con.close();
        }catch(SQLException e){
            
        }
    }
    
    public void llenarTabla(int idPersona, JTable tabla) throws SQLException{
        
        con=clases.Conectar.conexion();
    
        ps=(PreparedStatement)con.prepareStatement("SELECT trabajo.detalle FROM trabajo"
                + " INNER JOIN personaTrabajo ON trabajo.idTrabajo=personaTrabajo.idTrabajo"
                + " WHERE personaTrabajo.idPersona=?");
        
        ps.setInt(1, idPersona);
        
        rs=ps.executeQuery();
        
        DefaultTableModel modelo =new DefaultTableModel();
        modelo.addColumn("Trabajo");
        
        tabla.setModel(modelo);
        
        String[] datos= new String[1];
        try{
            
            while(rs.next()){
                
	            datos[0]=rs.getString(1);
	            
            	    modelo.addRow(datos);
            }

             tabla.setModel(modelo);
         }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR AL CARGAR LAS LOCALIDADES EN LA TABLA"); 
        }
        
    }
}
