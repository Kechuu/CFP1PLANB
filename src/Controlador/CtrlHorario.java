/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import modelo.Horario;
/**
 *
 * @author jesus
 */
public class CtrlHorario {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(Date desde, Date hasta, int dia){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO horario (desde,hasta,dia) VALUES (?,?,?)");
        
            ps.setDate(1, desde);
            ps.setDate(2, hasta);
            ps.setInt(3, dia);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idHorario, Date desde, Date hasta, int dia){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE horario SET desde = ?, hasta = ?, dia = ? WHERE idHorario = ?");
            
            ps.setDate(1, desde);
            ps.setDate(2, hasta);
            ps.setInt(3, dia);
            ps.setInt(4, idHorario);
            
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
    
    public Horario leer(int idHorario){
        Horario horario = new Horario();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM horario WHERE idHorario = ?");
            
            ps.setInt(1, idHorario);
            rs = ps.executeQuery();
            
            if(rs.next()){
                horario.setIdHorario(rs.getInt("idHorario"));
                horario.setDesde(rs.getTime("desde"));
                horario.setHasta(rs.getTime("hasta"));
                horario.setDia(rs.getInt("dia"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return horario;
    }
}
