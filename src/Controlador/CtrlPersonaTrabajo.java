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
import modelo.PersonaTrabajo;
/**
 *
 * @author jesus
 */
public class CtrlPersonaTrabajo {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idPersona, int idTrabajo){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO personaTrabajo (idTrabajo, idPersona) VALUES (?,?)");
        
            ps.setInt(1, idPersona);
            ps.setInt(2, idTrabajo);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idPersonaTrabajo, int idPersona, int idTrabajo){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE personaTrabajo SET idTrabajo = ? WHERE idPersonaTrabajo = ? AND "
                    + "idPersona = ?");
            
            ps.setInt(1, idTrabajo);
            ps.setInt(2, idPersonaTrabajo);
            ps.setInt(3, idPersona);

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
    
    public PersonaTrabajo leer(int idPersonaTrabajo, int idPersona){
        PersonaTrabajo personaTrabajo = new PersonaTrabajo();
        CtrlTrabajo ctrlTrabajo = new CtrlTrabajo();
        CtrlPersona ctrlPersona = new CtrlPersona();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM personaTrabajo WHERE idPersonaTrabajo = ? AND idPersona = ?");
            
            ps.setInt(1, idPersonaTrabajo);
            ps.setInt(2, idPersona);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                personaTrabajo.setIdTrabajo(ctrlTrabajo.leer(rs.getInt("idTrabajo")));
                personaTrabajo.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return personaTrabajo;
    }
}
