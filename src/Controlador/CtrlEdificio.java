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
import modelo.Edificio;

/**
 *
 * @author jesus
 */
public class CtrlEdificio {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int torre, int piso, int depto){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO edificio (torre,piso,depto) VALUES (?,?,?)");
        
            ps.setInt(1, torre);
            ps.setInt(2, piso);
            ps.setInt(3, depto);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int torre, int piso, int depto, int idEdificio){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE edificio SET torre = ?,piso = ? ,depto = ? WHERE idEdificio = ?");
            
            ps.setInt(1, torre);
            ps.setInt(2, piso);
            ps.setInt(3, depto);
            ps.setInt(4, idEdificio);
            
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
    
    public Edificio leer(int id){
        Edificio edificio = new Edificio();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM edificio WHERE idEdificio = ?");
            
            ps.setInt(1,id);
            rs = ps.executeQuery();
            
            if(rs.next()){
                edificio.setIdEdificio(rs.getInt("idEdificio"));
                edificio.setDepto(rs.getInt("depto"));
                edificio.setPiso(rs.getInt("piso"));
                edificio.setTorre(rs.getInt("torre"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return edificio;
    }
}
