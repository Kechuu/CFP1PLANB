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
import modelo.TipoCurso;
/**
 *
 * @author jesus
 */
public class CtrlTipoCurso {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    public void crear(String detalle, float costo, int idPeriodo){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO tipoCurso (detalle,costo,idPeriodo) VALUES (?,?,?)");
        
            ps.setString(1, detalle);
            ps.setFloat(2, costo);
            ps.setInt(3, idPeriodo);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void editar(int idTipoCurso, String detalle, float costo, int idPeriodo){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE tipoCurso SET detalle = ?, costo = ? , idPeriodo = ? "
                    + "WHERE idtipoCurso = ?");
            
            ps.setString(1, detalle);
            ps.setFloat(2, costo);
            ps.setInt(3, idPeriodo);
            ps.setInt(4, idTipoCurso);
            
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
    
    public void borrar(int idTipoCurso){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE curso SET borrado = TRUE WHERE idTipoCurso = ?");
            
            ps.setInt(1, idTipoCurso);
            
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
    
    public TipoCurso leer(int id){
        TipoCurso tipoCurso = new TipoCurso();
        CtrlPeriodo ctrlPeriodo = new CtrlPeriodo();
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM tipoCurso WHERE idTipoCurso = ?");
            
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setCosto(rs.getFloat("costo"));
                tipoCurso.setIdPeriodo(ctrlPeriodo.leer(rs.getInt("idPeriodo")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
        } catch (Exception e) {
        }
        
        
        return tipoCurso;
    }
}
