/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
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
        
            ps.setString(1, detalle.toUpperCase());
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
            
            ps.setString(1, detalle.toUpperCase());
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
    
    //Preguntar si la ara aprueba este cambio :v
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
    
    
    public TipoCurso leer(String detalle){
        TipoCurso tipoCurso = new TipoCurso();
        CtrlPeriodo ctrlPeriodo = new CtrlPeriodo();
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM tipoCurso WHERE detalle = ?");
            
            ps.setString(1, detalle.toUpperCase());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setCosto(rs.getFloat("costo"));
                tipoCurso.setIdPeriodo(ctrlPeriodo.leer(rs.getInt("idPeriodo")));
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return tipoCurso;
    }
    
    
    public TipoCurso leer(int idTipoCurso){
        TipoCurso tipoCurso = new TipoCurso();
        CtrlPeriodo ctrlPeriodo = new CtrlPeriodo();
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("SELECT * FROM tipoCurso WHERE idTipoCurso = ?");
            
            ps.setInt(1, idTipoCurso);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setCosto(rs.getFloat("costo"));
                tipoCurso.setIdPeriodo(ctrlPeriodo.leer(rs.getInt("idPeriodo")));
                
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        
        return tipoCurso;
    }
    
    public void cargarListaCurso(JList <TipoCurso> listDisponible){
        CtrlPeriodo ctrlPeriodo = new CtrlPeriodo();
        
        DefaultListModel<TipoCurso> modelo=new DefaultListModel<>();
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM tipoCurso");
            rs=ps.executeQuery();
            
            while (rs.next()) {
                TipoCurso tipoCurso = new TipoCurso();
        
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                tipoCurso.setCosto(rs.getFloat("costo"));
                tipoCurso.setIdPeriodo(ctrlPeriodo.leer(rs.getInt("idPeriodo")));
                
                modelo.addElement(tipoCurso);
            }
            
            listDisponible.setModel(modelo);
            con.close();
        }catch (SQLException e) {
        
        }
        
    
    }
    
    
        public void cargarCombo(JComboBox<TipoCurso> cbTipoCurso){
        
        try {
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM tipoCurso ORDER BY detalle ASC");
            rs=ps.executeQuery();
            TipoCurso tipoCurso = new TipoCurso();
            tipoCurso.setIdTipoCurso(0);
            tipoCurso.setDetalle("Seleccione una opcion...");
            cbTipoCurso.addItem(tipoCurso);
            
            while (rs.next()) {                
                tipoCurso = new TipoCurso();
                tipoCurso.setIdTipoCurso(rs.getInt("idTipoCurso"));
                tipoCurso.setDetalle(rs.getString("detalle"));
                cbTipoCurso.addItem(tipoCurso);
            }
            
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS CARGOS");       
        }
        
    }
    
}
