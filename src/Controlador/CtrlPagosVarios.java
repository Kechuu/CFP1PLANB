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
    
    public float llenarTabla(int idAlumno, JTable tabla){
        
        float saldoTotal=0;
        
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Fecha");
        modelo.addColumn("Concepto");
        modelo.addColumn("Costo");
        modelo.addColumn("Importe");
        modelo.addColumn("Curso");
        modelo.addColumn("Cobrador");
        
        Object[] datos= new Object[6];
        try{

            con=clases.Conectar.conexion();
            /*ps=(PreparedStatement)con.prepareStatement("SELECT pagosVarios.detalle, persona.nombrePersona, persona.apellidoPersona, pagosVarios.importe, cursoAlumno.saldo, pagosVarios.fecha FROM persona "
                    + " INNER JOIN alumno ON persona.idPersona = alumno.idPersona"
                    + " INNER JOIN pagosVarios ON alumno.idAlumno = pagosVarios.idAlumno"
                    + " INNER JOIN cursoAlumno ON alumno.idAlumno = cursoAlumno.idAlumno"
                    + " WHERE alumno.idAlumno = ? ORDER BY pagosVarios.fecha");*/
           
            ps=(PreparedStatement)con.prepareStatement("SELECT pagosVarios.fecha, pagosVarios.detalle, pagosVarios.importe, persona.apellidoPersona, persona.nombrePersona FROM pagosVarios"
                    + " INNER JOIN alumno ON pagosVarios.idAlumno = alumno.idAlumno"
                    //+ " INNER JOIN cursoAlumno ON alumno.idAlumno = cursoAlumno.idAlumno"
                    + " INNER JOIN empleado ON pagosVarios.idEmpleado = empleado.idEmpleado"
                    + " INNER JOIN persona ON empleado.idPersona = persona.idPersona"
                    + " WHERE alumno.idAlumno = ? ORDER BY pagosVarios.fecha");
            
            ps.setInt(1, idAlumno);
            rs=ps.executeQuery();
            
            while(rs.next()){
              
    //COLUMNAS: FECHA - CONCEPTO - COSTO -IMPORTE - CURSO - ENCARGADO
    
                datos[0]=rs.getString(1); //FECHA
                datos[1]=rs.getString(2);//CONCEPTO
                datos[2]=rs.getString(3); //COSTO
                datos[3]=rs.getString(3);//IMPORTE
                String cursoNom="---"; 
                datos[4]=cursoNom; //CURSO
                String cobrador=rs.getString(4)+" "+rs.getString(5); 
                datos[5]=cobrador;//NOMBRE DE ENCARGADO
                
                modelo.addRow(datos);
            }
           
            ps=null;
            rs=null;
            ps=(PreparedStatement)con.prepareStatement("SELECT pago.fecha, cursoAlumno.costo, pago.importe, tipoCurso.detalle, persona.apellidoPersona, persona.nombrePersona, cursoAlumno.saldo FROM pago"
                    + " INNER JOIN cursoAlumno ON pago.idCursoAlumno = cursoAlumno.idCursoAlumno"
                    + " INNER JOIN curso ON cursoAlumno.idCurso = curso.idCurso"
                    + " INNER JOIN tipoCurso ON curso.idTipoCurso = tipoCurso.idTipoCurso"
                    + " INNER JOIN empleado ON pago.idCobrador = empleado.idEmpleado"
                    + " INNER JOIN persona ON empleado.idPersona = persona.idPersona"
                    + " WHERE cursoAlumno.idEstadoAlumno = 1 AND cursoAlumno.idAlumno = ? ORDER BY pago.fecha");
            
            ps.setInt(1, idAlumno);
            
            rs=ps.executeQuery();
            
            
            while(rs.next()){
                datos[0]=rs.getString(1);//FECHA
                String concepto="Pago cooperativa";
                datos[1]=concepto; //CONCEPTO
                datos[2]=rs.getString(2);//COSTO
                datos[3]=rs.getString(3);//IMPORTE
                datos[4]=rs.getString(4);//CURSO
                String encargado=rs.getString(5)+" "+rs.getString(6);
                datos[5]=encargado;//NOMBRE DE ENCARGADO
                
                saldoTotal=saldoTotal+rs.getFloat(6);
                modelo.addRow(datos);
            }
            
            tabla.setModel(modelo);
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getErrorCode());
        }
        return saldoTotal;
    }
}
