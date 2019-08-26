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
import modelo.Domicilio;
import modelo.Lugar;
import modelo.Edificio;

/**
 *
 * @author jesus
 */
public class CtrlDomicilio {
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(){
        
    }
    
    public void editar(){
        
    }
    
    public void borrar(){
        
    }
    
    public Domicilio leer(int id){
        Domicilio domicilio = new Domicilio();
        Lugar lugar = new Lugar();
        CtrlLugar ctrlLugar = new CtrlLugar();
        Edificio edificio = new Edificio();
        CtrlEdificio ctrlEdificio = new CtrlEdificio();
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM empleado WHERE idEmpleado = ?");
            
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                domicilio.setIdDomicilio(rs.getInt("idDomicilio"));
                domicilio.setNro(rs.getInt("nro"));
                domicilio.setTelefono(rs.getString("telefono"));
                lugar = ctrlLugar.leer(rs.getInt("idLugar"));
                edificio = ctrlEdificio.leer(rs.getInt("idEdificio"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return domicilio;
    }
}
