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
    
    public void crear(int nro, String telefono, int idCalle, int idEdificio){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO domicilio (nro,telefono,idLugar,idEdificio) VALUES (?,?,?,?)");
            
            ps.setInt(1, nro);
            ps.setString(2, telefono);
            ps.setInt(3, idCalle);
            ps.setInt(4, idEdificio);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
    }
    
    public void cambiarAgregarTelefono(int idDomicilio, String telefono){

        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE domicilio SET telefono = ? WHERE idDomicilio = ?");
            
            ps.setString(1, telefono);
            ps.setInt(2, idDomicilio);
            
            int res = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        
    }
    
    public void cambiarDomicilio(int idDomicilio, int nro, String telefono, int idCalle, int idEdificio){
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("UPDATE domicilio SET nro = ?, telefono = ?, idLugar = ?,"
                    + "idEdificio = ? WHERE idDomicilio = ?");
            
            ps.setInt(1, nro);
            ps.setString(2, telefono);
            ps.setInt(3, idCalle);
            ps.setInt(4, idEdificio);
            ps.setInt(5, idDomicilio);
            
            int res = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
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
                domicilio.setIdLugar(ctrlLugar.leer(rs.getInt("idLugar")));
                domicilio.setIdEdificio(rs.getInt("idEdificio"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return domicilio;
    }
}
