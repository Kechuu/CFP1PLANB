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
    
    public void crear(String user, String pass, int jerarquia, int idEmpleado){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO usuario (user,pass,jerarquia,idEmpleado,borrado) "
                    + "VALUES (?,?,?,?,?)");
        
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, jerarquia);
            ps.setInt(4, idEmpleado);
            ps.setBoolean(5, false);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editarNombre(int idUsuario, String user, String pass){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE usuario SET user = ? WHERE idUsuario = ? AND pass = ?");
            
            ps.setString(1, user);
            ps.setInt(2, idUsuario);
            ps.setString(3, pass);
            
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
    
    public void editarPass(int idUsuario, String pass){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE usuario SET pass = ? WHERE idUsuario = ?");
            
            ps.setString(1, pass);
            ps.setInt(2, idUsuario);
            
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
    
    public Usuario leer(int idEmpleado){
        Usuario usuario = new Usuario();
        CtrlPersona ctrlPersona = new CtrlPersona();
        CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM usuario WHERE idEmpleado = ? AND borrado = FALSE");
            
            ps.setInt(1, idEmpleado);
            rs = ps.executeQuery();
            
            if(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPass(rs.getString("pass"));
                usuario.setJerarquia(rs.getInt("jerarquia"));
                usuario.setIdEmpleado(ctrlEmpleado.leerIdEmpleado(rs.getInt("idEmpleado")));
                
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
        CtrlEmpleado ctrlEmpleado=new CtrlEmpleado();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM usuario WHERE user = ? AND pass = ? AND borrado=false");
            
            ps.setString(1, user);
            ps.setString(2, pass);
            
            rs=ps.executeQuery();
            
            if(rs.next()){
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setUser(rs.getString("user"));
                usuario.setPass(rs.getString("pass"));
                usuario.setJerarquia(rs.getInt("jerarquia"));
                usuario.setIdEmpleado(ctrlEmpleado.leerIdEmpleado(rs.getInt("idEmpleado")));
                
            }else{
                JOptionPane.showMessageDialog(null, "No está registrado");
            }
            
            con.close();
        }catch(Exception e){
            
        }
        
        return usuario;
    }
    
    public boolean confirmar(String user){
        boolean bandera = false;
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM usuario WHERE user = ?");
            ps.setString(1,user);
            
            rs=ps.executeQuery();
            
            bandera=rs.next();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return bandera;
    }
    
    public boolean verificar(String user, String pass){
        boolean bandera = false;
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM usuario WHERE user = ? AND pass=?");
            ps.setString(1,user);
            ps.setString(2, pass);
            rs=ps.executeQuery();
            
            bandera=rs.next();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return bandera;
    }
}
