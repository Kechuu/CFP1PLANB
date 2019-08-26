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
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
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
