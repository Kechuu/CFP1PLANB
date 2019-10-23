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
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.Licencia;
import modelo.Persona;
/**
 *
 * @author jesus
 */
public class CtrlLicencia {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int articulo, String detalle, int idCaracter){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO licencia (articulo,detalle,idCaracter) VALUES (?,?,?)");
        
            ps.setInt(1, articulo);
            ps.setString(2, detalle.toUpperCase());
            ps.setInt(3, idCaracter);
            
            int res = ps.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar( int articulo, String detalle, int idCaracter){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE licencia SET articulo = ?, detalle = ?, idCaracter = ? WHERE articulo = ?");
            
            ps.setInt(1, articulo);
            ps.setString(2, detalle);
            ps.setInt(3, idCaracter);
            ps.setInt(4 , articulo);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public Licencia leer(int articulo){
        Licencia licencia = new Licencia();
        CtrlCaracter ctrlCaracter = new CtrlCaracter();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM licencia WHERE articulo = ?");
            
            ps.setInt(1, articulo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                licencia.setIdLicencia(rs.getInt("idLicencia"));
                licencia.setArticulo(rs.getInt("articulo"));
                licencia.setDetalle(rs.getString("detalle"));
                licencia.setIdCaracter(ctrlCaracter.leer(rs.getInt("idCaracter")));
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return licencia;
    }
    
    public void cargarCombo(JComboBox combo){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT articulo FROM licencia ORDER BY articulo ASC");
            
            rs=ps.executeQuery();
            combo.addItem("Seleccione uno de los articulos...");
            
            while (rs.next()) {                
                combo.addItem(String.valueOf(rs.getInt("articulo")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    public void cargarComboFiltrado(JComboBox combo, int idCaracter){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT articulo FROM licencia WHERE idCaracter = ? ORDER BY articulo ASC");
            ps.setInt(1, idCaracter);
            
            rs=ps.executeQuery();
            combo.addItem("Seleccione uno de los articulos...");
            
            while (rs.next()) {                
                combo.addItem(String.valueOf(rs.getInt("articulo")));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    
    public void cargarComboEmpleado(JComboBox combo){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT empleado.idEmpleado, persona.idPersona,"
                    + "persona.nombrePersona, persona.apellidoPersona FROM empleado INNER JOIN "
                    + "persona WHERE empleado.idPersona = persona.idPersona");
            
            rs=ps.executeQuery();
            combo.addItem("Seleccione un empleado");
            
            while (rs.next()) {
                Empleado empleado = new Empleado();
                Persona persona = new Persona();
                empleado.setIdEmpleado(rs.getInt("idEmpleado"));
                persona.setIdPersona(rs.getInt("idPersona"));
                persona.setApellidoPersona(rs.getString("apellidoPersona"));
                persona.setNombrePersona(rs.getString("nombrePersona"));
                combo.addItem(persona);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public List<Licencia> leerTodos(){
        CtrlCaracter ctrlCaracter = new CtrlCaracter();
        ResultSet rst;
        List<Licencia> lista = new ArrayList();
        con = clases.Conectar.conexion();
        try {
            ps = (PreparedStatement) con.prepareStatement("SELECT articulo,detalle,idCaracter FROM licencia ORDER BY articulo ASC");
            
            rst=ps.executeQuery();
            
            while (rst.next()) {                
                Licencia licencia = new Licencia();
                licencia.setArticulo(rst.getInt("articulo"));
                licencia.setDetalle(rst.getString("detalle"));
                licencia.setIdCaracter(ctrlCaracter.leer(rst.getInt("idCaracter")));
                
                lista.add(licencia);
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return lista;
    }
    
}
