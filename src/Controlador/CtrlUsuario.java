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
import modelo.Usuario;
/**
 *
 * @author jesus
 */
public class CtrlUsuario {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(String user, String pass, int jerarquia, int idPersona){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuario (user,pass,jerarquia,idPersona,borrado) "
                    + "VALUES (?,?,?,?,?)");
        
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, jerarquia);
            ps.setInt(4, idPersona);
            ps.setBoolean(5, false);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idUsuario, String user, String pass, int jerarquia, int idPersona){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE usuario SET user = ?,pass = ? ,jerarquia = ?, idPersona = ?,"
                    + " WHERE idUsuario = ?");
            
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, jerarquia);
            ps.setInt(4, idPersona);
            ps.setInt(5, idUsuario);
            
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
    
    public void borrar(int idUsuario){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE usuario SET borrado = TRUE WHERE idUsuario = ?");
            
            ps.setInt(1, idUsuario);
            
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
    
    public Usuario leer(int idPersona){
        Usuario usuario = new Usuario();
        CtrlPersona ctrlPersona = new CtrlPersona();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE idPersona = ? AND borrado = FALSE");
            
            ps.setInt(1, idPersona);
            rs = ps.executeQuery();
            
            if(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPass(rs.getString("pass"));
                usuario.setJerarquia(rs.getInt("jerarquia"));
                usuario.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return usuario;
    }
    
    public Usuario confirmar(String user, String pass){
        Usuario usuario=new Usuario();
        CtrlPersona ctrlPersona=new CtrlPersona();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM usuario WHERE user = ? AND pass = ?");
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPass(rs.getString("pass"));
                usuario.setJerarquia(rs.getInt("jerarquia"));
                usuario.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
            }else{
                JOptionPane.showMessageDialog(null, "No está registrado");
            }
        }catch(Exception e){
            
        }
        
        return usuario;
    }
}
