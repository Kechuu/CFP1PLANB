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
import java.util.Vector;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import modelo.PlanPersona;
import modelo.Planes;
/**
 *
 * @author jesus
 */
public class CtrlPlanPersona {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(int idPersona, int idPlanes){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO planPersona (idPersona,idPlanes) VALUES (?,?)");
        
            ps.setInt(1, idPersona);
            ps.setInt(2, idPlanes);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"clase control plan persona");
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public void editar(int idPlanPersona, int idPersona, int idPlanes){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("UPDATE planPersona SET idPlanes=? WHERE idPlanPersona = ? AND idPersona = ?");
            
            ps.setInt(1, idPlanes);
            ps.setInt(2, idPlanPersona);
            ps.setInt(3, idPersona);
            
            int res = ps.executeUpdate();
            
            if(res > 0){
                //Nada de Nada :v
            }else{
                JOptionPane.showMessageDialog(null, "Error al guardar los cambios ES AQUIA");
            }
            
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void borrar(int idPlanPersona, int idPlan, int idPersona){
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("DELETE FROM planPersona WHERE idPlanPersona=? AND idPersona=? AND idPlanes=?");
            
            ps.setInt(1, idPlanPersona);
            ps.setInt(2, idPersona);
            ps.setInt(3, idPlan);
            
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
    
    public PlanPersona leer(int idPersona, int idPlan){
        PlanPersona planPersona = new PlanPersona();
        CtrlPersona ctrlPersona = new CtrlPersona();
        CtrlPlanes ctrlPlanes = new CtrlPlanes();
        
        //JOptionPane.showMessageDialog(null, "persona "+idPersona+" plan"+idPlan);
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM planPersona WHERE idPersona = ? AND idPlanes=?");
            
            ps.setInt(1, idPersona);
            ps.setInt(2, idPlan);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                planPersona=new PlanPersona();
                
                planPersona.setIdPlanPersona(rs.getInt("idPlanPersona"));
                planPersona.setIdPersona(ctrlPersona.leer(rs.getInt("idPersona")));
                planPersona.setIdPlanes(ctrlPlanes.leer(rs.getInt("idPlanes")));
                
                //JOptionPane.showMessageDialog(null, planPersona.getIdPlanPersona()+"id persona "+planPersona.getIdPersona()+" plan"+planPersona.getIdPlanes());
            }    
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        
        return planPersona;
    }
    
    public void llenarLista(int idPersona, JList <Planes> lista){
        CtrlPlanes ctrlPlanes=new CtrlPlanes();
        PlanPersona planPersona;
        
        DefaultListModel<Planes> modelo=new DefaultListModel<>();
        
        try{
            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT * FROM planPersona WHERE idPersona = ?");
            ps.setInt(1, idPersona);
            
            rs=ps.executeQuery();
            
            while(rs.next()){
                planPersona=new PlanPersona();
                
                planPersona.setIdPlanes(ctrlPlanes.leer(rs.getInt("idPlanes")));
                
                modelo.addElement(planPersona.getIdPlanes());
                
            }
            
            lista.setModel(modelo);
            con.close();
        }catch(SQLException e){
            
        }
        
    }
}
