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
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.PagoVarios;
/**
 *
 * @author jesus
 */
public class CtrlPagosVarios {
    
    Connection con = null;
    PreparedStatement ps;
    ResultSet rs;
    
    public void crear(java.util.Date fecha, String detalle, float importe, int idEmpleado, int idAlumno){

        java.sql.Date fechaSql=new Date(fecha.getTime());
        
        try {
            con = clases.Conectar.conexion();
            ps = (PreparedStatement) con.prepareStatement("INSERT INTO pagosVarios (fecha,detalle,importe,idEmpleado,idAlumno) "
                    + "VALUES (?,?,?,?,?)");
        
            ps.setDate(1, fechaSql);
            ps.setString(2, detalle);
            ps.setFloat(3, importe);
            ps.setInt(4, idEmpleado);
            ps.setInt(5, idAlumno);
            
            int res = ps.executeUpdate();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
        }
    }
    
    public PagoVarios leer(int idPagosVarios){
        PagoVarios pagoVarios = new PagoVarios();
        CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
        CtrlAlumno ctrlAlumno = new CtrlAlumno();
        
        try {
            con = clases.Conectar.conexion();
            ps =  (PreparedStatement) con.prepareStatement("SELECT * FROM pagosVarios WHERE idPagosVarios = ?");
            
            ps.setInt(1, idPagosVarios);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                pagoVarios.setFecha(rs.getDate("fecha"));
                pagoVarios.setDetalle(rs.getString("detalle"));
                pagoVarios.setImporte(rs.getInt("importe"));
                pagoVarios.setIdEmpleado(ctrlEmpleado.leer(rs.getInt("idEmpleado")));
                pagoVarios.setIdAlumno(ctrlAlumno.leer(rs.getInt("idAlumno")));
            }else{
                JOptionPane.showMessageDialog(null, "No existe lo que está buscando");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getLocalizedMessage().toString());
        }
        return pagoVarios;
    }
    
    public void llenarTabla(int idAlumno, JTable tabla){
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Detalle");
        modelo.addColumn("Nombre");
        modelo.addColumn("Importe");
        modelo.addColumn("Saldo");
        modelo.addColumn("Fecha");
        
        Object[] datos= new Object[5];
        try{

            con=clases.Conectar.conexion();
            ps=(PreparedStatement)con.prepareStatement("SELECT pagosVarios.detalle, persona.nombrePersona, persona.apellidoPersona, pagosVarios.importe, cursoAlumno.saldo, pagosVarios.fecha FROM persona "
                    + " INNER JOIN alumno ON persona.idPersona = alumno.idPersona"
                    + " INNER JOIN pagosVarios ON alumno.idAlumno = pagosVarios.idAlumno"
                    + " INNER JOIN cursoAlumno ON alumno.idAlumno = cursoAlumno.idAlumno"
                    + " WHERE alumno.idAlumno = ? ORDER BY pagosVarios.fecha");
           
            ps.setInt(1, idAlumno);
            rs=ps.executeQuery();
            
            while(rs.next()){
                
                datos[0]=rs.getString(1);
                String nombre= rs.getString(2) +" "+ rs.getString(3);
                datos[1]=nombre;
//                datos[2]=rs.getString(3);
                
                datos[2]=String.valueOf(rs.getInt(4));
                datos[3]=String.valueOf(rs.getFloat(5));
                datos[4]=String.valueOf(rs.getDate(6));
                
                modelo.addRow(datos);
             
            }
           
            tabla.setModel(modelo);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getErrorCode());
        }
    }
}
