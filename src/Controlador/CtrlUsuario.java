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
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public Usuario leer(int id){
        Usuario usuario = new Usuario();
        CtrlPersona ctrlPersona = new CtrlPersona();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM alumno WHERE idPersona = ?");
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if(rs.next()){
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
}
