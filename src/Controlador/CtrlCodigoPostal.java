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
import modelo.CodigoPostal;
/**
 *
 * @author jesus
 */
public class CtrlCodigoPostal {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idLocalidad, String codigoPostal){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO codigoPostal (localidad,codigoPostal) VALUES (?,?)");
            
            ps.setInt(1, idLocalidad);
            ps.setString(2, codigoPostal);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idLocalidad, String codigoPostal){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE codigoPostal SET codigoPostal = ? WHERE idCodigoPostal = ?");
            
            ps.setInt(1, idLocalidad);
            ps.setString(2, codigoPostal);
            
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
    
    public void borrar(){
        //¿?
    }
    
    public CodigoPostal leer(int idLocalidad){
        CodigoPostal codigoPostal = new CodigoPostal();
        CtrlLugar ctrlLugar = new CtrlLugar();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM codigoPostal WHERE localidad = ?");
            
            ps.setInt(1, idLocalidad);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                codigoPostal.setLocalidad(ctrlLugar.leer(rs.getInt("idLugar")));
                codigoPostal.setCodigoPostal(rs.getString("codigoPostal"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return codigoPostal;
    }
}
