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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Gremio;
/**
 *
 * @author jesus
 */
public class CtrlGremio {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO gremio (detalle) VALUES (?)");
        
            ps.setString(1, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editarGremio(int idGremio, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE gremio SET detalle = ? WHERE idGremio = ?");
            
            ps.setString(1, detalle);
            ps.setInt(2, idGremio);
            
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
    
    public Gremio leer(int idGremio){
        Gremio gremio = new Gremio();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM gremio WHERE idGremio = ?");
            
            ps.setInt(1, idGremio);
            rs = ps.executeQuery();
            
            if(rs.next()){
                gremio.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return gremio;
    }
    
    public void cargarCombo(JComboBox<Gremio> cbGremio){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM gremio ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            Gremio gremio=new Gremio();
            gremio.setIdGremio(0);
            gremio.setDetalle("Seleccione una opción...");
            cbGremio.addItem(gremio);
            
            while (rs.next()) {                
                
                gremio=new Gremio();
                
                gremio.setIdGremio(rs.getInt("idGremio"));
                gremio.setDetalle(rs.getString("detalle"));
                cbGremio.addItem(gremio);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento");       
        }
    }    
        
}
