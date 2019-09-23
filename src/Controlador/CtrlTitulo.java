/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import modelo.Titulo;
/**
 *
 * @author jesus
 */
public class CtrlTitulo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO titulo (detalle) VALUES (?)");
        
            ps.setString(1, detalle);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idTitulo, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE titulo SET detalle = ? WHERE idTitulo = ?");
            
            ps.setString(1, detalle);
            ps.setInt(2, idTitulo);
            
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
    
    public Titulo leer(int idTitulo){
        Titulo titulo = new Titulo();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM titulo WHERE idTitulo = ?");
            
            ps.setInt(1, idTitulo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                titulo.setIdTitulo(rs.getInt("idTitulo"));
                titulo.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return titulo;
    }
    
    public void cargarCombo(JComboBox<Titulo> cbTitulo){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM titulo ORDER BY detalle ASC");
            rs=ps.executeQuery();
            
            Titulo titulo=new Titulo();
            titulo.setIdTitulo(0);
            titulo.setDetalle("Seleccione una opción");
            cbTitulo.addItem(titulo);
            
            while (rs.next()) {                
                
                titulo=new Titulo();
                
                titulo.setIdTitulo(rs.getInt("idTitulo"));
                titulo.setDetalle(rs.getString("detalle"));
                cbTitulo.addItem(titulo);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Tipo de Documento");       
        }
        
    }
}
