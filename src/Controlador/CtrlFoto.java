/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Foto;

/**
 *
 * @author jesus
 */
public class CtrlFoto {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(Blob imagen){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO foto (imagen) VALUES (?)");
        
            ps.setBlob(1, imagen);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idFoto, Blob imagen){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE foto SET imagen = ? WHERE idFoto = ?");
            
            ps.setBlob(1, imagen);
            ps.setInt(2, idFoto);
            
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
    
    public Foto leer(int idFoto){
        Foto foto = new Foto();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM foto WHERE idFoto = ?");
            
            ps.setInt(1, idFoto);
            rs = ps.executeQuery();
            
            if(rs.next()){
                foto.setImagen(rs.getBlob("imagen"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return foto;
    }
}
