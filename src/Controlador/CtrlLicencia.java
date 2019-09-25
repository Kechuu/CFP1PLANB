/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Licencia;
/**
 *
 * @author jesus
 */
public class CtrlLicencia {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int articulo, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO licencia (articulo,detalle) VALUES (?,?)");
        
            ps.setInt(1, articulo);
            ps.setString(2, detalle.toUpperCase());
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar( int articulo, String detalle){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE licencia SET articulo = ?, detalle = ? WHERE articulo = ?");
            
            ps.setInt(1, articulo);
            ps.setString(2, detalle);
            ps.setInt(3 , articulo);
            
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
    
    public Licencia leer(int articulo){
        Licencia licencia = new Licencia();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM licencia WHERE articulo = ?");
            
            ps.setInt(1, articulo);
            rs = ps.executeQuery();
            
            if(rs.next()){
                licencia.setArticulo(rs.getInt("articulo"));
                licencia.setDetalle(rs.getString("detalle"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return licencia;
    }
}
