/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import clases.Conectar;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.Time;
=======
>>>>>>> 5de7e7c6d3c4148b0a79d91ac41cc662b2b69473
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Horario;
/**
 *
 * @author jesus
 */
public class CtrlHorario {
    
    Connection con = clases.Conectar.conexion();
    PreparedStatement ps;
    ResultSet rs;
    ResultSetMetaData rsd;
    
    public void crear(String desde, String hasta, int dia){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO horario (desde,hasta,dia) VALUES (?,?,?)");
        
            //long desde1 = Date.parse(desde);
            //long hasta1 = Date.parse(hasta);
            
            //java.sql.Date d = new java.sql.Date(desde1);
            //java.sql.Date h = new java.sql.Date(hasta1);
            
            ps.setString(1, desde);
            ps.setString(2, hasta);
            ps.setInt(3, dia);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public void editar(int idHorario, Date desde, Date hasta, int dia){
        try {
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
    
    public ArrayList<Object[]> LlenarTabla(){
   
        ArrayList<Object[]> datos = new ArrayList<>();
             
                    try{
                          PreparedStatement st= (PreparedStatement) con.createStatement();

                       rs = st.executeQuery("SELECT idHorario,dia,desde,hasta FROM horario");
                       rsd = rs.getMetaData();
                                
                    } catch (SQLException e){
                        JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
                     }
                    
                    try{
                        
                       while(rs.next()){
                Object[] filas = new Object[rsd.getColumnCount()];
                
                for(int i = 0;i<rsd.getColumnCount();i++){
                    filas[i]= rs.getObject(i+1);
                   
                }
                datos.add(filas);
            }
                       
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
                    
       return datos;

    }
    
    public Horario leer(int dia, Time desde, Time hasta){
        Horario horario = new Horario();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM horario WHERE desde=? AND hasta=? AND dia=?");
            
            ps.setTime(1, desde);
            ps.setTime(2, hasta);
            ps.setInt(3, dia);
            rs = ps.executeQuery();
            
            if(rs.next()){
                horario.setIdHorario(rs.getInt("idHorario"));
                horario.setDesde(rs.getTime("desde"));
                horario.setHasta(rs.getTime("hasta"));
                horario.setDia(rs.getInt("dia"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando....");
            }
            
            con.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return horario;
    }
    
    public Horario leer(int idHorario){
        Horario horario = new Horario();
        try {
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM horario WHERE idHorario=?");
            
            ps.setInt(1, idHorario);
            rs = ps.executeQuery();
            
            if(rs.next()){
                horario.setIdHorario(rs.getInt("idHorario"));
                horario.setDesde(rs.getTime("desde"));
                horario.setHasta(rs.getTime("hasta"));
                horario.setDia(rs.getInt("dia"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando....");
            }
            
            con.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
        return horario;
    }
}
