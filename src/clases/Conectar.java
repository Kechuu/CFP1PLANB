package clases;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;


public class Conectar {
      
    public static Connection conexion = null;
    public static final String SERVIDOR="jdbc:mysql://localhost:3306/DatosCFP?useSSL=false";
    public static final String USUARIO = "root";
    public static final String PASS = "root";
    
    
      
      
    public static Connection conexion(){ 
    
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conexion = (Connection) DriverManager.getConnection(SERVIDOR, USUARIO, PASS);
                if (conexion!=null) {
                    //JOptionPane.showMessageDialog(null, "hola");
                }
   
            } catch(ClassNotFoundException | HeadlessException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                
        return conexion;
                
   }
    /*
    public void LlenarcomboLocalidad(Connection conexion, JComboBox<Lugarconfiguracion> comboLocalidad){//Este metodo para llenar el combo con las localidades 
        try {
            
            Statement st = (Statement) conexion.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM lugar WHERE nivel = 3 ORDER BY nombre ASC");
            Lugarconfiguracion dat= new Lugarconfiguracion();
            dat.setIdLugar(0);
            dat.setNombre("Selecciona una opción...");
            dat.setNivel(0);
            dat.setDe(0);
            comboLocalidad.addItem(dat);

            while(rs.next()){
                dat= new Lugarconfiguracion();
                dat.setIdLugar(rs.getInt("idLugar"));
                dat.setNombre(rs.getString("nombre"));
                dat.setNivel(rs.getInt("nivel"));
                dat.setDe(rs.getInt("de"));
                comboLocalidad.addItem(dat); 
            }
                
        } catch (SQLException ex) {
         
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR Las localidades");
        }
    }*/
}
